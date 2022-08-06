import java.io.*; import java.util.*;
class Cell{  int x, y; public Cell(int x, int y){ this.x = x;this.y = y; }}
public class Mooyo {
    static boolean contains(ArrayList<Cell> visited, int x, int y) {
        for (int i = 0; i < visited.size(); i++) {
            if (visited.get(i).x == x && visited.get(i).y == y) {
                return true;
            }
        }
        return false;
    }
    static void printgrid(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }
    static boolean isValid(int[][] grid, int x, int y, int current, ArrayList<Cell> visiting) { return  (!(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length  || grid[x][y] == 0 || grid[x][y] != current) || contains(visiting, x, y)); }
    static void floodFill(int[][] grid, ArrayList<Cell> visiting,  ArrayList<ArrayList<Cell>> regions, int x, int y) {
        Vector<Cell> queue = new Vector<>();
        visiting.add(new Cell(x, y));
        queue.add(new Cell(x, y));
        int current = grid[x][y];
        ArrayList<Cell> currentRegion = new ArrayList<>();
        currentRegion.add(new Cell(x, y));
        while (queue.size() > 0) {
            Cell currPixel = queue.get(queue.size() - 1);
            queue.remove(queue.size() - 1);
            int posX = currPixel.x;
            int posY = currPixel.y;
            if (isValid(grid,  posX + 1, posY, current, visiting) && !contains(visiting, posX+1, posY)) { visiting.add(new Cell(posX + 1, posY));  currentRegion.add(new Cell(posX + 1, posY)); queue.add(new Cell(posX + 1, posY));}
            if (isValid(grid, posX - 1, posY, current, visiting) && !contains(visiting, posX-1, posY)) { visiting.add(new Cell(posX - 1, posY)); currentRegion.add(new Cell(posX - 1, posY)); queue.add(new Cell(posX - 1, posY));}
            if (isValid(grid, posX, posY + 1, current, visiting) && !contains(visiting, posX, posY+1)) { visiting.add(new Cell(posX, posY+1));   currentRegion.add(new Cell(posX, posY+1));queue.add(new Cell(posX, posY + 1));}
            if (isValid(grid, posX, posY - 1, current, visiting) && !contains(visiting, posX, posY-1)) {visiting.add(new Cell(posX, posY-1)); currentRegion.add(new Cell(posX, posY-1));queue.add(new Cell(posX, posY - 1));}
        }
        regions.add(currentRegion);
    }
    static void gravity(int[][] grid){
        for (int j = 0; j < grid[0].length; j++) {
            int[] column = new int[grid.length];
            for (int i = 0; i < grid.length; i++) {
                column[i] = grid[i][j];
            }
            ArrayList<Integer> notZero = new ArrayList<>();
            for (int i = 0; i< column.length; i++){
                if (column[i] != 0){
                    notZero.add(column[i]);
                }
            }
            int zeros = column.length - notZero.size();
            for (int i = 0; i < column.length; i++) {
                if (i<zeros)
                    grid[i][j] = 0;
                else
                    grid[i][j] = notZero.get(i - zeros);
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mooyomooyo.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i, j, N, K;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] grid = new int[N][10];
        for (i = 0; i<N; i++){
            String[] s = br.readLine().split("");
            for (j = 0; j<10; j++){
                grid[i][j] = Integer.parseInt(s[j]);
            }
        }
        printgrid(grid);
        while (true){
            ArrayList<Cell> visiting = new ArrayList<>();
            ArrayList<ArrayList<Cell>> regions = new ArrayList<>();
            for (i = 0; i<N; i++){
                for (j = 0; j<10; j++){
                    if (grid[i][j] != 0 && !contains(visiting, i, j)) {
                        floodFill(grid, visiting, regions, i, j);
                    }
                }
            }
            int region_count = 0;

            for (i = 0; i < regions.size(); i++) {
                if (regions.get(i).size() >= K) {
                    region_count++;

                    for(j = 0; j < regions.get(i).size(); j++){
                        grid[regions.get(i).get(j).x][regions.get(i).get(j).y] = 0;
                    }
                }
            }
            //printgrid(grid);
            gravity(grid);
            visiting.clear();
            regions.clear();
            //printgrid(grid);
            if (region_count == 0){
                break;
            }

        }
//        printgrid(grid);

       //print to mooyomooyo.out
        PrintWriter pw = new PrintWriter(new File("mooyomooyo.out"));
        for (i = 0; i<N; i++){
            for (j = 0; j<10; j++){
                pw.print(grid[i][j]);
            }
            if (i != N-1)
                pw.println();
        }
        pw.close();
    }
}
