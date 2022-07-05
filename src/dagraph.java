import java.io.*;
import java.util.*;
public class dagraph {
    public static int recursive( int current_pointx, int current_pointy, int end_x, int end_y, char[][] grid, int answer, ArrayList<ArrayList<Integer> > visited, boolean going_down, boolean going_up){
        //Check Visited
        if (going_down && grid[current_pointx][current_pointy-1] != '#'){
            return recursive(current_pointx, current_pointy-1, end_x, end_y, grid, answer, visited, going_down, going_up);
        }
        if (going_up && grid[current_pointx][current_pointy+1] != '#'){

            return recursive(current_pointx, current_pointy-1, end_x, end_y, grid, answer, visited, going_down, going_up);
        }
        for (ArrayList<Integer> visit : visited){
            if (visit.get(0) == current_pointx && visit.get(1) == current_pointy){
                //Visited
                return 9999;
            }
        }
        ArrayList<Integer> add_to_visited = new ArrayList<>();
        add_to_visited.add(current_pointx);
        add_to_visited.add(current_pointy);
        visited.add(add_to_visited);
        boolean edge = false;
        if (current_pointx == grid.length-1){
            edge = true;
        }
        if (current_pointx == 0){
            edge = true;
        }
        if (current_pointy == grid.length-1){
            edge = true;
        }
        if (current_pointy == 0){
            edge = true;
        }
        if (edge){
            return 9999;
        }
        if (grid[current_pointx][current_pointy] == '.'){
            return 9999;
        }
        System.out.println("I'm at ("+current_pointx+", "+current_pointy+"). ");
        if (grid[current_pointx][current_pointy] == '#'){
            return 9999;
        }

        if (current_pointx == end_x && current_pointy == end_y){
            return answer;
        }
        int r1 = recursive(current_pointx, current_pointy+1, end_x, end_y, grid, answer+1, visited, false, true);
        int r2 = recursive(current_pointx, current_pointy-1, end_x, end_y, grid, answer+1, visited, true, false);
        int r3 = recursive(current_pointx+1, current_pointy, end_x, end_y, grid, answer+1, visited, false, false);
        int r4 = recursive(current_pointx-1, current_pointy, end_x, end_y, grid, answer+1, visited, false, false);
        return Math.min(Math.min(r1, r2), Math.min(r3, r4));
    }
    public static void main(String[] args) throws IOException{
        // 5 5
        //#####
        //#...#
        //#...D
        //#C...
        //##.##

        BufferedReader br = new BufferedReader(new FileReader("./gravity.in"));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        char[][] grid = new char[N][M];
        int C_x = 0;
        int C_y = 0;
        int D_x = -1;
        int D_y = -1;
        char[] char_s = new char[M];
        for (int i = 0; i<N; i++){
            //s = br.readLine().split(" ");
            char_s = br.readLine().toCharArray();

            for (int j = 0; j<char_s.length; j++){
                grid[i][j] = char_s[j];
                if (grid[i][j] == 'C'){
                    C_x = i;
                    C_y = j;
                }
                if (grid[i][j] == 'D'){
                    D_x = i;
                    D_y = j;
                }

            }
        }
        ArrayList<ArrayList<Integer>> visited = new ArrayList<>();
        PrintWriter printWriter = new PrintWriter ("gravity.out");
        printWriter.println(recursive(C_x, C_y, D_x, D_y, grid, 0, visited, false, false));
        printWriter.close();












    }

}



