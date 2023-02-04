import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class citystate {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("citystate.in"));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i<N; i++){
            String[] s = br.readLine().split(" ");
            hm.put(s[0].substring(0, 2)+s[1], 1);
        }
        //System.out.println(a);
//
//        MIAMI FL
//        DALLAS TX
//        FLINT MI
//        CLEMSON SC
//        BOSTON MA
//        ORLANDO FL
//        int count = 0;
//        for (int i = 0; i<a.size(); i++){
//            for (int j = i; j<a.size(); j++){
//                if (a.get(i).get(0).equals(a.get(j).get(1)) && a.get(i).get(1).equals(a.get(j).get(0)))
//                    count++;
//                System.out.println(a.get(i).get(0)+"-"+a.get(j).get(1));
//                System.out.println(a.get(i).get(1)+"-"+a.get(j).get(0));
//            }
//        }
//        System.out.println(count);
//        PrintWriter pr = new PrintWriter("citystate.out");
//        pr.println(count);
//        pr.close();
    }
}
