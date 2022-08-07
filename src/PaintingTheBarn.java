import java.util.*; import java.io.*;
public class PaintingTheBarn {
    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new FileReader("paintbarn.in"));
       PrintWriter pw = new PrintWriter("paintbarn.out");
       StringTokenizer st = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st.nextToken());
       int K = Integer.parseInt(st.nextToken());
       int lower_x = Integer.MAX_VALUE;
       int upper_x = Integer.MIN_VALUE;
       int lower_y = Integer.MAX_VALUE;
       int upper_y = Integer.MIN_VALUE;
       int[][] points = new int[N][4];
       for (int i = 0; i<N; i++){
           st = new StringTokenizer(br.readLine());
           int x1 = Integer.parseInt(st.nextToken());
           int y1 = Integer.parseInt(st.nextToken());
           int x2 = Integer.parseInt(st.nextToken());
           int y2 = Integer.parseInt(st.nextToken());
           if (x1 < lower_x) lower_x = x1;
           if (x2 > upper_x) upper_x = x2;
           if (y1 < lower_y) lower_y = y1;
           if (y2 > upper_y) upper_y = y2;
           points[i][0] = x1;
           points[i][1] = y1;
           points[i][2] = x2;
           points[i][3] = y2;
       }
       int[][] grid = new int[upper_x-lower_x+1][upper_y-lower_y+1];
       for (int i = 0; i<N; i++){
           int x1 = points[i][0] - lower_x;
           int y1 = points[i][1] - lower_y;
           int x2 = points[i][2] - lower_x;
           int y2 = points[i][3] - lower_y;
              for (int j = x1; j<=x2; j++){
                for (int k = y1; k<=y2; k++){
                     grid[j][k]++;
                }
              }
       }
       int answer = 0;
       for (int i = 0; i<grid.length; i++){
              for (int j = 0; j<grid[i].length; j++){
                if (grid[i][j] == K) answer++;
              }
       }
       System.out.println(answer);
       pw.close();
    }
}