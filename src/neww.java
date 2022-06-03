import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class neww {
    public static void main(String[] args) throws IOException {

    int MAX_M = 10000;
    int MAX_N = 10;
    int INF = 1000000000;

    int[][] best = new int[MAX_M+1][MAX_N+1];
    int[] A = new int[MAX_M+1];

    int M = 0;
    int N = 0;
    int i = 0;
    int j = 0;
    int k = 0;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] start = br.readLine().split(" ", 2);
    N = Integer.parseInt(start[0]);
    M = Integer.parseInt(start[1]);

    for (i = 0; i<N; i++){
        String temporary = br.readLine();
        A[i] = Integer.parseInt(temporary);
    }



    for (i=1; i<=M; i++)
        best[i][0] = INF;

    for (j=1; j<=N; j++)
        for (i=0; i<=M; i++) {
            best[i][j] = INF;
            for (k=1; k*k<=i; k++)
                if ((A[j]-k)*(A[j]-k) + best[i-k*k][j-1] < best[i][j])
                    best[i][j] = (A[j]-k)*(A[j]-k) + best[i-k*k][j-1];
        }

    if (best[M][N]==INF)
        System.out.println("-1\n");
    else
        System.out.println (best[M][N]);
        System.out.println(Arrays.deepToString(best));
    }
}
