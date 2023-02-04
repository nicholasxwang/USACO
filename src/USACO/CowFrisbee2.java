//import java.util.ArrayList;
//import java.util.Stack;
//
//public class CowFrisbee2 {
//    public static void main(String[] args){
//        int[] words = {4, 3, 1, 2 , 5, 6 ,7};
//        ArrayList<Stack<Integer>> stacks = new ArrayList<>();
//        int largest_term = words[0];
//        for (int i = 1; i<words.length; i++){
//            if (words[i]>largest_term){
//                largest_term = words[i];
//            }
//        }
//        int pointer_1 = 0;
//        int pointer_2 = 1;
//        int biggest_middle = -1;
//        while (true){
//            if (biggest_middle >= largest_term){
//                pointer_1++;
//            }
//            if (pointer_2 - pointer_1 == 1){
//                System.out.println("(" + pointer_1 + ", " + pointer_2 + ")");
//                biggest_middle = words[pointer_2];
//                pointer_2++
//
//        }
//    }
//
//}
