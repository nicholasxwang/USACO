package CSES.IntroductoryProblems.IncreasingArray;//package cses.DynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

public class IncreasingArray {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());
        long ans = 0;
        long current = Integer.parseInt(st.nextToken());
        for (int i = 0; i<N-1; i++){
            long next = Integer.parseInt(st.nextToken());
            if (next < current){
                ans += (current-next);
                next = current;
            }
            //System.out.println(next);
            current = next;
        }
        System.out.println(ans);
    }
}
