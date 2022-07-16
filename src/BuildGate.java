import java.util.ArrayList;

class TheFloodfill {
    private static int[][] grid;  // the grid itself
    private static int rowNum;
    private static int colNum;  // grid dimensions, rows and columns
    private static boolean[][] visited;  // keeps track of which nodes have been visited
    private static int currSize = 0;  // reset to 0 each time we start a new component

    public static void main(String[] args) {
        /*
         * input code and other problem-specific stuff here
         */
        for (int r = 0; r < rowNum; r++){
            for (int c = 0; c < colNum; c++){
                if(!visited[r][c]){
                    currSize = 0;
                    /*
                     * start a flood fill if the square hasn't already been visited,
                     * and then store or otherwise use the component size
                     * for whatever it's needed for
                     */
                    floodfill(r, c, grid[r][c]);
                }
            }
        }
    }

    private static void floodfill(int r, int c, int color) {
        if (
                (r < 0 || r >= rowNum || c < 0 || c >= colNum)  // if out of bounds
                        || grid[r][c] != color  // wrong color
                        || visited[r][c]  // already visited this square
        ) return;

        visited[r][c] = true; // mark current square as visited
        currSize++; // increment the size for each square we visit

        // recursively call flood fill for neighboring squares
        floodfill(r, c + 1, color);
        floodfill(r, c - 1, color);
        floodfill(r - 1, c, color);
        floodfill(r + 1, c, color);
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
    public static void main(String[] args){
        String s = "NNNESWWWSSEEEE";
        ArrayList<ArrayList<Integer>> went = new ArrayList<>();
        int x = 0;
        int y = 0;

        ArrayList<Integer> t  = new ArrayList<>();
        t.add(0);
        t.add(0);
        went.add(t);
        String[][] grid = new String[20][20];
        int count = 0;
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
        //use pixel thingyyÿ
//        for (int i = 0; i<grid.length; i++){
//            for (int j = 0; j<grid[i].length; j++){
//                grid[i][j] = ".";
//            }
//        }
//        for (int i = 0; i<went.size(); i++){
//            x = went.get(i).get(0)+10;
//            y = went.get(i).get(1)+10;
//            grid[x][y] = "#";
//        }
//       println(grid);

        Floodfill(0, 0)

    }


}
