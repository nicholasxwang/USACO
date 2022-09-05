import java.io.*;
import java.util.*;

class NumberCharacterPair{
    char c;
    int i;
    public NumberCharacterPair(char c, int i){
        this.c = c;
        this.i = i;
    }
}
public class SubsetEquality {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        Hashtable<Character, ArrayList<Integer>> ht1 = new Hashtable();
        Hashtable<Character, ArrayList<Integer>> ht2 = new Hashtable();
        int count = 0;
        for (char s: s1.toCharArray()) {
            if (!ht1.keySet().contains(s)) ht1.put(s, new ArrayList<>());
            ht1.get(s).add(count);
            count++;
        }
        count = 0;
        for (char s: s1.toCharArray()) {
            if (!ht2.keySet().contains(s)) ht2.put(s, new ArrayList<>());
            ht2.get(s).add(count);
            count++;
        }
        System.out.println(ht1);
        System.out.println(ht2);
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
