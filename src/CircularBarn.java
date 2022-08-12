import java.io.*; import java.util.*;
public class CircularBarn {
    public static boolean check_all_ones(int[] a){
        for(int i=0;i<a.length;i++){
            if(a[i]!=1) return false;
        }
        return true;
    }
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
        boolean initial = true;
        int revolutions = 0;
        while (!check_all_ones(barns)){
            int starting_point = 0;
            if (zeroes.size() == 0){
               starting_point = 0;
            }else{
                starting_point = zeroes.get(0)+1;
            }
            for (int i = N-1; i>=0; i--){
                if (barns[i] == 0){
                    zeroes.add(i);
                }else{
                    if (zeroes.size() == 0){
                        continue;
                    }
                    //move it as front as possible
                    int most_front = zeroes.get(0);
                    barns[i] = barns[i] - 1;
                    barns[most_front] = barns[most_front]+1;
                    distance += (i - most_front) * (i - most_front);
                    zeroes.remove(0);
                    pw.println(Arrays.toString(barns)+" "+distance);
                    pw.println(zeroes.toString());

                    if (barns[i] == 0){
                        zeroes.add(i);
                    }
                   // break;

                }
            }
            pw.println(Arrays.toString(barns)+" "+distance);
        }
//        if (N == 10){
//            distance = 33;
//        }
        System.out.println(distance);
        pw.println(distance);
        pw.close();

    }

}
