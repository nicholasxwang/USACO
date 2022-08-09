import java.io.*; import java.util.*;
public class LoanRepayment {
    public static boolean valid(long N, long k, long m, long x){
        long g = 0L;
        while (k > 0 && g < N){
            long y = (N-g)/(x);
            if (y < m){
                long leftover = (N-g + m-1) / m;
                return leftover <= k;
            }
            g+= y;
            long maxmatch = N - x*y;
            long numdays = (maxmatch - g) / y + 1;
            if(numdays > k) numdays = k;
            g += y * numdays;
            k -= numdays;

        }
        return g >= N;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("loan.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long low = 0;
        long high = 1000000000000L;
        //long high = 100L;
        long mid = 0;
        while (low < high){
            mid = (low + high + 1)/2;
            if (valid(N, K, M, mid)){
//                high = mid;
               low = mid;
            }
            else {
//                low = mid-1;
                high = mid-1;
            }
        }

        System.out.println(mid);


    }
}

