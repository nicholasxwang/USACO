import java.io.*;
import java.util.*;

public class swapityswapswap {
    public static int flip(int one, int two, int num){
        //2  5
        int distance_from_start = num-one;
        int distance_from_end = two-num;
        if (distance_from_end > distance_from_start){
            return two-distance_from_start;
        }
        if (distance_from_end < distance_from_start){
            return one+distance_from_end;
        }
        return num;
    }
//    public static void swap(ArrayList<Integer> nums, ArrayList<Integer> swap_pair){
        public static ArrayList<Integer> swap(ArrayList<Integer> nums, ArrayList<Integer> swap_pair){
        int num1 = swap_pair.get(0)-1;
        int num2 = swap_pair.get(1)-1;
        ArrayList<Integer> new_nums = new ArrayList<>();
        for (int i = 0; i<nums.size(); i++){
            new_nums.add(nums.get(i));
        }

        for (int i = num1; i<=num2; i++){
            new_nums.set(i, nums.get(flip(num1, num2, i)));
        }
        //nums = new_nums;
        return new_nums;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> ar = new ArrayList<>();
            ar.add(Integer.parseInt(st.nextToken()));
            ar.add(Integer.parseInt(st.nextToken()));
            arr.add(ar);
        }
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i<N; i++){
            nums.add(i+1);
        }
        for (int i = 0; i<K; i++){
            for (int j = 0; j<M; j++){
                nums = swap(nums, arr.get(j));
            }
        }
        System.out.println(nums);
    }
}
