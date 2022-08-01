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
        ArrayList<Edge>[] e = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            e[i] = new ArrayList<>();
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
            ArrayList<Boolean> visited = new ArrayList<>();
            int visCount = 0;
            for (int i = 0; i < N*2; i++) {
                visited.add(false);
            }
            visited.set(y, true);
            bfsQueue.add(y);
            while (!bfsQueue.isEmpty()) {
                int currentNode = bfsQueue.peek();
                bfsQueue.remove();

                for (Edge out : e[currentNode]) {
                    if (!visited.get(out.n2) && out.weight >= x) {
                        visited.set(out.n2, true);
                        bfsQueue.add(out.n2);
                        visCount += 1;
                    }
                }
            }
            if (q != Q-1) {
                pw.print(visCount + "\n");
            } else {
                pw.print(visCount);
            }
        }

        pw.close();

    }
}
