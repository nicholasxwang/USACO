import java.util.*;

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
        int[][] grid = new int[100000][100000];  // the grid itself
        int rowNum = 10000;
        int colNum = 10000;  // grid dimensions, rows and columns
        boolean[][] visited = new boolean[10000][1000];  // keeps track of which nodes have been visited
        int currSize = 0;  // reset to 0 each time we start a new component
        for (int r = 0; r < rowNum; r++) {
            for (int c = 0; c < colNum; c++) {
                if (!visited[r][c]) {
                    currSize = 0;
                    /*
                     * start a flood fill if the square hasn't already been visited,
                     * and then store or otherwise use the component size
                     * for whatever it's needed for
                     */
                    floodfill(r, c, grid[r][c], rowNum, colNum, grid, visited, currSize);
                }
            }
        }
    }
    public static void floodfill(int r, int c, int color, int rowNum, int colNum, int[][] grid, boolean[][] visited, int currSize) {
        if (
                (r < 0 || r >= rowNum || c < 0 || c >= colNum)  // if out of bounds
                        || grid[r][c] != color  // wrong color
                        || visited[r][c]  // already visited this square
        ) return;

        visited[r][c] = true; // mark current square as visited
        currSize++; // increment the size for each square we visit

        // recursively call flood fill for neighboring squares
        floodfill(r, c + 1, color, rowNum, colNum, grid, visited, currSize);
        floodfill(r, c - 1, color, rowNum, colNum, grid, visited, currSize);
        floodfill(r - 1, c, color, rowNum, colNum, grid, visited, currSize);
        floodfill(r + 1, c, color, rowNum, colNum, grid, visited, currSize);
    }
    public static void main(String[] args){

        String s = "NNNESWWWSSEEEE";
        ArrayList<ArrayList<Integer>> went = new ArrayList<>();
        int x = 0;
        int y = 0;

        ArrayList<Integer> t  = new ArrayList<>();
        t.add(1000);
        t.add(1000);
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



}
