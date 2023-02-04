package CSES.IntroductoryProblems.MissingNumber;//package cses.DynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

public class MissingNumber {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());
        boolean[] nums = new boolean[N+1];
        for (int i = 0; i<N-1; i++){
            nums[Integer.parseInt(st.nextToken())-1] = true;
        }
        for (int i = 0; i<N; i++){
            if (!nums[i]){
                System.out.println(i+1);
                break;
            }
        }
    }
}
