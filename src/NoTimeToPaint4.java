import java.io.*;
import java.util.*;

public class NoTimeToPaint4 {
    public static int[] construct_prefix(String s, int N){
        char[] letters = new char[N];
        for (int i = 0; i < N; i++) {
            letters[i] = s.charAt(i);
        }
        int[] prefix = new int[N];
        ArrayList<Character> current = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                prefix[i] = 1;
                current.add(letters[i]);
            } else {
                prefix[i] = prefix[i - 1];
                if (letters[i] > letters[i - 1]) {
                    prefix[i]++;
                } else if (letters[i] < letters[i - 1]) {
                    ArrayList<Character> remove = new ArrayList<>();
                    for (int j = 0; j < current.size(); j++) {
                        if (letters[j] > letters[i]) {
                            remove.add(letters[j]);
                        }
                    }
                    if (!current.contains(letters[i])){
                        current.add(letters[i]);
                        prefix[i]++;
                    }
                }
            }
        }
        return prefix;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String r = sb.toString();
        int[] prefix = construct_prefix(s, N);
        int[] suffix = construct_prefix(r, N);
        for (int i = 0; i < N/ 2; i++) {
            int t = suffix[i];
            suffix[i] = suffix[N  - i - 1];
            suffix[N - i - 1] = t;
        }
//        System.out.println(Arrays.toString(prefix));
//        System.out.println(Arrays.toString(suffix));
        for (int q = 0; q<Q; q++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // prefix[0:a-2] suffix[b:N-1]
            if (a > 1) System.out.println(prefix[a-2] - prefix[0] + suffix[b] - suffix[N-1]+2);
            else  System.out.println(suffix[b] - suffix[N-1]+1);
        }
    }
}
