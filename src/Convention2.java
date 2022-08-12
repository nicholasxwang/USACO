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
        PriorityQueue<GrassEatingCows> pq = new PriorityQueue<GrassEatingCows>(new Comparator<GrassEatingCows>() {
            public int compare(GrassEatingCows g1, GrassEatingCows g2) {
                if (g1.priority == g2.priority) return g1.arrival - g2.arrival;
                return g1.priority - g2.priority;
            }
        });
        int[][] rawcows = new int[N][2];
        GrassEatingCows[] cows = new GrassEatingCows[N];
        for (int i = 0; i<N; i++){
            String[] s = br.readLine().split(" ");
            rawcows[i][0] = Integer.parseInt(s[0]);
            rawcows[i][1] = Integer.parseInt(s[1]);
            GrassEatingCows cow = new GrassEatingCows(i, rawcows[i][0], rawcows[i][1]);
            cows[i] = cow;
        }
        int time = 0;
        int first_arrival = 0;
        int delayed = 0;
        for (int i = 0; i<N; i++){
            if (cows[i].arrival < cows[first_arrival].arrival && cows[i].priority > cows[first_arrival].priority) first_arrival =  i;
        }
        pq.add(cows[first_arrival]);
        ArrayList<Integer> processed = new ArrayList<Integer>();
        processed.add(first_arrival);
        System.out.println(first_arrival+1);
        time = cows[first_arrival].arrival;
        while (!pq.isEmpty()){
            System.out.println("Time: "+time+"\n");
            GrassEatingCows cow = pq.poll();
            first_arrival = -1;
            for (int i = 0; i<N; i++){
                if (processed.contains(i)) continue;
                if (first_arrival == -1) first_arrival = i;
                if (cows[i].arrival > time) continue;
                if (time < cows[i].arrival && time < cows[first_arrival].arrival)
                    if (cows[i].arrival < cows[first_arrival].arrival) first_arrival = i;
                else if (cows[i].priority > cows[first_arrival].priority) first_arrival =  i;
            }
            if (first_arrival != -1) {
                pq.add(cows[first_arrival]);
                processed.add(first_arrival);
            }
            if (cow != null) {
                int time_waited = 0;
                if (cow.arrival < time)
                    time_waited = time - cow.arrival;
//                time = cow.arrival;
                if (time < cow.arrival) time = cow.arrival;
                time = time + cow.time_taken ;
                System.out.println("Time: "+time+"\n");
                System.out.println("Delayed: "+time_waited+"\n");
                System.out.println(first_arrival + 1);


                if (time_waited > delayed) {
                    delayed = time_waited;
                }
            }

        }
        System.out.println(pq);


        pw.println(delayed);
        pw.close();



    }
}
