import java.io.*;
import java.util.*;

public class Superbull2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("superbull.in"));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i<N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        int[][] matrix = new int[N][N];
        int[] wealth = new int[N];
        for (int i = 0; i<N; i++){
            for (int j = 0; j<N; j++){
                if (i == j){
                    matrix[i][j] = 0;
                }
                else {
                    matrix[i][j] = nums[i] ^ nums[j];
                    wealth[i] += matrix[i][j];
//                    wealth[j] += matrix[i][j];
                }
            }
        }
        int ans = 0;
        int eliminated = 0;
        while (eliminated < N-1){
//            System.out.println(Arrays.deepToString(matrix).replaceAll("],", "],\n")+"\n");
//            System.out.println(Arrays.toString(wealth)+"\n");
            int minimum_index = 0;
            for (int i = 1; i<wealth.length; i++){
                if (wealth[minimum_index] > wealth[i]){
                    minimum_index = i;
                }
            }
            int largest = matrix[minimum_index][0];
            int largest_index = 0;
            for (int i = 1; i<N; i++){
                if (matrix[minimum_index][i] > largest){
                    largest = matrix[minimum_index][i];
                    largest_index = i;
                }
            }
            wealth[largest_index] -= largest;

            ans+=largest;
            // clear all wealth
            wealth[minimum_index] = Integer.MAX_VALUE;
            for (int i = 0; i< matrix.length; i++){
                matrix[minimum_index][i] = 0;
                matrix[i][minimum_index] = 0;
            }
            // don't get too many lol
            eliminated++;
        }
//        System.out.println(Arrays.deepToString(matrix).replaceAll("],", "],\n")+"\n");
//        System.out.println(Arrays.toString(wealth)+"\n");
        PrintWriter pw = new PrintWriter("superbull.out");
        pw.println(ans);
        pw.close();
    }
}
