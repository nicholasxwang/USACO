//import java.io.*;
//import java.lang.reflect.Array;
//import java.util.*;
//
//class DeliveryBarn{
//    int value;
//    ArrayList<Integer> connections = new ArrayList<Integer>();
//    int id;
//    int parent = -1;
//    ArrayList<Integer> children = new ArrayList<Integer>();
//
//    public DeliveryBarn(int id, int value){
//        this.id = id;
//        this.value = value;
//    }
//
//    public void addConnection(int id){
//        connections.add(id);
//    }
//}
//class DeliveryNetwork{
//    ArrayList<DeliveryBarn> barns = new ArrayList<>();
//    int barnsCount;
//    int rootId = -1;
//
//    public DeliveryNetwork(int[] values, int average, int[][] connections){
//        barnsCount = values.length;
//        for (int i = 0; i < values.length; i++){
//            barns.add(new DeliveryBarn(i, values[i] - average));
//        }
//        for (int i = 0; i < connections.length; i++){
//            barns.get(connections[i][0]).addConnection(connections[i][1]);
//            barns.get(connections[i][1]).addConnection(connections[i][0]);
//        }
//        rootId = findRoot();
//        constructTree();
//
//    }
//
//    public int findRoot(){
//        int[] temporaryConnections = new int[barnsCount];
//        ArrayList<Integer> roots = new ArrayList<>();
//        for (int i = 0; i < barns.size(); i++){
//            temporaryConnections[i] = barns.get(i).connections.size();
//            roots.add(i);
//        }
//        while (roots.size() > 1){
//            for (int i = 0; i < barnsCount; i++){
//                if (temporaryConnections[i] == 1){
//                    temporaryConnections[i] = 0;
//                    roots.remove((Integer)i);
//                    for (int j = 0; j < barns.get(i).connections.size(); j++){
//                        temporaryConnections[barns.get(i).connections.get(j)]--;
//                    }
//                }
//            }
//        }
//        return roots.get(0);
//    }
//    public void constructTree(){
//        // fill out parent and children attributes for each barn
//        // start from the root
//        ArrayList<Integer> queue = new ArrayList<>();
//        queue.add(rootId);
//        while (queue.size() > 0){
//            int currentBarn = queue.get(0);
//            queue.remove(0);
//            for (int i = 0; i < barns.get(currentBarn).connections.size(); i++){
//                int connection = barns.get(currentBarn).connections.get(i);
//                if (barns.get(connection).parent == -1){
//                    if (rootId != currentBarn) barns.get(connection).parent = currentBarn;
//                    barns.get(currentBarn).children.add(connection);
//                    queue.add(connection);
//                }
//            }
//        }
//    }
//    public void solve(int node){
//        // recursive algorithm
//        if (barns.get(node).children.size() == 0){
//            // leaf node
//            if (barns.get(node).value > 0){
//
//            }else if (barns.get(node).value < 0){
//                // send to parent
//                barns.get(barns.get(node).parent).value += barns.get(node).value;
//                barns.get(node).value = 0;
//            }else{
//                return;
//            }
//        }
//        else{
//            for (int )
//        }
//    }
//}
//public class __BarnTree__ {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        int[] barns = new int[N];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int average = 0;
//        for (int i = 0; i < N; i++) {
//            barns[i] = Integer.parseInt(st.nextToken());
//            average+= barns[i];
//        }
//        average/=N;
//        int[][] connections = new int[N-1][2];
//        for (int i = 0; i<N-1; i++){
//            st = new StringTokenizer(br.readLine());
//            connections[i][0] = Integer.parseInt(st.nextToken())-1;
//            connections[i][1] = Integer.parseInt(st.nextToken())-1;
//
//        }
//        DeliveryNetwork network = new DeliveryNetwork(barns, average, connections);
//        network.solve(0);
//
//
//    }
//}
