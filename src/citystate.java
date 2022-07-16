import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class citystate {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<String>> a = new ArrayList<>();
        for (int i = 0; i<N; i++){
            String[] s = br.readLine().split(" ");
            ArrayList<String> b = new ArrayList<>();
            b.add(s[0].substring(0, 2));
            b.add(s[1]);
            a.add(b);
        }
        System.out.println(a);
//
//        MIAMI FL
//        DALLAS TX
//        FLINT MI
//        CLEMSON SC
//        BOSTON MA
//        ORLANDO FL
        int count = 0;
        for (int i = 0; i<a.size(); i++){
            for (int j = i; j<a.size(); j++){
                if (a.get(i).get(0).equals(a.get(j).get(1)))
                    count++;
                if (a.get(i).get(1).equals(a.get(j).get(0)))
                    count++;
                System.out.println(a.get(i).get(0)+"-"+a.get(j).get(1));
                System.out.println(a.get(i).get(1)+"-"+a.get(j).get(0));
            }
        }
        System.out.println(count);
    }
}
