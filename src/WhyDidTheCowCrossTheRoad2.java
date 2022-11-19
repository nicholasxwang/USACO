import java.io.*; import java.util.*;
public class WhyDidTheCowCrossTheRoad2 {
    public static void main(String[] main) throws IOException{
        /* Example: 10 signals, Need 6 continuous signals, 5 are broken
        [2, 10, 1, 5, 9]
        Signals:        0 0 1 1 0 1 1 1 0 0
        Prefix of it:    0 0 1 2 2 3 4 5 5 5
        Optimal:        1 2 3 4 5 6 7 8 9 10
        Difference:     1 2 2 2 3 3 3 3 4 5
        Longest stretch is 5, so we need 6 - 5 = 1 more
        */

        BufferedReader br = new BufferedReader(new FileReader("maxcross.in"));
        PrintWriter pw = new PrintWriter("maxcross.out");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i, N, K, B;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        int[] numbers, binary, prefix, difference;
        numbers = new int[N];
        binary = new int[N];
        prefix = new int[N];
        difference = new int[N];
        for (i = 0; i<binary.length; i++){binary[i] = 1;}
        for (i = 0; i<B; i++){binary[Integer.parseInt(br.readLine())-1] = 0;}
        for (i = 1; i<=N; i++){
            numbers[i-1] = i;
            if (i > 1) prefix[i-1] = prefix[i-2] + binary[i-1];
            else prefix[i-1] = numbers[i-1];
            difference[i-1] = numbers[i-1] - prefix[i-1];
        }
        int min = Integer.MAX_VALUE;
        for (i = 0; i<N; i++){
            if (i+K >= N) break;
            int var = difference[i+K] - difference[i];
            if (var < min) min = var;
        }
        pw.println(min);
        pw.close();
    }
}