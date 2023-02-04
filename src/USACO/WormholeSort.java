//import java.io.*; import java.util.*;
//
//public class WormholeSort {
//    static void insertionSortRecursive(Vector<Integer> V,int N)
//    {
//        if (N <= 1)
//            return;
//
//        // General Case
//        // Sort V till second last element and
//        // then insert last element into V
//        insertionSortRecursive(V, N - 1);
//
//
//        // Insertion step
//        int j = N - 1;
//
//        // Insert V[i] into list 0..i-1
//        while (j > 0 && V.get(j) < V.get(j - 1))
//        {
//
//            // Swap V[j] and V[j-1]
//            int temp= V.get(j);
//            V.set(j, V.get(j - 1));
//            V.set(j - 1, temp);
//
//            // Decrement j by 1
//            j -= 1;
//        }
//
//    }
//
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(System.out);
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//        st = new StringTokenizer(br.readLine());
//
//        int[] cows = new int[N];
//        for (int i = 0; i<N; i++){
//            int x = Integer.parseInt(st.nextToken());
//            cows[i] = x;
//        }
//
//        for (int i = 0; i<M; i++){
//            st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
//            int w = Integer.parseInt(st.nextToken());
//
//        }
//
//        //find all possible ways to sort cows via swapping
//
//        //int sorted_cows = Arrays.sort(cows);
//        ArrayList<ArrayList<ArrayList<Integer>>> instructions = new ArrayList<>();
//        // inner layer = the pair of points that need to be swapped
//        // middle layer = the pair of points that need to be swapped
//        // outer layer = the ways we can do this
//
//        //find one way to swap and find all possible ways to reorder
//
//
//        //try insertion sort
//        if (N <= 1)
//            return;
//
//        // General Case
//        // Sort V till second last element and
//        // then insert last element into V
//        insertionSortRecursive(A,A.size());
//
////        String a = "print('hello world')";
////        for (int i = 0; )
//
//
//
//    }
//}
