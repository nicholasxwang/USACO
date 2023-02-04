//package cses.DynamicProgramming;

import java.io.*;
import java.util.ArrayList;

public class WeirdAlgorithm {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String ans = "";
        while (N!=1){
            ans+=N;
            ans+=" ";
            if (N % 2 == 1){
                N = N*3+1;
            }else{
                N = N/2;
            }
        }
        System.out.print(ans+"1");
    }
}
