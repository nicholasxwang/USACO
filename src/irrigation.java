import java.io.*;

import java.util.*;
//3 11
//0 2
//5 0
//4 3

class irrigation {
    public static int selectMinVertex(int[] value, boolean[] setMST, int V, int C){
        int min = 99999999;
        int vertex = 0;
        for (int i = 0; i<V; i++){
            if (setMST[i] == false && value[i]<min && value[i] >=C){
                vertex = i;
                min = value[i];
            }
        }
        return vertex;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String[] temp;


        temp = br.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int C = Integer.parseInt(temp[1]);
        int[][] adj = new int[N][N];
        int[] dist = new int[N];
        boolean[] mstSet = new boolean[N];
        int[] parent = new int[N];
        int[] x = new int[N];
        int[] y = new int[N];
        for (int i = 0; i<N; i++) {
            temp = br.readLine().split(" ");
            x[i] = Integer.parseInt(temp[0]);
            y[i] = Integer.parseInt(temp[1]);
            if (i==0) {
                dist[0] = 0;
            } else{
            dist[i] = 999999999;
            }
            mstSet[i] = false;
            parent[i] = -1;
        }
        for (int i = 0; i<N; i++){
            for (int j = 0; j<N; j++) {

                int init_i = x[i];
                int init_j = y[i];


                int cur_i = x[j];
                int cur_j = y[j];
                int calculated = (init_i - cur_i) * (init_i - cur_i) + (init_j - cur_j) * (init_j - cur_j);
                adj[i][j] = calculated;

            }


            }


//        int[][] adj2 = { {0, 4, 6, 0, 0, 0},
//            {4, 0, 6, 3, 4, 0},
//            {6, 6, 0, 1, 8, 0},
//            {0, 3, 1, 0, 2, 3},
//            {0, 4, 8, 2, 0, 7},
//            {0, 0, 0, 3, 7, 0} };
        int[][] adj2 = { {0, 29, 17},
                {29, 0, 10},
                {17, 10, 0}  };
        for (int i = 0; i<adj.length; i++){
            for (int j = 0; j<adj.length; j++){
                adj[i][j] = adj2[i][j];
            }
        }
        for (int i = 0; i<adj.length; i++){
            for (int j = 0; j<adj.length; j++){
                if (adj[i][j]<C){
                    adj[i][j] = 999999999;
                }
            }
        }


        for (int i = 0; i<N-1; i++){
            int U = selectMinVertex(dist, mstSet, N, C);
            mstSet[U] = true;

            for (int j = 0; j<N; j++){
                if (adj[U][j]!=0 && mstSet[j] == false && adj[U][j] < dist[j]){
                    dist[j] = adj[U][j];
                    parent[j] = U;
                }
            }
        }
        //Print MST
        for(int i=1;i<N;++i)
            System.out.println("U->V: "+parent[i]+"->"+i+"  wt = "+adj[parent[i]][i]+"\n");
        System.out.println("k  ");


    }
}