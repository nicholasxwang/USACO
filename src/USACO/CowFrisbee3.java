import java.util.*;

public class CowFrisbee3 {
    public static void main(String[] args){
        int[] cows = {4, 3, 1, 2 , 5, 6 ,7};
        int[] nextGreatest = new int[cows.length];
        int[] nextSmallest= new int[cows.length];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i<cows.length; i++){
            nextGreatest[i] = -1;
            nextSmallest[i] = -1;
        }
        for (int i = 0; i<cows.length; i++){
            if (stack.isEmpty() || stack.peek() > cows[i]){
                stack.push(i);
            }
            else{
                //int give_back = i-1;
                while (!stack.isEmpty() && cows[stack.peek()] < cows[i]){
                    nextGreatest[stack.peek()] = i;
                    stack.pop();
                }
                stack.push(i);
            }
            if (stack2.isEmpty() || stack2.peek() < cows[i]){
                stack2.push(i);
            }
            else{
                //int give_back = i-1;
                while (!stack2.isEmpty() && cows[stack2.peek()] > cows[i]){
                    nextSmallest[stack2.peek()] = i;
                    stack2.pop();
                }
                stack2.push(i);
            }
        }

        int distance = 0;
//        for (int i = 0; i<cows.length; i++){
//            if (i < cows.length-1) {
//                System.out.println("(" + (i + 1) + ", " + (i + 2) + ")");
//                System.out.println("Distance added: 2");
//                distance += 2;
//            }
//            if (nextGreatest[i] != i+1 && nextGreatest[i] != -1) {
//                System.out.println("("+(i+1)+", "+(nextGreatest[i]+1)+")");
//                distance += nextGreatest[i] - i + 2;
//                System.out.println("Distance added: " + (nextGreatest[i] - i + 2));
//            }
//        }

//        HashSet<Integer> answers = new HashSet<>();
//        for (int i = 0; i<cows.length; i++){
//            int tall = nextGreatest[i];
//            for (int j = i; j<tall; j++){
////                System.out.println("("+(i+1)+", "+(j+1)+")");
//                System.out.println("("+(j+1)+", "+(tall+1)+")");
//                answers.add(cows.length * (tall+1) + j+1);
//            }
//        }
//        System.out.println(answers);
//        for (int c : answers){
//            int a = c/cows.length;
//            int b = c%cows.length;
//            distance += a-b+1;
//        }

        for (int i = 0; i<cows.length; i++){
            if (i < cows.length-1) {
                System.out.println("(" + (i + 1) + ", " + (i + 2) + ")");
                System.out.println("Distance added: 2");
                distance += 2;
            }
            if (nextGreatest[i] != i+1 && nextGreatest[i] != -1) {
                System.out.println("("+(i+1)+", "+(nextGreatest[i]+1)+")");
                distance += nextGreatest[i] - i + 1;
                System.out.println("Distance added: " + (nextGreatest[i] - i + 1));
            }
        }
        System.out.println("--");
        for (int i = 0; i<cows.length; i++){
            if (nextSmallest[i] != i+1 && nextSmallest[i] != -1) {
                System.out.println("("+(nextSmallest[i]+1)+", "+(i+1)+")");
                distance += i - nextSmallest[i] + 1;
                System.out.println("Distance added: " + (nextSmallest[i] - i + 1));
            }
        }



        System.out.println("nextGreatest = " + java.util.Arrays.toString(nextGreatest));
        System.out.println("nextSmallest = " + java.util.Arrays.toString(nextSmallest));
        System.out.println(distance);

    }
}
