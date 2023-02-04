import java.io.*;
import java.util.*;

public class MeetInTheMiddle {
    public static int[] findSubsets(int set[]) {
        int N = set.length;
        int[] subsets = new int[(int) Math.pow(2, N)];
        for (int i = 0; i < (1<<N); i++)
        {
            for (int j = 0; j < N; j++)
                if ((i & (1 << j)) > 0)
                    subsets[i] += set[j];
        }
        return subsets;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] array1 = new int[N/2];
        int[] array2 = new int[N - N/2];
        for (int i = 0; i<N; i++){
           if (i < N/2) array1[i] = Integer.parseInt(st.nextToken());
           else array2[i-N/2] = Integer.parseInt(st.nextToken());
        }
        int[] subsets1 = findSubsets(array1);
        int[] subsets2 = findSubsets(array2);
        Arrays.sort(subsets1);
        Arrays.sort(subsets2);
        // find number of subsets1[x] + subsets2[y] = X
        int count = 0;
        for (int i = 0; i<subsets1.length; i++){
           for (int j = 0; j<subsets2.length; j++){
               if (subsets1[i] + subsets2[j] == X) count++;
           }
        }
        System.out.println(count);
    }
}
