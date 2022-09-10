import java.io.*;
import java.util.*;

//5 4
//1 3
//1 2
//2 3
//2 4
public class DanceMooves {
    public static void swap(ArrayList<Integer> arr, int a, int b){
        int var = arr.get(b);
        arr.set(b, arr.get(a));
        arr.set(a, var);
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

        ArrayList<Integer> cows = new ArrayList<>();
        ArrayList<HashSet<Integer>> position_master = new ArrayList<>();
        for (int i = 0; i<N; i++){
            cows.add(i+1);
            position_master.add(new HashSet<>());
        }

        int count = 0;
        //System.out.println(cows);


        while (count < 10000){
            ArrayList<Integer> current = swaps.get(count % K);
            swap(cows, current.get(0), current.get(1));
            for (int i = 0; i<N; i++){
                position_master.get(cows.get(i)-1).add(i);
            }
            //System.out.println(cows);
            count++;
        }
        //System.out.println(position_master);
        for (int i = 0; i<position_master.size(); i++){
            System.out.println(position_master.get(i).size());
        }






    }
}
