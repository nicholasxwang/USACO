import java.io.*;
import java.util.ArrayList;

class CoordinatePoint{
    int x;
    int y;
    public CoordinatePoint(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Cow_Steeplechase_II {
    public static Integer area(Point p1, Point p2, Point p3) {
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

        return Math.abs(sum1 - sum2)/2;

    }
    public static boolean intersect(Point p1, Point p2, Point p3, Point p4) {
        double Ax0 = Math.min(p1.x, p2.x);
        double Bx0 = Math.min(p3.x, p4.x);
        double Ax1 = Math.max(p1.x, p2.x);
        double Bx1 = Math.max(p3.x, p4.x);
        double Ay0 = Math.min(p1.y, p2.y);
        double By0 = Math.min(p3.y, p4.y);
        double Ay1 = Math.max(p1.y, p2.y);
        double By1 = Math.max(p3.y, p4.y);

        double a1 = p2.y - p1.y;
        double b1 = p1.x - p2.x;
        double c1 = p2.x * p1.y - p1.x * p2.y;

        double a2 = p4.y - p3.y;
        double b2 = p3.x - p4.x;
        double c2 = p4.x * p3.y - p3.x * p4.y;

        double den = a1*b2 - a2 * b1;
        if (Math.abs(den) < 0.000001) return false;

        Point p0 = new Point((b1*c2-b2*c1 )/ den, (a2 * c1 - a1 * c2)/den);


        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();

        for (int i = 0; i<N; i++){
            ArrayList<Integer> sub = new ArrayList<>();
            a.add(sub);
            counts.add(0);
        }
        for (int i = 0; i<N; i++){
            for (int j = i+1; j<N; j++){
                int x1_1 = a.get(i).get(0);
                int y1_1 = a.get(i).get(1);
                int x1_2 = a.get(i).get(2);
                int y1_2 = a.get(i).get(3);
                int x2_1 = a.get(j).get(0);
                int y2_1 = a.get(j).get(1);
                int x2_2 = a.get(j).get(2);
                int y2_2 = a.get(j).get(3);
                if (intersect(new Point(x1_1, y1_1), new Point(x1_2, y1_2), new Point(x2_1, y2_1), new Point(x2_2, y2_2) )){
                    counts.set(i, counts.get(i)+1);
                    counts.set(j, counts.get(j)+1);
                }
            }
        }
        int max_count = 0;
        for (int i = 0; i<N; i++){
            if (counts.get(max_count) < counts.get(i)) max_count = i;

        }
        System.out.println(max_count);



    }
}
