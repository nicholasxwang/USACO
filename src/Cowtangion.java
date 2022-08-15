import java.io.*; import java.util.*;
class TheNode{
    int P;
    int id;
    ArrayList<TheNode> neighbours;
    public TheNode(int id, int P, ArrayList<TheNode> neighbours){
        this.id = id;
        this.P = P;
        this.neighbours = neighbours;
    }
}

class TheGraph {
    ArrayList<TheNode> nodes;

    public TheGraph(ArrayList<TheNode> nodes) {
        this.nodes = nodes;
    }

    public static boolean Pythagorean(int x_1, int y_1, int x_2, int y_2, int P) {
        return (P * P > (x_1 - x_2) * (x_1 - x_2) + (y_1 - y_2) * (y_1 - y_2));
    }


    public int bfs(Node startNode, Graph g) {
        //Queue<Integer> bfsQueue = new PriorityQueue<Integer>() {
        //};

        Queue<Node> bfsQueue = new LinkedList<Node>();
        ArrayList<Boolean> visited = new ArrayList<>();
        int visCount = 0;
        for (int i = 0; i<g.nodes.size(); i++){
            visited.add(false);
        }
        visited.set(startNode.id, true);
        //bfsQueue.add(startNode.id);
        bfsQueue.add(startNode);

        while (!bfsQueue.isEmpty()) {
            Node currentNode = bfsQueue.peek();
            bfsQueue.remove();

            for (Node neighbour : currentNode.neighbours) {
                if (!visited.get(neighbour.id)) {
                    visited.set(neighbour.id, true);
                    bfsQueue.add(neighbour);
                }
            }

            visCount += 1;
        }

        return visCount;

    }

}

public class Cowtangion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<TheNode> nodes = new ArrayList<TheNode>();
        for (int i = 0; i<N; i++){
            nodes.add(new TheNode(i+1, 0, new ArrayList<TheNode>()));
        }
        for (int i = 0; i<N-1  ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nodes.get(x-1).neighbours.add(nodes.get(y-1));
            nodes.get(y-1).neighbours.add(nodes.get(x-1));
        }
        TheGraph g = new TheGraph(nodes);


        System.out.println(g);



    }

}
