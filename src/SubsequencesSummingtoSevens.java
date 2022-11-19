import java.io.*; import java.util.*;

public class SubsequencesSummingtoSevens {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("div7.in"));
        PrintWriter pw = new PrintWriter("div7.out");
        int N = Integer.parseInt(br.readLine());
        int[] cows = new int[N];
        for (int i = 0; i<N; i++){
            cows[i] = Integer.parseInt(br.readLine()) % 7;
        }
        int[] prefix = new int[N];
        for (int i = 0; i<N; i++){
            if (i == 0) prefix[i] = cows[i];
            else prefix[i] = (prefix[i-1] + cows[i]) % 7;
        }
        // find largest group of cows that sum to 0 mod 7


    }
}
