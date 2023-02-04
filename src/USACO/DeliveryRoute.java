import java.io.*;
import java.util.*;


public class DeliveryRoute {
    public static long selectMinVertex(long[] value, boolean[] setMST, int V){
        long min = 99999999;
        int vertex = 0;
        for (int i = 0; i<V; i++){
            if (!setMST[i] && value[i]<min){
                vertex = i;
                min = value[i];
            }
        }
        return vertex;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] adj = new long[N][N];
        long[] dist = new long[N];
        boolean[] mstSet = new boolean[N];
        int[][] coords = new int[N][2];
        long[] parent = new long[N];
        for (int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            coords[i][0] = Integer.parseInt(st.nextToken());
            coords[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i<N-1; i++){
            adj[i][i+1] = Math.abs(coords[i][0] - coords[i+1][0]) + Math.abs(coords[i][1] - coords[i+1][1]);
        }
        for (int i = 0; i<N; i++) {
            if (i==0) {
                dist[0] = 0;
            } else{
                dist[i] = 999999999;
            }
            mstSet[i] = false;
            parent[i] = -1;
        }



        for (int i = 0; i<N-1; i++){
            long U = selectMinVertex(dist, mstSet, N);
            mstSet[(int) U] = true;

            for (int j = 0; j<N; j++){
                if (adj[(int) U][j]!=0 && mstSet[j] == false && adj[(int) U][j] < dist[j]){
                    dist[j] = adj[(int) U][j];
                    parent[j] = U;
                }
            }
        }
        //Print MST
        long ans = 0;
        for(int i=1;i<N;++i) {
            if (parent[i] == -1){
                break;
            }else{
                ans +=adj[(int) parent[i]][i];
            }

        }
        System.out.println(ans+(Math.abs(coords[N-1][0] - coords[0][0]) + Math.abs(coords[N-1][1] - coords[0][1])));


    }

}
