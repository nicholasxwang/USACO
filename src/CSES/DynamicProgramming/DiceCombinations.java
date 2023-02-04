//package cses.DynamicProgramming;

import java.io.*;

public class DiceCombinations {
    public static long recursive(int N, long[] cache){
        if (N == 0) return 1;
        int answer = 0;
        for (int i = 6; i>0; i--){
            if (N >=i){
                if (cache[N-i] != 0){
                    answer += cache[N-i];
                }
                else {
                    long value = recursive(N-i, cache);
                    cache[N-i] = value;
                    answer += value;
                }
            }
        }
        return answer;
    }

    public static long iterative(int N, long[] cache){
        cache[0] = 1;
        for (int i = 1; i<=N; i++){
            for (int j = 1; j<=6; j++){
                if (i >= j){
                    cache[i] += cache[i-j];
                }
            }
        }
        return cache[N];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        long[] cache = new long[N+1];
//        int ans = recursive(N, cache);
        long  ans = iterative(N, cache);
//        System.out.println(ans);
//        System.out.println(ans % Math.pow(10, 9) + 7);
        long mod = (long) (Math.pow(10, 9) + 7);
        ans = (long) (ans % mod);
        System.out.println(ans);
    }
}
