import java.io.*; import java.util.*;

public class Teleportation {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("teleport.in"));
        PrintWriter pw = new PrintWriter("teleport.out");
        int N = Integer.parseInt(br.readLine());
        int[][] stuff  = new int[N][2];
        int smallest = 999999999;
        int biggest = -999999999;
        for (int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stuff[i][0] = x;
            stuff[i][1] = y;
            if (x < smallest) smallest = x;
            if (y < smallest) smallest = y;
            if (x > biggest) biggest = x;
            if (y > biggest)  biggest=y;
        }
        int smallest_dist = 999999;
        int smallest_dist_index = 0;
        for (int i = smallest; i<biggest+1; i++) {
            int dist = 0;
            for (int j = 0; j < N; j++) {
                int smaller = Math.min(stuff[j][0], stuff[j][1]);
                int larger = Math.max(stuff[j][0], stuff[j][1]);
                int dist1 = larger - smaller;
                int dist2 = (larger-i) + (smaller);
                int dist3 = (larger) + (smaller-i);
                dist += Math.min(Math.min(dist1, dist2), dist3);

            }
            System.out.println(i+" -> "+dist);
            if (i>0 && dist < smallest_dist){
                smallest_dist = dist;
                smallest_dist_index = i;
            }
        }
        //System.out.println(smallest_dist_index);
        pw.println(smallest_dist_index);
        pw.close();


    }
}
