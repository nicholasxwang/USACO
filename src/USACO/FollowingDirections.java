import java.io.*;
import java.util.*;

public class FollowingDirections {
    public static int old_calculateCost(String[][] grid){
        int N = grid.length-1;
        int sum = 0;
        for (int i = 0; i<N; i++){
            for (int j = 0; j<N; j++){
                // find the value of (i, j)
                int current_x = i;
                int current_y = j;
                while (true){
                    if (grid[current_x][current_y].equals("R")){
                        current_y++;
                    }
                    else if (grid[current_x][current_y].equals("D")){
                        current_x++;
                    }
                    else{
                        sum += Integer.parseInt(grid[current_x][current_y]);
                        break;
                    }
                }
            }
        }
        return sum;
    }
    public static int calculateCost(String[][] grid){
        int N = grid.length-1;
        int[][] cache = new int[N+1][N+1];
        for (int i = 0; i<N+1; i++){
            for (int j = 0; j<N+1; j++){
                cache[i][j] = -1;
            }
        }
        int sum = 0;
        for (int i = 0; i<N; i++){
            for (int j = 0; j<N; j++){
                // find the value of (i, j)
                int current_x = i;
                int current_y = j;
                while (true){
                    if (cache[current_x][current_y] != -1){
                        sum += cache[i][j];
                        break;
                    }
                    if (grid[current_x][current_y].equals("R")){
                        current_y++;
                    }
                    else if (grid[current_x][current_y].equals("D")){
                        current_x++;
                    }
                    else{
                        sum += Integer.parseInt(grid[current_x][current_y]);
                        cache[i][j] = Integer.parseInt(grid[current_x][current_y]);
                        break;
                    }
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String[][] grid = new String[N+1][N+1];
        String state_id = "";
        HashMap<String, Integer> cache = new HashMap<>(); // State_ID --> Value
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String[] directions = st.nextToken().split("");
            for (int j = 0; j<N; j++){
                grid[i][j] = directions[j];
                state_id += grid[i][j];
            }
            grid[i][N] = st.nextToken();
        }
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j<N; j++){
            grid[N][j] = st.nextToken();
        }
        int value = calculateCost(grid);
        cache.put(state_id, value);
        System.out.println(value);
        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int coor_x = Integer.parseInt(st.nextToken()) - 1;
            int coor_y = Integer.parseInt(st.nextToken()) - 1;
            if (grid[coor_x][coor_y].equals("R")){
                grid[coor_x][coor_y] = "D";
                // state_id_posititon
                int id_position = N*coor_x+coor_y;
                state_id = state_id.substring(0, id_position) + "D" + state_id.substring(id_position+1, N*N);
            }else{
                grid[coor_x][coor_y] = "R";
                // state_id_posititon
                int id_position = N*coor_x+coor_y;
                state_id = state_id.substring(0, id_position) + "R" + state_id.substring(id_position+1, N*N);
            }
            //System.out.println(state_id);
            // if its in the cache, print cache, if not, calculate
            if (cache.containsKey(state_id)) {
                System.out.println(cache.get(state_id));
            }else{
                value = calculateCost(grid);
                cache.put(state_id, value);
                System.out.println(value);
            }
        }
    }
}
