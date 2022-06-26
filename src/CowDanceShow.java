//import java.io.*;
//import java.util.*;
//
//public class CowDanceShow {
//    public static int calculate(int[] cows_, int K){
//        List<Integer> cows = new ArrayList<Integer>();
//        Collections.addAll(cows, cows_);
//        if (cows.size() < K){
//            return -1;
//        }
//        int[] c = new int[K];
//        for (int i = 0; i<K; i++){
//            c[i] = cows.get(i);
//        }
//        int upto = K;
//        //simulation
//        while (true){
//
//        }
//
//    }
//    public static void main(String[] args) throws IOException{
//        BufferedReader b = new BufferedReader(new FileReader("./reduce.in"));
//        String[] t = b.readLine().split(" ");
//        int N = Integer.parseInt(t[0]);
//        int T = Integer.parseInt(t[1]);
//        int[] a = new int[N];
//        for (int i = 0; i<N; i++){
//            a[i]= Integer.parseInt(b.readLine());
//        }
//        for (int i = 0; i<T; i++){
//            System.out.println(calculate(a, i));
//        }
//
//    }
//
//}
