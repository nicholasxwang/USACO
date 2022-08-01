import java.util.*;
import java.io.*;


class AnswerKeeper{
    int area;
    int perimeter;
    String color;
    public AnswerKeeper(String color){
        this.area = 0;
        this.perimeter = 0;
        this.color = color;

    }
    public void add_area() {
        this.area = this.area + 1;
    }
    public void add_perimeter(){
        this.perimeter= this.perimeter+1;
    }
}

class CustomComparator implements Comparator<AnswerKeeper> {
    @Override
    public int compare(AnswerKeeper o1, AnswerKeeper o2) {
        return Integer.parseInt(o1.color) - ( Integer.parseInt(o2.color));
    }
}

class Point_{
    int x;
    int y;
    public Point_(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class IcyPerimeter {
    static int color = 1;
    static boolean isValid(String[][] screen, int m, int n, int x, int y, String prevC, String newC) {
        if (x < 0 || x >= m || y < 0 || y >= n
                || screen[x][y].equals(newC) || !screen[x][y].equals(prevC))
            return false;
        return true;
    }


    // FloodFill function
    static void find_perimeter(ArrayList<AnswerKeeper> ans_keep_lis, String[][] grid){
        ArrayList<AnswerKeeper> remoove_list = new ArrayList<>();
        int count = 0;
        for(AnswerKeeper ans_keep: ans_keep_lis){
            if(Objects.equals(ans_keep.color, "0")){
                remoove_list.add(ans_keep);
            }
            ans_keep_lis.get(count).perimeter = 0;
            count++;
        }
        for (int i = 0; i<remoove_list.size(); i++){
            ans_keep_lis.remove(remoove_list.get(i));
        }
        

        Collections.sort(ans_keep_lis, new CustomComparator());

        for (int i= 0; i<grid.length; i++){
            for (int j = 0; j<grid.length; j++){
                int r = Integer.parseInt(grid[i][j]);
                if (r==0) continue;

                if (i>0 && Integer.parseInt(grid[i-1][j])==0) ans_keep_lis.get(r).add_perimeter();
                if (i<grid.length-1 && Integer.parseInt(grid[i+1][j])==0) ans_keep_lis.get(r).add_perimeter();
                if (j>0 && Integer.parseInt(grid[i][j-1])==0) ans_keep_lis.get(r).add_perimeter();
                if (j<grid.length-1 && Integer.parseInt(grid[i][j+1])==0) ans_keep_lis.get(r).add_perimeter();
            }
        }



    }
    static void floodFill(String[][] screen, int m, int n, int x, int y, String prevC, String newC, ArrayList<AnswerKeeper> ans_keep_list) {
        Vector<Point_> queue = new Vector<Point_>();
        newC = String.valueOf(color);

//        if (screen[x][y].equals(prevC)){
        if (!screen[x][y].equals(".")){
            color++;
            screen[x][y] = newC;
        }else{
            screen[x][y] = "0";
        }
        // Append the position of starting
        // pixel of the component
        queue.add(new Point_(x, y));

        // Color the pixel with the new color
        boolean validd = false;
        if (Objects.equals(screen[x][y], prevC)){
            validd = true;
        }



        // While the queue is not empty i.e. the
        // whole component having prevC color
        // is not colored with newC color
        ans_keep_list.add(new AnswerKeeper(String.valueOf(color)));
        if (validd)
            ans_keep_list.get(ans_keep_list.size() - 1).add_area();
        else{
            //return;
        }

        while (queue.size() > 0) {
            // Dequeue the front node
            Point_ currPixel = queue.get(queue.size() - 1);
            queue.remove(queue.size() - 1);

            int posX = currPixel.x;

            int posY = currPixel.y;

            // Check if the adjacent
            // pixels are valid
            if (isValid(screen, m, n, posX + 1, posY, prevC, newC)) {
                screen[posX + 1][posY] = newC;
                queue.add(new Point_(posX + 1, posY));
                ans_keep_list.get(ans_keep_list.size() - 1).add_area();
            }
            if (!screen[posX][posY].equals(".")){

                if ( posX+1 < 0 || posX+1 >= m || posY < 0 || posY >= n) {
                    ans_keep_list.get(ans_keep_list.size() - 1).add_perimeter();
                }
                else  if ((posX+1)<m && Objects.equals(screen[posX + 1][posY], ".")) {
                    ans_keep_list.get(ans_keep_list.size() - 1).add_perimeter();
                }
            }

            if (isValid(screen, m, n, posX - 1, posY, prevC, newC)) {
                screen[posX - 1][posY] = newC;
                queue.add(new Point_(posX - 1, posY));
                ans_keep_list.get(ans_keep_list.size() - 1).add_area();
            }if (!screen[posX][posY ].equals(".")){
                if ((posX - 1) < 0 || posX - 1 >= m || posY < 0 || posY >= n) {
                    ans_keep_list.get(ans_keep_list.size() - 1).add_perimeter();
                }
                else if (posX > 0 && Objects.equals(screen[posX - 1][posY], ".")) {
                    ans_keep_list.get(ans_keep_list.size() - 1).add_perimeter();
                }

            }

            if (isValid(screen, m, n, posX, posY + 1, prevC, newC)) {
                screen[posX][posY + 1] = newC;
                queue.add(new Point_(posX, posY + 1));
                ans_keep_list.get(ans_keep_list.size() - 1).add_area();
            }if (!screen[posX][posY ].equals(".")){
                if (posX  < 0 || posX >= m || posY + 1< 0 || posY+ 1 >= n) {
                    ans_keep_list.get(ans_keep_list.size() - 1).add_perimeter();
                }
                else  if ((posY+1)<n && Objects.equals(screen[posX][posY + 1], ".")) {
                    ans_keep_list.get(ans_keep_list.size() - 1).add_perimeter();
                }
            }

            if (isValid(screen, m, n, posX, posY - 1, prevC, newC)) {
                screen[posX][posY - 1] = newC;
                queue.add(new Point_(posX, posY - 1));
                ans_keep_list.get(ans_keep_list.size() - 1).add_area();
            }if (!screen[posX][posY ].equals(".")){
                if (posX < 0 || posX >= m || posY -1 < 0 || posY-1 >= n) {
                    ans_keep_list.get(ans_keep_list.size() - 1).add_perimeter();
                }
                else  if (posY-1>0 && Objects.equals(screen[posX][posY - 1], ".")) {
                    ans_keep_list.get(ans_keep_list.size() - 1).add_perimeter();
                }
            }
        }
    }

//    static void floodFill2(String[][] screen, int m, int n, int x, int y, String prevC, String newC, ArrayList<AnswerKeeper> ans_keep_list) {
//        Vector<Point_> queue = new Vector<Point_>();
//
//        // Append the position of starting
//        // pixel of the component
//        queue.add(new Point_(x, y));
//
//        // Color the pixel with the new color
//        boolean validd = false;
//        if (Objects.equals(screen[x][y], prevC)){
//            validd = true;
//        }
//        screen[x][y] = newC;
//
//
//
//        // While the queue is not empty i.e. the
//        // whole component having prevC color
//        // is not colored with newC color
//        ans_keep_list.add(new AnswerKeeper());
//        if (validd)
//            ans_keep_list.get(ans_keep_list.size() - 1).add_area();
//        else{
//            //return;
//        }
//
//        while (queue.size() > 0) {
//            // Dequeue the front node
//            Point_ currPixel = queue.get(queue.size() - 1);
//            queue.remove(queue.size() - 1);
//
//            int posX = currPixel.x;
//
//            int posY = currPixel.y;
//
//            // Check if the adjacent
//            // pixels are valid
//
//            if (!screen[posX][posY].equals(".")){
//
//                if ( posX+1 < 0 || posX+1 >= m || posY < 0 || posY >= n) {
//                    ans_keep_list.get(ans_keep_list.size() - 1).add_perimeter();
//                }
//                else  if ((posX+1)<m && Objects.equals(screen[posX + 1][posY], ".")) {
//                    ans_keep_list.get(ans_keep_list.size() - 1).add_perimeter();
//                }
//            }
//
//           if (!screen[posX][posY ].equals(".")){
//                if ((posX - 1) < 0 || posX - 1 >= m || posY < 0 || posY >= n) {
//                    ans_keep_list.get(ans_keep_list.size() - 1).add_perimeter();
//                }
//                else if (posX > 0 && Objects.equals(screen[posX - 1][posY], ".")) {
//                    ans_keep_list.get(ans_keep_list.size() - 1).add_perimeter();
//                }
//
//            }
//
//            if (!screen[posX][posY ].equals(".")){
//                if (posX  < 0 || posX >= m || posY + 1< 0 || posY+ 1 >= n) {
//                    ans_keep_list.get(ans_keep_list.size() - 1).add_perimeter();
//                }
//                else  if ((posY+1)<n && Objects.equals(screen[posX][posY + 1], ".")) {
//                    ans_keep_list.get(ans_keep_list.size() - 1).add_perimeter();
//                }
//            }
//
//            if (!screen[posX][posY ].equals(".")){
//                if (posX < 0 || posX >= m || posY -1 < 0 || posY-1 >= n) {
//                    ans_keep_list.get(ans_keep_list.size() - 1).add_perimeter();
//                }
//                else  if (posY-1>0 && Objects.equals(screen[posX][posY - 1], ".")) {
//                    ans_keep_list.get(ans_keep_list.size() - 1).add_perimeter();
//                }
//            }
//        }
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("perimeter.in"));
        int N = Integer.parseInt(br.readLine());
        String[][] grid = new String[N][N];
        String[][] grid2 = new String[N][N];
        for (int i = 0; i < N; i++) {
            char[] subgrid = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                grid[i][j] = String.valueOf(subgrid[j]);
                grid2[i][j] = String.valueOf(subgrid[j]);
            }
        }
        ArrayList<AnswerKeeper> answer_keeper_list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!Objects.equals(grid[i][j], ".") && !Objects.equals(grid[i][j], "#")) {
                    continue;
                }
                floodFill(grid, N, N, i, j, "#", "•", answer_keeper_list);
                //floodFill2(grid2, N, N, i, j, "#", "•", answer_keeper_list);
                System.out.println(Arrays.deepToString(grid).replace("],", "], \n"));
                System.out.println("\n\n");
            }


        }
        //System.out.println(answer_keeper_list);
        find_perimeter(answer_keeper_list, grid);
        ArrayList<AnswerKeeper> max_areas = new ArrayList<>();
        int max_area = -1;
        for (int i = 0; i<answer_keeper_list.size(); i++){

            //System.out.println("Area = "+answer_keeper_list.get(i).area+", Perimeter = "+answer_keeper_list.get(i).perimeter);
            if (answer_keeper_list.get(i).area > max_area){
                max_area = answer_keeper_list.get(i).area;
                max_areas.clear();
                max_areas.add(answer_keeper_list.get(i));
            }
            if (answer_keeper_list.get(i).area == max_area){
                max_areas.add(answer_keeper_list.get(i));
            }
        }
        AnswerKeeper target = max_areas.get(0);
        int smallest_perimeter = Integer.MAX_VALUE;
        if (answer_keeper_list.size() > 1){
            for (int i = 0; i<max_areas.size(); i++){
                if (max_areas.get(i).perimeter < smallest_perimeter){
                    smallest_perimeter = max_areas.get(i).perimeter;
                    target = max_areas.get(i);
                }
            }
        }

        //System.out.println(target.area + " "+ (target.perimeter+1));
        PrintWriter pw = new PrintWriter("perimeter.out");
        pw.println(target.area + " " + (target.perimeter+1));
        pw.close();

    }
}

