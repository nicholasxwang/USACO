import java.io.*;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Vector;


public class Wheres_Bessie {
    static boolean isValid(String[][] screen, int m, int n, int x, int y, String prevC, String newC) {
        if (x < 0 || x >= m || y < 0 || y >= n
                || screen[x][y] == newC || screen[x][y] == "#")
            return false;
        return true;
    }


    // FloodFill function
    static void floodFill(String[][] screen, int m, int n, int x, int y, String prevC, String newC) {
        Vector<Point> queue = new Vector<Point>();

        // Append the position of starting
        // pixel of the component
        queue.add(new Point(x, y));

        // Color the pixel with the new color
        screen[x][y] = newC;

        // While the queue is not empty i.e. the
        // whole component having prevC color
        // is not colored with newC color
        while (queue.size() > 0) {
            // Dequeue the front node
            Point currPixel = queue.get(queue.size() - 1);
            queue.remove(queue.size() - 1);

            int posX = currPixel.x;
            int posY = currPixel.y;

            // Check if the adjacent
            // pixels are valid
            if (isValid(screen, m, n, posX + 1, posY, prevC, newC)) {
                // Color with newC
                // if valid and enqueue
                screen[posX + 1][posY] = newC;
                queue.add(new Point(posX + 1, posY));
            }

            if (isValid(screen, m, n, posX - 1, posY, prevC, newC)) {
                screen[posX - 1][posY] = newC;
                queue.add(new Point(posX - 1, posY));
            }

            if (isValid(screen, m, n, posX, posY + 1, prevC, newC)) {
                screen[posX][posY + 1] = newC;
                queue.add(new Point(posX, posY + 1));
            }

            if (isValid(screen, m, n, posX, posY - 1, prevC, newC)) {
                screen[posX][posY - 1] = newC;
                queue.add(new Point(posX, posY - 1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //4
        //ABBC
        //BBBC
        //AABB
        //ABBC
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //PrintWriter pw = new PrintWriter("");
        int N = Integer.parseInt(br.readLine());
        String[][] grid = new String[N][N];
        String[] s;
        for (int i = 0; i < N; i++) {
            s = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                grid[i][j] = s[j];
            }
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    for (int l = k+1; l < N; l++) {
                        System.out.println("("+i+", "+j+", "+k+", "+l+")");
                        if (i== 0 && j==3 && k==0 && l == 1){
                            System.out.println();
                        }
                        String[][] newgrid = new String[j - i][l-k];
                        for (int a = i; a < j; a++) {
                            for (int b = k; b < l; b++) {
                                newgrid[j - i-1][l - k-1] = grid[a][b];
                            }
                        }
                        for (int a = 0; i < newgrid.length; i++) {
                            boolean breaky = false;
                            for (int b = 0; j < newgrid[i].length; j++) {
                                Hashtable<String, Integer> ht = new Hashtable<>();
                                String current = newgrid[a][b];
                                if (current == "#")
                                    continue;
                                floodFill(grid, grid.length, grid[0].length, i, j, current, "#");
                                if (!ht.keySet().contains(current)){
                                    ht.put(current, 0);
                                }
                                ht.put(current, ht.get(current)+1);
                                if (ht.size() > 2){
                                    breaky = true;
                                    break;
                                }
                                boolean returned = false;
                                boolean returned2 = false;
                                for (String key : ht.keySet()){
                                    if (ht.get(key) == 1){
                                        returned = true;
                                    }else{
                                        returned2 = true;
                                    }
                                }
                                if (!returned && !returned2){
                                    breaky = true;
                                    break;
                                }

                            }
                            if (breaky){
                                break;
                            }else{
                                ans++;
                                System.out.println(Arrays.deepToString(newgrid));
                            }
                        }

                    }
                }
            }
        }
        System.out.println(ans);

    }
}
