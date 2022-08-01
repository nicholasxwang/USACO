import java.io.*;
import java.util.*;
class Edge{
    int  n1;
    int n2;
    int weight;
    public Edge(int weight, int n1, int n2){this.n1 = n1; this.n2 = n2; this.weight = weight; }
}
public class MooTube {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
        PrintWriter pw = new PrintWriter("mootube.out");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        LinkedList<Edge>[] e = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            e[i] = new LinkedList<>();
        }
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            e[x-1].add(new Edge(z, x-1, y-1));
            e[y-1].add(new Edge(z, y-1, x-1));
        }
        String answer = "";
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken())-1;
            LinkedList<Integer> bfsQueue = new LinkedList<Integer>();
            boolean[] visited = new boolean[N];
            int visCount = 0;
//            for (int i = 0; i < N; i++) {
//                visited[i] = false;
//            }
            visited[y] = true;
            bfsQueue.add(y);
            while (!bfsQueue.isEmpty()) {
                int currentNode = bfsQueue.peek();
                bfsQueue.remove();

                for (Edge out : e[currentNode]) {
                    if (!visited[out.n2] && out.weight >= x) {
                        visited[out.n2] = true;
                        bfsQueue.add(out.n2);
                        visCount += 1;
                    }
                }
            }
            if (q != Q-1) {
               answer+=(visCount + "\n");
            } else {
                answer+=(visCount);
            }
        }

        pw.println(answer);
        pw.close();

    }
}
