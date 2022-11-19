import java.io.*; import java.util.*;

class GrassyPatch{
    int tastiness;
    int location;
    String claimer; // "N" for Farmer Nhoj, "J" for Farmer John
    public GrassyPatch(int tastiness, int location){
        this.tastiness = tastiness;
        this.location = location;
        this.claimer = "X";
    }

}

public class ClosestCowWins {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()); // Total number of patches
        int M = Integer.parseInt(st.nextToken()); // Farmer Nhoj's cows
        int N = Integer.parseInt(st.nextToken()); // Farmer John's cows
        GrassyPatch[] patches = new GrassyPatch[K];
        int[] ncows= new int[N];
        float[] jcows = new float[M];
        for (int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            patches[i] = new GrassyPatch(t, p);
        }
        for (int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            ncows[i] = p;
        }
        // Use greedy algorithm
        Arrays.sort(patches, new Comparator<GrassyPatch>() {
            @Override
            public int compare(GrassyPatch o1, GrassyPatch o2) {
                // put higher tasteiness at the front
                return o2.tastiness - o1.tastiness;
            }
        });

        int cows_placed = 0;
        int patch_index = 0;
        while (cows_placed < N){
            // First check how far it is from the closest Nhoj cow
            int close_nhoj = Integer.MAX_VALUE;
            for (int i = 0; i<M; i++){
                int distance = Math.abs(ncows[i] - patches[patch_index].location);
                if (distance < close_nhoj){
                    close_nhoj = distance;
                }
            }
            if (close_nhoj == 0){
                patch_index++;
                continue;
            }
            float john_distance = close_nhoj/2;
            //check how many pastures to the left and right with the boundaries of john_distance
            int left = 0;
            int right = 0;
            for (int i = 0; i<K; i++){
                // check ranges of patches
                if (patches[i].location < patches[patch_index].location - john_distance){
                    left++;
                }else if (patches[i].location > patches[patch_index].location + john_distance){
                                    right++;
                }
            }
            if (left > right) {
                // place a cow on the left
                patches[patch_index].claimer = "J";

                patch_index++;
            }
            else if (right > left){
                // place a cow on the right
                patches[patch_index].claimer = "J";
                patch_index++;
            }
            jcows[cows_placed] = patches[patch_index].location;
            cows_placed++;


        }


    }
}
