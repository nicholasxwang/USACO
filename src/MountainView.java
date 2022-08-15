import java.io.*; import java.util.*;
class MountainPoint{
    int x;
    int y;
    public MountainPoint(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Mountain{
    MountainPoint peak;
    MountainPoint left;
    MountainPoint right;
    int height;
    int length;

    public Mountain(int x, int y){
        this.peak = new MountainPoint(x, y);
        this.height = y;
        this.length = y*2;
        this.left = new MountainPoint(x-y, 0);
        this.right = new MountainPoint(x+y, 0);
    }


}
public class MountainView {
//    public static check_mountain9]

    static float sign (MountainPoint p1, MountainPoint p2, MountainPoint p3) {
        return (p1.x - p3.x) * (p2.y - p3.y) - (p2.x - p3.x) * (p1.y - p3.y);
    }

    static boolean PointInTriangle (MountainPoint pt, MountainPoint v1, MountainPoint v2, MountainPoint v3)
    {
        float d1, d2, d3;
        boolean has_neg, has_pos;

        d1 = sign(pt, v1, v2);
        d2 = sign(pt, v2, v3);
        d3 = sign(pt, v3, v1);

        has_neg = (d1 < 0) || (d2 < 0) || (d3 < 0);
        has_pos = (d1 > 0) || (d2 > 0) || (d3 > 0);

        return !(has_neg && has_pos);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Mountain> mountains = new ArrayList<>();
        for (int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Mountain mtn = new Mountain(x, y);
            mountains.add(mtn);
        }
        boolean stable = false;
        while (!stable){
            boolean small_stable = true;
            for (int  i =0; i<mountains.size(); i++){
               for (int j = 0; j<mountains.size(); j++){
                   if (i==j) continue;
                  if (!PointInTriangle(mountains.get(i).peak, mountains.get(j).peak, mountains.get(j).left, mountains.get(j).right) )
                    small_stable = false;
                    mountains.remove(i);
                    break;



               }

            }
            if (small_stable) stable = true;
            if (stable){
                break;
            }


        }
        System.out.println(mountains.size());





    }
}
