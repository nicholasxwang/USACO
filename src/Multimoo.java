import java.io.*; import java.util.*;
class GameCell{  int x, y; public GameCell(int x, int y){ this.x = x;this.y = y; }}
public class Multimoo {
    static boolean contains(boolean[][] visited, int x, int y) {
       return visited[x][y];
    }
    static boolean isValid(int[][] grid, int x, int y, int current, boolean[][] visited) { return  (!(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length  || grid[x][y] == 0 || grid[x][y] != current || contains(visited, x, y)));}
    static boolean isValid_modified(int[][] grid, int[] pair, int x, int y, int current, boolean[][] visited) {
        if (x< 0 || x >= grid.length || y < 0 || y >= grid[0].length ){
            return false;
        }
        return (!(contains(visited, x, y))) && (
                (pair[0] == (current)||pair[1] == (current)) && (pair[0] == (grid[x][y])||pair[1] == (grid[x][y]))
        );
    }
    static void floodFill(int[][] grid, ArrayList<ArrayList<GameCell>> regions, int x, int y, boolean[][] visited) {
        Vector<GameCell> queue = new Vector<>();
        queue.add(new GameCell(x, y));
        visited[x][y] = true;
        int current = grid[x][y];
        ArrayList<GameCell> currentRegion = new ArrayList<>();
        currentRegion.add(new GameCell(x, y));
        while (queue.size() > 0) {
            GameCell currPixel = queue.get(queue.size() - 1);
            queue.remove(queue.size() - 1);
            int posX = currPixel.x;
            int posY = currPixel.y;
            if (isValid(grid,  posX + 1, posY, current, visited) && !contains(visited, posX+1, posY)) { visited[posX+1][posY] = true;  currentRegion.add(new GameCell(posX + 1, posY)); queue.add(new GameCell(posX + 1, posY));}
            if (isValid(grid, posX - 1, posY, current, visited) && !contains(visited, posX-1, posY)) { visited[posX-1][posY] = true;  currentRegion.add(new GameCell(posX - 1, posY)); queue.add(new GameCell(posX - 1, posY));}
            if (isValid(grid, posX, posY + 1, current, visited) && !contains(visited, posX, posY+1)) { visited[posX][posY+1] = true;    currentRegion.add(new GameCell(posX, posY+1));queue.add(new GameCell(posX, posY + 1));}
            if (isValid(grid, posX, posY - 1, current, visited) && !contains(visited, posX, posY-1)) { visited[posX][posY-1] = true;  currentRegion.add(new GameCell(posX, posY-1));queue.add(new GameCell(posX, posY - 1));}
        }
        regions.add(currentRegion);

    }

    static void modified_floodFill(int[][] grid, int[] pair,  ArrayList<ArrayList<GameCell>> regions, int x, int y, boolean[][] visited) {
        Vector<GameCell> queue = new Vector<>();
        queue.add(new GameCell(x, y));
        visited[x][y] = true;
        int current = grid[x][y];
        ArrayList<GameCell> currentRegion = new ArrayList<>();
        currentRegion.add(new GameCell(x, y));
        while (queue.size() > 0) {
            GameCell currPixel = queue.get(queue.size() - 1);
            queue.remove(queue.size() - 1);
            int posX = currPixel.x;
            int posY = currPixel.y;
            if (isValid_modified(grid, pair,  posX + 1, posY, current, visited) && !contains(visited, posX+1, posY)) { visited[posX+1][posY] = true; currentRegion.add(new GameCell(posX + 1, posY)); queue.add(new GameCell(posX + 1, posY));}
            if (isValid_modified(grid, pair, posX - 1, posY, current, visited) && !contains(visited, posX-1, posY)) { visited[posX-1][posY] = true;  currentRegion.add(new GameCell(posX - 1, posY)); queue.add(new GameCell(posX - 1, posY));}
            if (isValid_modified(grid, pair, posX, posY + 1, current, visited) && !contains(visited, posX, posY+1)) { visited[posX][posY+1] = true;    currentRegion.add(new GameCell(posX, posY+1));queue.add(new GameCell(posX, posY + 1));}
            if (isValid_modified(grid, pair, posX, posY - 1, current, visited) && !contains(visited, posX, posY-1)) { visited[posX][posY-1] = true;  currentRegion.add(new GameCell(posX, posY-1));queue.add(new GameCell(posX, posY - 1));}
        }
        regions.add(currentRegion);

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("multimoo.in"));
        int N = Integer.parseInt(br.readLine());
        int[][] grid = new int[N][N];
        Set <Integer> set = new HashSet<>();
        int max_cur = 0;
        for (int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j<N; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                set.add(grid[i][j]);
                if (grid[i][j] > max_cur){
                    max_cur = grid[i][j];
                }
            }
        }



        ArrayList<Integer> arrayset = new ArrayList<>(set);
        //Adjacency List
        ArrayList<Integer>[] neighbours = new ArrayList[max_cur+1];
        //find neighbours
        for (int i = 0; i<N; i++){
            for (int j = 0; j<N; j++){
                if (i > 0 && grid[i][j] != grid[i-1][j] && !neighbours[grid[i][j]].contains(grid[i-1][j])){
                    if (neighbours[grid[i][j]] == null){
                        neighbours[grid[i][j]] = new ArrayList<>();
                    }
                    neighbours[grid[i][j]].add(grid[i-1][j]);
                }
                if (i < N-1 && grid[i][j] != grid[i+1][j] && !neighbours[grid[i][j]].contains(grid[i+1][j])){
                    if (neighbours[grid[i][j]] == null){
                        neighbours[grid[i][j]] = new ArrayList<>();
                    }
                    neighbours[grid[i][j]].add(grid[i+1][j]);
                }
                if (j > 0 && grid[i][j] != grid[i][j-1] && !neighbours[grid[i][j]].contains(grid[i][j-1])){
                    if (neighbours[grid[i][j]] == null){
                        neighbours[grid[i][j]] = new ArrayList<>();
                    }
                    neighbours[grid[i][j]].add(grid[i][j-1]);
                }
                if (j < N-1 && grid[i][j] != grid[i][j+1] && !neighbours[grid[i][j]].contains(grid[i][j+1])){
                    if (neighbours[grid[i][j]] == null){
                        neighbours[grid[i][j]] = new ArrayList<>();
                    }
                    neighbours[grid[i][j]].add(grid[i][j+1]);
                }
            }
        }

        int[][] pairs = new int[arrayset.size()*(arrayset.size()-1)/2][2];
        int counter = 0;
        for (int i = 0; i<arrayset.size(); i++){
            for (int j = i+1; j<arrayset.size(); j++){
                if (neighbours[arrayset.get(i)].contains(arrayset.get(j))){
                    pairs[counter][0] = arrayset.get(i);
                    pairs[counter][1] = arrayset.get(j);
                    counter++;
                }
            }
//            counter++;
        }
        ArrayList<ArrayList<GameCell>> regions = new ArrayList<>();
        boolean[][] visited = new boolean[300][300];
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
        //System.out.println(pairs);
        regions = new ArrayList<>();
        for (int n = 0; n<pairs.length; n++){
            if (pairs[n][0] == 0 && pairs[n][1] == 0){
                continue;
            }
            for (int i = 0; i<N; i++){
                for (int j = 0; j<N; j++){
                    visited = new boolean[300][300];
                    if (contains(visited, i, j)){
                        continue;
                    }
                    modified_floodFill(grid, pairs[n], regions, i, j, visited);

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
