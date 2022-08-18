import java.io.*;
import java.util.*;

public class WhyDidTheCowCrossTheRoad_1 {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] chickens = new int[C];
        int[][] cows = new int[N][2];
        for (int i = 0; i<C; i++){
            chickens[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cows[i][0] = x;
            cows[i][1] = y;
        }
        Arrays.sort(chickens);
        Arrays.sort(cows, new Comparator<int[]>() {
            public int compare(int[] n1, int[] n2) {
                if (n1[1]-n1[0] != n2[1] - n2[0]){
                    return Integer.compare(n1[1]-n1[0], n2[1] - n2[0]);
                }
                return Integer.compare(n1[0], n2[0]);
            };
        });
        int answer = 0;
        for (int i = 0; i<cows.length; i++){
            int low = cows[i][0];
            int high = cows[i][1];
            for (int j = 0; j<chickens.length; j++){
                if (chickens[j] > low) continue;
                if (chickens[j] > high) break;
                answer++;
                chickens
                break;
             }
        }
        System.out.println(answer);



    }
}
