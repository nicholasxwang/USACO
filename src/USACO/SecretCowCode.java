import java.io.*; import java.util.*;
public class SecretCowCode {
    public static char recursive(char[] s, long index){
        if(index < s.length) {
            return s[(int)index];
        }
        long length = s.length;
        while(2*length <= index) {
            length *= 2;
        }
        if(length == index) {
            return recursive(s, length-1);
        }
        return recursive(s, index - length - 1);
    }
   public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new FileReader("cowcode.in"));
       PrintWriter pw = new PrintWriter("cowcode.out");
       StringTokenizer st = new StringTokenizer(br.readLine());
       char[] original = st.nextToken().toCharArray();
       long N = Long.parseLong(st.nextToken())-1;
       pw.println(recursive(original, N));
       pw.close();
   }

}
