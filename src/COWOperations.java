import java.io.*;
import java.util.*;
/*

OW -> OOC -> C
OWOW -> OOCOOC -> CC -> X
OWWO -> OOCWO -> CWO -> CCOO -> X
OWWW -> OW -> OOC -> C

Odd Number of O and W becomes C and Odd Number of Cs makes C
*/
class LetterCount{
    int C;
    int O;
    int W;
    public LetterCount(int C, int O, int W){
        this.C = C;
        this.O = O;
        this.W = W;
    }
    public LetterCount add(int C, int O, int W){
        return new LetterCount(this.C + C, this.O + O, this.W + W);
    }

}
public class COWOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("");
        LetterCount[] prefix = new LetterCount[s.length+1];
        prefix[0] =  new LetterCount(0, 0, 0);
        for (int i = 1; i<s.length+1; i++){
            prefix[i] = new LetterCount(prefix[i-1].C, prefix[i-1].O, prefix[i-1].W);
            if (s[i-1].equals("C")) prefix[i] = prefix[i].add(1, 0, 0);
            else if (s[i-1].equals("O")) prefix[i] = prefix[i].add(0, 1, 0);
            else prefix[i] = prefix[i].add(0, 0, 1);
        }
        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i<Q; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int C = prefix[E].C - prefix[S-1].C % 2;
            int O = prefix[E].O - prefix[S-1].O % 2;
            int W = prefix[E].W - prefix[S-1].W % 2;
            C = C % 2;
            O = O % 2;
            W = W % 2;
            if (O == 1 && W == 1 && C == 1) System.out.print("Y");
            else System.out.print("N");
        }
    }
}
