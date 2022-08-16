import java.util.*; import java.io.*;
public class AngryCows {
    public static void main(String[] args) throws   IOException{
        BufferedReader br = new BufferedReader(new FileReader("angry.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] bales = new int[N];
        for (int i = 0; i<N; i++){
            bales[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bales);
//        ArrayList<Integer> sorted_bales = new ArrayList<Integer>(bales);
        ArrayList<Integer> sorted_bales = new ArrayList<Integer>();
        for (int i = 0; i<bales.length; i++){
            sorted_bales.add(bales[i]);
        }
        int V = 5;
        int A = 1;
        int starting = sorted_bales.get(0);
        for (int i = 0; i<N; i++){
            if (sorted_bales.get(i) > starting + V*2){
                A++;
                starting = sorted_bales.get(i);
            }
        }
        System.out.println(A);



    }
}
