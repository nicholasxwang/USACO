//package cses.DynamicProgramming;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class Repetitions {

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split("");
        String current = s[0];
        int streak = 1;
        int best_streak = 1;
        for (int i = 1; i<s.length; i++){
            if (Objects.equals(s[i], current)){
                streak++;
            }else{
                if (streak > best_streak) best_streak = streak;
                streak = 1;
                current = s[i];
            }
        }
        if (streak > best_streak) best_streak = streak;
        System.out.println(best_streak);
    }
}
