import java.io.*;

public class BaleShare {
//    public static int calculated_largest_difference(int arr[]){
//        return Math.max(Math.abs(arr[0]-arr[2]), Math.max(Math.abs(arr[0]-arr[1]), Math.abs(arr[2]-arr[1])));
//    }
//    public static int recursive(int[] arr, int[][] cache, int i, int sums[]){
//
//        return 1;
//    }
//    public static void main(String[] args){
//        int[] arr = {2, 4, 5, 8, 9, 14, 15, 20};
//        // divide into 3 groups
//        int[] sums = new int[3];
//        sums[0] = arr[0];
//        sums[1] = arr[1];
//        sums[2] = arr[2];
//        int ans = recursive(arr, new int[arr.length][arr.length], 4, sums);
//    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int sum = 0;
        for (int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
//        boolean[][][] good = new boolean[N+2][1000][1000]; // good[N][group_1][group_2] group 3 is found by N - group_1 - group_2
        boolean[][][] good = new boolean[2][sum][sum]; // good[N][group_1][group_2] group 3 is found by N - group_1 - group_2

//        for (int i = 0; i < 2; i++)
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 1000; j++)
                for (int k = 0; k < 1000; k++)
                    good[i][j][k] = false;
        good[0][0][0] = true;
        for (int i = 0; i<N; i++) {
            for (int j = 0; j < 1000; j++) {
                for (int k = 0; k < 1000; k++) {
                    if (good[i % 2][j][k]) {
                        good[(i + 1)%2][j][k] = true;
                        good[(i + 1)%2][j + arr[i]][k] = true;
                        good[(i + 1)%2][j][k + arr[i]] = true;
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i<1000; i++){
            for (int j = 0; j<1000; j++){
                if (good[N % 2][i][j]){
//                    System.out.println(Math.max(Math.max(i, j), N-i-j));
//                    ans = Math.min(ans, Math.max(Math.max(i, j), N-i-j));
                    int max = Math.max(Math.max(i, j), sum - i - j);
                    //System.out.println(max);
                    ans = Math.min(ans, max);
                }
            }
        }
        System.out.println(ans);

    }
}
