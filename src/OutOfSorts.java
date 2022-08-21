public class OutOfSorts {
    public static void main(String[] args){
        boolean sorted = false;
        int count = 0;
        int[] A = {3, 2, 1};
        int N = A.length;
        while (!sorted){
            sorted = true;
            count++;
            for (int i = 0; i<N-1; i++){
                if (A[i+1] < A[i]){
                    //swap
                    int one = A[i];
                    int two = A[i+1];
                    A[i] = two;
                    A[i+1] = one;
                    sorted = false;
                }
            }

        }
        System.out.println(count);

    }
}
