import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class CoordinatePoint {
    double x;
    double y;
    public CoordinatePoint(double x, double y){
        this.x = x;
        this.y = y;
    }
}
public class Cow_Steeplechase_II {
    public static Integer area(CoordinatePoint p1, CoordinatePoint p2, CoordinatePoint p3) {
        int one_x = (int) p1.x;
        int two_x = (int) p2.x;
        int three_x = (int) p3.x;
        int one_y = (int) p1.y;
        int two_y = (int) p2.y;
        int three_y = (int) p3.y;
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
    public static boolean intersect(CoordinatePoint p1, CoordinatePoint p2, CoordinatePoint p3, CoordinatePoint p4) {
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

        CoordinatePoint p0 = new CoordinatePoint((b1*c2-b2*c1 )/ den, (a2 * c1 - a1 * c2)/den);
        if (p0.x >= Ax0 && p0.x <= Ax1 && p0.x >= Bx0 && p0.x <= Bx1){
            if (p0.y >= Ay0 && p0.y <= Ay1 && p0.y >= By0 && p0.y <= By1){
                return true;
            }
        }


        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("cowjump.in"));
        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();

        for (int i = 0; i<N; i++){
            ArrayList<Integer> sub = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            sub.add(Integer.parseInt(st.nextToken()));
            sub.add(Integer.parseInt(st.nextToken()));
            sub.add(Integer.parseInt(st.nextToken()));
            sub.add(Integer.parseInt(st.nextToken()));
            a.add(sub);

        }

        ArrayList<Integer> activated = new ArrayList<>();
        activated.add(0);
        boolean break2 = false;
        for (int i = 1; i<N; i++){
            for (int a_index = 0; a_index<activated.size(); a_index++){
                int a_ = activated.get(a_index);
                if (a_ == i) continue;
                int x1_1 = a.get(i).get(0);
                int y1_1 = a.get(i).get(1);
                int x1_2 = a.get(i).get(2);
                int y1_2 = a.get(i).get(3);
                int x2_1 = a.get(a_).get(0);
                int y2_1 = a.get(a_).get(1);
                int x2_2 = a.get(a_).get(2);
                int y2_2 = a.get(a_).get(3);
                if (intersect(new CoordinatePoint(x1_1, y1_1), new CoordinatePoint(x1_2, y1_2), new CoordinatePoint(x2_1, y2_1), new CoordinatePoint(x2_2, y2_2) )){
                    PrintWriter pw = new PrintWriter("cowjump.out");
                    pw.println(i+1);
                    pw.close();
                    break2 = true;
                    break;
                }
                if (!activated.contains(a_)) activated.add(a_);

            }
            if (break2) break;
        }



    }
}
