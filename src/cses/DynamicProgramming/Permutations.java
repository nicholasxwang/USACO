//package cses.DynamicProgramming;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Permutations {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int current = 1;
        if (N % 2 == 1) System.out.print(N + " ");
        while (current <= (int) N / 2) {
            System.out.print(current);
            System.out.print(" ");
            System.out.print(current + 2);
            if (current < (int) N/2) System.out.print(" ");
            current++;
        }
        // 1 3 2 4
    }
}
