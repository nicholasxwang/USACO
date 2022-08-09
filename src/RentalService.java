import java.io.*; import java.util.*;
public class RentalService {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[] cows = new int[N];
        int[][] buy = new int[M][2];
        int[] rent = new int[R];
        for (int i = 0; i<N; i++){
            cows[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            buy[i][0] = Integer.parseInt(st.nextToken())-1;
            buy[i][1] = Integer.parseInt(st.nextToken())-1;
        }
        for (int i = 0; i<R; i++){
            rent[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(cows); //sort
        Arrays.sort(rent); //sort
        Arrays.sort(buy, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        Collections.reverse(Arrays.asList(cows)); //reverse


        //find the lowest price time

        int total_gallons = 0;
        for (int i = 0; i<cows.length; i++){
            if (i < (cows.length - rent.length)){
                //default to choosing buy
                int gallons_produced = cows[i];
                total_gallons += gallons_produced;
                continue;
            }
            int gallons_produced = cows[i];
            int rent_price = rent[i];


        }
        //65+69 =



    }
}
