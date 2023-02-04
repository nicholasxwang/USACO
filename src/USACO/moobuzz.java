import java.io.*;

public class moobuzz {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("moobuzz.in"));
        int count = 0;
        int seqcount = 0;
        int N = Integer.parseInt(br.readLine());
        int changingN = N;
        while (changingN > 8){
            changingN = changingN - 8;
//            seqcount += 15;
            count += 15;
            seqcount += 8;
        }
        while (seqcount != N){
            count++;
            if (!(count % 3 == 0) & !(count % 5 == 0)){
                seqcount++;
            }
        }
        PrintWriter pw = new PrintWriter("moobuzz.out");

        pw.println(count);
        pw.close();

    }
}
