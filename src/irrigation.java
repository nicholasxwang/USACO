import java.io.*;
import java.util.*;
import java.util.*;

class DisjointSets {
    int[] parents;  // 0-indexed
    int[] sizes;

    public DisjointSets(int size) {
        sizes = new int[size];
        parents = new int[size];
        Arrays.fill(sizes, 1);
        Arrays.fill(parents, -1);
    }

    // finds the "representative" node in a's component
    public int find(int x) {
        return parents[x] == -1 ? x : (parents[x] = find(parents[x]));
    }

    // returns whether the merge changed connectivity
    public boolean union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        if (xRoot == yRoot) {
            return false;
        }
        if (sizes[xRoot] < sizes[yRoot]) {
            parents[xRoot] = yRoot;
            sizes[yRoot] += sizes[xRoot];
        } else {
            parents[yRoot] = xRoot;
            sizes[xRoot] += sizes[yRoot];
        }
        return true;
    }

    // returns whether two nodes are in the same connected component
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
public class irrigation {
    public static HashMap<Integer, ArrayList<Integer>> MST;
    public static PriorityQueue<Edge> pq; //contains all edges

    public static int calculate(int xi, int xj, int yi, int yj){
        return (xi-xj)*(xi-xj)+(yi-yj)*(yi-yj);
    }
    //Assumes that DSU code is included
    public static void kruskal() {
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (DisjointSets.find(e.start) != DisjointSets.find(e.end)) {
                MST.get(e.start).add(e.end);
                MST.get(e.end).add(e.start);
                DisjointSets.union(e.start, e.end);
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int start,
                end,
                weight;
        public Edge(int s, int e, int w) {
            start = s;
            end = e;
            weight = w;
        }
        public int compareTo(Edge o) {
            if (this.weight > o.weight) {
                return 1;
            } else if (this.weight == o.weight) {
                return 0;
            } else {
                return -1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

    }

}
