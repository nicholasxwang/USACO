import java.io.*; import java.util.*;

public class ConvolutedIntervals {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] intervals = new int[N][2];
        int[][] x_sums = new int[N][N];
        int[][] y_sums = new int[N][N];
        int[] prefixx = new int[M*2+1];
        int[] prefixy = new int[M*2+1];
        int[] answers = new int[M*2+1];
        for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            intervals[i][0] = Integer.parseInt(st.nextToken());
            intervals[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i<N; i++){
            for (int j = 0; j<N; j++){
                x_sums[i][j] = intervals[i][0] + intervals[j][0];
                y_sums[i][j] = intervals[i][1] + intervals[j][1];
                int bottom = x_sums[i][j];
                int top = y_sums[i][j];
                prefixx[bottom]++;
                prefixy[top]++;
            }
        }
        //run prefix sums
        // run y prefix sums from 0 to end
        for (int i = 1; i<M*2+1; i++){
            prefixx[i] += prefixx[i-1];
        }
        // run x prefix sums from end to 0
        for (int i = M*2-1; i>=0; i--){
            prefixy[i] += prefixy[i+1];
        }

        for (int i = 0; i<answers.length; i++){
            // take the smaller of the two
            answers[i] = Math.min(prefixx[i], prefixy[i]);
        }

        String answer = "";
        for (int k = 0; k<= 2*M; k++){
            answer+=answers[k];
            if (k != 2*M) answer+="\n";
        }
        System.out.println(answer);

    }
}
