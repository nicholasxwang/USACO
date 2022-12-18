import java.io.*;
import java.util.*;

public class BessieShuffle {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[] answers = new int[N];
        int answer_index = N-1;
        ArrayList<Integer> cards = new ArrayList<>();
        for (int i = 0; i<N; i++){
            cards.add(i+1);
        }
        int[] P = new int[M];
        for (int i = 0; i<M; i++){
            P[i] = Integer.parseInt(br.readLine());
        }
        while (cards.size() > 1){
            System.out.println(cards);
            if (cards.size() >= M) {
                int[] cache = new int[M];
                for (int i = 0; i<M; i++){
                    cache[i] = cards.get(i);
                }
                for (int i = 0; i<M; i++){
                    cards.set(P[i]-1, cache[i]);
                }
            }
            int removed = cards.get(0);
            System.out.println(removed);
            cards.remove(0);
            answers[answer_index] = removed;
            answer_index--;
        }
        answers[answer_index] = cards.get(0);
        System.out.println(Arrays.toString(answers));
        PrintWriter pw = new PrintWriter(new FileWriter("shuffle.out"));
        for (int i = 0; i<Q; i++){
            int query = Integer.parseInt(br.readLine());
            pw.println(answers[query]);
        }
        pw.close();
    }
}
