import java.util.*;
public class SleepyCowHerding {
    public static boolean find_consecutive(int a, int b, int c){
        int[] arr = new int[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        Arrays.sort(arr);
        if (arr[1]-arr[0] != 1) return false;
        if (arr[2]- arr[1] != 1) return false;
        return true;

    }
    public static void main(String[] args){
        ArrayList<Integer> herding = new ArrayList<>(4, 7, 9);
        //find missing number...
        while (true){
            if ()
        }


    }
}

