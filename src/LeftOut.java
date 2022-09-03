import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class LeftOut {
    public static String opposite(String s){
        if (s.equals("L")) return "R";
        return "L";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] grid = new String[N][N];
        for (int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j<N; j++){
                grid[i][j] = (st.nextToken());
            }
        }

        //First try making everything "L"

        while (true){
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
            if (max == 0) break;
            int max_index = ht.get(max).get(0);
            for (int j = 0; j<N; j++){
                grid[max_index][j] = opposite(grid[max_index][j]);
            }
            System.out.println(Arrays.deepToString(grid));
        }

        //First try making everything "R"


    }
}
