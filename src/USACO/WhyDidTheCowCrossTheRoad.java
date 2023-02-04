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
//    static boolean isValid(String[][] screen, int m, int n, int x, int y, String prevC, String newC) {
//        if (x < 0 || x >= m || y < 0 || y >= n
//                || screen[x][y].equals(newC) || !screen[x][y].equals(prevC))
//            return false;
//        return true;
//    }
//
//
//    // FloodFill function
//    static void floodFill(String[][] screen, int m, int n, int x, int y, String prevC, String newC) {
//        Vector<Point> queue = new Vector<Point>();
//
//        // Append the position of starting
//        // pixel of the component
//        queue.add(new Point(x, y));
//
//        // Color the pixel with the new color
//        screen[x][y] = newC;
//
//        // While the queue is not empty i.e. the
//        // whole component having prevC color
//        // is not colored with newC color
//        while (queue.size() > 0) {
//            // Dequeue the front node
//            Point currPixel = queue.get(queue.size() - 1);
//            queue.remove(queue.size() - 1);
//
//            int posX = currPixel.x;
//            int posY = currPixel.y;
//
//            // Check if the adjacent
//            // pixels are valid
//            if (isValid(screen, m, n, posX + 1, posY, prevC, newC)) {
//                // Color with newC
//                // if valid and enqueue
//                screen[posX + 1][posY] = newC;
//                queue.add(new Point(posX + 1, posY));
//            }
//
//            if (isValid(screen, m, n, posX - 1, posY, prevC, newC)) {
//                screen[posX - 1][posY] = newC;
//                queue.add(new Point(posX - 1, posY));
//            }
//
//            if (isValid(screen, m, n, posX, posY + 1, prevC, newC)) {
//                screen[posX][posY + 1] = newC;
//                queue.add(new Point(posX, posY + 1));
//            }
//
//            if (isValid(screen, m, n, posX, posY - 1, prevC, newC)) {
//                screen[posX][posY - 1] = newC;
//                queue.add(new Point(posX, posY - 1));
//            }
//        }
//    }
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
