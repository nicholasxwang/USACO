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
    //custom print
    public String toString(){
        return " ("+this.peak.x+", "+this.peak.y+") ";
    }


}
public class MountainView {
    static double area(int x1, int y1, int x2, int y2,
                       int x3, int y3)
    {
        return Math.abs((x1*(y2-y3) + x2*(y3-y1)+
                x3*(y1-y2))/2.0);
    }
    static boolean PointInTriangle(int x1, int y1, int x2,
                            int y2, int x3, int y3, int x, int y)
    {
        /* Calculate area of triangle ABC */
        double A = area (x1, y1, x2, y2, x3, y3);

        /* Calculate area of triangle PBC */
        double A1 = area (x, y, x2, y2, x3, y3);

        /* Calculate area of triangle PAC */
        double A2 = area (x1, y1, x, y, x3, y3);

        /* Calculate area of triangle PAB */
        double A3 = area (x1, y1, x2, y2, x, y);

        /* Check if sum of A1, A2 and A3 is same as A */
        return (A == A1 + A2 + A3);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("mountains.in"));
        PrintWriter pw = new PrintWriter("mountains.out");
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
                  if (PointInTriangle(mountains.get(j).peak.x, mountains.get(j).peak.y, mountains.get(j).left.x, mountains.get(j).left.y, mountains.get(j).right.x, mountains.get(j).right.y , mountains.get(i).peak.x, mountains.get(i).peak.y) ) {
                      small_stable = false;
                      //System.out.println(mountains.get(i) + " got eaten by " + mountains.get(j));
                      mountains.remove(i);
                      break;
                  }



               }

            }
            if (small_stable) stable = true;
            if (stable){
                break;
            }


        }
        pw.println(mountains.size());
        pw.close();





    }
}
