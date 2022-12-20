package LeetCode;
import java.util.*;

public class WordBreakII140 {
    public static List<String> recursive(String s, List<String> wordDict, HashMap<String, Integer> cache){
        int N = s.length();
        List<String> answer = new ArrayList<>();
        if (N == 0) return new ArrayList<>();
        for (String word: wordDict){
//            if (s.startsWith(word){
//                answer.add(word);
//            }
        }
        return answer;
    }
    public static void main(String[] args){
        String s = "catsanddog";
        List<String> wordDict = new ArrayList<>();
        wordDict.addAll(List.of("cat", "cats", "and", "sand", "dog"));
        HashMap<String, Integer> cache = new HashMap<>();
        System.out.println(recursive(s, wordDict, cache));
    }
}
