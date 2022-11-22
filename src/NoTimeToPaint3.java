import java.io.*;
import java.util.*;

public class NoTimeToPaint3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        char[] s = br.readLine().toCharArray();
        int[] prefix = new int[N];
        int[] suffix = new int[N];
        Stack<Character> stack = new Stack<>();
        int strokes = 0;
        for (int i = 0; i<N; i++){
            ArrayList<Character> to_be_removed = new ArrayList<>();
            for (int j = 0; j<stack.size(); j++ ){
                if (stack.get(j) > s[i]){
                    to_be_removed.add(stack.get(j));
                }
            }
            for(int j=0; j<to_be_removed.size(); j++){
                stack.remove(to_be_removed.get(j));
            }
            if (!stack.contains(s[i])){
                stack.add(s[i]);
                strokes++;
            }
            prefix[i] = strokes;
        }
        strokes = 0;
        stack = new Stack<>();
        for (int i = N-1; i>=0; i--){
            ArrayList<Character> to_be_removed = new ArrayList<>();
            for (int j = 0; j<stack.size(); j++ ){
                if (stack.get(j) > s[i]){
                    to_be_removed.add(stack.get(j));
                }
            }
            for(int j=0; j<to_be_removed.size(); j++){
                stack.remove(to_be_removed.get(j));
            }
            if (!stack.contains(s[i])){
                stack.add(s[i]);
                strokes++;
            }
            suffix[N-i-1] = strokes;
        }
        System.out.println(Arrays.toString(prefix));
        System.out.println(Arrays.toString(suffix));
        int total = suffix[N-1] - suffix[0] + prefix[N-1] - prefix[0];
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int small = Integer.parseInt(st.nextToken())-2;
            int big = Integer.parseInt(st.nextToken())+1;
//
//            int answer = prefix[big] - prefix[small];
//            answer+= (suffix[N-small-1] - suffix[N-big-1]);
//            System.out.println(total - answer);
            System.out.println("Left Range: 0 to " + small+" and");
            System.out.println("Right Range: " + big + " to " + (N-1));
            int left_sum = 0;
            int right_sum = 0;
            if (small > 0)
                left_sum += prefix[small] - prefix[0];
            left_sum += suffix[N-1] - suffix[N-big-1];
            System.out.println("Left Sum: " + left_sum);
            if (big < N-1)
                right_sum += prefix[N-1] - prefix[big];
            right_sum += suffix[N-small-1] - suffix[0];
            System.out.println("Right Sum: " + right_sum);
            System.out.println(left_sum+right_sum);
        }

    }
}
