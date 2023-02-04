import java.io.*;
import java.util.*;

class TreeNode {
    int value;
    TreeNode parent;
    boolean is_root = false;
    boolean is_leaf = false;
    ArrayList<TreeNode> connections = new ArrayList<TreeNode>();
    public TreeNode(int value){
        this.value = value;
    }

}
class TheTree{
    ArrayList<TreeNode> nodes = new ArrayList<>();
    TreeNode root;
    public TheTree(){

    }

}
public class BarnTree {
    public static TheTree build_tree(int barns, int[] barn_values, int[][] connections){
        TheTree tree = new TheTree();
        int[] degrees = new int[barns];
        for (int i = 0; i<connections.length; i++){
            degrees[connections[i][0]-1]++;
            degrees[connections[i][1]-1]++;
        }
        // mark the ones with degree 1 as leaves and assign them a parent, then "remove" them from the tree and repeat
        int nodes_processed = 0;
        while (nodes_processed < barns){
            for (int i = 0; i<degrees.length; i++){
                if (degrees[i] == 1){
                    degrees[i] = 0;
                    nodes_processed++;
                    TreeNode node = new TreeNode(barn_values[i]);
                    tree.nodes.add(node);
                    for (int j = 0; j<connections.length; j++){
                        if (connections[j][0] == i+1){
                            degrees[connections[j][1]-1]--;
                            node.connections.add(new TreeNode(barn_values[connections[j][1]-1]));
                        }
                        else if (connections[j][1] == i+1){
                            degrees[connections[j][0]-1]--;
                            node.connections.add(new TreeNode(barn_values[connections[j][0]-1]));
                        }
                    }
                }
            }

        }
        return tree;
    }
    public static void balance(TheTree tree){

    }
    public static void function() throws IOException{
        // Get Data from Server
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); // Input Source
        int barns = Integer.parseInt(in.readLine()); // Number of Barns
        TheTree tree = new TheTree(); // Tree
        StringTokenizer st = new StringTokenizer(in.readLine());
        int average = 0; // Average Value of Barns
        int[] barn_values = new int[barns];
        for(int i = 0; i < barns; i++){
            barn_values[i] = Integer.parseInt(st.nextToken());
            average += barn_values[i];
        }
        average /= barns;
        for (int i = 0; i< barns; i++) barn_values[i] -= average;

        int[][] connections = new int[barns-1][2];
        for (int i = 0; i < barns-1; i++){
            st = new StringTokenizer(in.readLine());
            connections[i][0] = Integer.parseInt(st.nextToken());
            connections[i][1] = Integer.parseInt(st.nextToken());
        }

        tree = build_tree(barns, barn_values, connections);
        balance(tree);

    }
    public static void main(String[] args) throws IOException {
        function();

    }
}
