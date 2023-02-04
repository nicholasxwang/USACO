import java.io.*;

public class HoofPaperScissors3 {
    public static boolean move(int bessieMove, int johnMove){ // True for Bessie Victory, false for John victory/tie
        // 0 = Hoof; 1 = Paper; 2 = Scissors
        if(bessieMove == johnMove){
            return false;
        }
        switch(bessieMove){
            case 0:
                if(johnMove == 1){
                    return false;
                }
                break;
            case 1:
                if(johnMove == 2){
                    return false;
                }
                break;
            case 2:
                if(johnMove == 0){
                    return false;
                }
                break;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("hps.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
        int N = Integer.parseInt(reader.readLine());

        int[] moves = new int[N];
        for (int i = 0; i < N; i++) {
            String move = reader.readLine();
            if(move.equals("H")){
                moves[i] = 0;
            } else if(move.equals("P")){
                moves[i] = 1;
            } else {
                moves[i] = 2;
            }
        }
        // two layers of for loop
        // first: n-1 layers for where to divide
        // second: nine cases of choice
        int max_victory = 0;
        for (int i = 0; i<N-1; i++){
            // i and i+1 are the two divisions
            for (int john_move = 0; john_move<3; john_move++){
                for (int bessie_move = 0; bessie_move<3; bessie_move++){
                    int victory = 0;
                    for (int j = 0; j<=i; j++){
                        if(move(bessie_move, moves[j])){
                            victory++;
                        }
                    }
                    for (int j = i+1; j<N; j++){
                        if(move(john_move, moves[j])){
                            victory++;
                        }
                    }
                    if(victory>max_victory){
                        max_victory = victory;
                    }
                }
            }
        }
        pw.println(max_victory);
        pw.close();
    }
}
