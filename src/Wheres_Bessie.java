import java.io.*;
import java.util.Vector;


public class Wheres_Bessie {
    static boolean isValid(String[][] screen, int m, int n, int x, int y, String prevC, String newC)
    {
        if(x < 0 || x >= m || y < 0 || y >= n
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
        //4
        //ABBC
        //BBBC
        //AABB
        //ABBC
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter("");
        int N = Integer.parseInt(br.readLine());
        String[][] grid = new String[N][N];
        String[] s;
        for (int i = 0; i<N; i++){
            s = br.readLine().split(" ");
            for (int j = 0; j<N; j++){
                grid[i][j] = s[j];
            }
        }

        for (int i = 0; i<N; i++){
            for (int j = 0; j<N; j++){
                for (int k = 0; k<N; k++){
                    for (int l = 0; l<N; l++){
                        String[][] newgrid = new String[j-i][k-j];
                        for (int a = i; a<j; a++){
                            for (int b = k; b<l; b++){
                                newgrid[j-i][l-k] = grid[a][b];
                            }
                        }
                        for (int a = 0; i<newgrid.length; i++){
                            for (int b = 0; j<newgrid[i].length; j++){
                                //floodFill(floodFill(floodFill(floodFill(floodFill(floodFill(floodFill(floodFill(floodFill(floodFill(floodFill(floodFill(5, 5, 5, ,5););););););););););););
                                if (grid[i][j] == "#")

                                if (grid[i][j] == "•")
                                    continue;
                                floodFill(grid,grid.length, grid[0].length, i, j, ".", "•");

                            }
                        }

                    }
                }
            }
        }


    }
}
