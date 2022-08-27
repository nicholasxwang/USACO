import java.io.*;
import java.util.*;

class LineCow{
    int position;
    int prev_position;
    int weight;
    int velocity;
    boolean arrived;

    public LineCow(int weight, int position, int velocity){
        this.weight = weight;
        this.position = position;
        this.prev_position = position;
        this.velocity = velocity;
        this.arrived = false;
    }


}
public class Meetings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("moobuzz.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        ArrayList<LineCow> cows = new ArrayList<>();

        for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            cows.add(new LineCow(w, x, d));

        }

        while (true){
            
        }




    }
}
