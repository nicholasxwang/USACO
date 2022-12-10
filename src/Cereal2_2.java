// A Java program to find maximal
// Bipartite matching.
import java.util.*;
import java.lang.*;
import java.io.*;


public class Cereal2_2 {
    ArrayList<ArrayList<Integer>> logs = new ArrayList<>();
    // M is number of applicants
    // and N is number of jobs

    // A DFS based recursive function that
    // returns true if a matching for
    // vertex u is possible
    boolean bpm(boolean[][] bpGraph, int u, boolean[] seen, int[] matchR, int N, int M) {
        // Try every job one by one
        for (int v = 0; v < N; v++) {
            // If applicant u is interested
            // in job v and v is not visited
            if (bpGraph[u][v] && !seen[v]) {

                // Mark v as visited
                seen[v] = true;

                // If job 'v' is not assigned to
                // an applicant OR previously
                // assigned applicant for job v (which
                // is matchR[v]) has an alternate job available.
                // Since v is marked as visited in the
                // above line, matchR[v] in the following
                // recursive call will not get job 'v' again
                if (matchR[v] < 0 || bpm(bpGraph, matchR[v],
                        seen, matchR, N, M)) {
                    matchR[v] = u;
                    return true;
                }
            }
        }
        return false;
    }

    // Returns maximum number
    // of matching from M to N
    int maxBPM(boolean[][] bpGraph, int N, int M) {
        // An array to keep track of the
        // applicants assigned to jobs.
        // The value of matchR[i] is the
        // applicant number assigned to job i,
        // the value -1 indicates nobody is assigned.
        int matchR[] = new int[N];

        // Initially all jobs are available
        for (int i = 0; i < N; ++i)
            matchR[i] = -1;

        // Count of jobs assigned to applicants
        int result = 0;
        for (int u = 0; u < M; u++) {
            // Mark all jobs as not seen
            // for next applicant.
            boolean seen[] = new boolean[N];
            for (int i = 0; i < N; ++i)
                seen[i] = false;

            // Find if the applicant 'u' can get a job
//            if (bpm(bpGraph, u, seen, matchR, N, M))
//                logs.add(new ArrayList<>(Arrays.asList(u, matchR[u])));
//                result++;
            if (bpm(bpGraph, u, seen, matchR, N, M)) {
                try {
                    logs.add(new ArrayList<>(Arrays.asList(u, matchR[u])));
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
        boolean[][] matrix = new boolean[N][M];

//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                matrix[i][j] = false;
//            }
//        }

        int[][] priorities = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int favorite = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            matrix[i][favorite - 1] = true;
            matrix[i][second - 1] = true;
            priorities[i][0] = favorite;
            priorities[i][1] = second;
        }

//        System.out.println(Arrays.deepToString(matrix));
        Cereal2_2 m = new Cereal2_2();
        int fed = m.maxBPM(matrix, M, N);
//        System.out.println("Maximum cows fed is " + fed);
//        System.out.println(m.logs);
        // sorting
        ArrayList<Integer> firsts = new ArrayList<>();
        ArrayList<Integer> seconds = new ArrayList<>();
        ArrayList<Integer> hungry = new ArrayList<>();
        for (ArrayList<Integer> item : m.logs){
            int cow = item.get(0);
            int cereal = item.get(1);
            if (priorities[cow][0] == cereal + 1){
                firsts.add(cow + 1);
            }
            else if (priorities[cow][1] == cereal + 1){
                seconds.add(cow + 1);
            } else{
                hungry.add(cow + 1);
            }
        }
        boolean[] fed_cows = new boolean[N];
        System.out.println(N - fed);
        for (int i = 0; i<firsts.size(); i++){
            System.out.println(firsts.get(i));
            fed_cows[firsts.get(i) - 1] = true;
        }
        for (int i = 0; i<seconds.size(); i++){
            System.out.println(seconds.get(i));
            fed_cows[seconds.get(i) - 1] = true;
        }
//        for (int i = 0; i<hungry.size(); i++){
//            System.out.println(hungry.get(i));
//        }
        for (int i = 0; i<fed_cows.length; i++){
            if (!fed_cows[i]){
                System.out.println(i + 1);
            }
        }
    }
}