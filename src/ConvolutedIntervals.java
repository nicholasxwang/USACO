import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
        int[][] xsums = new int[N][N];
        int[][] ysums = new int[N][N];
        for (int i = 0; i<N; i++){
            for (int j = 0; j<N; j++){
                xsums[i][j] = intervals[i][0] + intervals[j][0];
                ysums[i][j] = intervals[i][1] + intervals[j][1];
            }
        }
        for (int k = 0; k<= 2*M; k++){
            int ans = 0;
            for (int i = 0; i<N; i++){
                for (int j = 0; j<N; j++){
                    if (xsums[i][j] <= k && ysums[i][j] >= k){
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }

    }
}
