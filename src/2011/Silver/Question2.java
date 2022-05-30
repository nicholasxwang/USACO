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
        for (int i = 0; i<N; i++){
            String[] temporary_unparsed = br.readLine().split(" ",2);
            cows[i][0] = Integer.parseInt(temporary_unparsed[0]);
            cows[i][1] = Integer.parseInt(temporary_unparsed[1]);
        }
        Arrays.sort(cows, Comparator.comparingDouble(o -> o[0]));
        HashSet<Integer> things = new HashSet<>();
        for (int i = 0; i<N; i++){
            things.add(cows[i][1]);
        }
        int[] cow_1d = new int[N];
        for (int i = 0; i<N; i++){
            cow_1d[i] = cows[i][1];
        }
        // 2 Points
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i<N; i++){
            for (int j = i; j<N; j++) {
                int[] subset = Arrays.copyOfRange(cow_1d, i, j+1);
                HashSet<Integer> subset_set = convert(subset);
                boolean valid = true;
                for (int k : things){
                    if (!subset_set.contains(k)){
                        valid = false;
                        break;
                    }
                }
                if (valid){
                    ans.add(cows[j][0]-cows[i][0]);

                }

            }

        }
        System.out.println(min(ans));




    }
}