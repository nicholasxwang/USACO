import java.io.*; import java.util.*;

public class ConvolutedIntervals {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        long pairs = ((long) N) * ((long) N);
        long[] aFreq = new long[M + 1];
        long[] bFreq = new long[M + 1];
        for (int j = 1; j <= N; j++) {
            tokenizer = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            aFreq[a]++;
            bFreq[b]++;
        }
        long[] aSumFreq = new long[(2 * M) + 1];
        long[] bSumFreq = new long[(2 * M) + 1];
        for (int x = 0; x <= M; x++) {
            for (int y = 0; y <= M; y++) {
                aSumFreq[x + y] += aFreq[x] * aFreq[y];
                bSumFreq[x + y] += bFreq[x] * bFreq[y];
            }
        }
        long aValid = aSumFreq[0];
        long bValid = pairs;
        StringBuilder out = new StringBuilder();
        for (int x = 0; x <= 2 * M; x++) {
            if (x > 0) {
                aValid += aSumFreq[x];
                bValid -= bSumFreq[x - 1];
            }
            long res = aValid + bValid - pairs;
            out.append(res).append('\n');
        }
        System.out.print(out);

    }
}
