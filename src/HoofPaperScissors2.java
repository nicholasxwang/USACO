import java.io.*;
import java.util.Objects;

public class HoofPaperScissors2  {
    public static boolean checky(String o, String t) {
        if (Objects.equals(o, t)){
            return false;
        }
        if (Objects.equals(o, "H")) {
            if (Objects.equals(t, "P")) {
                return false;
            }
            return Objects.equals(t, "S");
        } else if (Objects.equals(t, "P")) {
            if (Objects.equals(t, "S")) {
                return false;
            }
            return Objects.equals(t, "H");

        } else {
            if (Objects.equals(t, "H")) {
                return false;
            }
            return Objects.equals(t, "P");

        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader b = new BufferedReader(new FileReader("./hps.in"));
            int N = Integer.parseInt(b.readLine());
            String original = "";
            for (int i = 0; i<N; i++) {
                original += (b.readLine());
            }

            int biggest = 0;
            String[] options = {"H", "P", "S"};
            for (int i = 0; i<3; i++) {
                for (int j = 0; j<3; j++) {
                    int prev = 0;
                    char[] original_ = original.toCharArray();
                    boolean updated_previous;
                    int wins = 0;
                    for (int index = 0; index<original.length(); index++){
                        String app_1 = options[i];
                        String app_2 = options[j];
                        wins = 0;
                        wins += prev;
                        String debug = "";
                        debug += ("["+original+"]  ["+app_1+"]  ["+app_2+"]  ["+index+"]  ");
                        String current_ = app_1;
                        updated_previous = false;
                        for (int c = index; c<original_.length; c++){
                            if (c == index){
                                current_ = app_2;
                            }
                            if (checky(current_, String.valueOf(original_[c]))){
                                if (!updated_previous){
                                    updated_previous = true;
                                    prev++;

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
                        System.out.println(wins);
                        if (wins > biggest){
                            biggest = wins;
                        }
                    }
                }
            }
        PrintWriter printWriter = new PrintWriter ("hps.out");
        printWriter.println(biggest);
        printWriter.close ();

        //maybe something didnt get counted...no


    }

}
