import java.io.*;
import java.util.*;

public class RangeReconstruction3 {
    public static boolean verify(int[][] matrix, int[] generated, long limit) {
        // limit represents only to check elements [0, limit] for early termination
        long N = limit;
        for (int i = 0; i<N; i++){
            for (int j = i+1; j<N; j++){
                // check if the maximum - minimum (range) number of the range generated[i-j] is the same as matrix[i][j]
                int max = generated[i];
                int min = generated[i];
                for (int k = i+1; k<=j; k++){
                    if (generated[k] > max) max = generated[k];
                    if (generated[k] < min) min = generated[k];
                }
                int range = max - min;
                if (range != matrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            //for (int j = 0; j < N; j++) {
            for (int j = i; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
                matrix[j][i] = matrix[i][j];
            }
        }
        int[] change = new int[N];
        for (int i = 1; i < N; i++) {
            change[i] = matrix[i][i-1];
        }
        // try every possible combination of +/-, this will have 2^(N-1) possibilities
        int count = 0;
        int[] generated = new int[N];
        generated[0] = 0;
        for (int i = 1; i < N; i++) {
            count++;
            // two cases: + and -
            int[] postitive_generated = new int[N];
            int[] negative_generated = new int[N];
            // clone the previous generated array
            for (int j = 0; j < N; j++) {
                postitive_generated[j] = generated[j];
                negative_generated[j] = generated[j];
            }
            postitive_generated[i] = postitive_generated[i-1] + change[i];
            negative_generated[i] = negative_generated[i-1] - change[i];
            // check both
            if (verify(matrix, postitive_generated, i + 1)) {
                for (int j = 0; j < N; j++) {
                    generated[j] = postitive_generated[j];
                }
            } else if (verify(matrix, negative_generated, i + 1)) {
                for (int j = 0; j < N; j++) {
                    generated[j] = negative_generated[j];
                }
            } else {
                System.out.println("bruh");
                return;
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print(generated[i]);
            if (i != N-1) System.out.print(" ");

        }

    }
}
