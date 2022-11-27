import java.io.*; import java.util.*;


public class ClosestCowWins2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("INPUT.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long K = Long.parseLong(st.nextToken()); // Total number of patches
        long M = Long.parseLong(st.nextToken()); // Farmer Nhoj's cows
        long N = Long.parseLong(st.nextToken()); // Farmer John's cows
        long[][] patches = new long[(int) K][2];
        long[] ncows= new long[(int) M];
        long[][] jcows = new long[(int) M][2]; // [0] left value, [1] right value
        long largest_index = 0;
        for (int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            long p = Long.parseLong(st.nextToken())*4+8;
            long t = Long.parseLong(st.nextToken());
            if (p > largest_index) largest_index = p;
            patches[i] = new long[]{p, t};
        }
        for (int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            long p = Long.parseLong(st.nextToken())*4+8;
            if (p > largest_index) largest_index = p;
            ncows[i] = p;
        }
        int[][] closest_to_patch = new int[patches.length][2];
        // closest_to_patch[i] represents closest points to patch i
        for (int i = 0; i<K; i++){
            // search left
            long left_distance = Long.MAX_VALUE;
            int left_point = -1;
            for (int j = 0; j<M; j++){
                if (Math.abs(ncows[j] - patches[i][0]) < left_distance && ncows[j] < patches[i][0]){
                    left_distance = Math.abs(ncows[j] - patches[i][0]);
                    left_point = j;
                }
            }
            // search right
            long right_distance = Long.MAX_VALUE;
            int right_point = -1;
            for (int j = 0; j<M; j++){
                if (Math.abs(ncows[j] - patches[i][0]) < right_distance && ncows[j] > patches[i][0]){
                    right_distance = Math.abs(ncows[j] - patches[i][0]);
                    right_point = j;
                }
            }
            if (right_distance == left_distance )
                closest_to_patch[i] = new int[]{left_point, right_point};
            else if (right_distance < left_distance)
                closest_to_patch[i] = new int[]{-1, right_point};
            else
                closest_to_patch[i] = new int[]{left_point, -1};

        }
        for (int i = 0; i< patches.length; i++){
            if (closest_to_patch[i][0] != -1){ //left
                jcows[closest_to_patch[i][0]][1] += patches[i][1];
            }
            if (closest_to_patch[i][1] != -1){ //right
                jcows[closest_to_patch[i][1]][0] += patches[i][1];
            }
        }

        ArrayList<Long> lengths = new ArrayList<>();
        for (int i = 0; i<M; i++){
            lengths.add(jcows[i][0]);
            lengths.add(jcows[i][1]);
        }
        System.out.println(lengths);
       Collections.sort(lengths);
        // reverse array
        for (int i = 0; i<lengths.size()/2; i++){
            long temp = lengths.get(i);
            lengths.set(i, lengths.get(lengths.size()-i-1));
            lengths.set(lengths.size()-i-1, temp);
        }
        // choose first N
        int ans = 0;
        for (int i = 0; i<N; i++){
            ans += lengths.get(i);
        }
        System.out.println(ans);
    }
}
