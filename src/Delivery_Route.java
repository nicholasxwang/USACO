//import java.io.*;
//import java.util.*;
//
//public class Delivery_Route {
//    static int max_value = 999999999;
//    public static void dijkstra(int[][] graph, ArrayList<Integer> source, int max_y){
//        int V = graph.length;
//        int[] parent = new int[V];
//        ArrayList<Integer> value = new ArrayList<>();
//        ArrayList<Boolean> processed = new ArrayList<>();
//        for (int i = 0; i<V; i++){
//            value.add(max_value);
//            processed.add(false);
//            parent[i] = -1;
//        }
//        int source_int = twoD_to_oneD(source.get(0), source.get(1), max_y);
//        parent[source_int] = -1;
//        value.set(source_int, 0);
//        for (int i = 0; i<V; i++){
//            int U = selectMinVertex(value, processed, V);
//            processed.set(U, true);
//            for (int j = 0; j<V; j++){
//                if (graph[U][j]!=-1  && !processed.get(j) && value.get(U) != max_value &&
//                        value.get(U) + graph[U][j] < value.get(j)){
//                    if (value.get(U) + graph[U][j] < value.get(j)){
//                        value.set(j, value.get(U) + graph[U][j]);
//                        parent[j] = U;
//                    }
//                }
//            }
//        }
//        for (int i = 0; i<V; i++){
//            int weight;
//            try {
//                weight = graph[i][parent[i]];
//            }catch(Exception e){
//                weight=-1;
//            }
//            System.out.println(oneD_to_twoD(i, max_y)+" (id # "+i +")'s parent is "+oneD_to_twoD(parent[i], max_y)+" (id #"+parent[i]+") and their weight is "+weight+". The value is "+value.get(i)+". It has been processed: "+processed.get(i));
//        }
//        System.out.println(value.get(0));
//    }
//   public static void main(String[] args) throws IOException{
//       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//       int N = Integer.parseInt(br.readLine());
//       int[][] coords = new int[N][2];
//       int smallestx = 0;
//       int largestx = 0;
//       int smallesty = 0;
//       int largesty = 0;
//       for (int i = 0; i<N; i++) {
//           StringTokenizer st = new StringTokenizer(br.readLine());
//           coords[i][0] = Integer.parseInt(st.nextToken());
//           coords[i][1] = Integer.parseInt(st.nextToken());
//            if (coords[i][0] < coords[smallestx][0]){
//            smallestx = i;
//            }
//            if (coords[i][1] < coords[smallesty][1]){
//                smallesty = i;
//            }
//       }
//       // adjust the graph such that the smallest (x,y) is (2,2)
//       for (int i = 0; i<N; i++) {
//           coords[i][0] -= coords[smallestx][0];
//           coords[i][1] -= coords[smallesty][1];
//           coords[i][0] += 2;
//           coords[i][1] += 2;
//          if (coords[i][0] > coords[largestx][0]){
//            largestx = i;
//            }
//            if (coords[i][1] > coords[largesty][1]){
//             largesty = i;
//            }
//       }
//
//
//   }
//
//}
