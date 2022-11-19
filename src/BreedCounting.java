import java.io.*;

class CowCount{
    int one;
    int two;
    int three;
    public CowCount(int one, int two, int three){
        this.one = one;
        this.two = two;
        this.three = three;
    }
    public CowCount add(int one, int two, int three){
        return new CowCount(this.one+one, this.two+two, this.three+three);
    }

}
public class BreedCounting {
    /*
    Keep track of all 3 prefix sums at once with CowCount
    Use standard Prefix Sum algorithm but for 3 things at once
    */
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("bcount.in"));
        PrintWriter pw = new PrintWriter("bcount.out");
        String[] t =  br.readLine().split(" ", 2);
        int N = Integer.parseInt(t[0]);
        int Q = Integer.parseInt(t[1]);
        int[] cows = new int[N];
        CowCount[] cow_count = new CowCount[N];
        for (int i = 0; i<N; i++){ cows[i] = Integer.parseInt(br.readLine());  }
        CowCount temp_cow;
        for (int i = 0; i<N; i++){
            if (i == 0){
                if (cows[0] == 1) {
                    temp_cow = new CowCount(1, 0, 0);
                    cow_count[i] = temp_cow;
                }
                if (cows[0] == 2){
                    temp_cow = new CowCount(0, 1, 0);
                    cow_count[i] = temp_cow;
                }
                if (cows[0] == 3){
                    temp_cow = new CowCount(0, 0, 1);
                    cow_count[i] = temp_cow;
                }
            }else{
                if (cows[i] == 1) {
                    temp_cow = cow_count[i - 1].add(1, 0, 0);
                    cow_count[i] = temp_cow;
                }
                if (cows[i] == 2){
                    temp_cow = cow_count[i-1].add(0, 1, 0);
                    cow_count[i] = temp_cow;
                }
                if (cows[i] == 3) {
                    temp_cow = cow_count[i - 1].add(0, 0, 1);
                    cow_count[i] = temp_cow;
                }
            }
        }
        for (int i = 0; i<Q; i++){
            t = br.readLine().split(" ", 2);
            int ones;
            int twos;
            int threes;
            CowCount cow_one;
            try{
                cow_one = cow_count[Integer.parseInt(t[0])-2];}
            catch(Exception e){
                cow_one = new CowCount(0, 0, 0);
            }
            CowCount cow_two = cow_count[Integer.parseInt(t[1])-1];
            ones = cow_two.one - cow_one.one;
            twos = cow_two.two - cow_one.two;
            threes = cow_two.three - cow_one.three;
            pw.println(ones+" "+twos+" "+threes);
        }
        pw.close();

    }
}
