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


    public int bfs(TheGraph g) {
        Queue<TheNode> bfsQueue = new LinkedList<TheNode>();
        ArrayList<Boolean> visited = new ArrayList<>();
        for (int i = 0; i<g.nodes.size(); i++){
            visited.add(false);
        }
        int visCount = 0;
        for (int i = 0; i<g.nodes.size(); i++){
            if (g.nodes.get(i).neighbours.size() == 1){
                g.nodes.get(i).P = 1;
                visited.set(i, true);
                visCount++;
                bfsQueue.add(g.nodes.get(i));
            }
        }


        while (!bfsQueue.isEmpty()) {
            TheNode currentNode = bfsQueue.peek();
            bfsQueue.remove();

            for (TheNode neighbour : currentNode.neighbours) {
                if (!visited.get(neighbour.id-1)) {
                    visited.set(neighbour.id-1, true);
                    neighbour.P = currentNode.P + 1;
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
            nodes.add(new TheNode(i+1, Integer.MAX_VALUE, new ArrayList<TheNode>()));
        }
        for (int i = 0; i<N-1  ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            nodes.get(x-1).neighbours.add(nodes.get(y-1));
            nodes.get(y-1).neighbours.add(nodes.get(x-1));
        }
        TheGraph g = new TheGraph(nodes);


        System.out.println(g.bfs(g));




    }

}
