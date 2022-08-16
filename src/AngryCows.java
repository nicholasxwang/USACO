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
        int low = 1;
        int high = N;
        int V = 0;
        int smallest = N;
        int[] answers = new int[N];
        for (int i = 0; i<answers.length; i++){
            answers[i] = -1;
        }
        while (low!=high){
            V = (low + high)/2;
            int R = 1;
            int starting = sorted_bales.get(0);
            for (int i = 0; i<N; i++){
                if (sorted_bales.get(i) > starting + V*2){
                    R++;
                    starting = sorted_bales.get(i);
                }
            }
            //System.out.println(V+" -> "+R);
            if (R < smallest){
                smallest = V;
            }
            answers[V] = R;
            if (R > smallest || R>K ) // x is on the right side
                low = V + 1;

            else                  // x is on the left side
                high = V - 1;
        }

        for (V = smallest; V>=0; V--){
            int R = 1;
            int starting = sorted_bales.get(0);
            for (int j = 0; j<N; j++){
                if (sorted_bales.get(j) > starting + V*2){
                    R++;
                    starting = sorted_bales.get(j);
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
