import java.io.*;
import java.util.*;

class ClockRoom{
    int id;
    ArrayList<ClockRoom> neighbours = new ArrayList<>();
    int time;
    int process_time = 0;
    public ClockRoom(int id, int time){
        this.id = id;
        this.time = time;
    }
}
class ClockGraph{
    ArrayList<ClockRoom> rooms;
    public boolean bfs(ClockRoom start_node){
        for (int i = 0; i<this.rooms.size(); i++){
            this.rooms.get(i).process_time = this.rooms.get(i).time;
        }
        
        Queue<ClockRoom> bfsQueue = new LinkedList<ClockRoom>();
        bfsQueue.add(start_node);

        while (!bfsQueue.isEmpty()) {
            ClockRoom currentNode = bfsQueue.peek();
            bfsQueue.remove();

            for (ClockRoom neighbour : currentNode.neighbours) {
                if (this.rooms.get(neighbour.id).process_time < 12) {
                    this.rooms.get(neighbour.id).process_time+=1;
                    bfsQueue.add(neighbour);
                }
            }
        }
        return true;
    }
}
public class clock {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> terms = new ArrayList<>();
        for (int i = 0; i<N; i++){
            terms.add(Integer.parseInt(st.nextToken()));
        }
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        for (int i = 0; i<N-1; i++){
            ArrayList<Integer> ar = new ArrayList<>();
            ar.add(Integer.parseInt(st.nextToken()));
            ar.add(Integer.parseInt(st.nextToken()));
            paths.add(ar);
        }
        ClockGraph g = new ClockGraph();
        for (int i = 0; i<terms.size(); i++){
            ClockRoom cr = new ClockRoom(i, terms.get(i));
            g.rooms.add(cr);
        }
        for (int i = 0; i < N-1; i++){
            g.rooms.get(paths.get(i).get(0)-1).neighbours.add(g.rooms.get(paths.get(i).get(1)-1));
            g.rooms.get(paths.get(i).get(1)-1).neighbours.add(g.rooms.get(paths.get(i).get(0)-1));
        }
        for (int i = 0; i<N; i++){
            System.out.println(g.bfs(g.rooms.get(i)));
        }
    }
}
