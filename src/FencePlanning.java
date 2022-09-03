import java.io.*;
import java.util.*;

class FenceCow {
    int x;
    int y;
    int id;
    ArrayList<FenceCow> neighbours = new ArrayList<>();
    boolean visited = false;
    public FenceCow(int x, int y, int id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

}
public class FencePlanning {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<FenceCow> cows = new ArrayList<>();
        for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cows.add(new FenceCow(x, y, i));
        }
        for (int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken())-1;
            int c2 = Integer.parseInt(st.nextToken())-1;
            cows.get(c1).neighbours.add(cows.get(c2));
            cows.get(c2).neighbours.add(cows.get(c1));
        }
        ArrayList<ArrayList<Integer>> regions = new ArrayList<>();
        for (int n = 0; n<N; n++){
            if (cows.get(n).visited) continue;
            ArrayList<Integer> region = new ArrayList<>();
            FenceCow startNode = cows.get(n);
            Queue<FenceCow> bfsQueue = new LinkedList<FenceCow>();
            bfsQueue.add(startNode);

            while (!bfsQueue.isEmpty()) {
                FenceCow currentNode = bfsQueue.peek();
                region.add(currentNode.id);
                bfsQueue.remove();

                for (FenceCow neighbour : currentNode.neighbours) {
                    if (!cows.get(neighbour.id).visited) {
                        cows.get(neighbour.id).visited = true;
                        bfsQueue.add(neighbour);
                    }
                }
            }
            regions.add(region);
        }
        System.out.println(regions);




    }
}
