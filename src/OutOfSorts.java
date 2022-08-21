import java.io.*;

public class OutOfSorts {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sort.in"));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }
        boolean sorted = false;
        int count = 0;
        while (!sorted){
            sorted = true;
            count++;
            for (int i = 0; i<N-1; i++){
                if (A[i+1] < A[i]){
                    //swap
                    int one = A[i];
                    int two = A[i+1];
                    A[i] = two;
                    A[i+1] = one;
                    sorted = false;
                }
            }

        }
        PrintWriter pw = new PrintWriter("sort.out");
        pw.println(count);
        pw.close();

    }
}
