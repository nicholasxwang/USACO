import java.util.*; import java.io.*;
public class RectangularPasture {
    public static boolean valid_pair(int x1, int y1, int x2, int y2, int middle_x, int middl_y){
        return !(x1 <= middle_x && middle_x <= x2 && y1 <= middl_y && middl_y <= y2);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] points = new int[N][2];
        for (int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
//            points[i][0] = A - 1;
//            points[i][1] = B - 1;
            points[i][0] = A;
            points[i][1] = B;
        }

        ArrayList<Integer[]> pairs = new ArrayList<Integer[]>();
        for (int i = 0; i<N; i++){
            for (int j = i+1; j<N; j++) {
                boolean valid_pair = true;
                for (int k = 0; k<N; k++){
                    if (k== i || k==j ) continue;
                    if (valid_pair(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1])){
                        valid_pair = false;
                        System.out.println("("+points[i][0]+","+points[i][1]+") and ("+points[j][0]+","+points[j][1]+") are false because of ("+points[k][0]+","+points[k][1]+")");
                        break;
                    }
                }
                if (valid_pair){
                    pairs.add(new Integer[]{i, j});
                }
            }
        }
        System.out.println(pairs);

    }
}
