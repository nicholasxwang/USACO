import java.io.*; import java.util.*;
public class HighCardWins {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("highcard.in"));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> elsie = new ArrayList<Integer>();
        ArrayList<Integer> bessie = new ArrayList<Integer>();
        for (int i = 0; i<N; i++){
            int a = Integer.parseInt(br.readLine());
            elsie.add(a);
        }
        Collections.sort(elsie, Collections.reverseOrder());
        int comparing_index = 0;
        for (int i = N*2; i>=1; i--){
            if (elsie.size() > comparing_index && elsie.get(comparing_index)!=i){
                bessie.add(i);
            }else if (elsie.size() - 1 ==  comparing_index){
                bessie.add(i);
            }
            else{
                comparing_index++;
            }
        }

        int answer = 0;
        while (!elsie.isEmpty() && !bessie.isEmpty()){
            if (bessie.get(0) > elsie.get(0)){
                answer++;
                bessie.remove(0);
                elsie.remove(0);
            }
            else{
                elsie.remove(0);
                bessie.remove(bessie.size()-1);
            }
        }
        PrintWriter pw = new PrintWriter(new FileWriter("highcard.out"));
        pw.println(answer);
        pw.close();

    }
}
