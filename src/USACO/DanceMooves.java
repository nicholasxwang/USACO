import java.io.*;
import java.util.*;

//5 4
//1 3
//1 2
//2 3
//2 4
public class DanceMooves {
    public static void swap(int[] arr, int a, int b){
        int var = arr[b];
        arr[b] = arr[a];
        arr[a] = var;
    }
    public static void main(String[] argd) throws IOException{
        BufferedReader b = new BufferedReader( new InputStreamReader(System.in));
        String[] t = b.readLine().split(" ");
        int N = Integer.parseInt(t[0]);
        int K = Integer.parseInt(t[1]);
        ArrayList<ArrayList<Integer>> swaps = new ArrayList<>();
        for (int i = 0; i<K; i++){
            t = b.readLine().split(" ");
            ArrayList<Integer> swap = new ArrayList<>();
            swap.add(Integer.parseInt(t[0])-1);
            swap.add(Integer.parseInt(t[1])-1);
            swaps.add(swap);
        }

        int[] cows = new int[N];
        ArrayList<HashSet<Integer>> position_master = new ArrayList<>();
        for (int i = 0; i<N; i++){
            cows[i] = i+1;
            position_master.add(new HashSet<>());
        }

        int count = 0;

        int value = 50000; 

        while (count < value){
            ArrayList<Integer> current = swaps.get(count % K);
            swap(cows, current.get(0), current.get(1));
            for (int i = 0; i<N; i++){
                position_master.get(cows[i]-1).add(i);
            }
            count++;
        }
        //System.out.println(position_master);
        for (int i = 0; i<position_master.size(); i++){
            System.out.println(position_master.get(i).size());
        }






    }
}
