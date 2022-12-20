import java.io.*;
import java.util.*;

public class Superbull {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("superbull.in"));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i<N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        ArrayList<Integer> ar = new ArrayList<>();
        for (int i = 0; i<N; i++){
            for (int j = i+1; j<N; j++){
                ar.add(nums[i] ^ nums[j]);
            }
        }
        Collections.sort(ar);
        Collections.reverse(ar);
        int ans = 0;
        for (int i = 0; i<N-1; i++){
            ans += ar.get(i);
        }
        PrintWriter pw = new PrintWriter("superbull.out");
        pw.println(ans);
        pw.close();
    }
}
