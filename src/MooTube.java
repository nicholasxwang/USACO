//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.nio.Buffer;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.Queue;
//
//class Node_{
//    int id;
//    ArrayList<Node_> neighbours;
//    public Node_( ArrayList<Node_> neighbours, int id){
//        this.neighbours = neighbours;
//        this.id = id;
//    }
//}
//
//class Edge_{
//    Node_ n1;
//    Node_ n2;
//    int weight;
//    public Edge_(int weight, Node_ n1, Node_ n2){
//        this.n1 = n1;
//        this.n2 = n2;
//        this.weight = weight;
//    }
//}
//
//
//
//class Graph_ {
//    ArrayList<Node_> nodes;
//    ArrayList<Edge_> edges;
//
//    public Graph_(ArrayList<Node_> nodes) {
//        this.nodes = nodes;
//    }
//
//    public void add_node(int id) {
//        Node_ n = new Node_(new ArrayList<Node_>(), id);
//
//        this.nodes.add(n);
//    }
//    public void add_edge(int weight, Node_ n1, Node_ n2) {
//        Edge_ n = new Edge_(weight, n1, n2);
//
//        this.edges.add(n);
//    }
//
//    public int start_bfs() {
//        int maximum = -1;
//        for (int i = 0; i < this.nodes.size(); i++) {
//            int bfs = bfs(this.nodes.get(i), this);
//            if (bfs > maximum) {
//                maximum = bfs;
//            }
//        }
//        return maximum;
//
//    }
//
//    public int bfs(Node_ startNode, Graph_ g) {
//        //Queue<Integer> bfsQueue = new PriorityQueue<Integer>() {
//        //};
//
//        Queue<Node_> bfsQueue = new LinkedList<Node_>();
//        ArrayList<Boolean> visited = new ArrayList<>();
//        int visCount = 0;
//        for (int i = 0; i<g.nodes.size(); i++){
//            visited.add(false);
//        }
//        visited.set(startNode.id, true);
//        //bfsQueue.add(startNode.id);
//        bfsQueue.add(startNode);
//
//        while (!bfsQueue.isEmpty()) {
//            Node_ currentNode = bfsQueue.peek();
//            bfsQueue.remove();
//
//            for (Node_ neighbour : currentNode.neighbours) {
//                if (!visited.get(neighbour.id)) {
//                    visited.set(neighbour.id, true);
//                    bfsQueue.add(neighbour);
//                }
//            }
//
//            visCount += 1;
//        }
//
//        return visCount;
//
//    }
//
//}
//
//
//public class MooTube {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] s;
//        s = br.readLine().split(" ");
////4 3
////1 2 3
////2 3 2
////2 4 4
////1 2
////4 1
////3 1
//        int N = Integer.parseInt(s[0]);
//        int Q = Integer.parseInt(s[1]);
//        Graph_ g = new Graph_(new ArrayList<Node_>());
//        for (int i = 0; i < N; i++){
//            g.add_node(i);
//        }
//        for (int i = 0; i<N-1; i++){
//
//        }
//            g.add_edge();
//        }
//
//
//
//        for (int i = 0; i < Q; i++){
//
//        }
//
//
//
//    }
