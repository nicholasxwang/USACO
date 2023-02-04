import java.io.*;
import java.util.*;

class PairClass{
    int value;
    int amount;
    public PairClass(int value, int amount){
        this.value = value;
        this.amount = amount;
    }
}
public class PairedUp {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("pairup.in"));
        int N = Integer.parseInt(br.readLine());
        ArrayList<PairClass> cows = new ArrayList<>();
        for (int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            cows.add(new PairClass(value, count));
        }
        Collections.sort(cows, new Comparator<PairClass>(){
            public int compare(PairClass n1, PairClass n2){
                if (n1.value != n2.value){
                    return Integer.compare(n1.value, n2.value);
                }
                return Integer.compare(n1.amount, n2.amount);
            }
        });
        int max = 0;
        while (cows.size() > 1){
            PairClass first = cows.get(0);
            PairClass last = cows.get(cows.size()-1);
            if (first.amount == last.amount) {
                max = Math.max(max, first.value + last.value);
                cows.remove(0);
                cows.remove(cows.size() - 1);
            }
            else if (first.amount > last.amount){
                max = Math.max(max, first.value + last.value);
                cows.get(0).amount -= cows.get(cows.size()-1).amount;
                cows.remove(last);
            }
            else if (first.amount < last.amount){
                max = Math.max(max, first.value + last.value);
                cows.get(cows.size()-1).amount -= cows.get(0).amount;
                cows.remove(first);
            }
        }
        if (cows.size() == 1){
            max = Math.max(max, cows.get(0).value*2);
        }
        PrintWriter pw = new PrintWriter("pairup.out");
        pw.println(max);
        pw.close();


    }

}
