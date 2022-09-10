import java.io.*;
import java.util.*;

class GridValue{
    int x;
    int y;
    int value;
    public GridValue(int x, int y, int value){
        this.x=x;
        this.y= y;
        this.value = value;
    }
}
public class SpacedOut {
    public static void print(String[][] cowgrid){
        for (int i = 0; i<cowgrid.length; i++){
            for (int j = 0; j<cowgrid.length; j++){
                System.out.print(cowgrid[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static boolean finished(String[][] cowgrid){
        for (int i = 0; i<cowgrid.length; i++){
            for (int j = 0; j<cowgrid.length; j++){
                if (!check2(cowgrid, i,j)) return false;
            }
        }
        return true;
    }
    public static boolean check(String[][] cowgrid, int x, int y){
        // Checks if (x,y) can be placed on the grid
        int count;
        // (x-1, y-1) (x-1, y), (x, y-1), (x, y)
        count = 0;
        try {
            if (cowgrid[x - 1][y - 1].equals("c")) count++;
            if (cowgrid[x - 1][y].equals("c")) count++;
            if (cowgrid[x][y - 1].equals("c")) count++;
            if (count >= 2) return false;
        } catch (Exception ignored){}
        // (x-1, y+1) (x-1, y), (x, y+1), (x, y)
        count = 0;
        try {
            if (cowgrid[x - 1][y + 1].equals("c")) count++;
            if (cowgrid[x - 1][y].equals("c")) count++;
            if (cowgrid[x][y + 1].equals("c")) count++;
            if (count >= 2) return false;
        } catch (Exception ignored){}
        // (x+1, y-1) (x+1, y), (x, y-1), (x, y)
        count = 0;
        try {
            if (cowgrid[x + 1][y - 1].equals("c")) count++;
            if (cowgrid[x + 1][y].equals("c")) count++;
            if (cowgrid[x][y - 1].equals("c")) count++;
            if (count >= 2) return false;
        } catch (Exception ignored){}
        // (x+1, y+1) (x+1, y), (x, y+1), (x, y)
        count = 0;
        try {
            if (cowgrid[x + 1][y + 1].equals("c")) count++;
            if (cowgrid[x + 1][y].equals("c")) count++;
            if (cowgrid[x][y + 1].equals("c")) count++;
            if (count >= 2) return false;
        } catch (Exception ignored){}
        // Final
        return true;
    }public static boolean check2(String[][] cowgrid, int x, int y){
        // Checks if (x,y) can be placed on the grid
        int count;
        // (x-1, y-1) (x-1, y), (x, y-1), (x, y)
        count = 0;
        try {
            if (cowgrid[x - 1][y - 1].equals("c")) count++;
            if (cowgrid[x - 1][y].equals("c")) count++;
            if (cowgrid[x][y - 1].equals("c")) count++;
            if (count != 2) return false;
        } catch (Exception ignored){}
        // (x-1, y+1) (x-1, y), (x, y+1), (x, y)
        count = 0;
        try {
            if (cowgrid[x - 1][y + 1].equals("c")) count++;
            if (cowgrid[x - 1][y].equals("c")) count++;
            if (cowgrid[x][y + 1].equals("c")) count++;
            if (count != 2) return false;
        }catch (Exception ignored){}
        // (x+1, y-1) (x+1, y), (x, y-1), (x, y)
        count = 0;
        try {
            if (cowgrid[x + 1][y - 1].equals("c")) count++;
            if (cowgrid[x + 1][y].equals("c")) count++;
            if (cowgrid[x][y - 1].equals("c")) count++;
            if (count != 2) return false;
        } catch (Exception ignored){}
        // (x+1, y+1) (x+1, y), (x, y+1), (x, y)
        count = 0;
        try {
            if (cowgrid[x + 1][y + 1].equals("c")) count++;
            if (cowgrid[x + 1][y].equals("c")) count++;
            if (cowgrid[x][y + 1].equals("c")) count++;
            if (count != 2) return false;
        }catch (Exception ignored){}
        // Final
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] grid = new int[N][N];
        ArrayList<GridValue> values = new ArrayList<>();
        for (int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j<N; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                values.add(new GridValue(i, j, grid[i][j]));
            }
        }
        //Greedy Algorithm

        Collections.sort(values, new Comparator<GridValue>() {
            @Override
            public int compare(GridValue o1, GridValue o2) {
                return -(o1.value - o2.value);
            }
        });


        String[][] cowgrid = new String[N][N];
        for (int i = 0; i<N; i++){
            for (int j = 0; j<N; j++){
                cowgrid[i][j] = ".";
            }
        }
        System.out.println(Arrays.deepToString(cowgrid));
        int ans = 0;
        while (!finished(cowgrid)){
            int x = values.get(0).x;
            int y = values.get(0).y;
            ans+= values.get(0).value;
            values.remove(0);
            if (check(cowgrid, x, y)){
                cowgrid[x][y] = "c";
            }
            print(cowgrid);

        }
        System.out.println(ans);







    }
}
