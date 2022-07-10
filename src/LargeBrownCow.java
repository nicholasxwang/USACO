import java.util.*;
import java.io.*;

public class LargeBrownCow {

    public static ArrayList<String> tag(int index, ArrayList<ArrayList<String>> a){
        ArrayList<Integer> nums = new ArrayList<>();
        int temp = 1;
        for (int i = 0; i<a.size(); i++){
            temp = a.get(i).size()*temp;
        }
        temp = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i<nums.size(); i++){
            int number = nums.get(nums.size() - i);
            ans.add(index - (index % number)/ number);
            index = index % number;
        }
        ArrayList<String> returned = new ArrayList<>();
        for (int i = 0; i<ans.size(); i++){
            returned.add(a.get(i).get(ans.get(i)));
        }
        return returned;


    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//3 7
//Farmer John has no large brown noisy cow.
//Farmer John has no small white silent cow.
//Farmer John has no large spotted noisy cow.
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);
        ArrayList<ArrayList<String>> words = new ArrayList<>();
        for (int i = 0; i<N; i++){
            s = br.readLine().split(" ");
            for (int j = 4; j<s.length-1; j++){
                if (i == 0){
                    ArrayList<String> new_ = new ArrayList<>();
                    new_.add(s[j]);
                    words.add(new_);
                    //System.out.println(new_);
                }else{
                    words.get(j-4).add(s[j]);
                    //System.out.println(words.get(j-4));
                }

            }
        }
        for (int i = 0; i<words.size(); i++){
            ArrayList<String> processed = new ArrayList<>();
            for (int j = 0; j<words.get(i).size(); j++){
                if (!processed.contains(words.get(i).get(j))){
                    processed.add(words.get(i).get(j));
                }
            }
            Collections.sort(processed);
            words.set(i, processed);
        }

        System.out.println(words);
    }
}
