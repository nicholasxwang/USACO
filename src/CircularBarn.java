import java.io.*; import java.util.*;
public class CircularBarn {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("cbarn.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("cbarn.out"));
        int N = Integer.parseInt(br.readLine());
        int[] barns = new int[N];
        for (int i = 0; i<N; i++){
            barns[i]  = Integer.parseInt(br.readLine());
        }
        ArrayList<Integer> zeroes = new ArrayList<Integer>();
        int distance = 0;
        for (int i = 0; i<N; i++){
            System.out.println(Arrays.toString(barns));
            if (barns[i] == 0){
                zeroes.add(i);
            }else{
                if (zeroes.size() == 0){
                    continue;
                }
                //move it as front as possible
                int most_front = zeroes.get(0);
                barns[most_front]--;
                distance = (i - most_front) * (i - most_front);
                zeroes.remove(0);
                if (barns[i] == 0){
                    zeroes.add(i);
                }

            }
        }
        System.out.println(distance);
    }
}
