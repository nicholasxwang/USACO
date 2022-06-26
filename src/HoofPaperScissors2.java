import java.io.*;
import java.util.Objects;

public class HoofPaperScissors2  {
    public static boolean checky(String o, String t){
        if (Objects.equals(o, "H")){
            if (Objects.equals(t, "P")){
                return false;
            }
            return Objects.equals(t, "S");
        }else if (Objects.equals(o, "P")){
            if (Objects.equals(t, "S")){
                return false;
            }
            return Objects.equals(t, "H");

        }else{
            if (Objects.equals(t, "H")){
                return false;
            }
            return Objects.equals(t, "P");

        }
    }
    public static int operate(String original, String app_1, String app_2, int changeIndex, int[] previous){
        int wins = 0;
        wins += previous[0];
        String debug = "";
        debug += ("["+original+"]  ["+app_1+"]  ["+app_2+"]  ["+changeIndex+"]  ");
        char[] original_ = original.toCharArray();
        String current_ = app_1;
        boolean updated_previous = false;
        for (int i = changeIndex; i<original_.length; i++){
            if (i == changeIndex){
                current_ = app_2;
            }
            if (checky(current_, String.valueOf(original_[i]))){
                if (!updated_previous){
                    updated_previous = true;
                    previous[0] = previous[0]+1;

                }

                wins+=1;
                debug+="W";
            } else{
                if (!updated_previous){
                    updated_previous = true;

                }
                debug+="L";
            }

        }
        System.out.println(debug);
        return wins;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader b = new BufferedReader(new FileReader("./hps.in"));
            int N = Integer.parseInt(b.readLine());
            String stuff = "";
            for (int i = 0; i<N; i++) {
                stuff += (b.readLine());
            }

            int biggest = 0;
            String[] options = {"H", "P", "S"};
            for (int i = 0; i<3; i++) {
                for (int j = 0; j<3; j++) {
                    int[] prev = {0};
                    for (int k = 0; k<stuff.length(); k++){
                        int temp = operate(stuff, options[i], options[j], k, prev);
                        System.out.println(temp);
                        if (temp > biggest){
                            biggest = temp;
                        }
                    }
                }
            }
        PrintWriter printWriter = new PrintWriter ("hps.out");
        printWriter.println(biggest+1);
        printWriter.close ();


    }

}
