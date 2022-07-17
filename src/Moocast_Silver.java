import java.io.*;
import java.util.*;

class Node{
    int x;
    int y;
    int P;
    int id;
    ArrayList<Node> neighbours;
    public Node(int x, int y, int P, ArrayList<Node> neighbours, int id){
        this.x = x;
        this.y = y;
        this.P = P;
        this.neighbours = neighbours;
        this.id = id;
    }
}

class Graph{
    ArrayList<Node> nodes;
    public Graph(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }
    public static boolean Pythagorean(int x_1, int y_1, int x_2, int y_2, int P){
        return (P*P > (x_1-x_2)*(x_1-x_2) + (y_1-y_2)*(y_1-y_2));
    }
    public void add_node(int x, int y, int P, int id){
        Node n = new Node(x,y,P, new ArrayList<Node>(), id);
        for (int i = 0; i<this.nodes.size(); i++){
            if (Pythagorean(x, y, this.nodes.get(i).x, this.nodes.get(i).y, P)){
                n.neighbours.add(this.nodes.get(i));
            }
            if (Pythagorean(x, y, this.nodes.get(i).x, this.nodes.get(i).y, this.nodes.get(i).P)){
                this.nodes.get(i).neighbours.add(n);
            }
        }
        this.nodes.add(n);
    }
    public int start_dfs(){
        int ans = 0;
        for (int i = 0; i<nodes.size(); i++){
            int dfs = dfs(nodes.get(i));
            if (dfs> ans)
                ans = dfs(nodes.get(i));
        }
        return ans;

    }
    public int dfs(Node n){
        int ans = 0;
        for (int i = 0; i<n.neighbours.size(); i++){
            int dfs = dfs(n.neighbours.get(i));
            if (ans<dfs) {
                ans = dfs;
            }
        }
        return ans;
    }

    }



public class Moocast_Silver {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
        int N = Integer.parseInt(br.readLine());
        Graph g = new Graph(new ArrayList<Node>());
        String[] t;
        for (int i = 0; i<N; i++){
            t = br.readLine().split(" ");
            g.add_node(Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]), i);

        }
        PrintWriter pw = new PrintWriter("moocast.out");
        pw.println(g.start_dfs());
        pw.close();
    }
}
