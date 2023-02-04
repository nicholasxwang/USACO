//import java.io.*;
//import java.util.Vector;
//
//public class Multimoo{
//    //floodfill
//    // FloodFill function
//    static boolean isValid(int[][] screen, int m, int n, int x, int y, int prevC, int newC)
//    {
//        if(x < 0 || x >= m || y < 0 || y >= n
//                || screen[x][y]== newC || screen[x][y] == "#")
//            return false;
//        return true;
//    }
//
//
//    // FloodFill function
//    static void floodFill(int[][] screen, int m, int n, int x, int y, String prevC, String newC)
//    {
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
//        while(queue.size() > 0)
//        {
//            // Dequeue the front node
//            Point currPixel = queue.get(queue.size() - 1);
//            queue.remove(queue.size() - 1);
//
//            int posX = currPixel.x;
//            int posY = currPixel.y;
//
//            // Check if the adjacent
//            // pixels are valid
//            if(isValid(screen, m, n, posX + 1, posY, prevC, newC))
//            {
//                // Color with newC
//                // if valid and enqueue
//                screen[posX + 1][posY] = newC;
//                queue.add(new Point(posX + 1, posY));
//            }
//
//            if(isValid(screen, m, n, posX-1, posY, prevC, newC))
//            {
//                screen[posX-1][posY]= newC;
//                queue.add(new Point(posX-1, posY));
//            }
//
//            if(isValid(screen, m, n, posX, posY + 1, prevC, newC))
//            {
//                screen[posX][posY + 1]= newC;
//                queue.add(new Point(posX, posY + 1));
//            }
//
//            if(isValid(screen, m, n, posX, posY-1, prevC, newC))
//            {
//                screen[posX][posY-1]= newC;
//                queue.add(new Point(posX, posY-1));
//            }
//        }
//    }
//
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new FileReader("multimoo.in"));
//        int N = Integer.parseInt(br.readLine());
//        int[][] grid = new int[N][N];
//        for (int i = 0; i<N; i++){
//            String[] line = br.readLine().split(" ");
//            for (int j = 0; j<N; j++){
//                grid[i][j] = Integer.parseInt(line[j]);
//            }
//        }
//
//        for (int i = 0; i<N; i++){
//            for (int j = 0; j<N; j++){
//                if (grid[i][j] == 1){
//                    floodFill(grid, N, N, i, j, "0", "1");
//                }
//            }
//        }
//
//        for (int i = 0; i<N; i++){
//
//
//        }
//
//    }
//}