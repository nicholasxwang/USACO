//import java.io.*;
//import java.util.*;
//public class dagraph {
//    static class Pair<K, V> {
//        public K a;
//        public V b;
//        public Pair(K a, V b) {
//            this.a = a;
//            this.b = b;
//        }
//        public K getKey() {
//            return a;
//        }
//        public V getValue() {
//            return b;
//        }
//    }
//    public static void main(String[] args) throws IOException{
//        // 5 5
//        //#####
//        //#...#
//        //#...D
//        //#C...
//        //##.##
//
//        BufferedReader br = new BufferedReader(new FileReader("./gravity.in"));
//        String[] s = br.readLine().split(" ");
//        int N = Integer.parseInt(s[0]);
//        int M = Integer.parseInt(s[1]);
//        char[][] grid = new char[N][M];
//        int C_x = 0;
//        int C_y = 0;
//        int D_x = -1;
//        int D_y = -1;
//        char[] char_s = new char[M];
//        for (int i = 0; i<N; i++){
//            char_s = br.readLine().toCharArray();
//
//            for (int j = 0; j<char_s.length; j++){
//                grid[i][j] = char_s[j];
//                if (grid[i][j] == 'C'){
//                    C_x = i;
//                    C_y = j;
//                }
//                if (grid[i][j] == 'D'){
//                    D_x = i;
//                    D_y = j;
//                }
//
//            }
//        }
//        ArrayList<ArrayList<Integer>> stable = new ArrayList<>();
//        for (int i = 1; i< grid.length-1; i++){
//            for (int j = 1; j<grid[i].length-1; j++){
//                if (grid[i][j-1] == '#' || grid[i][j+1] == '#'){
//                    ArrayList<Integer> ar = new ArrayList<>();
//                    ar.add(i);
//                    ar.add(j);
//                    stable.add(ar);
//                }
//            }
//        }
//        PrintWriter printWriter = new PrintWriter ("gravity.out");
//        printWriter.println(answer);
//        printWriter.close();
//
//
//
//
//
//
//
//
//
//
//
//
//    }
//
//}
//
//
//
