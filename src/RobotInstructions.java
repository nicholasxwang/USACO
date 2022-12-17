import java.io.*;
import java.util.*;

class Subset  implements Comparable<Subset>{
    int amountx;
    int amounty;
    int element_count;
    public Subset(int amountx, int amounty, int element_count){
        this.amountx = amountx;
        this.amounty = amounty;
        this.element_count = element_count;
    }

    public int compareTo(Subset other) {
        if (amounty != other.amounty) {
            return Long.compare(amounty, other.amounty);
        } else {
            return Long.compare(amountx, other.amountx);
        }
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

        Subset[] subsets1 = new Subset[(int) Math.pow(2, instructions1.length)];
        Subset[] subsets2 = new Subset[(int) Math.pow(2, instructions2.length)];

        for (int i = 0; i < (1<<instructions1.length); i++){
            subsets1[i] = new Subset(0, 0, 0);
            for (int j = 0; j < instructions1.length; j++)
                if ((i & (1 << j)) > 0) {
                    subsets1[i].amountx += instructions1[j][0];
                    subsets1[i].amounty += instructions1[j][1];
                    subsets1[i].element_count++;
                }
        }
        for (int i = 0; i < (1<<instructions2.length); i++){
            subsets2[i] = new Subset(0, 0, 0);
            for (int j = 0; j < instructions2.length; j++)
                if ((i & (1 << j)) > 0) {
                    subsets2[i].amountx += instructions2[j][0];
                    subsets2[i].amounty += instructions2[j][1];
                    subsets2[i].element_count++;
                }
        }

        Arrays.sort(subsets1);
        Arrays.sort(subsets2);

        // find number of subsets1[x] + subsets2[y] = X
        int j = 0;
        int k = 0;
        long[] amounts = new long[(N / 2) + 1];
        for (Subset choice : subsets1) {
            while (j < subsets2.length && subsets2[j].compareTo(choice) <= 0) {
                amounts[subsets2[j].element_count]++;
                j++;
            }
            while (k < subsets2.length && subsets2[k].compareTo(choice) < 0) {
                amounts[subsets2[k].element_count]--;
                k++;
            }
            for (int element_count = 0; element_count <= N / 2; element_count++) {
                answers[element_count + choice.element_count] += amounts[element_count];
            }
        }

        for (int i = 1; i<answers.length; i++){
            System.out.println(answers[i]);
        }
    }
}
