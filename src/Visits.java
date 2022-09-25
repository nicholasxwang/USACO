import java.io.*;
import java.util.*;


public class Visits {
    public static int selectMinVertex(int[] value, boolean[] setMST, int V){
        int min = 99999999;
        int vertex = 0;
        for (int i = 0; i<V; i++){
            if (setMST[i] == false && value[i]<min){
                vertex = i;
                min = value[i];
            }
        }
        return vertex;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] adj = new int[N][N];
        int[] dist = new int[N];
        boolean[] mstSet = new boolean[N];
        int[] parent = new int[N];
        for (int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());
            adj[i][j] = w;
            adj[j][i] = w;
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
            int U = selectMinVertex(dist, mstSet, N);
            mstSet[U] = true;

            for (int j = 0; j<N; j++){
                if (adj[U][j]!=0 && mstSet[j] == false && adj[U][j] < dist[j]){
                    dist[j] = adj[U][j];
                    parent[j] = U;
                }
            }
        }
        //Print MST
        int ans = 0;
        for(int i=1;i<N;++i) {
            //System.out.println("U->V: " + parent[i] + "->" + i + "  wt = " + adj[parent[i]][i] + "\n");
            if (parent[i] == -1){
                ans = -1;
                break;
            }else{
                ans +=adj[parent[i]][i];
            }

        }


    }

}
