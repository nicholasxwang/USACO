import java.io.*; import java.util.*;
public class Convention2{
    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("convention2.in"));
//        PrintWriter pw = new PrintWriter(System.out);
        PrintWriter pw = new PrintWriter(new FileWriter("convention2.out"));
        int N = Integer.parseInt(br.readLine());
        int[][] cows = new int[N][2];
        ArrayList<Integer> significant = new ArrayList<>();
        for (int i = 0; i<N; i++){
            String[] s = br.readLine().split(" ");
            cows[i][0] = Integer.parseInt(s[0]);
            cows[i][1] = Integer.parseInt(s[1]);
            significant.add(cows[i][0]);
            //significant.add(cows[i][1]+cows[i][0]);
        }

        int eaten_count = 0;
        int timestamp = 0;
        int current_finish = 0;
        int early = 0;
        int delayed = 0;
        while (eaten_count != N){
            early++;
            if (early == 10000){
                break;
            }
            for (int i = 0; i<N; i++){
                if (cows[i][0] == -1) continue;
//                if (cows[i][0] <= timestamp && current_finish <= cows[i][1]){
                if (cows[i][0] <= timestamp && current_finish <= timestamp){
//                    if (cows[i][0] - timestamp > delayed) {
                    if (timestamp  - cows[i][0] > delayed) {
//                        delayed =  cows[i][0] - timestamp;
                        delayed = timestamp - cows[i][0];
                    }

                    eaten_count++;
                    current_finish = timestamp + cows[i][1];
                    //System.out.println(i+" will start eating. ETA: "+current_finish);
                    //prevent cow from eating twice
                    cows[i][0] = -1;

                }
            }
            timestamp++;
            //System.out.println(timestamp);
        }
        //System.out.println(delayed);
        pw.println(delayed);
        pw.close();



    }
}
