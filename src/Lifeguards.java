import java.util.*; import java.io.*;
public class Lifeguards {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
        PrintWriter pw = new PrintWriter("lifeguards.out");
        int N = Integer.parseInt(br.readLine());
        int[][] intervals = new int[N][2];
        int max_bound = 0;
        for (int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            intervals[i][0] = A;
            intervals[i][1] = B;
            if (B > max_bound) max_bound = B;
        }
        int[] prefix = new int[max_bound+1];
        for (int i = 0; i<N; i++) {
            for (int j = intervals[i][0]; j<intervals[i][1]; j++) {
                prefix[j]++;
            }
        }
        System.out.println(Arrays.toString(prefix));

        }

    }


//1-2  2-3  3-4  4-5  5-6  6-7  7-8  8-9
// 1    1     2    1   2     2    1    1

