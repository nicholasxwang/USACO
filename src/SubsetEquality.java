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
        Hashtable<Character, ArrayList<NumberCharacterPair>> ht1 = new Hashtable();
        Hashtable<Character, ArrayList<NumberCharacterPair>> ht2 = new Hashtable();
        int count = 0;
        for (char s: s1.toCharArray()) {
            if (!ht1.containsKey(s)) ht1.put(s, new ArrayList<>());
            ht1.get(s).add(new NumberCharacterPair(s, count));
            count++;
        }
        count = 0;
        for (char s: s1.toCharArray()) {
            if (!ht2.containsKey(s)) ht2.put(s, new ArrayList<>());
            ht2.get(s).add(new NumberCharacterPair(s, count));
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
            ArrayList<NumberCharacterPair> valid1 = new ArrayList<>();
            ArrayList<NumberCharacterPair> valid2 = new ArrayList<>();
            for (int k = 0; k<allowed.size(); k++){
                if (ht1.containsKey(allowed.get(k))) valid1.addAll(ht1.get(allowed.get(k)));
                if (ht2.containsKey(allowed.get(k))) valid2.addAll(ht2.get(allowed.get(k)));
            }
            Collections.sort(valid1, new Comparator<NumberCharacterPair>() {
                        public int compare(NumberCharacterPair o1, NumberCharacterPair o2) {
                            return o1.i - o2.i;
                        }
            });
            Collections.sort(valid2, new Comparator<NumberCharacterPair>() {
                public int compare(NumberCharacterPair o1, NumberCharacterPair o2) {
                    return o1.i - o2.i;
                }
            });

            StringBuilder new1 = new StringBuilder();
            for (int k = 0; k<valid1.size(); k++){
                new1.append(valid1.get(k).c);
            }
            StringBuilder new2 = new StringBuilder();
            for (int k = 0; k<valid2.size(); k++){
                new2.append(valid2.get(k).c);
            }
            if (new1.toString().equals(new2.toString())){
                System.out.print("Y");
            }else{
                System.out.print("N");
            }
        }


    }
}
