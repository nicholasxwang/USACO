import java.io.*; import java.util.*;

public class ConvolutedIntervals {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int[][] intervals = new int[N][2];
        for (int i = 0; i<N; i++){
            tokenizer = new StringTokenizer(br.readLine());
            intervals[i][0] = Integer.parseInt(tokenizer.nextToken());
            intervals[i][1] = Integer.parseInt(tokenizer.nextToken());
        }
        int[] answers = new int[2*M+1];
        for (int i = 0; i<N; i++){
            for (int j = i; j<N; j++) {
                for (int k = intervals[i][0] + intervals[j][0]; k <= intervals[i][1] + intervals[j][1]; k++) {
                    if (k > 2*M) break;
                    if (i == j) answers[k]++;
                    else answers[k] += 2;
                }
            }
        }
        for (int k = 0; k<2*M+1; k++){
            System.out.println(answers[k]);
        }
    }
}
