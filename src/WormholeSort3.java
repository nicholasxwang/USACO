import java.io.*; import java.util.*;
class theEdge {
    int d, w;
    theEdge(int d, int w) {
        this.d = d;
        this.w = w;
    }
}
public class WormholeSort3 {
    static void dfs(int curr, int label, int minW, LinkedList[] edges, int[] component) {
        //int[] component;
        if(component[curr] == label) return;
        component[curr] = label;
        for(theEdge child: edges[curr]) if(child.w >= minW) dfs(child.d, label, minW);
    }
    static boolean valid(int minW, int[] component, LinkedList[] edges) {
        Arrays.fill(component, -1);
        int numcomps = 0;
        for(int i = 0; i < component.length; i++) {
            if(component[i] < 0) {
                dfs(i, numcomps++, minW, edges, component);
            }
        }

        for(int i = 0; i < loc.length; i++) {
            if(component[i] != component[loc[i]]) return false;
        }
        return true;
    }
   public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new FileReader("wormhole.in"));
       PrintWriter pw = new PrintWriter(new FileWriter("wormhole.out"));
         StringTokenizer st = new StringTokenizer(br.readLine());
         int N = Integer.parseInt(st.nextToken());
         int M = Integer.parseInt(st.nextToken());
         st = new StringTokenizer(br.readLine());
         int[] cows = new int[N];
         LinkedList<Integer>[] edges = new LinkedList[N ];
         for (int i = 0; i<N; i++){
                cows[i] = Integer.parseInt(st.nextToken());
         }
         for (int i = 0; i<M; i++){
             st = new StringTokenizer(br.readLine());
             int a = Integer.parseInt(st.nextToken())-1;
             int b = Integer.parseInt(st.nextToken())-1;
             int w = Integer.parseInt(st.nextToken());
             edges[a].add(new theEdge(b, w));
             edges[b].add(new theEdge(a, w));
         }
         int low = 0;
         int high = 1000000001;
         while (low != high){
             int middle = (low + high + 1) / 2;
             if (valid(middle)) low = middle;
             else high = middle - 1;
         }
       if(low > 1e9) low = -1;
       pw.println(low);
       pw.close();

   }


}
