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

            //Initial scan for terms
            HashSet<Character> used_ = new HashSet<>();
            for (int p = 0; p<small-1; p++){
               used_.add(s[p]);
            }
            ArrayList<Character> used = new ArrayList<>(used_);
            Collections.sort(used);

            for (int u = 0; u<used.size(); u++){
                boolean active = false;
                for (int p = 0; p<small-1; p++){
                    if (s[p] == used.get(u) && !active){
                        active = true;
                        strokes++;
                    }
                    else if (s[p] < used.get(u)){
                        active = false;
                    }
                }
            }


            //range 2: (big + 1) -> N-1
            for (int p = big; p<N; p++){
                used_.add(s[p]);
            }
            used = new ArrayList<>(used_);
            Collections.sort(used);

            for (int u = 0; u<used.size(); u++){
                boolean active = false;
                for (int p = big; p<N; p++){
                    if (s[p] == used.get(u) && !active){
                        active = true;
                        strokes++;
                    }
                    else if (s[p] < used.get(u)){
                        active = false;
                    }
                }
            }

            System.out.println(strokes);
        }
    }
}
