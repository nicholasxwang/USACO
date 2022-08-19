import java.io.*; import java.util.*;
public class GrassPlanting {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] neighbours = new ArrayList[N];
        for (int i = 0; i<N-1; i++){
            String s = br.readLine();
            int x = Integer.parseInt(s.split(" ")[0])-1;
            int y = Integer.parseInt(s.split(" ")[1])-1;
            if (neighbours[x] == null){
                neighbours[x] = new ArrayList<>();
            }
            neighbours[x].add(y);
            if (neighbours[y] == null){
                neighbours[y] = new ArrayList<>();
            }
            neighbours[y].add(x);
        }
        ArrayList<Integer> color = new ArrayList<>();
        for (int i = 0; i<N; i++){
            color.add(-1);
        }
        color.set(0, 0);
        Queue<Integer> processed = new LinkedList<>();
        processed.add(0);
        boolean[] visited = new boolean[N];
        while (!processed.isEmpty()){
            int cur = processed.poll();
            visited[cur] = true;
            if (neighbours[cur] != null && neighbours[cur].size() > 0){
                for (int i = 0; i<neighbours[cur].size(); i++){
                    int next = neighbours[cur].get(i);
                    if (!visited[next]){
                       ArrayList<Integer> taken_colors = new ArrayList<>();
                       for (int k = 0; k<neighbours[next].size(); k++){
                           int n = neighbours[next].get(k);
                           if (color.get(n) != -1){
                               taken_colors.add(color.get(n));
                           }
                       }
                       int available = 0;
                       while (true){
                           if (taken_colors.contains(available)){
                               available++;
                           }else{
                               break;
                           }
                       }
                          color.set(next, available);
                    }
                }
            }
        }
        System.out.println(color);
    }
}
