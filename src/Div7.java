import java.io.*;
import java.util.ArrayList;

public class Div7 {
    public void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine()) % 7;
        }

        //ArrayList<Integer> cache=


    }
}
