import java.io.*; import java.util.*;

public class Convention {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("convention.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        ArrayList<Integer> cows = new ArrayList<>(N);
        st = new StringTokenizer(br.readLine());
        int low = 99999;
        int high = 0;
        for (int i = 0; i<N; i++){
            int value = Integer.parseInt(st.nextToken());
            if (value > high){
                high = value;
            }
            if (value < low){
                low = value;
            }
            cows.add(value);
        }
        high = high-low;
        low = 1;
        Collections.sort(cows);
        int mid = 0;
        int revolutions = 0;
        int max_wait_time = 0;
        while (low != high ){
            revolutions++;
            mid = (low + high) / 2;
            int bus_count = 0;
            int current_bus = 0;
            boolean full = false;
            max_wait_time = 0;
            for (int i = 0; i<N; i++){
                current_bus ++;
                if (current_bus >= C){
                    current_bus = current_bus - C;
                    bus_count++;
                    int bus_max_wait_time = cows.get(i) - cows.get(i-C+1);
                    if (bus_max_wait_time > max_wait_time){
                        max_wait_time = bus_max_wait_time;
                    }
                    if (bus_max_wait_time >  mid){
                        full = true;
                        if (i == N-1) full = false;
                        break;
                    }
                }
                if (bus_count >= M){
                    full = true;
                    max_wait_time = Integer.MAX_VALUE;
                    break;
                }
            }

            if (mid >= max_wait_time){
                full = true;
            }
            //System.out.println("low: " + low + " high: " + high + " mid: " + mid+" full: " + full+" " +max_wait_time);
            if (revolutions>30 || !full) //|| high <-1)
                break;

            //else if (!full) // x is on the right side
            else if (!full)
                low = mid + 1;

            else                  // x is on the left side
                high = mid - 1;
        }
        //System.out.println(max_wait_time);
        pw.println(max_wait_time);
        pw.close();

    }
}
