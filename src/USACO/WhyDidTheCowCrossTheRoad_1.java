import java.io.*;
import java.util.*;

public class WhyDidTheCowCrossTheRoad_1 {

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("helpcross.in"));
        PrintWriter pw = new PrintWriter("helpcross.out");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        ArrayList<Integer> chickens = new ArrayList<>();
        int[][] cows = new int[N][2];
        for (int i = 0; i<C; i++){
            chickens.add(Integer.parseInt(br.readLine()));
        }
        for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cows[i][0] = x;
            cows[i][1] = y;
        }
        Collections.sort(chickens);
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
            for (int j = 0; j<chickens.size(); j++){
                if (chickens.get(j) < low) continue;
                if (chickens.get(j) > high) break;
                answer++;
                //System.out.println("Cow ["+low+", "+high+"] went with Chicken "+chickens.get(j));
                chickens.remove(j);
                break;
             }
        }
        pw.println(answer);
        pw.close();



    }
}
