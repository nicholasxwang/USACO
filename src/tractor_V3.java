import java.io.*;
import java.util.*;
public class tractor_V3 {
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
            if (x > max_x) max_x = x;
            if (y > max_y)  max_y = y;
        }
        max_x+=2; max_y+=2;
        int[][] graph = new int[max_x][max_y];
        for (int i = 0; i<points.size(); i++) {
            ArrayList<Integer> p = points.get(i);
            graph[p.get(0)][p.get(1)] = 1;
        }
        int[][] dist = new int[max_x][max_y];
        for (int i = 0; i<dist.length; i++){
            for (int j = 0; j<dist[0].length; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;
        int change = 1;
        int counter = 0;
        while (change == 1 && counter < 800){
            change = 0;
            counter++;
            for (int i = 0; i<max_x; i++){
                for (int j = 0; j<max_y; j++){
                    if (i == 0 && j == 0) continue;
                    int var1, var2, var3, var4;
                    var1 = var2 = var3 = var4 = Integer.MAX_VALUE;
                    if (i+1 < max_x)  var1 = dist[i+1][j];
                    if (i > 0)  var2 = dist[i-1][j];
                    if (j+1 < max_y)  var3 = dist[i][j+1];
                    if (j > 0)  var4 = dist[i][j-1];
                    int min = Math.min(var1, Math.min(var2, Math.min(var3, var4)));
                    if ( dist[i][j] != graph[i][j] + min) { change = 1; dist[i][j] = graph[i][j] + min;}
                }
            }
        }
        System.out.println(dist[source.get(0)][source.get(1)]);
        System.out.println(counter);
    }
}

