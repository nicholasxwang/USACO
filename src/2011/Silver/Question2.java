import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class Question2{
    public static int max(ArrayList<Integer> numbers){
        int largest = -1;
        for (int number:numbers){
            if (number > largest){
                largest = number;
            }
        }
        return largest;
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
        HashMap<Integer, ArrayList<Integer>> things = new HashMap<>();
        for (int i = 0; i<N; i++){
            if (!things.containsKey(cows[i][1])){
                things.put(cows[i][1], new ArrayList<Integer>());
            }
            things.get(cows[i][1]).add(cows[i][0]);
        }
        System.out.println(things);




    }
}