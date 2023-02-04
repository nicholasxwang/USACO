import java.io.*;
import java.util.*;

public class MooRoute {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> steps = new ArrayList<>();
        int[] values = new int[N];
        int total = 0;
        for (int i = 0; i<N; i++){
            values[i] = Integer.parseInt(st.nextToken());
            total += values[i];
        }
        int current = 0;
        boolean up = true;
        while (total > 0){
            steps.add(current);
            System.out.println(steps);
            values[current] --;
            total--;
            if (N - current > 1){
               if (up){
                   if (values[current+1] > 0) current++;
                   else current --;
               }else{
                   if (values[current+1] < N-1) current--;
                   else current ++;
               }
            }
            else{
                current--;
                up = false;
            }
        }
        steps.add(current);
        System.out.println(steps);
        for (int i = 1; i<steps.size(); i++){
            if (steps.get(i) > steps.get(i-1)){
                System.out.print("R");
            }else{
                System.out.print("L");
            }
        }
    }

}
