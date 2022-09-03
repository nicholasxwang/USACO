import java.io.*;
import java.util.*;

//Status Codes
// 0 = H
// 1 = G
// 2 = Both

class Barn{
    int index;
    ArrayList<Barn> neighbours = new ArrayList<>();
    int type;

    public Barn(int index, int type){
        this.index = index;
        this.type = type;
    }
}
class VisitGraph{
    ArrayList<Barn> nodes = new ArrayList<>();

    public int bfs(Barn startNode, VisitGraph g, int[][] cache) {
        Queue<Barn> bfsQueue = new LinkedList<Barn>();
        ArrayList<Boolean> visited = new ArrayList<>();
        int visCount = 0;
        for (int i = 0; i<g.nodes.size(); i++){
            visited.add(false);
        }
        visited.set(startNode.index, true);
        bfsQueue.add(startNode);

        while (!bfsQueue.isEmpty()) {
            Barn currentNode = bfsQueue.peek();
            bfsQueue.remove();

            for (Barn neighbour : currentNode.neighbours) {
                if (!visited.get(neighbour.index)) {
                    visited.set(neighbour.index, true);
                    if (cache[neighbour.index][currentNode.index] == -1){
                        if (neighbour.type == currentNode.type){
                            cache[neighbour.index][currentNode.index] = neighbour.type;
                            cache[currentNode.index][neighbour.index] = neighbour.type;
                        }else{
                            cache[neighbour.index][currentNode.index] = 2;
                            cache[currentNode.index][neighbour.index] = 2;
                        }
                    }
                    bfsQueue.add(neighbour);
                }
            }
            visCount += 1;
        }

        return visCount;

    }

}
public class MilkVisits {
    public static void main(String[] args) throws IOException {



    }
}
