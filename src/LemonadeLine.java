import java.io.*; import java.util.*;

public class LemonadeLine {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cows = new int[N];
        for (int i = 0; i<N; i++){
            cows[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cows);
        int[] reversed_cows = new int[N];
        //Collections.reverse(Arrays.asList(cows));
        for (int i = 0; i<N; i++){
            reversed_cows[i] = cows[N-1-i];
        }
        int cowcount = 0;
        while (true){
            if (reversed_cows[cowcount] >= cowcount){
                cowcount++;
            }else{
                break;
            }
        }
        System.out.println(cowcount);

    }
}
