import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;

public class Photo {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().strip());
        int[][] lineups = new int[N][5];
        for (int i = 0; i<5*N; i++){
            lineups[i / 5][i % 5] = Integer.parseInt(br.readLine().strip());
        }
        Hashtable<Integer, ArrayList<Integer>> hash = new Hashtable<>();
        for (int[] line:lineups){
            for (int j = 0; j<line.length; j++){
                int element = line[j];
                if (!hash.keySet().contains(element)){
                    ArrayList<Integer> temp = new ArrayList<>();
                    hash.put(element, temp);
                }
                hash.get(element).add(j);
            }
        }
        System.out.println(hash);
//        for i
        // hash sort; most frequent oen

//        2
//        1
//        2
//        2
//        1
//        1
//        2
//        2
//        1
//        2
//        1

//        5
//        10
//        20
//        30
//        40
//        50
//        20
//        10
//        30
//        40
//        50
//        30
//        10
//        20
//        40
//        50
//        40
//        10
//        20
//        30
//        50
//        50
//        10
//        20
//        30
//        40


    }
}
