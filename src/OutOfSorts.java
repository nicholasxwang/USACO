import java.io.*; import java.util.*;

public class OutOfSorts {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sort.in"));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        int[] sorted = new int[N];
        for (int i = 0; i<N; i++){
            sorted[i] = A[i];
        }
        Arrays.sort(sorted);
        for (int i = 0; i<N; i++){
            //set each element of the array to location in sorted
            for (int j = 0; j<N; j++){
                if (A[i] == sorted[j]){
                    A[i] = j;
                    break;
                }
            }
        }

        PrintWriter pw = new PrintWriter("sort.out");
        pw.println(0);
        pw.close();

    }
}
