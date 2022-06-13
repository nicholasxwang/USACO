import java.io.*;
import java.util.*;

public class MilkMeasurement {
    public static void main(String[] args) throws IOException{
        int N;
        int i;
        int G;
        Hashtable<Integer, ArrayList<Integer>> h;
        h = new Hashtable<Integer, ArrayList<Integer>>();

        BufferedReader b = new BufferedReader(new FileReader("./measurement.in"));
        String[] l = b.readLine().split(" ", 2);
        N = Integer.parseInt(l[0]);
        G = Integer.parseInt(l[1]);
        for (i = 0; i<N; i++){
            String[] t = b.readLine().split(" ", 3);
            ArrayList<Integer> n = new ArrayList<Integer>(2);
            n.add(-1);
            n.add(-1);
            n.set(0, Integer.parseInt(t[1]));
            n.set(1, Integer.parseInt(t[2]));
            h.put(Integer.parseInt(t[0]),n);
        }
        ArrayList<Integer> k = new ArrayList<Integer>(h.keySet());
        Collections.sort(k);
        Hashtable<Integer, Integer> c = new Hashtable<>();
        for (i = 0; i<N; i++){
            c.put(i, G);
        }
//        int w = G;
//        ArrayList<Integer> honorable = new ArrayList<>();
//        int changed = 0;
        ArrayList<Integer> previous = new ArrayList<>();
        int ans = 0;
        for (i = 0; i<k.size(); i++){
            int cur = k.get(i);
            int cow = h.get(cur).get(0);
            int change = h.get(cur).get(1);
            c.put(cow, c.get(cow) + change);
            int w = -1;
            ArrayList<Integer> honorable = new ArrayList<>();
            if (change > 0) { //added dis to save time
                for (int j : c.keySet()) {
                    if (c.get(j) > w) {
                        honorable.clear();
                        w = c.get(j);
                        honorable.add(j);
                    } else if (c.get(j) == w) {
                        honorable.add(j);
                    }
                }

                //sort to improve search accuracy
                Collections.sort(honorable);
                if (i > 0 && !honorable.equals(previous)) {
                    ans++;
                }
                previous.clear();
                previous.addAll(honorable);
            }

        }
//        int ans = 0;
//        for (i = 0; i<honorables.size(); i++){
//            if (i!= 0 && !honorables.get(i).equals(honorables.get(i-1))){
//                ans++;
//            }
//        }
        //System.out.println(ans+1);
        PrintWriter printWriter = new PrintWriter ("measurement.out");
        printWriter.println(ans+1);

        printWriter.close ();



    }
}
