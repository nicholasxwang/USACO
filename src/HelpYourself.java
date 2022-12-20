import java.util.*;
import java.io.*;

class SubsetNode{
    int id;
    ArrayList<SubsetNode> neighbours = new ArrayList<>();
    public SubsetNode(int id){
        this.id = id;
    }
}
public class HelpYourself {
    public static int bfs(ArrayList<Integer> nodes_to_skip, ArrayList<SubsetNode> nodes){
        if (nodes_to_skip.size() == nodes.size()) return 0;
        if (nodes_to_skip.size()+1 == nodes.size()) return 1;
        int connected_components = 0;
        boolean[] visited = new boolean[nodes.size()];
        for (int i = 0; i<nodes.size(); i++){
            if (nodes_to_skip.contains(i)) continue;
            if (visited[i]) continue;
            connected_components++;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            while (!queue.isEmpty()){
                int current = queue.peek();
                queue.remove(current);
                visited[current] = true;
                for (int j = 0; j<nodes.get(current).neighbours.size(); j++){
                    if (!nodes_to_skip.contains(nodes.get(current).neighbours.get(j).id) &&
                            !visited[nodes.get(current).neighbours.get(j).id]){
                        queue.add(nodes.get(current).neighbours.get(j).id);
                    }
                }
            }
        }
        return connected_components;
    }
    public static boolean checkIntersection(int[] interval1, int[] interval2){
        int start1 = interval1[0];
        int start2 = interval2[0];
        int end1 = interval1[1];
        int end2 = interval2[1];
        if ((start1 <= end2) && (end1 >= start2)) return true;
        if ((start2 <= end1) && (end2 >= start1)) return true;
        return false;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("help.in"));
        int N = Integer.parseInt(br.readLine());
        int[][] intervals = new int[N][2];
        for (int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            intervals[i][0] = Integer.parseInt(st.nextToken());
            intervals[i][1] = Integer.parseInt(st.nextToken());
        }
        ArrayList<SubsetNode> nodes = new ArrayList<>();
        for (int i = 0; i<N; i++){
            nodes.add(new SubsetNode(i));
        }
        for (int i = 0; i<N; i++){
            for (int j = i+1; j<N; j++){
                if (checkIntersection(intervals[i], intervals[j])){
                    nodes.get(i).neighbours.add(nodes.get(j));
                    nodes.get(j).neighbours.add(nodes.get(i));
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < (1<<N); i++) {
            ArrayList<Integer> nodes_to_skip = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) > 0)
                    nodes_to_skip.add(j);
            }
            int answer = bfs(nodes_to_skip, nodes);
            ans += answer;
        }
        PrintWriter pw = new PrintWriter("help.out");
        pw.println(ans);
        pw.close();

    }

}
