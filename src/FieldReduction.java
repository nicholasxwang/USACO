import java.io.*;

public class FieldReduction {
    public static int distance(int x1, int y1, int x2, int y2){
        return ((x1-x2)*(x1-x2) +  (y1-y2)*(y1-y2));
    }
    public static void main(String[] args) throws IOException{
        BufferedReader b = new BufferedReader(new FileReader("./reduce.in"));
        int N = Integer.parseInt(b.readLine());
        int[][] a = new int[N][2];
        for (int i = 0; i<N; i++){
            String[] t = b.readLine().split(" ");
            a[i][0] = Integer.parseInt(t[0]);
            a[i][1] = Integer.parseInt(t[1]);
        }
        // find a cluster in them middle\=
        //Task: Determine the most NEAR cows

    }

}
