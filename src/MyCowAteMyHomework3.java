import java.io.*;
import java.util.*;

public class MyCowAteMyHomework3 {
    public static void main(String[] args) throws IOException {
        int N;
        int i;
        BufferedReader b = new BufferedReader(new FileReader("./homework.in"));
        N = Integer.parseInt(b.readLine());
        String[] n = b.readLine().split(" ", N);
        float[] q = new float[N];
        for (i = 0; i<N; i++){
            q[i] = Float.parseFloat(n[i]);
        }
        ArrayList<Float>  a = new ArrayList<>();
        float p;
        p = -1;

        float w = -1; //current win number
        ArrayList<Integer> ans = new ArrayList<>();
        float allTimeSum = 0;
        float min = 999999999;
        for (i = N-1; i>=0; i--){
            a.add(q[i]);
            allTimeSum += q[i];
            if (q[i] < min){
                min = q[i];
            }
            float s;
            if (a.size() == 1){
                s = -1;
            }else{
                s = (allTimeSum - min) / (a.size()-1);
            }
            if (s<p){
                p = s;
            }else{
                if (w == -1){
                    w = s;
                    //missing purge here
                    ans.clear();
                    ans.add(i);
                }
                else if (w == s){
                    ans.add(i);
                }
                else if (s > w){
                    ans.clear();
                    w = s;
                    ans.add(i);
                }
                p = s;
            }
        }
        PrintWriter printWriter = new PrintWriter ("homework.out");
        N = ans.size();
        for (i = 0; i<N; i++){
            printWriter.println(ans.get(N-i-1));
        }
        printWriter.close ();
    }
}
