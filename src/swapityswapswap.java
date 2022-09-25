import java.io.*; import java.util.*;

public class swapityswapswap {
    public static long lcm(long n1, int n2){
        int gcd = 1;

        for(int i = 1; i <= n1 && i <= n2; ++i) {
            if(n1 % i == 0 && n2 % i == 0)
                gcd = i;
        }

        return (n1 * n2) / gcd;
    }
    public static long all_lcm(ArrayList<Integer> a, int M){
        long lcm = (long) a.get(0);
        for (int i = 1; i<a.size(); i++){
            lcm = lcm(lcm, a.get(i));
            if (lcm > M){
                return 1000000000;
            }
        }
        return lcm;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("swap.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];
        for (int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int[] ar = new int[2];
            ar[0] = Integer.parseInt(st.nextToken());
            ar[1] = Integer.parseInt(st.nextToken());
            arr[i] = ar;
        }
        int[] nums = new int[N];

        for(int i=0;i<N;i++) {
            nums[i] = i+1;
            for(int j=0;j<M;j++)
                if(nums[i] >= arr[j][0] && nums[i] <= arr[j][1])
                    nums[i] = arr[j][1] + arr[j][0] - nums[i];
        }
        ArrayList<ArrayList<Integer>> swappers = new ArrayList<>();
        HashSet<Integer> lengths = new HashSet<>();
        for (int i = 0; i<N; i++){
            ArrayList<Integer> the_sequence = new ArrayList<>();
            int number = i+1;
            the_sequence.add(number);
            number = nums[number-1];
            if (number != (i+1))
                the_sequence.add(number);
            while (number != (i+1)){
                number = nums[number-1];
                if (number != (i+1))
                    the_sequence.add(number);
            }
            swappers.add(the_sequence);
            lengths.add(the_sequence.size());
        }
        ArrayList<Integer> newLengths = new ArrayList<>(lengths);
        long lcm = all_lcm(newLengths, M);
        K = (int) (K % lcm);
        PrintWriter pw = new PrintWriter("swap.out");
        for (int i = 0; i<N; i++){
            //System.out.println(swappers.get(i).get(K % newLengths.get(i)));
            pw.println(swappers.get(i).get(K % swappers.get(i).size()));
        }
        pw.close();
    }
}
