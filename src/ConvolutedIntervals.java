import java.io.*; import java.util.*;

public class ConvolutedIntervals {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] intervals = new int[N][2];
        for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            intervals[i][0] = Integer.parseInt(st.nextToken());
            intervals[i][1] = Integer.parseInt(st.nextToken());
        }
        int[][] x_sums = new int[N][N];
        int[][] y_sums = new int[N][N];
        for (int i = 0; i<N; i++){
            for (int j = 0; j<N; j++){
                x_sums[i][j] = intervals[i][0] + intervals[j][0];
                y_sums[i][j] = intervals[i][1] + intervals[j][1];
            }
        }
        int[] answers = new int[M*2+1];
        for (int i = 0; i<N; i++){
            for (int j = 0; j<N; j++){
                int bottom = x_sums[i][j];
                int top = y_sums[i][j];
                if (bottom > top) continue;
                for (int k = bottom; k<=top; k++){
                    answers[k]++;
                }
            }
        }
        String answer = "";
        for (int k = 0; k<= 2*M; k++){
            answer+=answers[k];
            if (k != 2*M) answer+="\n";
        }
        System.out.println(answer);

    }
}
