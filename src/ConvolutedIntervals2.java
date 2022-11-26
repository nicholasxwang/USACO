import java.io.*; import java.util.*;

public class ConvolutedIntervals2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int[][] intervals = new int[N][2];
        for (int i = 0; i<N; i++){
            tokenizer = new StringTokenizer(br.readLine());
            intervals[i][0] = Integer.parseInt(tokenizer.nextToken());
            intervals[i][1] = Integer.parseInt(tokenizer.nextToken());
        }
        ArrayList<Integer>[] small_bound = new ArrayList[2*M+1];
        ArrayList<Integer>[] large_bound = new ArrayList[2*M+1];
        for (int i = 0; i<2*M+1; i++){
            small_bound[i] = new ArrayList<>();
            large_bound[i] = new ArrayList<>();
        }

        for (int k = 0; k<=2*M; k++){

        }

    }
}
