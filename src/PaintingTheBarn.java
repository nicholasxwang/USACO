import java.io.*;
import java.util.*;

public class PaintingTheBarn{
    public static boolean checkIfContained(Integer x, Integer y, ArrayList<Integer> range){
        if (x < range.get(0)){
            return false;
        }
        if (y < range.get(1)){
            return false;
        }
        if (x > range.get(2)){
            return false;
        }
        if (y > range.get(3)){
            return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader b = new BufferedReader(new FileReader("./paintbarn.in"));
        String[] t = b.readLine().split(" ");
        int N = Integer.parseInt(t[0]);
        int K = Integer.parseInt(t[1]);
        int s_x = 99999;
        int s_y = 99999;
        int b_x = -1;
        int b_y = -1;
        ArrayList<ArrayList<Integer>> main = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i<N; i++){
            t = b.readLine().split(" ");
            ArrayList<Integer> main_temp = new ArrayList<>();
            int el1 = Integer.parseInt(t[0]);
            int el2 = Integer.parseInt(t[1]);
            int el3 = Integer.parseInt(t[2]);
            int el4 = Integer.parseInt(t[3]);
            if (el1 < s_x){
                s_x = el1;
            }
            if (el2 < s_y){
                s_y = el2;
            }
            if (el3 > b_x){
                b_x = el3;
            }
            if (el4 > b_y){
                b_y = el4;
            }
            main_temp.add(el1);
            main_temp.add(el2);
            main_temp.add(el3);
            main_temp.add(el4);
            main.add(main_temp);

        }

        int[][] grid = new int[b_x - s_x][b_y - s_y];
        for (int i =s_x; i<b_x; i++){
            for (int j = s_y; j<b_y; j++){
                for (int k = 0; k<main.size(); k++){
                    if (checkIfContained(i-s_x, j-s_y, main.get(k)))
                        grid[i-s_x][j-s_y]+=1;
                }
            }
        }
        int ans = 0;
        for (int i =s_x; i<b_x; i++){
            for (int j = s_y; j<b_y; j++){
                if (grid[i-s_x][j-s_y] == K){
                    ans++;
                }
            }}

        System.out.println(ans);
    }

}
