import java.util.*;
import java.io.*;

public class LargeBrownCow {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//3 7
//Farmer John has no large brown noisy cow.
//Farmer John has no small white silent cow.
//Farmer John has no large spotted noisy cow.
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        ArrayList<HashSet<String>> words = new ArrayList<>();
        ArrayList<String> illegal = new ArrayList<>();
        for (int i = 0; i<N; i++){
            String s_ = br.readLine();
            s = s_.split(" ");
            illegal.add((s_+" "));
            HashSet<String> new_ = new HashSet<>();
            for (int j = 3; j<s.length-1; j++){
                new_.add(s[j]);
            }
            words.add(new_);
            // remove first 4 words, last word
        }
        ArrayList<String> adjective = new ArrayList<>();
        for (int i = 0; i<words.size(); i++){
            if (adjective.size() == K+1){
                System.out.println(adjective.get(K));
            }
            String string = "";
            for (String word: words.get(i)){
                string += word;
                string += " ";
            }
            boolean is_illegal = false;
            for (int j = 0; j<illegal.size(); j++){
                if (illegal.contains(string)){
                    is_illegal = true;
                    break;
                }
            }
            if (!is_illegal){
                adjective.add(string);
            }
        }

    }
}
