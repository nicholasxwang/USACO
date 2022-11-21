import java.io.*; import java.util.*;

//class ConnectingNodes{
//    int id;
//    ArrayList<ConnectingEdge> connections;
//    public ConnectingNodes(int id){
//        this.id = id;
//        connections = new ArrayList<ConnectingEdge>();
//    }
//}
//class ConnectingEdge{
//   int weight;
//   ConnectingNodes node1;
//    ConnectingNodes node2;
//    public ConnectingEdge(int weight, ConnectingNodes node1, ConnectingNodes node2){
//        this.weight = weight;
//        this.node1 = node1;
//        this.node2 = node2;
//    }
//}
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

    public static int dijkstra(int graph[][], int V)
    {

        int[] parent = new int[V];	//Stores Shortest Path Structure
        //Keeps shortest path values to each vertex from source
        	//TRUE->Vertex is processed
        ArrayList<Integer> value = new ArrayList<>();
        ArrayList<Boolean> processed = new ArrayList<>();
        for (int i = 0; i<V; i++){
            value.add(Integer.MAX_VALUE);
            processed.add(false);
            parent[i] = 0;
        }

        //Assuming start point as Node-0
        parent[0] = -1;	//Start node has no parent
        value.set(0, 0);	//start node has value=0 to get picked 1st


        //Include (V-1) edges to cover all V-vertices
        for(int i=0;i<V-1;++i)
        {
            //Select best Vertex by applying greedy method
            int U = selectMinVertex(value,processed, V);
            processed.set(U, true);	//Include new Vertex in shortest Path Graph

            //Relax adjacent vertices (not yet included in shortest path graph)
            for(int j=0;j<V;++j)
            {
			/* 3 conditions to relax:-
			      1.Edge is present from U to j.
			      2.Vertex j is not included in shortest path graph
			      3.Edge weight is smaller than current edge weight
			*/
                if(graph[U][j]!=-1 && processed.get(j) ==false && value.get(U) != Integer.MAX_VALUE
                        && (value.get(U) +graph[U][j] < value.get(j)))
                {
                    value.set(j, value.get(U) + graph[U][j]);
                    parent[j] = U;
                }
            }
        }
        //Print Shortest Path Graph
//        for(int i=1;i<V;++i)
//            System.out.println("U->V: "+parent[i]+"->"+i+"  wt = "+graph[parent[i]][i]+"\n");
        //return path length
        return value.get(V-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
//            ConnectingNodes[] nodes = new ConnectingNodes[N];
//            for (int j = 0; j<N; j++){
//                nodes[j] = new ConnectingNodes(j);
//            }
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
