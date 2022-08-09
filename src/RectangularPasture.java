import java.util.*; import java.io.*;
public class RectangularPasture {
    public static int getSum(int[][] sums, int from_x, int to_x, int from_y, int to_y) {
        return sums[to_x][to_y] - sums[from_x - 1][to_y] - sums[to_x][from_y - 1] + sums[from_x - 1][from_y - 1];
    }

    public static void main(String[] args) throws IOException {
        int[][] sums;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] xs = new int[n];
        int[] ys = new int[n];
        Integer[] cows = new Integer[n];
        for (int j = 0; j < n; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            xs[j] = Integer.parseInt(st.nextToken());
            ys[j] = Integer.parseInt(st.nextToken());
            cows[j] = j;
        }
        Arrays.sort(cows, Comparator.comparingInt(j -> xs[j]));
        for (int x = 1; x <= n; x++) {
            xs[cows[x - 1]] = x;
        }
        Arrays.sort(cows, Comparator.comparingInt(j -> ys[j]));
        for (int y = 1; y <= n; y++) {
            ys[cows[y - 1]] = y;
        }
        sums = new int[n + 1][n + 1];
        for (int j = 0; j < n; j++) {
            sums[xs[j]][ys[j]]++;
        }
        for (int x = 0; x <= n; x++) {
            for (int y = 0; y <= n; y++) {
                if (x > 0) {
                    sums[x][y] += sums[x - 1][y];
                }
                if (y > 0) {
                    sums[x][y] += sums[x][y - 1];
                }
                if (x > 0 && y > 0) {
                    sums[x][y] -= sums[x - 1][y - 1];
                }
            }
        }
        long answer = n + 1;
        for (int j = 0; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                answer += getSum( sums, Math.min(xs[j], xs[k]), Math.max(xs[j], xs[k]), 1, Math.min(ys[j], ys[k]))
                        * getSum(sums, Math.min(xs[j], xs[k]), Math.max(xs[j], xs[k]), Math.max(ys[j], ys[k]), n);
            }
        }
        System.out.println(answer);

}
    }
