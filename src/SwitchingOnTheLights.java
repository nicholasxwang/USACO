import java.util.*; import java.io.*;
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
    static boolean isValid(int[][] screen, int N, int x, int y, int old_x, int old_y, int[][] matrix) {
        int new_value = twod_to_one(N, x, y);
        int old_value = twod_to_one(N, old_x, old_y);
        return  (!(x < 0 || x >= N || y < 0 || y >= N  || matrix[old_value][new_value] == 0));
    }
    static int floodFill(int[][] rooms, int N, int x, int y, int[][]  matrix) {
        Vector<Point_> queue = new Vector<>();
        rooms[x][y] = 1;
        queue.add(new Point_(x, y));
        int changes = 0;
        while (queue.size() > 0) {
            Point_ currPixel = queue.get(queue.size() - 1);
            queue.remove(queue.size() - 1);
            int posX = currPixel.x;
            int posY = currPixel.y;
            if (isValid(rooms, N, posX + 1, posY, posX, posY, matrix)) { rooms[posX + 1][posY] = 1; queue.add(new Point_(posX + 1, posY)); changes++;}
            if (isValid(rooms, N, posX - 1, posY, posX, posY, matrix)) { rooms[posX - 1][posY] = 1; queue.add(new Point_(posX - 1, posY)); changes++;}
            if (isValid(rooms, N, posX, posY + 1, posX, posY, matrix)) { rooms[posX][posY + 1] = 1; queue.add(new Point_(posX, posY + 1)); changes++;}
            if (isValid(rooms, N, posX, posY - 1, posX, posY, matrix)) {rooms[posX][posY - 1] = 1; queue.add(new Point_(posX, posY - 1)); changes++;}
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
        System.out.println(Arrays.deepToString(rooms));



    }
}
