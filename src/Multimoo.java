import java.io.*; import java.util.*;
public class Multimoo {
    static boolean isValid(int[][] grid, int x, int y, int current) { return  (!(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length  || grid[x][y] == 0 || grid[x][y] != current));}
    static void floodFill(int[][] grid,  ArrayList<ArrayList<Cell>> regions, int x, int y) {
        Vector<Cell> queue = new Vector<>();
        queue.add(new Cell(x, y));
        int current = grid[x][y];
        ArrayList<Cell> currentRegion = new ArrayList<>();
        currentRegion.add(new Cell(x, y));
        while (queue.size() > 0) {
            Cell currPixel = queue.get(queue.size() - 1);
            queue.remove(queue.size() - 1);
            int posX = currPixel.x;
            int posY = currPixel.y;
            if (isValid(grid,  posX + 1, posY, current)){  currentRegion.add(new Cell(posX + 1, posY)); queue.add(new Cell(posX + 1, posY));}
            if (isValid(grid, posX - 1, posY, current)){  currentRegion.add(new Cell(posX - 1, posY)); queue.add(new Cell(posX - 1, posY));}
            if (isValid(grid, posX, posY + 1, current)){    currentRegion.add(new Cell(posX, posY+1));queue.add(new Cell(posX, posY + 1));}
            if (isValid(grid, posX, posY - 1, current)){ currentRegion.add(new Cell(posX, posY-1));queue.add(new Cell(posX, posY - 1));}
        }
        regions.add(currentRegion);

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("multimoo.in"));
        int N = Integer.parseInt(br.readLine());
        int[][] grid = new int[N][N];
        ArrayList<int[][]> pairs = new ArrayList<>();
        Set <Integer> set = new HashSet<>();
        for (int i = 0; i<N; i++){
            String[] s = br.readLine().split("");
            for (int j = 0; j<N; j++){
                grid[i][j] = Integer.parseInt(s[j]);
                set.add(grid[i][j]);
            }
        }
        ArrayList<Integer> arrayset = new ArrayList<>(set);
        for (int i = 0; i<arrayset.size(); i++){
            for (int j = i; j<arrayset.size(); j++){
                int[][] newgrid = new int[N][N];
               for (int k = 0; k<N; k++){
                   for (int l = 0; l<N; l++){
                       if (grid[k][l] == arrayset.get(j)){
                           grid[k][l] = arrayset.get(i);
                       }
                       newgrid[k][l] = grid[k][l];
                   }
               }
               pairs.add(newgrid);
            }
        }
        ArrayList<ArrayList<Cell>> regions = new ArrayList<>();
        for (int i = 0; i<N; i++){
            for (int j = 0; j<N; j++){
                if (grid[i][j] != 0){
                    floodFill(grid, regions, i, j);
                }
            }
        }
        int max = 0;
        for (int i = 0; i<regions.size(); i++){
            if (regions.get(i).size() > max){
                max = regions.get(i).size();
            }
        }







    }
}
