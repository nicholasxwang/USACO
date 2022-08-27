import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class Barn{
    int index;
    ArrayList<Barn> neighbours = new ArrayList<>();
    int type;
    //Status Codes
    // 0 = H
    // 1 = G
    // 2 = Both
    public Barn(int index, int type){
        this.index = index;
        this.type = type;
    }
}
class VisitGraph{
    ArrayList<Barn> nodes = new ArrayList<>();

    public int bfs(Barn startNode, VisitGraph g, Barn endNode, int[][] cache) {
        //Queue<Integer> bfsQueue = new PriorityQueue<Integer>() {
        //};

        Queue<Barn> bfsQueue = new LinkedList<Barn>();
        ArrayList<Boolean> visited = new ArrayList<>();
        int visCount = 0;
        for (int i = 0; i<g.nodes.size(); i++){
            visited.add(false);
        }
        visited.set(startNode.index, true);
        //bfsQueue.add(startNode.id);
        bfsQueue.add(startNode);

        while (!bfsQueue.isEmpty()) {
            Barn currentNode = bfsQueue.peek();
            bfsQueue.remove();

            for (Barn neighbour : currentNode.neighbours) {
                if (!visited.get(neighbour.index)) {
                    visited.set(neighbour.index, true);
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
        BufferedReader br = new BufferedReader(new FileReader("milkvisits.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] farm_data = br.readLine().split("");
        //Status Codes
        // 0 = H
        // 1 = G
        // 2 = Both
        VisitGraph g = new VisitGraph();
        for (int i = 0; i<farm_data.length; i++){
            int type = 1;
            if (farm_data[i].equals("H")) type = 0;
            g.nodes.add(new Barn(i, type));
        }
        int[][] cache = new int[N][N]; //If you want to find type between 1 and 3, you do cache[1][3]

        for (int i = 0; i<N; i++){
            for (int j = 0; j<N; j++){
                cache[i][j] = -1;
            }

        }
        for (int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken())-1;
            int two = Integer.parseInt(st.nextToken())-1;
            g.nodes.get(one).neighbours.add(g.nodes.get(two));
            g.nodes.get(two).neighbours.add(g.nodes.get(one));
        }
        for (int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1;
            int end = Integer.parseInt(st.nextToken())-1;
            int type = 1;
            if (st.nextToken().equals("H")) type = 0;
            bfs()



        }









    }
}
