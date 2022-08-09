import java.util.*; import java.io.*;
public class BovineShuffle {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> positions = new HashSet<Integer>();
        for (int i = 0; i<N; i++){
            positions.add(Integer.parseInt(st.nextToken()));
        }
        PrintWriter pw = new PrintWriter(new FileWriter("shuffle.out"));
        pw.println(positions.size());
        pw.close();

    }
}
