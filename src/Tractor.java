import java.io.*;
import java.util.*;
class Location{
    int x;
    int y;
    int id;
    public Location(int x, int y, int id){
        this.x = x;
        this.y = y;
        this.id = id;
    }
}
// Main class DPQ
public class Tractor {
    private int dist[];
    private Set<Integer> settled;
    private PriorityQueue<DijkstraNode> pq;
    private int V;
    List<List<DijkstraNode> > adj;

    public Tractor(int V)
    {

        // This keyword refers to current object itself
        this.V = V;
        dist = new int[V];
        settled = new HashSet<Integer>();
        pq = new PriorityQueue<DijkstraNode>(V, new DijkstraNode());
    }

    // Method 1
    // Dijkstra's Algorithm
    public void dijkstra(List<List<DijkstraNode> > adj, Location src)
    {
        this.adj = adj;
        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;
        pq.add(new DijkstraNode(src, 0));
        // Distance to the source is 0
        dist[src.id] = 0;

        while (settled.size() != V) {

            // Terminating condition check when
            // the priority queue is empty, return
            if (pq.isEmpty())
                return;

            // Removing the minimum distance DijkstraNode
            // from the priority queue
            int u = pq.remove().DijkstraNode.id;

            // Adding the DijkstraNode whose distance is
            // finalized
            if (settled.contains(u))

                // Continue keyword skips execution for
                // following check
                continue;

            // We don't have to call e_Neighbors(u)
            // if u is already present in the settled set.
            settled.add(u);

            e_Neighbours(u);
        }
    }

    // Method 2
    // To process all the neighbours
    // of the passed DijkstraNode
    private void e_Neighbours(int u)
    {

        int edgeDistance = -1;
        int newDistance = -1;

        // All the neighbors of v

        for (int i = 0; i < adj.get(u).size(); i++) {
            DijkstraNode v = adj.get(u).get(i);

            // If current DijkstraNode hasn't already been processed
            if (!settled.contains(v.DijkstraNode)) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;

                // If new distance is cheaper in cost
                if (newDistance < dist[v.DijkstraNode.id])
                    dist[v.DijkstraNode.id] = newDistance;

                // Add the current DijkstraNode to the queue
                pq.add(new DijkstraNode(v.DijkstraNode, dist[v.DijkstraNode.id]));
            }
        }
    }

    // Main driver method
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s =  br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int X = Integer.parseInt(s[1]);
        int Y = Integer.parseInt(s[2]);
        Location source = new Location(X, Y, 0);
        // Adjacency list representation of the
        // connected edges by declaring List class object
        // Declaring object of type List<DijkstraNode>
        List<List<DijkstraNode> > adj
                = new ArrayList<List<DijkstraNode> >();
        // Initialize list for every DijkstraNode
        for (int i = 0; i < N; i++) {
            List<DijkstraNode> item = new ArrayList<DijkstraNode>();
            adj.add(item);
        }
        // Inputs for the Tractor(dpq) graph
        for (int i = 1; i<N+1; i++){
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            Location loc = new Location(x, y, i);
            adj.get(0).add(new DijkstraNode(loc, 1));
        }
        // Calculating the single source shortest path
        Tractor dpq = new Tractor(N+1);
        dpq.dijkstra(adj, source);

        // Printing the shortest path to all the DijkstraNodes
        // from the source DijkstraNode
        System.out.println("The shorted path from DijkstraNode :");

        for (int i = 0; i < dpq.dist.length; i++)
            System.out.println(source + " to " + i + " is "
                    + dpq.dist[i]);
    }
}

// Class 2
// Helper class implementing Comparator interface
// Representing a DijkstraNode in the graph
class DijkstraNode implements Comparator<DijkstraNode> {

    // Member variables of this class
    public Location DijkstraNode;
    public int cost;

    // Constructors of this class

    // Constructor 1=
    public DijkstraNode() {}

    // Constructor 2
    public DijkstraNode(Location DijkstraNode, int cost)
    {

        // This keyword refers to current instance itself
        this.DijkstraNode = DijkstraNode;
        this.cost = cost;
    }

    // Method 1
    @Override public int compare(DijkstraNode DijkstraNode1, DijkstraNode DijkstraNode2)
    {

        if (DijkstraNode1.cost < DijkstraNode2.cost)
            return -1;

        if (DijkstraNode1.cost > DijkstraNode2.cost)
            return 1;

        return 0;
    }
}
