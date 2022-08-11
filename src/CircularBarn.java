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
        while (!zeroes.isEmpty() || initial){
            initial = false;
            if (revolutions == 30){
                break;

            }
            revolutions++;

            System.out.println("again");
            for (int i = 0; i<N; i++){
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
                    System.out.println(Arrays.toString(barns)+" "+distance);
                    System.out.println(zeroes.toString());

                    if (barns[i] == 0){
                        zeroes.add(i);
                    }
                    break;

                }
            }
            System.out.println("again");
            System.out.println(Arrays.toString(barns)+" "+distance);
        }
        System.out.println(distance);
    }
}
