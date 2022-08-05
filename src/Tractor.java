import java.io.*;
import java.util.*;
class Tractor {
    public static int twoD_to_oneD(int x, int y, int size_y){ return x*size_y + y;}
    public static ArrayList<Integer> oneD_to_twoD(int id, int size_y){
        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(id/size_y);
        ar.add(id%size_y);
        return ar;
    }
    public static boolean includes(ArrayList<ArrayList<Integer>> ar, int x, int y){
        for (ArrayList<Integer> integers : ar) { if (integers.get(0) == x && integers.get(1) == y) return true; }
        return false;
    }
    public static boolean accessible(int x1, int y1, int x2, int y2){
        if (x1 == x2 && Math.abs(y1-y2) == 1) return true;
        return y1 == y2 && Math.abs(x1 - x2) == 1;
    }
    public static int selectMinVertex(ArrayList<Integer> value, ArrayList<Boolean> processed, int V){
        int minimum = 9;
        int vertex = -1;
        for (int i = 0; i<V; i++){
            if (!processed.get(i) && value.get(i)<minimum){
                minimum = value.get(i);
                vertex = i;
            }
        }
        return vertex;
    }
    public static void dijkstra(int[][] graph, ArrayList<Integer> source, int max_y){
        int V = graph.length;
        int[] parent = new int[V];
        ArrayList<Integer> value = new ArrayList<>();
        ArrayList<Boolean> processed = new ArrayList<>();
        for (int i = 0; i<V; i++){
            value.add(9);
            processed.add(false);
        }
        int source_int = twoD_to_oneD(source.get(0), source.get(1), max_y);
        parent[source_int] = -1;
        value.set(source_int, 0);
        for (int i = 0; i<V; i++){
            int U = selectMinVertex(value, processed, V);
            for (int j = 0; j<V; j++){
                if (graph[U][j]!=0  && !processed.get(j) && value.get(U) != 9 &&
                value.get(U) + graph[U][j] < value.get(j)){
                    if (value.get(U) + graph[U][j] < value.get(j)){
                        value.set(j, value.get(U) + graph[U][j]);
                        parent[j] = U;
                    }
                }
            }
        }
        System.out.println(value.get(0));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int x = Integer.parseInt(s[1])-1;
        int y = Integer.parseInt(s[2])-1;
        ArrayList<ArrayList<Integer>> points = new ArrayList<>(N);
        int max_x = x;
        int max_y = y;
        ArrayList<Integer> source = new ArrayList<>();
        source.add(x);
        source.add(y);
        for (int i = 0; i<N; i++){
            s = br.readLine().split(" ");
            x = Integer.parseInt(s[0])-1;
            y = Integer.parseInt(s[1])-1;
            ArrayList<Integer> t = new ArrayList<>();
            t.add(x);
            t.add(y);
            points.add(t);
            if (x>max_x) {
                max_x = x;

            }
            if (y>max_y){
                max_y = y;
            }
        }
        max_x++;
        max_y++;
        ArrayList<Integer> processed_points = new ArrayList<>();
        for (int i = 0; i<max_x; i++){
            for (int j = 0; j<max_y; j++){
                int v = twoD_to_oneD(i, j, max_y);
                processed_points.add(v);
            }
        }
        int[][] graph = new int[processed_points.size()][processed_points.size()];
        for (int i = 0; i<processed_points.size(); i++){
            for (int j = 0; j<processed_points.size(); j++){
                ArrayList<Integer> xy = oneD_to_twoD(processed_points.get(i), max_y);
                x = xy.get(0);
                y = xy.get(1);
                ArrayList<Integer> xy2 = oneD_to_twoD(processed_points.get(j), max_y);
                int x2 = xy2.get(0);
                int y2 = xy2.get(1);
                int value = 9;
                if (i == j){
                    value = 0;
                }
                else {
                    if (accessible(x, y, x2, y2)){
                        if (includes(points, x2, y2) && includes(points, x, y)) {
                            value = 1;
                        } else {
                            value = 0;
                        }
                    }
                }
                graph[processed_points.get(i)][processed_points.get(j)] = value+1;
            }
        }
        dijkstra(graph, source, max_y);
    }
}