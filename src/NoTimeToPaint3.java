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

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int small = Integer.parseInt(st.nextToken())-1;
            int big = Integer.parseInt(st.nextToken())-1;

            int answer = prefix[big] - prefix[small];
            answer+= (suffix[N-small-1] - suffix[N-big-1]);
            System.out.println(answer);
        }

    }
}
