import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;

public class Question1 {
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



    }
}
