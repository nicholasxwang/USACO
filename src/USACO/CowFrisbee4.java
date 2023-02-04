public class CowFrisbee4 {
    public static void main(String[] args){
        int[] cows = {4, 3, 1, 2 , 5, 6 ,7};
        int[] cows_prev = new int[cows.length];
        int[] cows_next = new int[cows.length];
        for (int i = 0; i<cows.length; i++){
            cows_prev[i] = i-1;
            cows_next[i] = i+1;
        }

    }
}
