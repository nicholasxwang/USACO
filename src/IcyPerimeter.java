import java.util.*;
import java.io.*;
class Point_{
    int x;
    int y;
    public Point_(int x, int y){ this.x = x;this.y = y; }
}
class IcyPerimeter {
    static int color = 1;
    static boolean isValid(String[][] screen, int N, int x, int y, String newC) { return  (!(x < 0 || x >= N || y < 0 || y >= N  || screen[x][y].equals(newC) || !screen[x][y].equals("#"))); }
    static void floodFill(String[][] screen, int N, int x, int y) {
        Vector<Point_> queue = new Vector<>();
        String newC = String.valueOf(color);
        if (!screen[x][y].equals(".")) { screen[x][y] = newC;}
        else screen[x][y] = "0";
        queue.add(new Point_(x, y));
        while (queue.size() > 0) {
            Point_ currPixel = queue.get(queue.size() - 1);
            queue.remove(queue.size() - 1);
            int posX = currPixel.x;
            int posY = currPixel.y;
            if (isValid(screen, N, posX + 1, posY, newC)) { screen[posX + 1][posY] = newC; queue.add(new Point_(posX + 1, posY));}
            if (isValid(screen, N, posX - 1, posY, newC)) { screen[posX - 1][posY] = newC; queue.add(new Point_(posX - 1, posY));}
            if (isValid(screen, N, posX, posY + 1, newC)) { screen[posX][posY + 1] = newC; queue.add(new Point_(posX, posY + 1));}
            if (isValid(screen, N, posX, posY - 1, newC)) { screen[posX][posY - 1] = newC; queue.add(new Point_(posX, posY - 1));}
        }
        if (!screen[x][y].equals(".")) color++;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("perimeter.in"));
        int N = Integer.parseInt(br.readLine());
        String[][] grid = new String[N][N];
        for (int i = 0; i < N; i++) {
            char[] subgrid = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                grid[i][j] = String.valueOf(subgrid[j]);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                //System.out.println(Arrays.deepToString(grid).replace("], ", "], \n")+"\n\n");
                if (!Objects.equals(grid[i][j], ".") && !Objects.equals(grid[i][j], "#")) continue;
                floodFill(grid, N, i, j);
            }
        }
        int[] areas = new int[color+1];
        int[] perimeter = new int[color+1];
        for (int i= 0; i<grid.length; i++){
            for (int j = 0; j<grid.length; j++){
                if (!grid[i][j].equals("0")){ areas[Integer.parseInt(grid[i][j])]++;}
                try{if (grid[i+1][j].equals("0")){perimeter[Integer.parseInt(grid[i][j])]++;}}catch(Exception e){perimeter[Integer.parseInt(grid[i][j])]++;}
                try{if (grid[i-1][j].equals("0")){perimeter[Integer.parseInt(grid[i][j])]++;}}catch(Exception e){perimeter[Integer.parseInt(grid[i][j])]++;}
                try{if (grid[i][j+1].equals("0")){perimeter[Integer.parseInt(grid[i][j])]++;}}catch(Exception e){perimeter[Integer.parseInt(grid[i][j])]++;}
                try{if (grid[i][j-1].equals("0")){perimeter[Integer.parseInt(grid[i][j])]++;}}catch(Exception e){perimeter[Integer.parseInt(grid[i][j])]++;}
            }
        }
        int best_id = 0;
        for (int i = 1; i<color+1; i++){
            if (areas[i] > areas[best_id] || (areas[i] == areas[best_id] && perimeter[i] < perimeter[best_id])) best_id = i;
        }
        PrintWriter pw = new PrintWriter("perimeter.out");
        pw.println(areas[best_id] + " " + (perimeter[best_id]));
        pw.close();
    }
}

