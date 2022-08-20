import java.io.*; import java.util.*;
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

        //COMPLEXITY O(M^3*N)
        int ans = 0;
          for (int i = 0; i<M; i++){
              for (int j = i+1; j<M; j++){
                  for (int k = j+1; k<M; k++){
                      ArrayList<String> seen_in_spotted = new ArrayList<>();
                      for (int cow = 0; cow<N; cow++) {
                          seen_in_spotted.add(spotted[cow][i] + spotted[cow][j] + spotted[cow][k]);
                      }
                      boolean valid = true;
                      for (int cow = 0; cow<N; cow++){
                          if (seen_in_spotted.contains(plain[cow][i] + plain[cow][j] + plain[cow][k])){
                              valid = false;
                              break;
                          }
                      }
                      if (valid) ans++;
//                      if (valid){
//                          System.out.println("["+i+", "+j+", "+k+"]");
//                      }


                  }
              }
          }
//          System.out.println(ans);
        PrintWriter pw = new PrintWriter("cownomics.out");
        pw.println(ans);
        pw.close();






    }
}
