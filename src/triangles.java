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
        int NEGATIVE_SUPPORT = 0;
        int[] x_values = new int[10000+NEGATIVE_SUPPORT];
        int[] y_values = new int[10000+NEGATIVE_SUPPORT];
        int[] x_counts = new int[10000+NEGATIVE_SUPPORT];
        int[] y_counts = new int[10000+NEGATIVE_SUPPORT];

        ArrayList<TriangularPoint> arr = new ArrayList<>();
        for (int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())+NEGATIVE_SUPPORT;
            int y = Integer.parseInt(st.nextToken())+NEGATIVE_SUPPORT;
            TriangularPoint point = new TriangularPoint(x, y);

            x_values[x] += y;
            y_values[y] += x;
            x_counts[x] ++;
            y_counts[y] ++;
            arr.add(point);
        }

        int sum = 0;
        for (int i = 0; i<N; i++){
            TriangularPoint point = arr.get(i);
            int x = x_values[point.x];
            int y = y_values[point.y];
            int x_count = x_counts[point.x];
            int y_count = y_counts[point.y];
            int area = (x - x_count*point.x)*(y - y_count*point.y);
//            int area = (x - 20000)*(y - 20000);
            area = area % MOD;
            sum = sum % MOD;
            if (area > 0)
                sum += area;

        }
       PrintWriter pw = new PrintWriter("triangles.out");
        pw.println(sum % MOD);
        pw.close();



    }
}
