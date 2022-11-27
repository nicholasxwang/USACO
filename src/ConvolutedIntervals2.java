import java.io.*; import java.util.*;

public class ConvolutedIntervals2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int[][] intervals = new int[N][2];
        int[] start_interval = new int[100000];
        int[] end_interval = new int[100000];
        for (int i = 0; i<N; i++){
            tokenizer = new StringTokenizer(br.readLine());
            intervals[i][0] = Integer.parseInt(tokenizer.nextToken());
            intervals[i][1] = Integer.parseInt(tokenizer.nextToken());
        }
        for (int i = 0; i<N; i++){
            for (int j = 0; j<N; j++){
                start_interval[intervals[i][0]+intervals[j][0]]++;
                end_interval[intervals[i][1]+intervals[j][1]]++;
                //System.out.println("Interval: ("+(intervals[i][0] + intervals[j][0])+", "+(intervals[i][1] + intervals[j][1])+")");
            }
        }
        int current = 0;
        for (int i = 0; i<=2*M; i++){
            current += start_interval[i];
            System.out.println(current);
            current -= end_interval[i];
        }

    }
}
