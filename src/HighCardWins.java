import java.io.*; import java.util.*;

public class HighCardWins {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("highcard.in"));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> elsie = new ArrayList<Integer>();
        ArrayList<Integer> bessie = new ArrayList<Integer>();
        for (int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            elsie.add(a);
        }
        for (int i = N*2; i>=1; i--){
            if (!elsie.contains(i)){
                bessie.add(i);
            }
        }
        Collections.sort(elsie, Collections.reverseOrder());
        //Collections.sort(bessie, Collections.reverseOrder());
        int answer = 0;
        while (!elsie.isEmpty() && !bessie.isEmpty()){
            //System.out.println(elsie + "\n\n" + bessie+"\n\n\n");
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
