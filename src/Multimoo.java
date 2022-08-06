import java.io.*; import java.util.*;
class GameCell{  int x, y; public GameCell(int x, int y){ this.x = x;this.y = y; }}
public class Multimoo {
    static boolean contains(ArrayList<GameCell> visited, int x, int y) {
        for (int i = 0; i < visited.size(); i++) {
            if (visited.get(i).x == x && visited.get(i).y == y) {
                return true;
            }
        }
        return false;
    }
    static boolean isValid(int[][] grid, int x, int y, int current, ArrayList<GameCell> visited) { return  (!(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length  || grid[x][y] == 0 || grid[x][y] != current || contains(visited, x, y)));}
    static void floodFill(int[][] grid,  ArrayList<ArrayList<GameCell>> regions, int x, int y, ArrayList<GameCell> visited) {
        Vector<GameCell> queue = new Vector<>();
        queue.add(new GameCell(x, y));
        visited.add(new GameCell(x, y));
        int current = grid[x][y];
        ArrayList<GameCell> currentRegion = new ArrayList<>();
        currentRegion.add(new GameCell(x, y));
        while (queue.size() > 0) {
            GameCell currPixel = queue.get(queue.size() - 1);
            queue.remove(queue.size() - 1);
            int posX = currPixel.x;
            int posY = currPixel.y;
            if (isValid(grid,  posX + 1, posY, current, visited) && !contains(visited, posX+1, posY)) { visited.add(new GameCell(posX + 1, posY));  currentRegion.add(new GameCell(posX + 1, posY)); queue.add(new GameCell(posX + 1, posY));}
            if (isValid(grid, posX - 1, posY, current, visited) && !contains(visited, posX-1, posY)) { visited.add(new GameCell(posX - 1, posY)); currentRegion.add(new GameCell(posX - 1, posY)); queue.add(new GameCell(posX - 1, posY));}
            if (isValid(grid, posX, posY + 1, current, visited) && !contains(visited, posX, posY+1)) { visited.add(new GameCell(posX, posY+1));   currentRegion.add(new GameCell(posX, posY+1));queue.add(new GameCell(posX, posY + 1));}
            if (isValid(grid, posX, posY - 1, current, visited) && !contains(visited, posX, posY-1)) {visited.add(new GameCell(posX, posY-1)); currentRegion.add(new GameCell(posX, posY-1));queue.add(new GameCell(posX, posY - 1));}
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
            String[] s = br.readLine().split(" ");
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
                       newgrid[k][l] = grid[k][l];
                       if (newgrid[k][l] == arrayset.get(j)){
                           newgrid[k][l] = arrayset.get(i);
                       }
                   }
               }
               pairs.add(newgrid);
            }
        }
        ArrayList<ArrayList<GameCell>> regions = new ArrayList<>();
        ArrayList<GameCell> visited = new ArrayList<>();
        for (int i = 0; i<N; i++){
            for (int j = 0; j<N; j++){
                if (contains(visited, i, j)){
                    continue;
                }
                floodFill(grid, regions, i, j, visited);

            }
        }
        int max = 0;
        for (int i = 0; i<regions.size(); i++){
            if (regions.get(i).size() > max){
                max = regions.get(i).size();
            }
        }
        PrintWriter pw = new PrintWriter("multimoo.out");
        pw.println(max);
        max = 0;
        for (int n = 0; n<pairs.size(); n++){
            regions = new ArrayList<>();
            visited = new ArrayList<>();
            for (int i = 0; i<N; i++){
                for (int j = 0; j<N; j++){
                    if (contains(visited, i, j)){
                        continue;
                    }
                    floodFill(pairs.get(n), regions, i, j, visited);

                }
            }

            for (int i = 0; i<regions.size(); i++){
                if (regions.get(i).size() > max){
                    max = regions.get(i).size();
                }
            }
        }
        pw.println(max);
        pw.close();







    }
}
