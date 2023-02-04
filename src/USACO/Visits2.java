import java.io.*;
import java.util.*;

class DSU {
    static ArrayList<Integer> e;

    public DSU(int N) {
        e = new ArrayList<Integer>(List.of(N, -1));
    }

    public static int get(int x) {
       //return e[x] < 0 ? x : e[x] = get(e[x]);
        if (e.get(x) < 0){
            return x;
        }else{
            return get(e.get(x)-1);
        }
    }

    public static boolean unite(int x, int y) {
//        x = get(x-1);
//        y = get(y-1);
        x = get(x);
        y = get(y);
        if (x == y) return false;
        if (e.get(x) > e.get(y)){
            int old_x = x;
            x = y;
            y = old_x;
        }
        e.set(x, e.get(x) + e.get(y));
        e.set(y, x);
        return true;
    }
}


public class Visits2 {
    public static void main(String[] args) throws IOException {
        int N;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int i = 1; i <= N; ++i) {
            int a, v;
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken())-1;
            v = Integer.parseInt(st.nextToken());
            edges.add(new ArrayList<>(List.of(v, i-1, a)));
        }
        Collections.sort(edges, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0) - o1.get(1);
            }
        });
        DSU D = new DSU(N+1);
        int ans = 0;
        for (ArrayList<Integer> a: edges){
            int v = a.get(0);
            int x = a.get(1);
            int y = a.get(2);
            if (D.unite(x, y)) ans += v;
        }
        System.out.println(ans);
    }

}
