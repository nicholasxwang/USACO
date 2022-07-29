import java.io.*;
import java.util.*;

class irrigation {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String[] temp;
        //3 11
        //0 2
        //5 0
        //4 3

        temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int C = Integer.parseInt(temp[1]);
        int[][] adj = new int[N][N];
        int[] dist = new int[N];
        boolean[] mstSet = new boolean[N];
        int[] parent = new int[N];
        int init_i = -1;
        int init_j = -1;
        for (int i = 0; i<N; i++){
            temp = br.readLine().split(" ");
            if (i==0){
                dist[0] = 0;
                init_i = Integer.parseInt(temp[0]);
                init_j = Integer.parseInt(temp[1]);
            }else{
                dist[i] = 999999999;
                int cur_i = Integer.parseInt(temp[0]);
                int cur_j = Integer .parseInt(temp[1]);

            }
            mstSet[i] = false;
            parent[i] = -1;


        }

        for (int i = 0; i<N; i++){
            for (int j = 0; j<N; j++){
                if (adj[i][j]!=0 && mstSet[j] == false && adj[i][j] < dist[j]){
                    dist[j] = adj[i][j];
                    parent[j] = i;
                }
            }
        }

    }
}