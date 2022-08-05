import java.io.*;
import java.util.*;
class Tractor {
    static int V = 6;

    public static int twod_oned(int x, int y, int size_x, int size_y){
        return x*size_y + y;
    }
    public static ArrayList<Integer> oned_twodd(int id, int size_x, int size_y){
        ArrayList<Integer> ar = new ArrayList<>();
        ar.add(id/size_y);
        ar.add(id%size_y);
        return ar;
    }

    public static boolean includes(ArrayList<ArrayList<Integer>> ar, int x, int y){
        boolean bool = false;
        for (int i = 0; i<ar.size(); i++){
            if (ar.get(i).get(0) == x && ar.get(i).get(1) == y) {bool = true; break;}

        }
        return bool;
    }

    public static int selectMinVertex(ArrayList<Integer> value, ArrayList<Boolean> processed){
        int minimum = Integer.MAX_VALUE;
        int vertex = -1;
        for (int i = 0; i<V; i++){
            if (!processed.get(i) && value.get(i)<minimum){
                minimum = value.get(i);
                vertex = i;
            }
        }
        return vertex;
    }
    public static void dijkstra(int graph[][], ArrayList<Integer> source){
        int[] parent = new int[V];
        ArrayList<Integer> value = new ArrayList<>();
        ArrayList<Boolean> processed = new ArrayList<>();
        for (int i = 0; i<V; i++){
            value.add(Integer.MAX_VALUE);
            processed.add(false);
        }
        parent[0] = -1;
        value.set(source.get(0), source.get(1));
        for (int i = 0; i<V; i++){
            int U = selectMinVertex(value, processed);

            for (int j = 0; j<V; j++){
                if (graph[U][j] != 0 && !processed.get(j) && value.get(U) != Integer.MAX_VALUE &&
                value.get(U) + graph[U][j] < value.get(j)){
                    if (value.get(U) + graph[U][j] < value.get(j)){
                        value.set(j, value.get(U) + graph[U][j]);
                        parent[j] = U;
                    }
                }

            }
        }
        for(int i=1;i<V;++i)
            System.out.println("U->V: "+parent[i]+"->"+i+"  wt = "+graph[parent[i]][i]+"\n");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int x = Integer.parseInt(s[1]);
        int y = Integer.parseInt(s[2]);
        ArrayList<ArrayList<Integer>> points = new ArrayList<>(V);
        int max_x = x;
        int max_y = y;
        ArrayList<Integer> source = new ArrayList<>();
        source.add(x);
        source.add(y);
        for (int i = 0; i<N; i++){
            s = br.readLine().split(" ");
            x = Integer.parseInt(s[0]);
            y = Integer.parseInt(s[1]);
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

        ArrayList<Integer> processed_points = new ArrayList<>();
        for (int i = 0; i<max_x; i++){
            for (int j = 0; j<max_y; j++){
                int v = twod_oned(i, j, max_x, max_y);
                processed_points.add(v);
            }
        }
        int[][] graph = new int[processed_points.size()][processed_points.size()];
        for (int i = 0; i<processed_points.size(); i++){
            for (int j = 0; j<processed_points.size(); j++){
                ArrayList<Integer> xy = oned_twodd(processed_points.get(i), max_x, max_y);
                x = xy.get(0);
                y = xy.get(1);
                ArrayList<Integer> xy2 = oned_twodd(processed_points.get(j), max_x, max_y);
                int x2 = xy2.get(0);
                int y2 = xy2.get(1);
                int value = 9;
                if (i == j){
                    value = 0;
                }
                else {
                    boolean x_diff = x2 - x == 1 || x2 - x == -1;
                    boolean y_diff = y2 - y == 1 || y2 - y == -1;
                    if (x_diff && y_diff) {
                        x_diff = false;
                        y_diff = false;
                    }
                    if (x_diff || y_diff) {
                        if (includes(points, x2, y2)) {
                            value = 1;
                        } else {
                            value = 0;
                        }
                    }
                }



                graph[processed_points.get(i)][processed_points.get(j)] = value;

            }
        }

        dijkstra(graph, source);
    }
}
