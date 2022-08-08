import java.io.*; import java.util.*;
public class LoanRepayment {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("loan.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long low = 0;
        long high = N/M;
        high+=10;
        long mid = -1;
        ArrayList<Long> list = new ArrayList<Long>();
//        list.add(-1);
//        list.add(-1);
        //contains two most recent;
        while (true){
            mid = (low + high)/2;
            long current_total = 0;
            long revolution = 0;
            long formula;
            while (current_total < N){
                formula = (N-current_total)/(mid+1);
                if (formula < M){
                    formula = M;
                }
                current_total+= formula;
                revolution++;

            }

           // System.out.println(mid+" -> "+revolution);
//            list.remove(0);
            list.add(mid);
            if (list.size() > 3){
                list.remove(0);
            }
            if (revolution == K ){
                break;
            }

            else if (revolution < K ) // x is on the right side
                low = mid + 1;

            else                  // x is on the left side
                high = mid - 1;
        }
        long var1 = Math.min(list.get(0), list.get(1));
        long var2 = Math.max(list.get(0), list.get(1));

        for (long min = var2; min >= var1; min--){
            long current_total = 0;
            long revolution = 0;
            long formula;
            while (current_total < N){
                formula = (N-current_total)/(mid+1);
                if (formula < M){
                    formula = M;
                }
                current_total+= formula;
                revolution++;

            }
            if (revolution == K){
                System.out.println(min);
                PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
                pw.println(min);
                pw.close();
                break;
            }
        }


    }
}

