import java.io.*; import java.util.*;

public class Cowtangion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] d = new int[N];
        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            d[x]++;
            d[y]++;

        }
        int ans = N - 1;
        for (int i = 0; i < N; i++) {
            if (d[i] > 1 || i == 0)    // check that i is not leaf node in tree
            {
                int children = d[i];
                if (i != 0) children--;
                // compute ceil(log(children + 1))
                int log_children = 0;
                int pow = 1;
                while (pow < children + 1)
                    log_children++;
                pow *= 2;
                ans += log_children;
            }


        }
        System.out.println(ans);
    }

}
