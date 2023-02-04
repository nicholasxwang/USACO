import java.io.*;

public class SearchingForSoulmates {
    public static int function(int smaller, int larger){
        int steps = 0;
        while (larger != smaller){
            if (larger % 2 == 1){
                larger++;
                steps++;
            }
            if (larger % 2 == 0 && larger > smaller){
                larger /= 2;
                steps++;
            }
            if (larger < smaller){
                larger++;
                steps++;

            }
        }
        return steps;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i<N; i++){
            String[] s = br.readLine().split(" ");
            int i1 = Integer.parseInt(s[0]);
            int i2  = Integer.parseInt(s[1]);
            int smaller = Math.min(i1, i2);
            int larger = Math.max(i1, i2);
            int steps = function(smaller, larger);
            System.out.println(steps);
        }
    }
}
