import java.io.*; import java.util.*;

class GrassyPatch{
    int tastiness;
    int location;
    String claimer; // "N" for Farmer Nhoj, "J" for Farmer John
    int claimer_index;
    public GrassyPatch(int tastiness, int location, int claimed_by){
        this.tastiness = tastiness;
        this.location = location;
        this.claimer = "N";
        this.claimer_index = claimed_by;
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
        int[] ncows= new int[M];
        int[] jcows = new int[N];
        int largest_index = 0;
        for (int i = 0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken())*4+8;
            int t = Integer.parseInt(st.nextToken());
            if (p > largest_index) largest_index = p;
            patches[i] = new GrassyPatch(t, p, -1);
        }
        for (int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken())*4+8;
            if (p > largest_index) largest_index = p;
            ncows[i] = p;
        }
        // fix claim indexes


        // Use greedy algorithm
        Arrays.sort(patches, new Comparator<GrassyPatch>() {
            @Override
            public int compare(GrassyPatch o1, GrassyPatch o2) {
                // put higher tasteiness at the front
                return o2.tastiness - o1.tastiness;
            }
        });

//        int cows_placed = 0;
//        int patch_index = 0;
//        while (cows_placed < N){
//            // First check how far it is from the closest Nhoj cow
//            int close_nhoj = Integer.MAX_VALUE;
//            for (int i = 0; i<M; i++){
//                int distance = Math.abs(ncows[i] - patches[patch_index].location);
//                if (distance < close_nhoj){
//                    close_nhoj = distance;
//                }
//            }
//            if (close_nhoj == 0){
//                patch_index++;
//                continue;
//            }
//            float john_distance = close_nhoj/2;
//            //check how many pastures to the left and right with the boundaries of john_distance
//            int left = 0;
//            int right = 0;
//            for (int i = 0; i<K; i++){
//                // check ranges of patches
//                if (patches[i].location < patches[patch_index].location - john_distance){
//                    left++;
//                }else if (patches[i].location > patches[patch_index].location + john_distance){
//                                    right++;
//                }
//            }
//            if (left > right) {
//                // place a cow on the left
//                patches[patch_index].claimer = "J";
//
//                patch_index++;
//            }
//            else if (right > left){
//                // place a cow on the right
//                patches[patch_index].claimer = "J";
//                patch_index++;
//            }
//            jcows[cows_placed] = patches[patch_index].location;
//            cows_placed++;
//
//
//        }

        int[] gain_array = new int[largest_index+8];

        // gain_array[i] = the gain of placing a cow at i
        // it should be the theoretical sum if a cow is placed there

        for (int i = 0; i<gain_array.length; i++){
            int gain = 0;
            for (int j = 0; j<K; j++){
                int distance = Math.abs(patches[j].location - i);
                if (distance == 0){
                    gain += patches[j].tastiness;
                }else{
                    gain += patches[j].tastiness/distance;
                }
            }
            gain_array[i] = gain;
        }

        Arrays.sort(gain_array);
        // reverse gain_array
        for (int i = 0; i<gain_array.length/2; i++){
            int temp = gain_array[i];
            gain_array[i] = gain_array[gain_array.length-1-i];
            gain_array[gain_array.length-1-i] = temp;
        }

        int ans = 0;
        for (int i = 0; i<N ;i++){
            ans+=gain_array[i];
        }
        System.out.println(ans);


    }
}
