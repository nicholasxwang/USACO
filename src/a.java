import java.io.*;
import java.util.*;

public class a {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PrintWriter pw = new PrintWriter("a.out");
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        char[] s = br.readLine().toCharArray();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int small = Integer.parseInt(st.nextToken());
            int big = Integer.parseInt(st.nextToken());
            int strokes = 0;
            //range 1: 1 -> (small-1)
            HashSet<Character> used_ = new HashSet<>();
            for (int p = 0; p < small - 1; p++) {
                used_.add(s[p]);
            }
            ArrayList<Character> used = new ArrayList<>(used_);
            for (int u = 0; u < used.size(); u++) {
                boolean active = false;
                for (int p = 0; p < small - 1; p++) {
                    if (s[p] == used.get(u) && !active) {
                        active = true;
                        strokes++;
                    } else if (s[p] < used.get(u)) {
                        active = false;
                    }
                }
            }


            //range 2: (big + 1) -> N-1
            for (int p = big; p < N; p++) {
                used_.add(s[p]);
            }
            used = new ArrayList<>(used_);

            for (int u = 0; u < used.size(); u++) {
                boolean active = false;
                for (int p = big; p < N; p++) {
                    if (s[p] == used.get(u) && !active) {
                        active = true;
                        strokes++;
                    } else if (s[p] < used.get(u)) {
                        active = false;
                    }
                }
            }

            pw.println(strokes);
        }
        pw.close();
    }
}