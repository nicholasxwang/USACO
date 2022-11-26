import java.io.*; import java.util.*;


public class ClosestCowWins2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); // Total number of patches
        int M = Integer.parseInt(st.nextToken()); // Farmer Nhoj's cows
        int N = Integer.parseInt(st.nextToken()); // Farmer John's cows
        int[][] patches = new int[K][2];
        int[] ncows= new int[M];
        int[][] jcows = new int[M][2]; // [0] left value, [1] right value
        int largest_index = 0;
        for (int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken())*4+8;
            int t = Integer.parseInt(st.nextToken());
            if (p > largest_index) largest_index = p;
            patches[i] = new int[]{p, t};
        }
        for (int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken())*4+8;
            if (p > largest_index) largest_index = p;
            ncows[i] = p;
        }
        int[][] closest_to_patch = new int[patches.length][2];
        // closest_to_patch[i] represents closest points to patch i
        for (int i = 0; i<K; i++){
            // search left
            int left_distance = Integer.MAX_VALUE;
            int left_point = -1;
            for (int j = 0; j<M; j++){
                if (Math.abs(ncows[j] - patches[i][0]) < left_distance){
                    left_distance = Math.abs(ncows[j] - patches[i][0]);
                    left_point = j;
                }
            }
            // search right
            int right_distance = Integer.MAX_VALUE;
            int right_point = -1;
            for (int j = 0; j<M; j++){
                if (Math.abs(ncows[j] - patches[i][0]) < right_distance){
                    right_distance = Math.abs(ncows[j] - patches[i][0]);
                    right_point = j;
                }
            }

            closest_to_patch[i] = new int[]{left_point, right_point};

        }
        for (int i = 0; i< patches.length; i++){
            if (closest_to_patch[i][0] != -1){ //left
                jcows[closest_to_patch[i][0]][1] += patches[i][1];
            }
            if (closest_to_patch[i][1] != -1){ //right
                jcows[closest_to_patch[i][1]][0] += patches[i][1];
            }
        }

        ArrayList<Integer> lengths = new ArrayList<>();
        for (int i = 0; i<M; i++){
            lengths.add(jcows[i][0]);
            lengths.add(jcows[i][1]);
        }
        System.out.println(lengths);
        Arrays.sort(lengths.toArray());

    }
}
