import java.io.*;
import java.util.*;

public class CowIDs {
    public static int factorial(int N, HashMap<Integer, Integer> cache){
        if (N==0){
            return 1;
        }
        if (cache.containsKey(N)){
            return cache.get(N);
        }
        int ans = N*factorial(N-1, cache);
        cache.put(N, ans);
        return ans;
    }
    public static int choose(int a, int b, HashMap<Integer, Integer> cache){
        int ans = factorial(a, cache)/(factorial(b, cache)*factorial(a-b, cache));
        return ans;
    }
    public static int calculate(int L, int K, int N){
        // 111
        // 1011, 1101, 1110
        // 10011, 10101, 10110, 11001, 11010, 11100
        // return the Nth number in a list of all numbers with L digits and K 1s
        //for (int  )
        return 1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> factorial_cache = new HashMap<Integer, Integer>();

        int length = K;
        while (true){
            int next_tier = choose(length-1, length - K, factorial_cache);
            if (next_tier>N){
                break;
            }
            length++;
            N -= next_tier;
        }
        System.out.println("Length is " + length+" and N is " + N);
        System.out.println(calculate(length, K, N));
    }
}

