// Java Program to Implement Dijkstra's Algorithm
// Using Priority Queue

// Importing utility classes
import java.util.*;

// Main class DPQ
public class Tractor {

    // Member variables of this class
    private int dist[];
    private Set<Integer> settled;
    private PriorityQueue<DijkstraNode> pq;
    // Number of vertices
    private int V;
    List<List<DijkstraNode> > adj;

    // Constructor of this class
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
    public void dijkstra(List<List<DijkstraNode> > adj, int src)
    {
        this.adj = adj;

        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;

        // Add source DijkstraNode to the priority queue
        pq.add(new DijkstraNode(src, 0));

        // Distance to the source is 0
        dist[src] = 0;

        while (settled.size() != V) {

            // Terminating condition check when
            // the priority queue is empty, return
            if (pq.isEmpty())
                return;

            // Removing the minimum distance DijkstraNode
            // from the priority queue
            int u = pq.remove().DijkstraNode;

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
                if (newDistance < dist[v.DijkstraNode])
                    dist[v.DijkstraNode] = newDistance;

                // Add the current DijkstraNode to the queue
                pq.add(new DijkstraNode(v.DijkstraNode, dist[v.DijkstraNode]));
            }
        }
    }

    // Main driver method
    public static void main(String arg[])
    {

        int V = 5;
        int source = 0;

        // Adjacency list representation of the
        // connected edges by declaring List class object
        // Declaring object of type List<DijkstraNode>
        List<List<DijkstraNode> > adj
                = new ArrayList<List<DijkstraNode> >();

        // Initialize list for every DijkstraNode
        for (int i = 0; i < V; i++) {
            List<DijkstraNode> item = new ArrayList<DijkstraNode>();
            adj.add(item);
        }

        // Inputs for the Tractor(dpq) graph
        adj.get(0).add(new DijkstraNode(1, 9));
        adj.get(0).add(new DijkstraNode(2, 6));
        adj.get(0).add(new DijkstraNode(3, 5));
        adj.get(0).add(new DijkstraNode(4, 3));

        adj.get(2).add(new DijkstraNode(1, 2));
        adj.get(2).add(new DijkstraNode(3, 4));

        // Calculating the single source shortest path
        Tractor dpq = new Tractor(V);
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
    public int DijkstraNode;
    public int cost;

    // Constructors of this class

    // Constructor 1
    public DijkstraNode() {}

    // Constructor 2
    public DijkstraNode(int DijkstraNode, int cost)
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
