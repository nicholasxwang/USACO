import java.io.*; import java.util.*;
public class SecretCowCode {
   public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
       StringTokenizer st = new StringTokenizer(br.readLine());
       char[] original = st.nextToken().toCharArray();
       int N = Integer.parseInt(st.nextToken());

       char[] array = new char[N];
       int index = original.length;
       for (int i = 0; i<original.length; i++){
           array[i] = original[i];
       }
        boolean break_twice = false;
       while (true){
           if (index == N-1 || break_twice){
               System.out.println(array[N-1]);
               break;
           }
           int stop = index-1;
           array[index] = array[index-1];
           index++;
           for (int i = 0; i<stop; i++){
               if (index == N-1){
                   System.out.println(array[N-1]);
                   break;
               }
               array[index] = array[i];
               index++;

           }

       }



   }

}
