import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class FindAndReplace {
    public static int solve(String old, String into){
        HashMap<Character, Character> hm = new HashMap<>();
        int count = 0;
        boolean differences = false;
        for (int i = 0; i<old.length(); i++){
            char original = old.charAt(i);
            char wannabe = into.charAt(i);
            if (hm.containsKey(original)){
                if (hm.get(original) == wannabe) continue;
                return -1; // Conflicting Interests
            }else{
                if (original != wannabe) differences = true;
                hm.put(original, wannabe);
            }
        }
        if (!differences) return 0; //Nothing needs to be changed

        // count rotation groups (abcdaf -> cadbcf) a, b, c, d are the rotation pairs
        // it is always the sum of the number of rotation groups
        // the number of rotational groups are elements + 1; the 1 being the first substitution
        // HOWEVER, if they used all 52 letters; there is not substitution making it impossible\
        // finally add stray elements not part of rotation group (like AB --> CD would add 2)
        if (hm.size() == 52) return -1;
        HashMap<Character, Integer> groups = new HashMap<>();
        int number_of_groups = 0;
        ArrayList<ArrayList<Character>> clusters = new ArrayList<>();
        for (char c : hm.keySet()){
            if (c == hm.get(c)) continue;
            else{
                if (groups.containsKey(c)){
                    int var = groups.get(c);
                    if (!clusters.get(var).contains(hm.get(c)))  clusters.get(var).add(hm.get(c));
                }else if (groups.containsKey(hm.get(c))){
                    int var = groups.get(hm.get(c));
                    if (!clusters.get(var).contains(c)) clusters.get(var).add(c);
                }else{
                    number_of_groups++;
                    groups.put(c, clusters.size());
                    groups.put(hm.get(c), clusters.size());
                    clusters.add(new ArrayList<>());
                    clusters.get(clusters.size()-1).add(c);
                    clusters.get(clusters.size()-1).add(hm.get(c));
                }


            }
        }
        // validate clusters
        ArrayList<ArrayList<Character>> fake_clusters = new ArrayList<>();
        for (int i = 0; i<clusters.size(); i++){
            // one to one function; each input has one output
            ArrayList<Character> outputs = new ArrayList<>();
            for (int j = 0; j<clusters.get(i).size(); j++){
                outputs.add(hm.get(clusters.get(i).get(j)));
            }
            for (int j = 0; j<clusters.get(i).size(); j++){
                if (!outputs.contains(clusters.get(i).get(j))){
                    fake_clusters.add(clusters.get(i));
                    break;
                }
            }
        }
        for (int i = 0; i<fake_clusters.size(); i++){
            clusters.remove(fake_clusters.get(i));
            number_of_groups--;
        }
        groups = new HashMap<>();
        for (int i = 0; i<clusters.size(); i++){
            for (int j = 0; j<clusters.get(i).size(); j++){
                groups.put(clusters.get(i).get(j), i);
            }
        }

        // now lets tally them up
        count += number_of_groups; // the extra 1s
        for (char c : hm.keySet()){
            if (groups.containsKey(c)){
                count++;
            }else if (hm.get(c) != c){
                count++;
            }
        }
        return count;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i<N; i++){
            String old = br.readLine();
            String into = br.readLine();
            System.out.println(solve(old, into));
        }

    }
}
