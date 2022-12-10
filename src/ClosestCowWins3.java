import java.io.*; import java.util.*;

public class ClosestCowWins3 {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new FileReader("INPUT.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long K = Long.parseLong(st.nextToken()); // Total number of patches
        long M = Long.parseLong(st.nextToken()); // Farmer Nhoj's cows
        long N = Long.parseLong(st.nextToken()); // Farmer John's cows
        long[][] patches = new long[(int) K][2];
        long[] ncows = new long[(int) M];
        float[][] jcows = new float[(int) M][2]; // [0] left value, [1] right value
        long largest_index = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            long p = Long.parseLong(st.nextToken()) * 4 + 8;
            long t = Long.parseLong(st.nextToken());
            if (p > largest_index) largest_index = p;
            patches[i] = new long[]{p, t};
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            long p = Long.parseLong(st.nextToken()) * 4 + 8;
            if (p > largest_index) largest_index = p;
            ncows[i] = p;
        }
        Arrays.sort(ncows);
        Arrays.sort(patches, new Comparator<long[]>() {
                    @Override
                    public int compare(long[] o1, long[] o2) {
                        return (int) (o1[0] - o2[0]);
                    }
        });


        // There are M+1 Intervals to steal
        int[] interval_wealth = new int[(int) (M+1)];
        int nhoj_pointer = 0;
        for (int i = 0; i<K; i++) {
            if (nhoj_pointer >= M || patches[i][0] < ncows[nhoj_pointer]) {
                interval_wealth[nhoj_pointer] += patches[i][1];
            } else {
                nhoj_pointer++;
                i--;
            }
        }

        System.out.println(Arrays.toString(interval_wealth));

        int[] interval_wealth_one_cow = new int[(int) (M+1)]; // wha if only one cow per interval
        long termination =  Math.max(patches[(int) (K-1)][0], ncows[(int) (M-1)]);
        nhoj_pointer = 0;
        for (int i = 0; i<termination; i++){

        }
        // two cases
        // []   <grass>   []
        // <grass> []    <grass>
        // Use a Simple Greedy Algorithm



    }
}
