import java.util.*;
import java.io.*;

public class Cereal2_3 {
    ArrayList < ArrayList < Integer >> logs = new ArrayList < > ();
    boolean bpm(int[][] bpGraph, int u, boolean[] seen, int[] matchR, int N, int M) {
        for (int v = 0; v < N; v++) {
            if (bpGraph[u][v] == 1 && !seen[v]) {
                seen[v] = true;
                if (matchR[v] < 0 || bpm(bpGraph, matchR[v],
                        seen, matchR, N, M)) {
                    matchR[v] = u;
                    return true;
                }
            }
        }
        return false;
    }

    boolean bpm2(int[][] bpGraph, int u, boolean[] seen, int[] matchR, int N, int M) {
        for (int v = 0; v < N; v++) {
            if (bpGraph[u][v] == 2 && !seen[v]) {
                seen[v] = true;
                if (matchR[v] < 0 || bpm(bpGraph, matchR[v],
                        seen, matchR, N, M)) {
                    matchR[v] = u;
                    return true;
                }
            }
        }
        return false;
    }

    int maxBPM(int[][] bpGraph, int N, int M) {
        int[] matchR = new int[N];
        for (int i = 0; i < N; ++i)
            matchR[i] = -1;

        int result = 0;
        for (int u = 0; u < M; u++) {
            boolean[] seen = new boolean[N];
            for (int i = 0; i < N; ++i)
                seen[i] = false;
            if (bpm(bpGraph, u, seen, matchR, N, M)) {
                try {
                    logs.add(new ArrayList < > (Arrays.asList(u, matchR[u])));
                    result++;
                } catch (Exception ignored) {

                }
            }else if(bpm2(bpGraph, u, seen, matchR, N, M)){
                try {
                    logs.add(new ArrayList < > (Arrays.asList(u, matchR[u])));
                    result++;
                } catch (Exception ignored) {

                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N][M];
        int[][] priorities = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int favorite = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            matrix[i][favorite - 1] = 1;
            matrix[i][second - 1] = 2;
            priorities[i][0] = favorite;
            priorities[i][1] = second;
        }
        Cereal2_3 m = new Cereal2_3();
        int fed = m.maxBPM(matrix, M, N);
        ArrayList < Integer > firsts = new ArrayList < > ();
        ArrayList < Integer > seconds = new ArrayList < > ();
        boolean[] fed_cows = new boolean[N];
        for (ArrayList < Integer > item: m.logs) {
            int cow = item.get(0);
            int cereal = item.get(1);
            if (priorities[cow][0] == cereal + 1) {
                firsts.add(cow + 1);
                fed_cows[cow] = true;
            } else if (priorities[cow][1] == cereal + 1) {
                seconds.add(cow + 1);
                fed_cows[cow] = true;
            }
        }
        System.out.println(N - fed);
        for (Integer first : firsts) {
            System.out.println(first);
            fed_cows[first - 1] = true;
        }
        for (Integer second : seconds) {
            System.out.println(second);
            fed_cows[second - 1] = true;
        }
        for (int i = 0; i < fed_cows.length; i++) {
            if (!fed_cows[i]) {
                System.out.println(i + 1);
            }
        }
    }
}