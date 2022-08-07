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

        double[] averages = new double[N];
        for (int i = 0; i < N; i++) {
            // find average of interval
            double average = 0;
            for (int j = intervals[i][0]; j < intervals[i][1]-1; j++) {
                average += prefix[j];
            }
            average /= (intervals[i][1] - intervals[i][0]);
            averages[i] = average;
        }
        System.out.println(Arrays.toString(averages));

        int minimum_average = 0;
        for (int i = 0; i < N; i++) {
            if (averages[i] < averages[minimum_average]) {
                minimum_average = i;
            }
        }

        System.out.println(minimum_average);

        for (int i =0; i<prefix.length; i++){
            if (intervals[minimum_average][0]-1 <= i && i < intervals[minimum_average][1]){
                prefix[i]--;
            }
        }
        System.out.println(Arrays.toString(prefix));
        int answer = 1;
        for (int i = 0; i<prefix.length; i++){
            if (prefix[i] > 0){
                answer++;
            }
        }
        pw.println(answer);
        pw.close();
    }


    }


//1-2  2-3  3-4  4-5  5-6  6-7  7-8  8-9
// 1    1     2    1   2     2    1    1

