import java.io.*;
import java.util.*;

public class NoTimeToPaint {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        char[] s = br.readLine().toCharArray();
        for (int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            int small =Integer.parseInt(st.nextToken());
            int big = Integer.parseInt(st.nextToken());
            int strokes = 0;
            //range 1: 1 -> (small-1)

            Stack<Character> stack = new Stack<>();
            for (int p = 0; p<small-1; p++){
                for (int j = 0; j<stack.size(); j++ ){
                    if (stack.get(j) > s[p]){
                        stack.remove(stack.get(j));
                    }
                }
                if (!stack.contains(s[p])){
                    stack.add(s[p]);
                    strokes++;
                }
            }


            //range 2: (big + 1) -> N-1


            stack.clear();
            for (int p = big; p<N; p++){
                for (int j = 0; j<stack.size(); j++ ){
                    if (stack.get(j) > s[p]){
                        stack.remove(stack.get(j));
                    }

                }
                if (!stack.contains(s[p])){
                    stack.add(s[p]);
                    strokes++;
                }
            }

            System.out.println(strokes);
        }
    }
}
