import java.io.*; import java.util.*;

public class DiamondCollector {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       // maybe use binary search :thonk:
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] diamonds = new int[N];
        for (int i = 0; i<N; i++){
            diamonds[i] = Integer.parseInt(br.readLine());
        }

        for (int j = 0; j<N; j)
        for (int i = 0; i<N; i++){
            for (int j = i+1; j<N; j++){
                if (Math.abs(diamonds[i] - diamonds[j]) < K){
                    System.out.println("("+i+","+j+")");
                }
            }
        }




    }

}
