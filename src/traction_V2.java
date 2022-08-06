import java.io.*;
import java.util.*;

public class traction_V2 {

    static int max_value = 999999;
    public static int twoD_to_oneD(int x, int y, int size_y) { return x * size_y + y;}

    public static ArrayList<Integer> oneD_to_twoD(int id, int size_y) {
        ArrayList<Integer> ar = new ArrayList<>();  ar.add(id / size_y); ar.add(id % size_y); return ar;
    }
    public static boolean includes(ArrayList<ArrayList<Integer>> ar, int x, int y) {
        for (ArrayList<Integer> integers : ar) {
            if (integers.get(0) == x && integers.get(1) == y) return true;
        }
        return false;
    }
    public static boolean accessible(int x1, int y1, int x2, int y2) {
        if (x1 == x2 && Math.abs(y1 - y2) == 1) return true;
        return y1 == y2 && Math.abs(x1 - x2) == 1;
    }

    public static int search_path(int[][] graph, int x, int y, int max_x, int max_y, boolean[] visited){
        System.out.println("(" + x + "," + y + ")"+" "+ Arrays.toString(visited));
        if (x==0 && y==0){ visited[twoD_to_oneD(x, y, max_y)]  = true; return 0;};
        if (x<0 || y<0 || x>=max_x|| y>=max_y) return max_value;
        visited[twoD_to_oneD(x, y, max_y)] = true;
        int value1 = max_value;
        int value2 = max_value;
        int value3 = max_value;
        int value4 = max_value;
        if (twoD_to_oneD(x+1, y, max_y) < visited.length && !visited[twoD_to_oneD(x+1, y, max_y)])
            value1 = search_path(graph, x+1, y, max_x, max_y, visited);
        //int value2 =  search_path(graph, x-1, y, max_x, max_y, visited);
        if (twoD_to_oneD(x-1, y, max_y) >= 0 && !visited[twoD_to_oneD(x-1, y, max_y)])
            value2 =  search_path(graph, x-1, y, max_x, max_y, visited);
        if (twoD_to_oneD(x, y+1, max_y)  < visited.length  && !visited[twoD_to_oneD(x, y+1, max_y)])
            value3 = search_path(graph, x, y+1, max_x, max_y, visited);
        //int value4 = search_path(graph, x+1, y-1, max_x, max_y, visited);
        if (twoD_to_oneD(x, y-1, max_y) >= 0 && !visited[twoD_to_oneD(x, y-1, max_y)])
            value4 = search_path(graph, x, y-1, max_x, max_y, visited);
        int var = Math.min(Math.min(value1, value2), Math.min(value3, value4));
        visited[twoD_to_oneD(x, y, max_y)]  = true;
        System.out.println(var + graph[x][y]);
        return var + graph[x][y];

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int x = Integer.parseInt(s[1]);
        int y = Integer.parseInt(s[2]);
        ArrayList<ArrayList<Integer>> points = new ArrayList<>(N);
        int max_x = x;
        int max_y = y;
        ArrayList<Integer> source = new ArrayList<>();
        source.add(x);
        source.add(y);
        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            x = Integer.parseInt(s[0]);
            y = Integer.parseInt(s[1]);
            ArrayList<Integer> t = new ArrayList<>();
            t.add(x);
            t.add(y);
            points.add(t);
            if (x > max_x) {
                max_x = x;

            }
            if (y > max_y) {
                max_y = y;
            }
        }

        max_x++;
        max_y++;

        int[][] graph = new int[max_x][max_y];
        for (int i = 0; i<points.size(); i++) {
            ArrayList<Integer> p = points.get(i);
            graph[p.get(0)][p.get(1)] = 1;
        }

        boolean[] visited = new boolean[twoD_to_oneD(max_x-1, max_y-1, max_y)];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        int result = search_path(graph, source.get(0), source.get(1), max_x, max_y, visited);
        System.out.println(result);


    }
}

