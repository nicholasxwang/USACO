import java.io.*;
import java.util.*;

public class PairedUp {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> cows = new ArrayList<>();
        for (int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            for (int j = 0; j<count; j++){
                cows.add(value);
            }
        }
        Collections.sort(cows);
        int max = 0;
        while (cows.size() > 0){
            int first = cows.get(0);
            cows.remove(0);
            int last = cows.get(cows.size()-1);
            cows.remove(cows.size()-1);
            max = first+last;
        }
        System.out.println(max);


    }

}
