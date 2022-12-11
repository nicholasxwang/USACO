import java.io.*;
import java.util.*;

public class RedistributingGifts {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] matrix = new boolean[N][N];
         //[i] - cow; [j] - gift
        int[] gifts = new int[N];
        int[][] choices = new int[N][N];
        for (int i = 0; i<N; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                choices[i][j] = Integer.parseInt(s[j])-1;
                matrix[i][choices[i][j]] = true;
                if (choices[i][j] == i) {
                    gifts[i] = j;
                }
            }
        }
        System.out.println(Arrays.toString(gifts));
        for (int i = 0; i<N; i++){
            // locate which index they have currently
            int current = gifts[i];
            System.out.println(Arrays.toString(gifts));
            for (int j = 0; j<current; j++){
                // check if both of them get the upgrade
               if (matrix[i][choices[i][j]] && matrix[choices[i][j]][i]){
                   if (gifts[i] > gifts[choices[i][j]] || gifts[j] > gifts[choices[j][i]]) {
                       continue;
                   }
                     gifts[i] = j;
                     gifts[j] = i;
                     break;
               }
            }

        }
        for (int i = 0; i<N; i++){
            System.out.println(choices[i][gifts[i]]+1);
        }

    }
}
