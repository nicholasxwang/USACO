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
        int V;
        int smallest = N;
        for (V = N; V>=0; V--){
            int R = 1;
            int starting = bales[0] + V*2;
            for (int j = 0; j<N; j++){
                if (bales[j] > starting){
                    R++;
                    starting = bales[j] + V*2;
                }
            }
            if (R > K ){
                break;
            }else{
                smallest = V;
            }
        }
        PrintWriter pw = new PrintWriter("angry.out");
        pw.println(smallest);
        pw.close();

    }
}
