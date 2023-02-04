import java.io.*;
import java.util.*;

class RunnerPosition{
    int laps_finished;
    int position;
    public RunnerPosition(int laps_finished, int position){
        this.laps_finished = laps_finished;
        this.position = position;
    }
}
public class RunningLaps {
    public static void main(String[] args) throws IOException{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(in.readLine());
            int cows = Integer.parseInt(st.nextToken());
            int laps = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            int[] speeds = new int[cows];
            st = new StringTokenizer(in.readLine());
            int slowest = Integer.MAX_VALUE;
            int largest = 0;
            RunnerPosition[] positions = new RunnerPosition[cows];
            for (int i = 0; i<laps; i++){
               speeds[i] = Integer.parseInt(st.nextToken());
                if (speeds[i] < slowest){
                     slowest = speeds[i];
                }
                if (speeds[i] > largest){
                    largest = speeds[i];
                }
                positions[i] = new RunnerPosition(0, i);
            }
            int end = length * laps / slowest;
            for (int i = 0; i<end; i+=slowest){
                for (int j = 0; j<cows; j++){
                    positions[j].laps_finished += speeds[j];
                }
                Arrays.sort(positions, new Comparator<RunnerPosition>() {
                    @Override
                    public int compare(RunnerPosition r1, RunnerPosition r2) {
                        return r1.laps_finished - r2.laps_finished;
                    }
                });
                int crossing = 0; // a crossing is when a cow passes another cow
                for (int j = 0; j<cows; j++){
                    positions[j].position+=speeds[j];
                    if (positions[j].position > length){
                        positions[j].position -= length;
                        positions[j].laps_finished += length;
                    }

                    

                }
            }

    }
}