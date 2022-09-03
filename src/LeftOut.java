import java.io.*;
import java.util.*;

public class LeftOut {
    public static String get_answer(String[][] grid){
        int N = grid.length;
        boolean done = true;
        //Check if rest are all 1
        for (int i = 1; i<N; i++){
            for (int j = 1; j<N; j++){
                if (!grid[i][j].equals("R")){
                    done = false;
                }
            }
        }
        if (done){
            return "1 1";
        }

        //Check rows and columns are all 1
        for (int i = 1; i<N; i++){
            boolean current_valid = true;
            for (int j = 1; j<N; j++){
                if (!grid[i][j].equals("R")){
                    current_valid = false;
                }
            }
            if (current_valid){
                return "1 "+(i+1);
            }
        }
        for (int i = 1; i<N; i++){
            boolean current_valid = true;
            for (int j = 1; j<N; j++){
                if (!grid[j][i].equals("R")){
                    current_valid = false;
                }
            }
            if (current_valid){
                return (i+1)+" 1";
            }
        }

        //one element is 1
        for (int i = 1; i<N; i++){
            for (int j = 1; j<N; j++){
                if (!grid[j][i].equals("R")){
                    return (i+1)+" "+(j+1);
                }
            }
        }
        //not existing
        return "-1 -1";


    }
    public static void swap(String[][] grid){
        //fix the columns then rows
        int N = grid.length;
        for (int i = 0; i<N; i++){
            if (!grid[i][0].equals("L")){
                for (int j = 0; j<N; j++){
                    grid[i][j] = opposite(grid[i][j]);
                }
            }
        }

        for (int i = 0; i<N; i++){
            if (!grid[0][i].equals("L")){
                for (int j = 0; j<N; j++){
                    grid[j][i] = opposite(grid[j][i]);
                }
            }
        }

    }
    public static void print(String[][] grid){
        for (int i  =0; i<grid.length; i++){
            for (int j  =0; j<grid.length; j++){
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
    public static String opposite(String s){
        if (s.equals("L")) return "R";
        return "L";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("leftout.in"));
        int N = Integer.parseInt(br.readLine());
        String[][] grid = new String[N][N];
        for (int i = 0; i<N; i++){
            String[] st = br.readLine().split("");
            for (int j = 0; j<N; j++){
                grid[i][j] = (st[j]);
            }
        }

        //check if all remainder is 1
        swap(grid);

        String answer = get_answer(grid);

        PrintWriter pw = new PrintWriter("leftout.out");
        pw.println(answer);
        pw.close();



    }
}
