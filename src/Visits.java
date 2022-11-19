import java.io.*;
import java.util.*;


public class Visits {
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
        long[] parent = new long[N];
        for (int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());
            adj[i][j] = 0-w;
            adj[j][i] = 0-w;
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
        System.out.println(-ans);


    }

}
