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
//    public static check_mountain9
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Queue<Mountain> mountains = new LinkedList<>();
        for (int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Mountain mtn = new Mountain(x, y);
            mountains.add(mtn);
        }
    }
}
