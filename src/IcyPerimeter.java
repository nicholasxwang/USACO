import java.util.*;
import java.io.*;
class AnswerKeeper{
    int area;
    int perimeter;
    public AnswerKeeper(){
        this.area = 0;
        this.perimeter = 0;
    }
    public void add_area(){
        this.area = this.area+1;
    }
    public void add_perimeter(){
        this.perimeter= this.perimeter+1;
    }
}
class IcyPerimeter {
    static boolean isValid(String[][] screen, int m, int n, int x, int y, String prevC, String newC) {
        if (x < 0 || x >= m || y < 0 || y >= n
                || screen[x][y].equals(newC) || !screen[x][y].equals(prevC))
            return false;
        return true;
    }


    // FloodFill function
    static void floodFill(String[][] screen, int m, int n, int x, int y, String prevC, String newC, ArrayList<AnswerKeeper> ans_keep_list) {
        Vector<Point> queue = new Vector<Point>();

        // Append the position of starting
        // pixel of the component
        queue.add(new Point(x, y));

        // Color the pixel with the new color
        boolean validd = false;
        if (Objects.equals(screen[x][y], prevC)){
            validd = true;
        }
        screen[x][y] = newC;



        // While the queue is not empty i.e. the
        // whole component having prevC color
        // is not colored with newC color
        ans_keep_list.add(new AnswerKeeper());
        if (validd)
            ans_keep_list.get(ans_keep_list.size() - 1).add_area();

        while (queue.size() > 0) {
            // Dequeue the front node
            Point currPixel = queue.get(queue.size() - 1);
            queue.remove(queue.size() - 1);

            int posX = currPixel.x;

            int posY = currPixel.y;

            // Check if the adjacent
            // pixels are valid
            if (isValid(screen, m, n, posX + 1, posY, prevC, newC)) {
                // Color with newC
                // if valid and enqueue
                screen[posX + 1][posY] = newC;


                queue.add(new Point(posX + 1, posY));
                ans_keep_list.get(ans_keep_list.size() - 1).add_area();
            }else {
                if (Objects.equals(screen[posX][posY], prevC)){
                    if ( posX+1 < 0 || posX+1 >= m || posY < 0 || posY >= n) {
                        ans_keep_list.get(ans_keep_list.size() - 1).add_perimeter();
                    }
                    if ((posX+1)<m && Objects.equals(screen[posX + 1][posY], ".")) {
                        ans_keep_list.get(ans_keep_list.size() - 1).add_perimeter();
                    }
                }

            }

            if (isValid(screen, m, n, posX - 1, posY, prevC, newC)) {
                screen[posX - 1][posY] = newC;
                queue.add(new Point(posX - 1, posY));
                ans_keep_list.get(ans_keep_list.size() - 1).add_area();
            }else{
                if (Objects.equals(screen[posX][posY], prevC)) {
                    if ((posX - 1) < 0 || posX - 1 >= m || posY < 0 || posY >= n) {
                        ans_keep_list.get(ans_keep_list.size() - 1).add_perimeter();
                    }
                    if (posX > 0 && Objects.equals(screen[posX - 1][posY], ".")) {
                        ans_keep_list.get(ans_keep_list.size() - 1).add_perimeter();
                    }
                }

            }

            if (isValid(screen, m, n, posX, posY + 1, prevC, newC)) {
                screen[posX][posY + 1] = newC;
                queue.add(new Point(posX, posY + 1));
                ans_keep_list.get(ans_keep_list.size() - 1).add_area();
            }else{
                if (Objects.equals(screen[posX][posY], prevC)) {
                    if (posX < 0 || posX >= m || posY + 1 < 0 || posY + 1 >= n) {
                        ans_keep_list.get(ans_keep_list.size() - 1).add_perimeter();
                    }
                    if ((posY + 1) < n && Objects.equals(screen[posX][posY + 1], ".")) {
                        ans_keep_list.get(ans_keep_list.size() - 1).add_perimeter();
                    }
                }
            }

            if (isValid(screen, m, n, posX, posY - 1, prevC, newC)) {
                screen[posX][posY - 1] = newC;
                queue.add(new Point(posX, posY - 1));
                ans_keep_list.get(ans_keep_list.size() - 1).add_area();
            }else{
                if (Objects.equals(screen[posX][posY], prevC)) {
                    if (posX < 0 || posX >= m || posY - 1 < 0 || posY - 1 >= n) {
                        ans_keep_list.get(ans_keep_list.size() - 1).add_perimeter();
                    }
                    if (posY > 0 && Objects.equals(screen[posX][posY - 1], ".")) {
                        ans_keep_list.get(ans_keep_list.size() - 1).add_perimeter();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] grid = new String[N][N];
        for (int i = 0; i < N; i++) {
            char[] subgrid = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                grid[i][j] = String.valueOf(subgrid[j]);
            }
        }
        ArrayList<AnswerKeeper> answer_keeper_list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Objects.equals(grid[i][j], "•")) {
                    continue;
                }
                floodFill(grid, N, N, i, j, "#", "•", answer_keeper_list);
                System.out.println(Arrays.deepToString(grid).replace("],", "], \n"));
                System.out.println("\n\n");
            }


        }
//        System.out.println(answer_keeper_list);
        for (int i = 0; i<answer_keeper_list.size(); i++){
            System.out.println("Area = "+answer_keeper_list.get(i).area+", Perimeter = "+answer_keeper_list.get(i).perimeter);
        }

    }
}