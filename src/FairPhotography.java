import java.io.*;
import java.util.*;
public class FairPhotography {
    public static void main(String[] args) throws IOException{
        //Initialized Variables
        String s;
        String[] parsed;
        
        BufferedReader br = new BufferedReader(new FileReader("fairphoto.in"));



        //Read Input
        int N = Integer.parseInt(br.readLine());

        Hashtable<Integer, String> h = new Hashtable<>();
        int[] a = new int[N];
        for (int i = 0; i<N; i++){
            s = br.readLine();
            parsed = s.split(" ");
            a[i] = Integer.parseInt(parsed[0]);
            h.put(Integer.parseInt(parsed[0]), parsed[1]);
        }
        int[] prefix = new int[N];
        Arrays.sort(a);
        for (int i = 0; i<N; i++){
            if (Objects.equals(h.get(a[i]), "W")){
                if (i == 0){
                    prefix[0] = 1;
                }else{
                    prefix[i] = prefix[i-1]+1;
                }
            }else{
                if (i == 0){
                    prefix[0] = -1;
                }else{
                    prefix[i] = prefix[i-1]-1;
                }
            }
        }

        ArrayList<Integer> final_ = new ArrayList<>();


        boolean still_bigger
        for (int i = 0; i<N; i++){

        }






        //Return BEST
        PrintWriter pw = new PrintWriter("fairphoto.out");

        pw.println(0);
        pw.close();

    }
}
