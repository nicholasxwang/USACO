import java.io.*; import java.util.*;
class Cell{  int x, y; public Cell(int x, int y){ this.x = x;this.y = y; }}
public class Mooyo {
    static boolean isValid(int[][] grid, int x, int y, int current) { return  (!(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length  || grid[x][y] != 0 || grid[x][y] == current)); }
    static void floodFill(int[][] grid, ArrayList<Cell> visiting,  ArrayList<ArrayList<Cell>> regions, int x, int y) {
        Vector<Cell> queue = new Vector<>();
        visiting.add(new Cell(x, y));
        queue.add(new Cell(x, y));
        int current = grid[x][y];
        ArrayList<Cell> currentRegion = new ArrayList<>();
        while (queue.size() > 0) {
            Cell currPixel = queue.get(queue.size() - 1);
            queue.remove(queue.size() - 1);
            int posX = currPixel.x;
            int posY = currPixel.y;
            if (isValid(grid,  posX + 1, posY, current)) { visiting.add(new Cell(posX + 1, posY));  currentRegion.add(new Cell(posX + 1, posY)); queue.add(new Cell(posX + 1, posY));}
            if (isValid(grid, posX - 1, posY, current)) { visiting.add(new Cell(posX - 1, posY)); currentRegion.add(new Cell(posX - 1, posY)); queue.add(new Cell(posX - 1, posY));}
            if (isValid(grid, posX, posY + 1, current)) { visiting.add(new Cell(posX, posY+1));   currentRegion.add(new Cell(posX, posY+1));queue.add(new Cell(posX, posY + 1));}
            if (isValid(grid, posX, posY - 1, current)) {visiting.add(new Cell(posX, posY-1)); currentRegion.add(new Cell(posX, posY-1));queue.add(new Cell(posX, posY - 1));}
        }
        regions.add(currentRegion);
    }
    static void gravity(int[][] grid){
        for (int j = 0; j < grid[0].length; j++) {
            int[] column = new int[grid[0].length];
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
        PrintWriter pw = new PrintWriter("mooyomooyo.out");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i, j, N, K;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] grid = new int[N][10];
        for (i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine(), "");
            for (j = 0; j<10; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true){
            ArrayList<Cell> visiting = new ArrayList<>();
            ArrayList<ArrayList<Cell>> regions = new ArrayList<>();
            for (i = 0; i<N; i++){
                for (j = 0; j<10; j++){
                    floodFill(grid, visiting, regions, i, j);
                }
            }
            int region_count = 0;

            for (i = 0; i < regions.size(); i++) {
                if (regions.get(i).size() < K) {
                    region_count++;
                }else{
                    for(j = 0; j < regions.get(i).size(); j++){
                        grid[regions.get(i).get(j).x][regions.get(i).get(j).y] = 0;
                    }
                }
            }

            gravity(grid);
            if (region_count == 0){
                break;
            }
        }
        for (i = 0; i<grid.length; i++){
            for (j = 0; j<grid[0].length; j++){
                pw.print(grid[i][j] + " ");
            }
            pw.println();
        }
    }
}
