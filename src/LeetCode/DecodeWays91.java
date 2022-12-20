package LeetCode;

import java.util.*;

public class DecodeWays91 {
    public static int recursive(String s, HashMap<String, Integer> cache){
        int N = s.length();
        if (N == 0) return 1;
        int answer = 0;
        // Two Cases
        if (!s.substring(0, 1).equals( "0")){
            if (cache.containsKey(s.substring(1))){
                answer += cache.get(s.substring(1));
            }
            else {
                int value = recursive(s.substring(1), cache);
                cache.put(s.substring(1), value);
                answer += value;
            }
        }
        if (N > 1 && Integer.parseInt(s.substring(0, 2)) >= 10 &&
                Integer.parseInt(s.substring(0, 2)) <= 26){
            if (cache.containsKey(s.substring(2))){
                answer += cache.get(s.substring(2));
            }
            else {
                int value = recursive(s.substring(2), cache);
                cache.put(s.substring(2), value);
                answer += value;
            }
        }
        return answer;
    }

    public static int iterative(String s, HashMap<String, Integer> cache){
        int N = s.length();
        if (N == 0 || s.charAt(0) == '0') return 0;
        int[] dp = new int[N+1];
        dp[0] = 1;
        dp[1]= 1;
        for (int i = 2; i<=N; i++){
            if (s.charAt(i-1) != '0'){
                dp[i] += dp[i-1];
            }
            if (Integer.parseInt(s.substring(i-2, i)) >= 10 &&
                            Integer.parseInt(s.substring(i-2, i)) <= 26){
                        dp[i] += dp[i-2];
                    }
            }
        return dp[N];

    }
    public static void main(String[] args){
        String s = "12";
        HashMap<String, Integer> cache = new HashMap<>();
//        System.out.println(recursive(s, cache));
        System.out.println(iterative(s, cache));
    }
}
