import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Question3{
    public static boolean prime(int N){
        for (int i = 2; i <=   N / 2; ++i) {
            // condition for nonprime number
            if (N % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void find_sum_of_squares(int number, int count){
        if (count == 1 || prime(number)){
            return;
        }
        System.out.println(count);
        ArrayList<Integer> dimensions = find_dimensions(number);
        //dimensions = dimensions.subList(0, dimensions.size()/2+1);
        ArrayList<Integer> newdimensions = new ArrayList<Integer>();
        for (int i = 0; i<dimensions.size()/2+1; i++){
                    newdimensions.add(dimensions.get(i));
                }

        for (int dimension : newdimensions){
            int smaller = dimension;
            int larger = number/dimension;
            larger = larger-smaller;
            find_sum_of_squares(smaller*larger, count-1);
        }

    }
    public static ArrayList<Integer> find_dimensions(int N){
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i<=N; i++){
            if (N % i == 0){
                    nums.add(i);
            }
        }
        return nums;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] start = br.readLine().split(" ", 2);
        int N = Integer.parseInt(start[0]);
        int M = Integer.parseInt(start[1]);
        int[] old = new int[M];
        for (int i = 0; i<N; i++){
            String temporary = br.readLine();
            old[i] = Integer.parseInt(temporary);
        }
        int number = 6;
        find_sum_of_squares(number, 3);
    }
}