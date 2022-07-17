import java.util.*;
import java.io.*;

class Point{
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class BuildGate {
    public static void printgrid(String[][] grid){
        for (int i = 0; i<grid.length; i++){
            for (int j = 0; j<grid[0].length; j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
    // Function that returns true if
    // the given pixel is valid
    static boolean isValid(String[][] screen, int m, int n, int x, int y, String prevC, String newC)
    {
        if(x < 0 || x >= m || y < 0 || y >= n || screen[x][y] != prevC
                || screen[x][y]== newC || screen[x][y] == "#")
            return false;
        return true;
    }


    // FloodFill function
    static void floodFill(String[][] screen, int m, int n, int x, int y, String prevC, String newC)
    {
        Vector<Point> queue = new Vector<Point>();

        // Append the position of starting
        // pixel of the component
        queue.add(new Point(x, y));

        // Color the pixel with the new color
        screen[x][y] = newC;

        // While the queue is not empty i.e. the
        // whole component having prevC color
        // is not colored with newC color
        while(queue.size() > 0)
        {
            // Dequeue the front node
            Point currPixel = queue.get(queue.size() - 1);
            queue.remove(queue.size() - 1);

            int posX = currPixel.x;
            int posY = currPixel.y;

            // Check if the adjacent
            // pixels are valid
            if(isValid(screen, m, n, posX + 1, posY, prevC, newC))
            {
                // Color with newC
                // if valid and enqueue
                screen[posX + 1][posY] = newC;
                queue.add(new Point(posX + 1, posY));
            }

            if(isValid(screen, m, n, posX-1, posY, prevC, newC))
            {
                screen[posX-1][posY]= newC;
                queue.add(new Point(posX-1, posY));
            }

            if(isValid(screen, m, n, posX, posY + 1, prevC, newC))
            {
                screen[posX][posY + 1]= newC;
                queue.add(new Point(posX, posY + 1));
            }

            if(isValid(screen, m, n, posX, posY-1, prevC, newC))
            {
                screen[posX][posY-1]= newC;
                queue.add(new Point(posX, posY-1));
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("gates.in"));
        br.readLine();
        String s = br.readLine();
        ArrayList<ArrayList<Integer>> went = new ArrayList<>();
        int x = 0;
        int y = 0;

        ArrayList<Integer> t  = new ArrayList<>();
        t.add(0);
        t.add(0);
        went.add(t);
        int smallest_x = 10000;
        int smallest_y = 10000;
        for (int i = 0; i<s.toCharArray().length; i++){
            if (s.toCharArray()[i] == 'N'){
                y++;
            }
            if (s.toCharArray()[i] == 'S'){
                y--;
            }
            if (s.toCharArray()[i] == 'E'){
                x++;
            }
            if (s.toCharArray()[i] == 'W'){
                x--;
            }
            t  = new ArrayList<>();
            for (int j = 0; j<went.size(); j++){
                if (went.get(j).get(0) == x && went.get(j).get(1) == y){
                }
            }
            t.add(x*2);
            t.add(y*2);
            went.add(t);
            //t.clear();
            ArrayList<Integer> t2  = new ArrayList<>();
            if (s.toCharArray()[i] == 'N'){
                t2.add(x*2);
                t2.add(y*2-1);
            }
            if (s.toCharArray()[i] == 'S'){
                t2.add(x*2);
                t2.add(y*2+1);
            }
            if (s.toCharArray()[i] == 'E'){
                t2.add(x*2-1);
                t2.add(y*2);
            }
            if (s.toCharArray()[i] == 'W'){
                t2.add(x*2+1);
                t2.add(y*2);
            }
//            went.add(t);
            went.add(t2);
            if (x*2<smallest_x){
                smallest_x = x*2;
            }
            if (y*2<smallest_y){
                smallest_y = y*2;
            }

        }

        int x_bound = -1;
        int y_bound = -1;

        for (int i = 0; i<went.size(); i++){
            if (smallest_x < 0){
                went.get(i).set(0,went.get(i).get(0)+(-smallest_x));
            }
            if (smallest_y < 0){
                went.get(i).set(1,went.get(i).get(1)+(-smallest_y));
            }
            if (went.get(i).get(0)> x_bound){
                x_bound = went.get(i).get(0);
            }
            if (went.get(i).get(1)> y_bound){
                y_bound = went.get(i).get(1);
            }
        }
        x_bound++;
        y_bound++;
        String[][] grid = new String[x_bound][y_bound];
        for (int i = 0; i<x_bound; i++){
            for (int j = 0; j<y_bound; j++){
                grid[i][j] = ".";
            }
        }
        for (int i = 0; i<went.size(); i++){
            grid[went.get(i).get(0)][went.get(i).get(1)] = "#";
        }
        //printgrid(grid);
        int ans = -1;
        for (int i = 0; i<grid.length; i++){
            for (int j = 0; j<grid[i].length; j++){
                if (grid[i][j] == "#")
                    continue;
                if (grid[i][j] == "•")
                    continue;
                floodFill(grid,grid.length, grid[0].length, i, j, grid[x][y], "•");
                printgrid(grid);
                System.out.println("――――――――――――――――――――――――――――――");
                ans++;
            }
        }
        //printgrid(grid);
        System.out.println(ans);
        PrintWriter pw = new PrintWriter("gates.out");
        pw.close();
    }

}





