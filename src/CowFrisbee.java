import java.io.*; import java.util.*;

public class CowFrisbee {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer>[] tracker = new ArrayList[N]; // keeps track of all sequences that end from the tracker index
        for (int i = 1; i<N; i++){
            tracker[i] = new ArrayList<Integer>();
            tracker[i].add(i-1);
            int heighest_yet = numbers[i-1];
            if (numbers[i-1] > numbers[i]){
                continue; // these ones cannot survive
            }
            for (int j = i-2; j>=0; j--){
               if (numbers[j] > heighest_yet){
                   heighest_yet = numbers[j];
                   tracker[i].add(j);
               }else{
                   break;
               }
            }
        }
        int ans = 0;
        for (int i = 1; i<N; i++){
            for (int j = 0; j<tracker[i].size(); j++){
                //System.out.println("(" + (j+1) + ", " + (i+1) + ")");
               ans+= (i-j);
            }
        }
        //System.out.println(Arrays.toString(tracker));
        System.out.println(ans);


    }
}
