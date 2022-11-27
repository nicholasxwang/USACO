import java.io.*; import java.util.*;

public class ConvolutedIntervals3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int[][] intervals = new int[N][2];
        int[] M_start_histogram = new int[2*M+1]; // keeps track of how many occurrences of each M
        int[] M_end_histogram = new int[2*M+1]; // keeps track of how many occurrences of each M

        for (int i = 0; i<N; i++){
            tokenizer = new StringTokenizer(br.readLine());
            intervals[i][0] = Integer.parseInt(tokenizer.nextToken());
            intervals[i][1] = Integer.parseInt(tokenizer.nextToken());
            M_start_histogram[intervals[i][0]]++;
            M_end_histogram[intervals[i][1]]++;
        }

        int[] TWOM_start_histogram = new int[2*M+1]; // keeps track of how many occurrences of each M
        int[] TWOM_end_histogram = new int[2*M+1]; // keeps track of how many occurrences of each M
        for (int i = 0; i<M; i++){
            for (int j = 0; j<M; j++){
                TWOM_start_histogram[i+j] += M_start_histogram[i] * M_start_histogram[j];
                TWOM_end_histogram[i+j] += M_end_histogram[i] * M_end_histogram[j];
            }
        }

        int current = 0;
        for (int i = 0; i<=2*M; i++){
            current += TWOM_start_histogram[i];
            System.out.println(current);
            current -= TWOM_end_histogram[i];
        }

    }
}
