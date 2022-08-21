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
        for (int i = 0; i<N; i++){
            count += (Math.abs(A[i] - i));
        }
//        count = count/2 + 1;
        count = count -  1;
        PrintWriter pw = new PrintWriter("sort.out");
        pw.println(count);
        pw.close();

    }
}
