import java.io.*; import java.util.*;

class GrassRectangle{
    int x1;
    int y1;
    int x2;
    int y2;
    public GrassRectangle(int x1, int y1, int x2, int y2){
        this.x1 = x1; this.x2 = x2; this.y1 = y1; this.y2 = y2;
    }
}
public class Overplanting {
    public static boolean in_between(int lower, int upper, int point){ return lower<=point && point <= upper;}
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int smallest = 999999999;
        int biggest = -1;
        ArrayList<GrassRectangle> rects = new ArrayList<>();
        for (int i = 0; i<N; i++){
            StringTokenizer st =   new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            if (x1 < smallest) smallest = x1;
            if (x2 > biggest) biggest = x2;
            rects.add(new GrassRectangle(x1, y1, x2, y2));

        }


        //sweepline

        for (int i = smallest; i<=biggest; i++){
            //current x value
            int lower_bound = 99999;
            int upper_bound = -1;
            for (int j = 0; j<rects.size(); j++){
                if (!in_between(rects.get(j).x1, rects.get(j).x2, i)) continue;
                if (rects.get(j).y1 < lower_bound) lower_bound = rects.get(j).y1;
                if (rects.get(j).y2 > upper_bound) upper_bound = rects.get(j).y2;


            }
            int bound = upper_bound - lower_bound + 1;
        }

    }
}
