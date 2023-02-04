import java.io.*;
import java.util.*;

class ClimbingCow{
    int up;
    int down;
    int id;
    public ClimbingCow(int up, int down, int id){
        this.up = up;
        this.down = down;
        this.id = id;
    }
}
public class MountainClimbing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<ClimbingCow> cows = new ArrayList<>();
        for (int i = 0; i<N; i++){
            String[] temp = br.readLine().split(" ", 2);
            cows.add(new ClimbingCow(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), i));
        }
        Collections.sort(cows, new Comparator<ClimbingCow>() {
            @Override
            public int compare(ClimbingCow o1, ClimbingCow o2) {
                if (o1.up == o2.up){
                    return o1.down - o2.down;
                }
                return o1.up - o2.up;
            }
        });
        int time = 0;
        int cows_gone = 0;
        int discount_from_up = 0;
        while (cows_gone <= N){
            if (cows_gone == 0){
                time += cows.get(0).up;
                cows_gone++;
            }
            else if (cows_gone == N){
                time += cows.get(N-1).down;
                cows_gone++;
            }
            else{
                if (cows.get(cows_gone).up < cows.get(cows_gone-1).down){
                    time += cows.get(cows_gone-1).down;
                    // give the next person going up a headstart if the previous person is too slow going down
                    if (cows.get(cows_gone-1).down > cows.get(cows_gone).up){
                        discount_from_up = cows.get(cows_gone-1).down - cows.get(cows_gone).up;
                    }
                    cows_gone++;
                }
                else{
                    //time += cows.get(cows_gone).up;
                    time += (cows.get(cows_gone).up - discount_from_up);
                    discount_from_up = 0;
                    cows_gone++;
                }
            }
        }
        System.out.println(time);
    }
}
