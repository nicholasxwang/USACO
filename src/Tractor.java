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
    public static void dijkstra(int graph[][]){
        int[] parent = new int[V];
        ArrayList<Integer> value = new ArrayList<>();
        ArrayList<Boolean> processed = new ArrayList<>();
        for (int i = 0; i<V; i++){
            value.add(Integer.MAX_VALUE);
            processed.add(false);
        }
        parent[0] = -1;
        value.set(0, 0);
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
        for (int i = 0; i<V; i++){
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
        int[][] graph = new int[(max_x+1)*(max_y+1)][(max_x+1)*(max_y+1)];
        ArrayList<Integer> processed_points = new ArrayList<>();
        for (int i = 0; i<max_x; i++){
            for (int j = 0; j<max_y; j++){
                int v = twod_oned(x, y, max_x, max_y);
                processed_points.add(v);
            }
        }
        for (int i = 0; i<processed_points.size(); i++){
            for (int j = 0; j<processed_points.size(); j++){
                ArrayList<Integer> xy = oned_twodd(processed_points.get(i), max_x, max_y);
                x = xy.get(0);
                y = xy.get(1);
                if (includes(points, x, y)){
                    graph[processed_points.get(i)][processed_points.get(j)] = 0;
                }else if (includes(points, x+1, y) || includes(points, x-1, y) || includes(points, x, y+1) || includes(points, x, y-1)) {
                    graph[processed_points.get(i)][processed_points.get(j)] = 1;
                } else{
                    graph[processed_points.get(i)][processed_points.get(j)] = Integer.MAX_VALUE;
                }
            }
        }

        dijkstra(graph);
    }
}
