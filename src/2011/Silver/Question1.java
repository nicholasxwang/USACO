import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Floodfill {
    private static int[][] grid;
    private static int rowNum;
    private static int colNum;
    public static void floodfill() {
        rowNum = Integer.parseInt(dims.nextToken());
        colNum = Integer.parseInt(dims.nextToken());
        grid = new int[rowNum][colNum];
        for (int r = 0; r < rowNum; r++) {
            grid[r] = Arrays.stream(read.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}

class Question1{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        String[] firstLine_Splitted = firstLine.split(" ", 2);
        int N = Integer.parseInt(firstLine_Splitted[0]);
        int M = Integer.parseInt(firstLine_Splitted[1]);
        int[][] grid = new int[N][M];
        for (int i = 0; i<N; i++){
            String[] unparsedInput = br.readLine().split(" ", M);
            for (int j = 0; i<M; i++){
                int parsedInteger = Integer.parseInt(unparsedInput[j]);
                grid[i][j] = parsedInteger;
            }

        }
        //Flood Fill

//        for i i



    }
}



