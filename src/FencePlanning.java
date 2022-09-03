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
        BufferedReader br = new BufferedReader(new FileReader("fenceplan.in"));
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
            Set<Integer> region = new HashSet<Integer>();
            FenceCow startNode = cows.get(n);
            region.add(startNode.id);
            Queue<FenceCow> bfsQueue = new LinkedList<FenceCow>();
            bfsQueue.add(startNode);

            while (!bfsQueue.isEmpty()) {
                FenceCow currentNode = bfsQueue.peek();
                bfsQueue.remove();

                for (FenceCow neighbour : currentNode.neighbours) {
                    if (!cows.get(neighbour.id).visited) {
                        cows.get(neighbour.id).visited = true;
                        region.add(neighbour.id);
                        bfsQueue.add(neighbour);
                    }
                }
            }
            regions.add(new ArrayList<>(region));
        }
        //System.out.println(regions);
        int min_peri = 999999999;
        for (int i = 0; i<regions.size(); i++){
            int smallest_x = 999999999;
            int smallest_y = 999999999;
            int biggest_x = 0;
            int biggest_y = 0;
            for (int j = 0; j<regions.get(i).size(); j++){
                int x = cows.get(regions.get(i).get(j)).x;
                int y = cows.get(regions.get(i).get(j)).y;
                if (x > biggest_x) biggest_x = x;
                if (y > biggest_y) biggest_y = y;
                if (x < smallest_x) smallest_x = x;
                if (y < smallest_y) smallest_y = y;

            }
            int perimeter = 2*(biggest_x - smallest_x) +  2*(biggest_y - smallest_y);
            if (min_peri > perimeter) min_peri = perimeter;
        }
       PrintWriter pw = new PrintWriter("fenceplan.out");
        pw.println(min_peri);
        pw.close();




    }
}
