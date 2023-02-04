import java.io.*; import java.util.*;

public class Cereal2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N][M]; // [cow][cereal]
        int edge_count = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][Integer.parseInt(st.nextToken()) - 1] = 1;
            matrix[i][Integer.parseInt(st.nextToken()) - 1] = 2;
            edge_count += 2;
        }
        // first eliminate the cereals that only one cow wants
        ArrayList<Integer> unsatisfied = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            unsatisfied.add(i);
        }
        ArrayList<Integer> permutation = new ArrayList<>();

        // then use greedy to elimate everything else
        while (edge_count > 0) {
            int target_cereal = -1;
            int target_ones = Integer.MAX_VALUE;
            int target_twos = Integer.MAX_VALUE;
            // priority - least number of "1"s, then least number of "2"s
            for (int i = 0; i < M; i++) {
                int ones = 0;
                int twos = 0;
                for (int j = 0; j < N; j++) {
                    if (matrix[j][i] == 1) {
                        ones++;
                    } else if (matrix[j][i] == 2) {
                        twos++;
                    }
                }
                if (ones  == 0  && twos == 0){
                    continue;
                }
                if (ones < target_ones){
                    target_cereal = i;
                    target_ones = ones;
                    target_twos = twos;
                }
                else if (ones == target_ones && twos < target_twos){
                    target_cereal = i;
                    target_ones = ones;
                    target_twos = twos;
                }
            }
            // choose a random "1" and if there are no "1"s, choose a random "2"
            for (int i = 0; i < N; i++) {
                if (matrix[i][target_cereal] == 1 || (matrix[i][target_cereal] == 2 && target_ones == 0)) {
                    permutation.add(i);
                    unsatisfied.removeAll(Collections.singleton(i));
                    for (int j = 0; j < N; j++) {
                        if (matrix[j][j] != 0) {
                            edge_count--;
                        }
                        matrix[j][target_cereal] = 0;
                    }
                    break;
                }
            }
        }
        System.out.println(unsatisfied);
        for (int i = 0; i < permutation.size(); i++) {
            System.out.println(permutation.get(i) + 1);
        }
    }
}
