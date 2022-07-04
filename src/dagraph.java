import java.io.*;
import java.util.*;
public class dagraph {
    public static int recursive( int current_pointx, int current_pointy, int end_x, int end_y, char[][] grid, int answer){
        System.out.println("I'm at ("+current_pointx+", "+current_pointy+"). ");
        if (grid[current_pointx][current_pointy] == '#'){
            return 9999;
        }
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
        if (grid[current_pointx][current_pointy] == '.' && edge){
            return 9999;
        }

        if (current_pointx == end_x && current_pointy == end_y){
            return answer;
        }
        int r1 = recursive(current_pointx+1, current_pointy+1, end_x, end_y, grid, answer+1);
        int r2 = recursive(current_pointx-1, current_pointy+1, end_x, end_y, grid, answer+1);
        int r3 = recursive(current_pointx+1, current_pointy-1, end_x, end_y, grid, answer+1);
        int r4 = recursive(current_pointx-1, current_pointy-1, end_x, end_y, grid, answer+1);
        return Math.min(Math.min(r1, r2), Math.min(r3, r4));
    }
    public static void main(String[] args) throws IOException{
        // 5 5
        //#####
        //#...#
        //#...D
        //#C...
        //##.##

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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

        System.out.println(recursive(C_x, C_y, D_x, D_y, grid, 0));











    }

}



