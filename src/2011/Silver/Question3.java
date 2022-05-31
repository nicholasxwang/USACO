import java.util.ArrayList;

class Question3{
    public static void find_sum_of_squares(int number, int count){
        int sqrt = (int)Math.sqrt(number);
        int count = 0;
        ArrayList<Integer> squares =  new ArrayList<>();
        for (int i = 0; i<=sqrt; i++){
            count += i*i;
            squares.add(count);
        }
    }
    public static void find_dimensions(int N){
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i<=N; i++){
            if (N % i == 0){
                    
            }
        }
    }
    public static void main(String[] args){
        int number = 6;
        System.out.println(find_sum_of_squares(number));
    }
}