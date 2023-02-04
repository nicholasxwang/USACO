import java.io.*; import java.util.*;

public class ConnectingTwoBarns {
    public static int selectMinVertex(ArrayList<Integer> value, ArrayList<Boolean> processed, int V){
        int minimum = Integer.MAX_VALUE;
        int vertex = -1;
        for (int i = 0; i<V; i++){
            if (!processed.get(i) && value.get(i)<minimum){
                minimum = value.get(i);
                vertex = i;
            }
        }
        return vertex;
    }

    public static int dijkstra(int graph[][], int V) {
        int[] parent = new int[V];
        ArrayList<Integer> value = new ArrayList<>();
        ArrayList<Boolean> processed = new ArrayList<>();
        for (int i = 0; i<V; i++){
            value.add(Integer.MAX_VALUE);
            processed.add(false);
            parent[i] = 0;
        }
        parent[0] = -1;
        value.set(0, 0);
        for(int i=0;i<V-1;++i) {
            int U = selectMinVertex(value,processed, V);
            processed.set(U, true);
            for(int j=0;j<V;++j) {
                if(graph[U][j]!=-1 && processed.get(j) ==false && value.get(U) != Integer.MAX_VALUE
                        && (value.get(U) +graph[U][j] < value.get(j))) {
                    value.set(j, value.get(U) + graph[U][j]);
                    parent[j] = U;
                }
            }
        }
        return value.get(V-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] edgeMatrix = new int[N][N];
            for (int j = 0; j<N; j++){
                for (int k = 0; k<N; k++){
                    edgeMatrix[j][k] = (j-k)*(j-k);
                }
            }
            for (int j = 0; j<M; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                edgeMatrix[a][b] = 0;
                edgeMatrix[b][a] = 0;
            }
            int var = dijkstra(edgeMatrix, N);
            System.out.println(var);
        }
    }
}
