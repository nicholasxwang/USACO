import java.util.*;

class DetectWall {
    boolean north;
    boolean west;
    boolean south;
    boolean east;
    public DetectWall(boolean north, boolean south, boolean east, boolean west) {
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
    }
    public void change(boolean north, boolean south, boolean east, boolean west) {
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
    }

}
public class BuildGate {
    public static void println(String[][] arr){
        String line = "";
        for (int i = 0; i<arr.length; i++){
            line = "";
            for (int j = 0; j<arr.length; j++){
                line+=arr[i][j];
            }
            System.out.println(line);
        }
    }

    public static void start_floodfill(ArrayList<ArrayList<Integer>> indexes) {
        int[][] grid = new int[40][40];  // the grid itself
        DetectWall[][] grid2 = new DetectWall[40][40];  // the grid itself
        int rowNum = 40;
        int colNum = 40;  // grid dimensions, rows and columns
        boolean[][] visited = new boolean[40][40];  // keeps track of which nodes have been visited
        int currSize = 0;  // reset to 0 each time we start a new component
        for (int i = 0; i<grid2.length; i++) {
            for (int j = 0; j < grid2[i].length; j++) {
                grid2[i][j] = new DetectWall(false, false, false, false);
            }
        }
        for (int i =0; i<indexes.size(); i++) {
            int x = indexes.get(i).get(0);
            int y = indexes.get(i).get(1);
            grid2[x][y + 1].change(true, grid2[x + 1][y].south, grid2[x + 1][y].east, grid2[x + 1][y].west);
            grid2[x][y - 1].change(grid2[x + 1][y].north, true, grid2[x + 1][y].east, grid2[x + 1][y].west);
            grid2[x + 1][y].change(grid2[x + 1][y].north, grid2[x + 1][y].south, true, grid2[x + 1][y].west);
            grid2[x - 1][y].change(grid2[x + 1][y].north, grid2[x + 1][y].south, grid2[x + 1][y].east, true);
        }
        for (int r = 0; r < rowNum; r++) {
            for (int c = 0; c < colNum; c++) {
                if (!visited[r][c]) {
                    currSize = 0;
                    /*
                     * start a flood fill if the square hasn't already been visited,
                     * and then store or otherwise use the component size
                     * for whatever it's needed for
                     */
                    floodfill(r, c, grid2, rowNum, colNum, grid, visited, currSize);
                }
            }
        }
        int n한共中ち民ñ和ōいこπんi华国人oわ글 = 0; //niñoこんいちわ中华人民共和国한글 = 0;
        //System.out.println(n한共中ち民ñ和ōいこπんi华国人oわ글);
        System.out.println(currSize);

    }
    public static void floodfill(int r, int c, DetectWall[][] grid2, int rowNum, int colNum, int[][] grid, boolean[][] visited, int currSize) {
        System.out.println("RECURSIVE ("+r+", "+c+")");
        if (
                (r < 0 || r >= rowNum || c < 0 || c >= colNum)  // if out of bounds
                        // wrong color
                        || visited[r][c]  // already visited this square
        ) return;

        visited[r][c] = true; // mark current square as visited
        currSize++; // increment the size for each square we visit
        //System.out.println(currSize);
        // recursively call flood fill for neighboring squares
        if (!grid2[r][c].north)
            floodfill(r, c + 1, grid2, rowNum, colNum, grid, visited, currSize);
        if (!grid2[r][c].south)
            floodfill(r, c - 1, grid2, rowNum, colNum, grid, visited, currSize);
        if (!grid2[r][c].west)
            floodfill(r - 1, c, grid2, rowNum, colNum, grid, visited, currSize);
        if (!grid2[r][c].east)
            floodfill(r + 1, c, grid2, rowNum, colNum, grid, visited, currSize);
    }
    public static void main(String[] args){

        String s = "NNNESWWWSSEEEE";
        ArrayList<ArrayList<Integer>> went = new ArrayList<>();
        int x = 20;
        int y = 20;

        ArrayList<Integer> t  = new ArrayList<>();
        t.add(20);
        t.add(20);
        went.add(t);
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
            System.out.println("("+x+", "+y+")");
            t  = new ArrayList<>();
            for (int j = 0; j<went.size(); j++){
                if (went.get(j).get(0) == x && went.get(j).get(1) == y){
                    System.out.println("DUPLICATE!!!");
                }
            }
            t.add(x);
            t.add(y);
            went.add(t);
        }

        start_floodfill(went);

    }

}



