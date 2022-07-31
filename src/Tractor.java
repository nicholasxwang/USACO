import java.util.*;
import java.io.*;

public class Tractor {
    static class Pair<K, V> {
        public K a;
        public V b;
        public Pair(K a, V b) {
            this.a = a;
            this.b = b;
        }
        public K getKey() {
            return a;
        }
        public V getValue() {
            return b;
        }
    }
    static ArrayList<Pair<Integer, Integer>> graph[];
    static long dist[];
    static int N;

    static void dijkstra(int src) {
        //Set all distances to infinity
        for (int i = 0; i < N; ++i)
            dist[i] = Long.MAX_VALUE;
        PriorityQueue<Pair<Long, Integer>> pq = new PriorityQueue<Pair<Long, Integer>>
                ((a, b) -> Long.compare(a.getKey(), b.getKey()));
        dist[src] = 0; // The shortest path from a node to itself is 0
        pq.add(new Pair<Long, Integer>(0L, src));
        while(!pq.isEmpty()) {
            Pair<Long, Integer> p = pq.poll();
            long cdist = p.getKey();
            int node = p.getValue();
            if(cdist != dist[node])
                continue;
            for (Pair<Integer, Integer> i : graph[node]) {
                // If we can reach a neighbouring node faster,
                // we update its minimum distance
                if(cdist+i.getValue() < dist[i.getKey()]) {
                    dist[i.getKey()] = cdist + i.getValue();
                    pq.add(new Pair<Long, Integer>(dist[i.getKey()], i.getKey()));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N];
        dist = new long[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<Pair<Integer, Integer>>();
        }
        for (int i = 0; i <N ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph[i].add(new Pair<Integer, Integer>(N,N ));
        }
        dijkstra(0);

        for (int i = 0; i < N; i++) {
            System.out.print(dist[i] + " ");

        }
    }
}
