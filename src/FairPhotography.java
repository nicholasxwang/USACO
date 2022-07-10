import java.io.*;
import java.util.*;
class Cow implements Comparable<Cow>{
    int index;
    char type;
    public Cow(int index_, char type_){
        this.index = index_;
        this.type = type_;

    }
    @Override
    public int compareTo(Cow c)
    {
        return this.index - c.index;
    }

}
public class FairPhotography {
    public static void main(String[] args) throws IOException{
        //Initialized Variables
        String s;
        String[] parsed;
        Cow cow;
        int N;
        int i;
        Cow[] c;
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("fairphoto.in"));



        //Read Input
        N = Integer.parseInt(br.readLine());
        c = new Cow[N];
        for (i = 0; i<N; i++){
            s = br.readLine();
            parsed = s.split(" ");
            cow = new Cow(Integer.parseInt(parsed[0]), parsed[1].toCharArray()[0]);
            c[i] = cow;
        }



        //Sort
        Arrays.sort(c);



        //Apply 2 pointers algo
        //If middle is spotted: DEAD
        //If middle is white, change to spotted

        int l = 0;
        int r = 0;
        char prev_cow = '-';
        char last_cow = '-';
        int MAX = 0;
        while (l<N && r<N){
            last_cow = c[r].type;
            if (prev_cow!='-' && last_cow!=prev_cow){
                if (last_cow == 'W'){
                    last_cow = 'S';
                }
            }else{
                if (last_cow == 'S'){
                    //change
                    l = r;
                }
            }
            prev_cow = last_cow;
            System.out.println(c[l].index+" --> "+c[r].index);
            if (c[r].index-c[l].index > MAX){
                MAX = c[r].index-c[l].index;
            }
            r++;

        }




        //Return BEST
        PrintWriter pw = new PrintWriter("fairphoto.out");
        if (MAX == 0){
            MAX = 1;
        }
        pw.println(MAX);
        pw.close();

    }
}
