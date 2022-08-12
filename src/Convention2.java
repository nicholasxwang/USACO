import java.io.*; import java.util.*;
class GrassEatingCows{
    int priority;
    int time_taken;
    int arrival;
    public GrassEatingCows(int priority, int arrival, int time_taken){
        this.priority = priority;
        this.time_taken = time_taken;
        this.arrival = arrival;
    }
    // custom print
    public String toString(){
        return "priority: " + priority + " time_taken: " + time_taken + " arrival: " + arrival;
    }
}
public class Convention2{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("convention2.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("convention2.out"));
        int N = Integer.parseInt(br.readLine());
        int[][] cows = new int[N][2];
        PriorityQueue<GrassEatingCows> pq = new PriorityQueue<GrassEatingCows>(new Comparator<GrassEatingCows>() {
            public int compare(GrassEatingCows g1, GrassEatingCows g2) {
                if (g1.priority == g2.priority) return g1.arrival - g2.arrival;
                return g1.priority - g2.priority;
            }
        });

        for (int i = 0; i<N; i++){
            String[] s = br.readLine().split(" ");
            cows[i][0] = Integer.parseInt(s[0]);
            cows[i][1] = Integer.parseInt(s[1]);
            GrassEatingCows cow = new GrassEatingCows(i, cows[i][0], cows[i][1]);
            pq.add(cow);
        }
        System.out.println(pq);
        int delayed = 0;


        pw.println(delayed);
        pw.close();



    }
}
