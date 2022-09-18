import java.io.*;
import java.util.*;

public class swapityswapswap {
    public static int lcm(int n1, int n2){
        int gcd = 1;

        for(int i = 1; i <= n1 && i <= n2; ++i) {
            // Checks if i is factor of both integers
            if(n1 % i == 0 && n2 % i == 0)
                gcd = i;
        }

        int lcm = (n1 * n2) / gcd;
        return lcm;
    }
    public static int all_lcm(ArrayList<Integer> a){
        int lcm = a.get(0);
        for (int i = 1; i<a.size(); i++){
            lcm = lcm(lcm, a.get(i));
        }
        return lcm;
    }
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
        BufferedReader br = new BufferedReader(new FileReader("swap.in"));
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

        for (int j = 0; j<M; j++){
            nums = swap(nums, arr.get(j));
        }
        ArrayList<ArrayList<Integer>> swappers = new ArrayList<>();
        HashSet<Integer> lengths = new HashSet<>();
        for (int i = 0; i<N; i++){
            ArrayList<Integer> the_sequence = new ArrayList<>();
            int number = i+1;
            the_sequence.add(number);
            number = nums.get(number-1);
            if (number != (i+1))
                the_sequence.add(number);
            while (number != (i+1)){
                number = nums.get(number-1);
                if (number != (i+1))
                    the_sequence.add(number);
            }
            swappers.add(the_sequence);
            lengths.add(the_sequence.size());
        }
        //System.out.println(swappers);
        ArrayList<Integer> newlengths = new ArrayList<>(lengths);
        int lcm = all_lcm(newlengths);
        K = K % lcm;
        PrintWriter pw = new PrintWriter("swap.out");
        for (int i = 0; i<N; i++){
            //System.out.println(swappers.get(i).get(K % newlengths.get(i)));
            pw.println(swappers.get(i).get(K % swappers.get(i).size()));
        }
        pw.close();
    }
}
