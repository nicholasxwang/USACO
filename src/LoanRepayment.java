import java.io.*; import java.util.*;
public class LoanRepayment {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int low = 0;
        int high = N/M;
        high+=10;
        int mid = -1;
        while (low!=high){
            mid = (low + high)/2;
            int current_total = 0;
            int revolution = 0;
            int formula;
            while (current_total < N){
                formula = (N-current_total)/(mid+1);
                current_total+= formula;
                revolution++;

            }
            if (revolution == K ){
                break;
            }

            else if (revolution < K ) // x is on the right side
                low = mid + 1;

            else                  // x is on the left side
                high = mid - 1;
        }
        System.out.println(mid);

    }
}

