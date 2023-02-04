
import java.io.*;
import java.util.*;

public class Div7 {
    public static void
    findSubsets(List<List<Integer>> subset, ArrayList<Integer> nums, ArrayList<Integer> output, int index)
    {
        if (index == nums.size()) {
            subset.add(output);
            return;
        }findSubsets(subset, nums, new ArrayList<>(output), index + 1);
        output.add(nums.get(index));
        findSubsets(subset, nums, new ArrayList<>(output), index + 1);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());List<List<Integer>> subset = new ArrayList<>();

        ArrayList<Integer> input = new ArrayList<>();
        for (int i = 0; i<N; i++){
           input.add(Integer.parseInt(br.readLine()) % 7);
        }

        findSubsets(subset, input, new ArrayList<>(), 0);
        Collections.sort(subset, (o1, o2) -> {
            int n = Math.min(o1.size(), o2.size());
            for (int i = 0; i < n; i++) {
                if (o1.get(i) == o2.get(i)){
                    continue;
                }else{
                    return o1.get(i) - o2.get(i);
                }
            }
            return 1;
        });


        // Printing Subset
        for(int i = 0; i < subset.size(); i++){
            for(int j = 0; j < subset.get(i).size(); j++){
                System.out.print(subset.get(i).get(j) + " ");
            }
            System.out.println();

        }



    }
}
