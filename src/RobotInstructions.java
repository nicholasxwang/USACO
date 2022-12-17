import java.io.*;
import java.util.*;

class Subset{
    int amountx;
    int amounty;
    int element_count;
    public Subset(int amountx, int amounty, int element_count){
        this.amountx = amountx;
        this.amounty = amounty;
        this.element_count = element_count;
    }
}
public class RobotInstructions {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int[] answers = new int[N+1];
        int[][] instructions1 = new int[N/2][2];
        int[][] instructions2 = new int[N-N/2][2];
        for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (i < N/2) {
                instructions1[i][0] = a;
                instructions1[i][1] = b;
            }
            else {
                instructions2[i-N/2][0] = a;
                instructions2[i-N/2][1] = b;
            }
        }

        Subset[] subsets1 = new Subset[(int) Math.pow(2, N)];
        Subset[] subsets2 = new Subset[(int) Math.pow(2, N)];
        for (int i = 0; i < (1<<subsets1.length); i++){
            for (int j = 0; j < subsets1.length; j++)
                if ((i & (1 << j)) > 0) {
                    if (subsets1[i] == null){
                        subsets1[i] = new Subset(0, 0, 0);
                    }
                    subsets1[i].amountx += instructions1[j][0];
                    subsets1[i].amounty += instructions1[j][1];
                    subsets1[i].element_count++;
                }
        }
        for (int i = 0; i < (1<<subsets2.length); i++){
            for (int j = 0; j < subsets2.length; j++)
                if ((i & (1 << j)) > 0) {
                    if (subsets2[i] == null){
                        subsets2[i] = new Subset(0, 0, 0);
                    }
                    subsets2[i].amountx += instructions2[j][0];
                    subsets2[i].amounty += instructions2[j][1];
                    subsets2[i].element_count++;
                }
        }

        // find number of subsets1[x] + subsets2[y] = X
        for (int i = 0; i<subsets1.length; i++){
            for (int j = 0; j<subsets2.length; j++){
                try {
                    if (subsets1[i].amountx + subsets2[j].amountx == x && subsets1[i].amounty + subsets2[j].amounty == y) {
                        answers[subsets1[i].element_count + subsets2[j].element_count]++;
                    }
                }
                catch (Exception e){
                }
            }
        }
        for (int i = 0; i<answers.length; i++){
            System.out.println(answers[i]);
        }
    }
}
