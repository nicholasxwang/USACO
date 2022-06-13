import java.io.*;
import java.util.*;

public class MyCowAteMyHomework {
    public static int operation(ArrayList<Integer> a){
        int m;
        int i;
        int s;
        int x;
        m = a.get(0);
        x = a.size();
        if (x == 1){
            //return 0;
            return -1;
        }
        s = 0;
        for (i = 0; i<x; i++){
            if (a.get(i) < m){
                m = a.get(i);
            }
            s += a.get(i);
        }

        //forgot to subtract min

        s-=m;

        //s /= (x-=1);
        s /= (x-1);
        return s;

    }
    public static void main(String[] args) throws IOException {
        int N;
        int i;
        //BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader b = new BufferedReader(new FileReader("./homework.in"));
        N = Integer.parseInt(b.readLine());
        String[] n = b.readLine().split(" ", N);
        int[] q = new int[N];
        for (i = 0; i<N; i++){
            q[i] = Integer.parseInt(n[i]);
        }
        ArrayList<Integer>  a = new ArrayList<>();
        int p;
        p = -1;

        //no support for multiple wins
        int w = -1; //current win number
        ArrayList<Integer> ans = new ArrayList<>();
        for (i = N-1; i>=0; i--){
            a.add(q[i]);
            int s = operation(a);
            if (s<p){
                //missing previous
                //p = s;
                System.out.println(p);
                System.out.println("Loser: Our new "+s+" is smaller than our previous "+p);
                System.out.println(a);
                System.out.println(i);
                System.out.println(i+1);
                p = s;

//                PrintWriter printWriter = new PrintWriter ("homework.out");
//                printWriter.println(i+1);
//                printWriter.close (); //No longer valid, for multipple winners
                //break;
            }else{
                if (w == -1){
                    w = s;
                    //missing purge here
                    ans.clear();
                    ans.add(i);
                }
                // if (w == s){
                else if (w == s){
                    ans.add(i);
                }
                //if (s > w){
                else if (s > w){
                    ans.clear();
                    w = s;
                    ans.add(i);
                }
                System.out.println("Winner: Our new "+s+" is bigger than/equal than our previous "+p);
                System.out.println(a);
                System.out.println(i);
                System.out.println("Our winner array is now "+ans);
                p = s;
            }
        }
        PrintWriter printWriter = new PrintWriter ("homework.out");
        N = ans.size();
        for (i = 0; i<N; i++){
            printWriter.println(ans.get(N-i-1));
        }
        printWriter.close ();
    }
}
