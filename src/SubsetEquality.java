import java.io.*;
import java.util.*;

public class SubsetEquality {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i<N; i++){
            ArrayList<Character> allowed = new ArrayList<Character>();
            char[] allowed_ = br.readLine().toCharArray();
            for (int k = 0; k<allowed_.length; k++){
                allowed.add(allowed_[k]);
            }

            String news1 = "";
            for (char s: s1.toCharArray()){
                if (allowed.contains(s)) news1+=s;
            }
            String news2 = "";
            for (char s: s2.toCharArray()){
                if (allowed.contains(s)) news2+=s;
            }
            if (news1.equals(news2)){
                System.out.print("Y");
            }else{
                System.out.print("N");
            }
        }


    }
}
