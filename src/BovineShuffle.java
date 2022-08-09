import java.util.*; import java.io.*;
public class BovineShuffle {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> positions = new HashSet<Integer>();
        int[] sources = new int[N];
        for (int i = 0; i<N; i++){
            int value = Integer.parseInt(st.nextToken());
            positions.add(value);
            sources[i] = value;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        while (true){
            for (int i = 0; i<sources.length; i++){
                if (!positions.contains(sources[i]) || queue){
                    queue.add(i);
                }
            }
        }
        PrintWriter pw = new PrintWriter(new FileWriter("shuffle.out"));
        pw.println(positions.size());
        pw.close();

    }
}
