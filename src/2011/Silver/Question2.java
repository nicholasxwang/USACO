import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Question2{
    public static int min(ArrayList<Integer> numbers){
        int smallest = numbers.get(0);
        for (int number:numbers){
            if (number < smallest){
                smallest = number;
            }
        }
        return smallest;
    }
    static  HashSet<Integer> convert(int[] array)
    {
        // Hash Set Initialisation
        HashSet<Integer> Set = new HashSet<>();

        // Iteration using enhanced for loop
        for (int element : array) {
            Set.add(element);
        }
        // returning the set
        return Set;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] cows = new int[N][2];
        int smallest_start = -1;
        int largest_end = -1;
        for (int i = 0; i<N; i++){
            String[] temporary_unparsed = br.readLine().split(" ",2);
            cows[i][0] = Integer.parseInt(temporary_unparsed[0]);
            cows[i][1] = Integer.parseInt(temporary_unparsed[1]);
        }
        Arrays.sort(cows, Comparator.comparingDouble(o -> o[0]));
        HashMap<Integer, ArrayList<Integer>> things = new HashMap<>();
        for (int i = 0; i<N; i++){
            if (!things.containsKey(cows[i][1])){
                things.put(cows[i][1], new ArrayList<Integer>());
            }
            things.get(cows[i][1]).add(cows[i][0]);
            if (smallest_start == -1){
                smallest_start = cows[i][0];
            }else if (smallest_start > cows[i][0]){
                smallest_start = cows[i][0];
            }
            if (largest_end == -1) {
                largest_end = cows[i][0];
            }else if (largest_end < cows[i][0]){
                largest_end = cows[i][0];
            }
        }
        System.out.println(things);
        int[] cow_1d = new int[N];
        for (int i = 0; i<N; i++){
            cow_1d[i] = cows[i][1];
        }
        // 2 Points
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = smallest_start; i<largest_end; i++){
            for (int j = i; j<largest_end; j++) {
                if (j-i < things.keySet().size()){
                    continue;
                }
                int[] subset = Arrays.copyOfRange(cow_1d, i, j);
                //convert subset into a HashSet
//                HashSet<Integer> subset_set = new HashSet<Integer>(Arrays.asList(subset));
                HashSet<Integer> subset_set = convert(subset);
                boolean valid = true;
                for (int k : things.keySet()){
                    if (!subset_set.contains(k)){
                        valid = false;
                        break;
                    }
                }
                if (valid){
                    ans.add(cows[j][0]-cows[i][0]);
//                    System.out.println("("+i+", "+j+")");
                    System.out.println("("+cows[i][0]+", "+cows[j][0]+")");
                }

            }

        }
        System.out.println(min(ans));
        System.out.println(ans);



    }
}