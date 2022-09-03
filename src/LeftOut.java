import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class LeftOut {
    public static void print(String[][] grid){
        for (int i  =0; i<grid.length; i++){
            for (int j  =0; j<grid.length; j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
    public static String opposite(String s){
        if (s.equals("L")) return "R";
        return "L";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] grid = new String[N][N];
        for (int i = 0; i<N; i++){
            String[] st = br.readLine().split("");
            for (int j = 0; j<N; j++){
                grid[i][j] = (st[j]);
            }
        }

        //First try making everything "L"

        int times = 0;
        while (true){
            if (times == 10) break;
            times++;
            //Check All the Rows
            Hashtable<Integer, ArrayList<Integer>> ht = new Hashtable<>();
            int max = -1;
            for (int i = 0; i<N; i++){
                int count = 0;
                for (int j = 0; j<N; j++){
                    if (grid[i][j].equals("R")) count++;
                }
                if (count > max) max=count;
                if (!ht.containsKey(count))  ht.put(count, new ArrayList<Integer>());
                ht.get(count).add(i);

            }
            //Check All the Coumns
            Hashtable<Integer, ArrayList<Integer>> ht2 = new Hashtable<>();
            int max2 = -1;
            for (int i = 0; i<N; i++){
                int count = 0;
                for (int j = 0; j<N; j++){
                    if (grid[i][j].equals("R")) count++;
                }
                if (count > max2) max2=count;
                if (!ht2.containsKey(count))  ht2.put(count, new ArrayList<Integer>());
                ht2.get(count).add(i);

            }
            if (max == 0) break;
            int max_index;
            if (max>max2){
                max_index = ht.get(max).get(0);
                for (int j = 0; j<N; j++){
                    grid[max_index][j] = opposite(grid[max_index][j]);
                }
            }
            else {
                max_index = ht2.get(max).get(0);
                for (int j = 0; j<N; j++){
                    grid[j][max_index] = opposite(grid[j][max_index]);
                }
            }

            print(grid);
        }

        //First try making everything "R"


    }
}
