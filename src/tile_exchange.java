import java.io.*;
import java.util.*;
public class tile_exchange {
    public static void print(int[][] arr){
        StringBuilder s = new StringBuilder();
        s.append("[\n");
        for (int i = 0; i<arr.length; i++){
            s.append("  [");
            for (int j = 0; j<arr[0].length; j++){
                s.append(arr[i][j]);
                if (j!=arr[0].length - 1){
                    s.append(", ");
                }
            }
            s.append("]");
            if (i!=arr.length-1){
                s.append(",\n");
            }
        }
        s.append("\n]");
        System.out.println(s.toString());
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = Integer.parseInt(s.split(" ")[0]);
        int M = Integer.parseInt(s.split(" ")[1]);
        int[] A = new int[N+1];
        int i = 0;
        int j = 0;
        int k = 0;
        int INF = 1999999999;
        for (i = 0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        int[][] best = new int[M+1][N+1];
        for (i = 1; i<=M; i++){
            best[i][0] = INF;

        }
        print(best);

        for (j = 1; j<=N; j++){
            for (i = 0; i<=M; i++){
                best[i][j] = INF;
                for (k=1; k*k <= i; k++) {
                     if ((A[j]-k)*(A[j]-k)+best[i-k*k][j-1] < best[i][j]){
                        best[i][j] = (A[j]-k)*(A[j]-k)+best[i-k*k][j-1];
                    }
                }
            }
        }
        print(best);

        if (best[M][N] == INF)
            System.out.println("-1");
        else{
            System.out.println(best[M][N]);
        }

    }
}
