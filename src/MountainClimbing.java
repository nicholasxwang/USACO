import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class MountainClimbing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i<N; i++){
            String[] temp = br.readLine().split(" ", 2);
            arr[i][0] = Integer.parseInt(temp[0]);
            arr[i][1] = Integer.parseInt(temp[1]);
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return Integer.compare(o1[1], o2[1]);
                } else {
                    return Integer.compare(o1[0], o2[0]);
                }
            }
        });
        int ans = 0;
        for (int i = -1; i<(N); i++){
            int j = i+1;
            int value1 = 0;
            int value2 = 0;
            if (j<N){
                value1 = arr[j][0];
            }
            if (i>=0){
                value2 = arr[i][1];
            }
            ans += Math.max(value1, value2);


        }
        System.out.println(ans);
    }
}
