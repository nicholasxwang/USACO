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
    public static void main(String[] args) throws IOException{
//        4
//        0 0
//        0 1
//        1 0
//        1 2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, ArrayList<TriangularPoint>> x_values = new HashMap<>();
        HashMap<Integer, ArrayList<TriangularPoint>> y_values = new HashMap<>();

        ArrayList<TriangularPoint> arr = new ArrayList<>();
        for (int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            TriangularPoint point = new TriangularPoint(x, y);
            if (!x_values.keySet().contains(x)){
                x_values.put(x, new ArrayList<>());
            }
            if (!y_values.keySet().contains(y)){
                y_values.put(y, new ArrayList<>());
            }
            x_values.get(x).add(point);
            y_values.get(y).add(point);
            arr.add(point);
        }



    }
}
