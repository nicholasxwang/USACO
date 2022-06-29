import java.io.*;
import java.util.*;

public class FieldReduction {

    public static int distance(int x1, int y1, int x2, int y2){
        return ((x1-x2)*(x1-x2) +  (y1-y2)*(y1-y2));
    }
    public static void main(String[] args) throws IOException{
        BufferedReader b = new BufferedReader(new FileReader("./reduce.in"));
        int N = Integer.parseInt(b.readLine());
        int[][] a = new int[N][2];
        float average_x = 0;
        float average_y = 0;
        for (int i = 0; i<N; i++){
            String[] t = b.readLine().split(" ");
            a[i][0] = Integer.parseInt(t[0]);
            average_x += a[i][0];
            a[i][1] = Integer.parseInt(t[1]);
            average_y +=  a[i][1];
        }
        average_x = average_x / N;
        average_y = average_y / N;
        Hashtable<Integer, Integer> dist = new Hashtable<>();
        for (int i = 0; i<N; i++){
            dist.put(i, distance(a[i][0], a[i][1], (int) average_x, (int) average_y));
        }

        //Transfer as List and sort it
        ArrayList<Map.Entry<?, Integer>> dist2 = new ArrayList(dist.entrySet());
        Collections.sort(dist2, new Comparator<Map.Entry<?, Integer>>(){

            public int compare(Map.Entry<?, Integer> o1, Map.Entry<?, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }});
        int s_x = 999999999;
        int b_x = -1;
        int s_y = 999999999;
        int b_y = -1;

        for (int s = 0; s<dist2.size()-3; s++){
            int key = (int) dist2.get(s).getKey();
            int[] data = a[key];
            if (data[0] < s_x){
                s_x = data[0];
            }
            if (data[1] < s_y){
                s_y = data[1];
            }
            if (data[0] > b_x){
                b_x = data[0];
            }
            if (data[1] > b_y){
                b_y = data[1];
            }
        }
        //System.out.println((s_x - b_x)*(s_y - b_y));
        PrintWriter printWriter = new PrintWriter ("reduce.out");
        printWriter.println((s_x - b_x)*(s_y - b_y));
        printWriter.close ();




    }

}
