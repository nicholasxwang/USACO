import java.io.*;
import java.util.*;

public class SpacedOut {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] grid = new int[N][N];
        for (int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j<N; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = -1;

        //Row Alternate

        for (int i = 0; i<N; i++){
            // I represents a column

        }

        // Columns Alternate

        // Final
        System.out.println(max);
    }
}
