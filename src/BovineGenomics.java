import java.io.*; import java.util.*;
class Types{
    int index;
    boolean same_as_spotty;
    ArrayList<String> types = new ArrayList<>();
    public Types(int index, ArrayList<String> types){
        this.index = index;
        this.types = types;
        this.same_as_spotty = false;
    }
}
public class BovineGenomics {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[][] spotted = new String[N][M];
        String[][] plain = new String[N][M];
        for (int i = 0; i<N; i++){
            String[] s = br.readLine().split("");
            for (int j = 0; j<M; j++){
                spotted[i][j] = (s[j]);
            }
        }

        for (int i = 0; i<N; i++){
            String[] s = br.readLine().split("");
            for (int j = 0; j<M; j++){
                plain[i][j] = (s[j]);
            }
        }
       ArrayList<Types> list_of_types = new ArrayList<>();
        for (int i = 0; i<M; i++){
            Set<String> types = new HashSet<>();
            for (int j = 0; j<N; j++){
                //types.add(spotted[j][i]);
                types.add(plain[j][i]);
            }
            Set<String> types2 = new HashSet<>();
            for (int j = 0; j<N; j++){
                //types.add(plain[j][i]);
                types2.add(spotted[j][i]);
            }
            if (types.size() <= 3){
                if (!types.equals(types2)){
                    Types types_object = new Types(i, new ArrayList<String>(types));
                    list_of_types.add(types_object);
                }
            }
        }

        //find how many pairs of 3 can exist
        System.out.println(".");






    }
}
