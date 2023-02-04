import java.io.*; import java.util.*;
public class SubsetEquality2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int N = Integer.parseInt(br.readLine());
        Hashtable<Character, Integer> count1 = new Hashtable<>();
        Hashtable<Character, Integer> count2 = new Hashtable<>();
        for (char s : s1.toCharArray()){
            if (!count1.containsKey(s)) count1.put(s, 1);
            else count1.put(s, count1.get(s)+1);

        }
        char[] letters = {
                'a', 'b', 'c', 'd', 'e', 'f', 'g',
                'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r'
        };
        for (char s : s2.toCharArray()){
            if (!count2.containsKey(s)) count2.put(s, 1);
            else count2.put(s, count2.get(s)+1);

        }

        for (int i = 0; i<N; i++){
            String t = br.readLine();
            int counts1 = 0;
            int counts2 = 0;
            for (char s : t.toCharArray()){
                if (count1.containsKey(s)){
                    counts1+= count1.get(s);
                }
                if (count2.containsKey(s)){
                    counts2+= count2.get(s);
                }
            }
            if (counts1 != counts2){
                System.out.print("N"); continue;
            }
            boolean broken = false;
            for (char char1 : letters ){
                for (char char2 : letters){
//                    if (char1 >= char2) continue;
//                    int var1  = 0;
//                    int var2 = 0;
//                    if (count1.containsKey(char1)){
//                        var1+= count1.get(char1);
//                    }
//                    if (count2.containsKey(char1)){
//                        var2+= count2.get(char1);
//                    }
//                    if (count1.containsKey(char2)){
//                        var1+= count1.get(char2);
//                    }
//                    if (count2.containsKey(char2)){
//                        var2+= count2.get(char2);
//                    }
//                    if (var1 != var2) broken = true;


                }
            }
            if (broken) {
                System.out.print("N");
            }else {
                System.out.print("Y");
            }
        }

    }
}
