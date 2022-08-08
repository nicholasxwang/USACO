import java.util.*; import java.io.*;
public class Lifeguards {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
        PrintWriter pw = new PrintWriter("lifeguards.out");
        int N = Integer.parseInt(br.readLine());
        int[][] intervals = new int[N][2];
        int max_bound = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            intervals[i][0] = A - 1;
            intervals[i][1] = B - 1;
            if (B - 1 > max_bound) max_bound = B - 1;
        }
        int[] prefix = new int[max_bound];
        for (int i = 0; i < N; i++) {
            for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                prefix[j]++;
            }
        }
        System.out.println(Arrays.toString(prefix));

        int answer = 0;
        int[] valuable = new int[intervals.length];
        for (int i = 0; i<intervals.length; i++){
            for (int j = intervals[i][0]; j<intervals[i][1]; j++){
                int valuable_amount = 0;
                if (prefix[j] == 1) valuable_amount++;
                valuable[i] += valuable_amount;

            }
        }
        System.out.println(Arrays.toString(valuable));
        for (int value : valuable) {
            if (answer < value) answer = value;
        }

        for (int i =0; i<intervals.length; i++){
            if (intervals[answer][0] <= i && i < intervals[answer][1]){
                prefix[i]--;
            }
        }
        System.out.println(Arrays.toString(prefix));
        int realanswer = 1;
        for (int i = 0; i<prefix.length; i++){
            if (prefix[i] > 0){
                realanswer++;
            }
        }


        pw.println(realanswer-1);
        pw.close();
    }


    }


//1-2  2-3  3-4  4-5  5-6  6-7  7-8  8-9
// 1    1     2    1   2     2    1    1

