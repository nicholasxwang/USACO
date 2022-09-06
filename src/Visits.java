import java.io.*;
import java.util.*;


class NetworkEdge{
    int c1;  //cow visiting
    int c2; //cow being visted
    int w; //number of moos
    public NetworkEdge(int c1, int c2, int w){
        this.c1 = c1;
        this.c2 = c2;
        this.w = w;
    }
}

class NetworkNode{
    int vistors; //number of visitors
    int id;
    public NetworkNode(int id){
        this.vistors = 0;
        this.id = id;
    }

}
public class Visits {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<NetworkEdge> edges = new ArrayList<>();
        ArrayList<NetworkNode> nodes = new ArrayList<>();
        for (int i = 0; i<N; i++){
            nodes.add(new NetworkNode(i));
        }
        for (int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken())-1;
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new NetworkEdge(i, cow, weight));
            nodes.get(cow).vistors = nodes.get(cow).vistors+1;
        }

        Collections.sort(edges, new Comparator<NetworkEdge>() {
            public int compare(NetworkEdge o1, NetworkEdge o2) {
                if (o1.w != o2.w) return o2.w - o1.w;
                return 0;
            }
        });
        ArrayList<Integer> blacklisted = new ArrayList<>();
        int MAX = 0;
        for (int i = 0; i<edges.size(); i++){
            NetworkEdge current = edges.get(i);
            if (blacklisted.contains(nodes.get(current.c1).id)) continue;
            blacklisted.add(current.c2);
            //System.out.println(blacklisted);
            MAX+=current.w;
        }
        System.out.println(MAX);



    }

}
