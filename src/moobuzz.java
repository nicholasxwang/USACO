import java.io.*;

public class moobuzz {
    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("moobuzz.in"));
        int count = 0;
        int seqcount = 0;
        int N = Integer.parseInt(br.readLine());
        while (seqcount != N){
            count++;
            if (!(count % 3 == 0) & !(count % 5 == 0)){
                seqcount++;
            }
        }
//        System.out.println(count);
        PrintWriter pw = new PrintWriter("moobuzz.out");
        pw.println(count);
        pw.close();

    }
}
