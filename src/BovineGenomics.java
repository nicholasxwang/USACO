import java.io.*; import java.util.*;
class Types{
    int index;
    ArrayList<Integer> types = new ArrayList<>();
    public Types(int index, ArrayList<Integer> types){
        this.index = index;
        this.types = types;
    }
}
public class BovineGenomics {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("bovine.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] spotted = new int[N][M];
        int[][] plain = new int[N][M];
        for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<M; j++){
                spotted[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<M; j++){
                plain[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i<M; i++){
            Set<String> types = new HashSet<>();
            for (int j = 0; j<N; j++){

            }
        }






    }
}
