import java.io.*;
import java.util.*;

public class CircularBarn2022 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i<Q; i++){
            int  N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (N > 1){
                int[] numbers = new int[N+1];
                for (int j = 0; j<N; j++){
                    numbers[j] = Integer.parseInt(st.nextToken()) % 4;
                }
                numbers[N] = numbers[0];
                boolean john_going = true;
                for (int j = 0; j<=N; j++){
                    boolean first_person_going_wins = numbers[j] % 4 != 0;
                    if (!first_person_going_wins){
                        john_going = !john_going;
                    }
                }
                System.out.println(john_going ? "Farmer John" : "Farmer Nhoj");
            }else{
                int number = Integer.parseInt(st.nextToken());
                System.out.println(number % 4 != 0 ? "Farmer John" : "Farmer Nhoj");
            }

        }
    }

}
