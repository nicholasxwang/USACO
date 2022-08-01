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
        String[] s;
        s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int Q = Integer.parseInt(s[1]);
        LinkedList<Edge>[] e = new LinkedList[N];
        for (int i = 0; i < N; i++) {
            e[i] = new LinkedList<>();
        }
        for (int i = 0; i < N-1; i++) {
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            int z = Integer.parseInt(s[2]);
            e[x-1].add(new Edge(z, x-1, y-1));
            e[y-1].add(new Edge(z, y-1, x-1));
        }
        String answer = "";
        for (int q = 0; q < Q; q++) {
            s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1])-1;
            Queue<Integer> bfsQueue = new LinkedList<Integer>();
            boolean[] visited = new boolean[N];
            int visCount = 0;
            for (int i = 0; i < N; i++) {
                visited[i] = false;
            }
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
