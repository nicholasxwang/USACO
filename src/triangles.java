import java.io.*;
import java.util.*;

class TriangularPoint{
    int x;
    int y;
    public TriangularPoint(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class triangles {
    public static Integer area(TriangularPoint p1, TriangularPoint p2, TriangularPoint p3) {
        int one_x = p1.x;
        int two_x = p2.x;
        int three_x = p3.x;
        int one_y = p1.y;
        int two_y = p2.y;
        int three_y = p3.y;
        int sum1 = 0;
        sum1 += (one_x * two_y);
        sum1 += (two_x * three_y);
        sum1 += (three_x * one_y);
        int sum2 = 0;
        sum2 += (one_y * two_x);
        sum2 += (two_y * three_x);
        sum2 += (three_y * one_x);
        return Math.abs(sum1 - sum2);
    }
    public static void main(String[] args) throws IOException{
        int MOD = 10*10*10*10*10*10*10*10*10+7;
        BufferedReader br = new BufferedReader(new FileReader("triangles.in"));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] x_values = new ArrayList[20000];
        ArrayList<Integer>[] y_values = new ArrayList[20000];

        ArrayList<TriangularPoint> arr = new ArrayList<>();
        for (int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())+10000;
            int y = Integer.parseInt(st.nextToken())+10000;
            TriangularPoint point = new TriangularPoint(x, y);
            if (x_values[x] == null){
                x_values[x] =  new ArrayList<>();
            }
            if (y_values[y] == null){
                y_values[y] =  new ArrayList<>();
            }

            x_values[x].add(i);
            y_values[y].add(i);
            arr.add(point);
        }

        int sum = 0;
        for (int i = 0; i<N; i++){
            TriangularPoint point = arr.get(i);
            ArrayList<Integer> x = x_values[point.x];
            ArrayList<Integer> y = y_values[point.y];
            for (Integer a : x) {
                if (a == i) continue;
                for (Integer b : y) {
                    if (b == i || Objects.equals(b, a)) continue;
                    int area = area(arr.get(i), arr.get(a), arr.get(b));
                    area = area % MOD;
                    sum = sum % MOD;
                    sum += area;

                }
            }

        }
       PrintWriter pw = new PrintWriter("triangles.out");
        pw.println(sum);
        pw.close();



    }
}
