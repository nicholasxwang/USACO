import java.util.*; import java.io.*;
public class PaintingTheBarn {
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new FileReader("paintbarn.in"));
       PrintWriter pw = new PrintWriter("paintbarn.out");
       StringTokenizer st = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st.nextToken());
       int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[1000][1000];
       while (N != 0){
           N--;
           st = new StringTokenizer(br.readLine());
           int x = Integer.parseInt(st.nextToken());
           int y = Integer.parseInt(st.nextToken());
           int w = Integer.parseInt(st.nextToken());
           int z = Integer.parseInt(st.nextToken());
           dp[x][y]++;
           dp[w][z]++;
           dp[x][z]--;
           dp[w][y]--;

       }
       int answer = 0;
       for (int i = 0; i< dp.length; i++){
           for (int j = 0; j< dp.length; j++){
               if (i!=0) dp[i][j] += dp[i-1][j];
               if (j!=0) dp[i][j] += dp[i][j-1];
                if (i!=0 && j!=0) dp[i][j] -= dp[i-1][j-1];
                if (dp[i][j] == K) answer++;
           }
       }
       pw.println(answer);
       pw.close();
    }
}