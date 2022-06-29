import java.io.*;
import java.util.*;

public class CowDanceShow {
    public static int calculate(ArrayList<Integer>  cows, int K){
        if (cows.size() < K){
            return -1;
        }
        ArrayList<Integer> cur = new ArrayList<>(K);
        int index = K-1;
        for (int i = 0; i<K; i++){
            cur.add(cows.get(i));
        }
        int timing = 0;
        while (index != cows.size()){
//            timing++;
//            System.out.println("("+index+") The Cows: "+cur);
            ArrayList<Integer> to_be_removed = new ArrayList<>();
            for (int i = 0; i<cur.size(); i++){
//                cur.set(i,cur.get(i)-1);
                if (cur.get(i) == 0){
                    index+=1;
                    //to_be_removed = index;
                    to_be_removed.add(i);
                }else{
                    cur.set(i,cur.get(i)-1);
                }


            }
            if (to_be_removed.size() > 0){
                for (int el = 0; el<to_be_removed.size(); el++){
                    cur.remove(to_be_removed.get(el));
                    if (index < cows.size())
                        cur.add(cows.get(index));
                }

            }
            timing++;
        }

        return timing;

    }
    public static void main(String[] args) throws IOException{
        BufferedReader b = new BufferedReader(new FileReader("./reduce.in"));
        String[] t = b.readLine().split(" ");
        int N = Integer.parseInt(t[0]);
        int T = Integer.parseInt(t[1]);
        ArrayList<Integer> a = new ArrayList<Integer>(N);
        for (int i = 0; i<N; i++){
            //a.set(i, Integer.parseInt(b.readLine()));
            a.add(Integer.parseInt(b.readLine()));
        }
        for (int i = 1; i<a.size(); i++){
            System.out.println("["+i+"]  "+calculate(a, i));
        }

        int l_pointer= 0;
        int r_pointer = a.size();
        while (true){

            int value = calculate(a, l_pointer);
            System.out.println("["+l_pointer+"]  "+value);

        }

    }

}
