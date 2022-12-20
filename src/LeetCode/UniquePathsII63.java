package LeetCode;

public class UniquePathsII63 {

    public static int iterative(int[][] obstacleGrid, int[][] cache){
        int N = obstacleGrid.length;
        int M = obstacleGrid[0].length;
        if (N == 0 || M == 0) return 0;
        if (obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[N][M];
//        dp[N-1][M-1] = 1;
        dp[0][0] = 1;
        for (int i = 0; i<N; i++){
            for (int j = 0; j<M; j++){
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else {
                    if (i > 0) dp[i][j] += dp[i-1][j];
                    if (j > 0) dp[i][j] += dp[i][j-1];
                }
            }
        }
        return dp[N-1][M-1];
    }
    public static int recursive(int i, int j, int[][] obstacleGrid, int[][] cache){
        int N = obstacleGrid.length;
        int M = obstacleGrid[0].length;
//        if (i == N-1 && j == N-1 && obstacleGrid[i][j] == 0) return 1;
        if (i == N-1 && j == M-1 && obstacleGrid[i][j] == 0) return 1;
        if (obstacleGrid[i][j] == 1) return 0;
        int answer = 0;
        if (i+1 < N){
            if (cache[i+1][j] != 0){
                answer += cache[i+1][j];
            }
            else {
                int value = recursive(i+1, j, obstacleGrid, cache);
                cache[i+1][j] = value;
                answer += value;
            }
        }
//        if (j+1 < N){
        if (j+1 < M){
            if (cache[i][j+1] != 0){
                answer += cache[i][j+1];
            }
            else {
                int value = recursive(i, j+1, obstacleGrid, cache);
                cache[i][j+1] = value;
                answer += value;
            }
        }
        return answer;
    }

    public static void main(String[] args){
       int[][] obstacleGrid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
//        int[][] obstacleGrid = new int[][]{{0,0}, {0, 1}};
//        int[][] obstacleGrid = new int[][]{{0, 1}};
//        int[][] obstacleGrid = new int[][]{{0, 0}};
        int[][] cache = new int[obstacleGrid.length][obstacleGrid[0].length];
//        System.out.println(recursive(0, 0, obstacleGrid, cache));
        System.out.println(iterative(obstacleGrid, cache));
    }
}
