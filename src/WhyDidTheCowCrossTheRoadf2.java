import java.io.*; import java.util.*;
public class WhyDidTheCowCrossTheRoadf2 {
    public static void main(String[] main) throws IOException{
        //BufferedReader br = new BufferedReader(new FileReader("maxcross.in"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter("maxcross.out");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i, N, K, B;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        int[] numbers, binary, prefix, difference;
        numbers = binary = prefix = difference = new int[N];
        for (i = 0; i<B; i++) binary[Integer.parseInt(br.readLine())-1] = 1;
        for (i = 1; i<=N; i++){
            numbers[i-1] = i;
            if (i > 1) prefix[i-1] = prefix[i-2] + binary[i-1];
            else prefix[i-1] = numbers[i-1];
            difference[i-1] = numbers[i-1] - prefix[i-1];
        }
        int min = Integer.MAX_VALUE;
        for (i = 0; i<N; i++){
            if (i+K > N) break;
            int var = difference[i+K] - difference[i];
            if (var < min) min = var;
        }
        System.out.println(min);
        pw.close();
    }
}

// 1 2 3 4 5 6 7 8 9 10
// 0 0 1 1 0 1 1 1 0 0
// 0 0 1 2 2 3 4 5 5 5
// 1 2 2 2 3 3 3 3 4 5