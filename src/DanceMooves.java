import java.io.*;
import java.util.*;

public Graph {

        }

//5 4
//1 3
//1 2
//2 3
//2 4
public class DanceMooves {
    public static void main(String[] argd) throws IOException{
        BufferedReader b = new BufferedReader( new InputStreamReader(System.in));
        String[] t = b.readLine().split(" ");
        int N = Integer.parseInt(t[0]);
        int K = Integer.parseInt(t[1]);
        ArrayList<Integer> swaps = new ArrayList<>();
        for (int i = 0; i<K; i++){
            t = b.readLine().split(" ");
            swaps.add(Integer.parseInt(t[0]));
            swaps.add(Integer.parseInt(t[1]));
        }
        




    }
}
