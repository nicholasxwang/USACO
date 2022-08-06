//import java.io.*;
//import java.util.*;
//class TractorLocation{
//    int x;
//    int y;
//    public TractorLocation(int x, int y){
//        this.x = x;
//        this.y = y;
//    }
//}
//public class tractor_V3 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] s = br.readLine().split(" ");
//        int N = Integer.parseInt(s[0]);
//        int x = Integer.parseInt(s[1]);
//        int y = Integer.parseInt(s[2]);
//        ArrayList<TractorLocation> points = new ArrayList<>(N);
//        int max_x = x;
//        int max_y = y;
//        TractorLocation source = new TractorLocation(x, y);
//        for (int i = 0; i < N; i++) {
//            s = br.readLine().split(" ");
//            x = Integer.parseInt(s[0]);
//            y = Integer.parseInt(s[1]);
//            TractorLocation t = new TractorLocation(x, y);
//            points.add(t);
//            if (x > max_x) {
//                max_x = x;
//            }
//            if (y > max_y) {
//                max_y = y;
//            }
//        }
//        max_x++;
//        max_y++;
//        ArrayList<Integer> processed_points = new ArrayList<>();
//        for (int i = 0; i < N; i++) {
//            processed_points.add(0);
//        }
//        for (int i = 0; i < max_x; i++) {
//            for (int j = 0; j < max_y; j++) {
//                int v = twoD_to_oneD(i, j, max_y);
//                processed_points.add(v);
//            }
//        }
//
//        int[][] graph = new int[max_x][max_y];
//        graph[0][0] = 0;
//        for (int i = 0; i< max_x; i++){
//            for (int j = 0; j< max_y; j++){
//                graph[i][j] = max_value ;
//            }
//        }
//
//    }
//}
//
