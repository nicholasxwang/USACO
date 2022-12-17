import java.io.*;
import java.util.*;

public class SubsetEquality3 {
    static boolean contains(List<?> list, List<?> sublist) {
        return Collections.indexOfSubList(list, sublist) != -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split("");
        String[] t = br.readLine().split("");
        int Q = Integer.parseInt(br.readLine());
        boolean[] results = new boolean[Q];
        ArrayList<ArrayList<String>> queries = new ArrayList<>(Q);
        HashSet<String> LetterSet = new HashSet<>();
        for (int i = 0; i<Q; i++){
            queries.add(new ArrayList<>());
            String[] str = br.readLine().split("");
            for (int j = 0; j<str.length; j++){
                queries.get(i).add(str[j]);
                LetterSet.add(s[j]);
            }
        }
        HashMap<String, Integer> LetterMap = new HashMap<>();
        HashMap<String, Integer> LetterMap2 = new HashMap<>();
        for (int i = 0; i<s.length; i++){
            if (LetterMap.containsKey(s[i])){
                LetterMap.put(s[i], LetterMap.get(s[i])+1);
            }
            else {
                LetterMap.put(s[i], 1);
            }
        }
        for (int i = 0; i<t.length; i++){
            if (LetterMap2.containsKey(t[i])){
                LetterMap2.put(t[i], LetterMap2.get(t[i])+1);
            }
            else {
                LetterMap2.put(t[i], 1);
            }
        }
        for (int i = 0; i<Q; i++){
            ArrayList<String> current = queries.get(i);
            //System.out.println("-----------\nStarting a New Quest: "+current);
            //System.out.println("[Level 1: Simple Check]");
            // If the counts of each letter doesn't match, terminate!!!
            boolean terminate = false;
            for (int j = 0; j<queries.get(i).size(); j++){
                String letter = queries.get(i).get(j);
                if (LetterMap2.get(letter) != LetterMap.get(letter)) {
                    terminate = true;
                    break;
                }
            }
            if (terminate) continue;

            // if it doesn't terminate, compare the two
            //System.out.println("[Level 2: Intense Matching]");
            ArrayList<String> sub1 = new ArrayList<>();
            ArrayList<String> sub2 = new ArrayList<>();
            for (int j = 0; j<Math.max(s.length, t.length); j++){
                if (sub1.size() > 0 && sub2.size() > 0){
                    if (!contains(sub1, sub2)){
                        terminate = true;
                        break;
                    }
                }
                if (j < s.length && current.contains(s[j])){
                    sub1.add(s[j]);
                }
                if (j < t.length && current.contains(t[j])){
                    sub2.add(t[j]);
                }
                //System.out.println("[Currently] "+sub1+" | "+sub2);
            }
            if (terminate) continue;
            results[i] = true;
        }
        for (int i = 0; i<results.length; i++){
            if (results[i]) System.out.print("Y");
            else System.out.print("N");
        }

    }
}
