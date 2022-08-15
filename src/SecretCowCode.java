import java.io.*; import java.util.*;
public class SecretCowCode {
   public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new FileReader("cowcode.in"));
       PrintWriter pw = new PrintWriter("cowcode.out");
       StringTokenizer st = new StringTokenizer(br.readLine());
       char[] original = st.nextToken().toCharArray();
       long N = Long.parseLong(st.nextToken());
       char[] array = new char[(int) N];
       int index = original.length;
       for (int i = 0; i<original.length; i++) array[i] = original[i];
       boolean break_twice = false;
       while (true){
           if (index == N || break_twice){
               pw.println(array[(int) (N-1)]);
               break;
           }
           int stop = index-1;
           //DONT make a copy of the array!


           array[index] = array[index-1];
           index++;
           for (int i = 0; i<stop; i++){
               if (index == N){
                   break_twice = true;
                   break;
               }
               array[index] = array[i];
               index++;

           }


       }
       pw.close();



   }

}
