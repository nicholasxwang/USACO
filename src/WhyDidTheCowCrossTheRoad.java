//import java.io.*;
//import java.util.*;
//
//class Coordinate{
//    int x;
//    int y;
//    public Coordinate(int x, int y){
//        this.x = x;
//        this.y = y;
//    }
//}
//class cow_Node{
//    Coordinate c;
//    int id;
//    ArrayList<Node> neighbours;
//    public cow_Node(Coordinate C, int id, ArrayList<Node> neighbours){
//        this.c = C;
//        this.id = id;
//        this.neighbours = neighbours;
//    }
//}
//class cow_Graph{
//    ArrayList<Node> nodes;
//    public cow_Graph(ArrayList<Node> nodes){
//        this.nodes = nodes;
//    }
//
//}
//public class WhyDidTheCowCrossTheRoad {
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter("");
//        ArrayList<Coordinate> cows = new ArrayList<>();
//        ArrayList<ArrayList<Coordinate>> roads = new ArrayList<>();
//        //3 3 3
//        //2 2 2 3
//        //3 3 3 2
//        //3 3 2 3
//        //3 3
//        //2 2
//        //2 3
//        String[] s = br.readLine().split(" ");
//        int N = Integer.parseInt(s[0]);
//        int K = Integer.parseInt(s[1]);
//        int R = Integer.parseInt(s[2]);
//        for (int i = 0; i<K; i++){
//            s = br.readLine().split(" ");
//            Coordinate c1 = new Coordinate(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
//            Coordinate c2 = new Coordinate(Integer.parseInt(s[2]), Integer.parseInt(s[3]));
//            ArrayList<Coordinate> road = new ArrayList<>();
//            road.add(c1);
//            road.add(c2);
//            roads.add(road);
//        }
//        for (int i = 0; i<K; i++){
//            s = br.readLine().split(" ");
//            Coordinate c1 = new Coordinate(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
//            cows.add(c1);
//        }
//        //Don't use floodfill o_O, use bfs
//
//        //Find pairs 😀
//        for (int i = 0; i<cows.size(); i++){
//            for (int j = i; j<cows.size(); j++){
//                // Check if pairs :thonk:
//                for ()
//            }
//        }
//
//
//
//
//
//
//    }
//}
//
