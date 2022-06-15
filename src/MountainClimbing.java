import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MountainClimbing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] a = new int[N][2];
        for (int i = 0; i<N; i++){
            String[] temp = br.readLine().split(" ", 2);
            a[i][0] = Integer.parseInt(temp[0]);
            a[i][1] = Integer.parseInt(temp[1]);
        }
        Arrays.sort(a, (a, b) -> a[0] - b[0]), (a, b) -> a[1] - b[1]))
    }
}
