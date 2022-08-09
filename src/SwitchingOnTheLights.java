import java.util.*; import java.io.*;
class RoomLocation{
    int x;
    int y;
    public RoomLocation(int x, int y){ this.x = x;this.y = y; }
}
public class SwitchingOnTheLights {
    public static int twod_to_one(int n, int i, int j) {
        return i * n + j;
    }
    public static int[] one_to_twod(int i, int n) {
        int[] ret = new int[2];
        ret[0] = i / n;
        ret[1] = i % n;
        return ret;
    }
    static int floodFill(int[][] rooms, int N, int x, int y, int[][]  matrix) {
        Vector<RoomLocation> queue = new Vector<>();
        rooms[x][y] = 1;
        queue.add(new RoomLocation(x, y));
        int changes = 0;
        while (queue.size() > 0) {
            RoomLocation currPixel = queue.get(queue.size() - 1);
            queue.remove(queue.size() - 1);
            int current_RoomLocationvalue = twod_to_one(N, currPixel.x, currPixel.y);
            for (int i = 0; i<N*N; i++){
                if (matrix[current_RoomLocationvalue][i] == 1 && rooms[i/N][i%N] == 0) {
                    int[] next_point = one_to_twod(i, N);
                    rooms[next_point[0]][next_point[1]] = 1;
                    queue.add(new RoomLocation(next_point[0], next_point[1]));
                    changes++;
                }
            }

        }
        return changes;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("lightson.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N =  Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N*N][N*N]; // x value is giver, y value is receiver
        for (int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int recieved_x = Integer.parseInt(st.nextToken())-1;
            int recieved_y = Integer.parseInt(st.nextToken())-1;
            int giver = twod_to_one(N, x, y);
            int receiver = twod_to_one(N, recieved_x, recieved_y);
            matrix[giver][receiver] = 1;
        }
        int[][] rooms = new int[N][N];
        while (true){
            int changes = floodFill(rooms, N, 0, 0, matrix) ;
            if (changes == 0) break;
        }
//        System.out.println(Arrays.deepToString(rooms));
        int answer= 0;
        for (int i = 0; i<N; i++){
            for (int j = 0; j<N; j++){
                if (rooms[i][j] == 1) answer++;
            }
        }
        pw.println(answer);
        pw.close();



    }
}
