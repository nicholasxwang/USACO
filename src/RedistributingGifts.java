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
            boolean keep_adding = true; // make sure nothng gets added thats worse
            for (int j = 0; j < N; j++) {
                choices[i][j] = Integer.parseInt(s[j])-1;
                if (choices[i][j] == i) {
                    keep_adding = false;
                }
                if (keep_adding) {
                    matrix[i][choices[i][j]] = true;
                }
                if (choices[i][j] == i) {
                    gifts[i] = j;
                }
            }
        }
        //System.out.println(Arrays.toString(gifts));
        for (int i = 0; i<N; i++){
            // locate which index they have currently
            int current = gifts[i];
            //System.out.println(Arrays.toString(gifts));
            for (int j = 0; j<current; j++){
                // check if both of them get the upgrade
               if (matrix[i][choices[i][j]] && matrix[choices[i][j]][i]){
                   int old_position1 = gifts[i];
                   int new_position1 = Integer.MAX_VALUE;
                   int old_position2 = gifts[choices[i][j]];
                   int new_position2 = Integer.MAX_VALUE;
                 for (int k = 0; k<N; k++){
//                     if (choices[i][k] == choices[i][j]){
//                         new_position1 = k;
//                         gifts[i] = new_position1;
//                         System.out.println("Swapping " + i + " with " + choices[i][j]);
//                         break;
//                     }
//                     if (choices[choices[i][j]][k] == i){
//                         new_position2 = k;
//                         gifts[choices[i][j]] = new_position2;
//                            System.out.println("Swapping " + choices[i][j] + " with " + i);
//                         break;
//                     }
                     if (choices[i][k] == choices[i][j] && choices[choices[i][j]][k] == i){
                         new_position1 = k;
                         gifts[i] = new_position1;
                         //System.out.println("Swapping " + i + " with " + choices[i][j]);
                         new_position2 = k;
                         gifts[choices[i][j]] = new_position2;
                         //System.out.println("Swapping " + choices[i][j] + " with " + i);
                         break;
                     }
                 }

               }
            }

        }
        for (int i = 0; i<N; i++){
            System.out.println(choices[i][gifts[i]]+1);
        }

    }
}
