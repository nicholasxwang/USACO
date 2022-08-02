import java.io.*;
import java.util.*;
public class Wheres_Bessie {
    static boolean isValid(String[][] screen, int m, int n, int x, int y, String prevC) {
        return !(x < 0 || x >= m || y < 0 || y >= n || screen[x][y].equals(".") || !screen[x][y].equals(prevC));}
    static boolean pcl(Hashtable<String, Integer>  hashtable, boolean ending  ){
        if (!ending && hashtable.size() > 2)   return false;
        if (ending && hashtable.size() != 2)   return false;
        if (ending) {
            boolean has_single = false;
            boolean has_double = false;
            for (String key : hashtable.keySet()) {
                if (hashtable.get(key) == 1) {
                    has_single = true;
                }
                if (hashtable.get(key) > 1) {
                    has_double = true;
                }
            }
            return has_single && has_double;
        } return true;
    }
    static void floodFill(String[][] screen, int m, int n, int x, int y, String prevC) {
        Vector<Point> queue = new Vector<Point>();
        queue.add(new Point(x, y));
        screen[x][y] = ".";
        while (queue.size() > 0) {
            Point currPixel = queue.get(queue.size() - 1);
            queue.remove(queue.size() - 1);
            int posX = currPixel.x;
            int posY = currPixel.y;
            if (isValid(screen, m, n, posX + 1, posY, prevC)) { screen[posX + 1][posY] =  ".";  queue.add(new Point(posX + 1, posY));}
            if (isValid(screen, m, n, posX - 1, posY, prevC)) { screen[posX - 1][posY] =  ".";;;queue.add(new Point(posX - 1, posY));}
            if (isValid(screen, m, n, posX, posY + 1, prevC)) { screen[posX][posY + 1] =  ".";; queue.add(new Point(posX, posY + 1));}
            if (isValid(screen, m, n, posX, posY - 1, prevC)) { screen[posX][posY - 1] =  ".";; queue.add(new Point(posX, posY - 1));}
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] grid = new String[N][N];
        String[] s;
        for (int i = 0; i < N; i++) {
            s = br.readLine().split("");
            for (int j = 0; j < N; j++) grid[i][j] = s[j];
        }
        ArrayList<ArrayList<Integer>> pcls = new ArrayList<>();
        for (int i = 0; i < N; i++) { for (int j = i+1; j < N; j++) { for (int k = 0; k < N; k++) { for (int l = k+1; l < N; l++) {
                        String[][] subgrid = new String[j-i+1][l-k+1];
                        for (int n = 0; n<j-i+1; n++) {
                            for (int m = 0; m<l-k+1; m++) subgrid[n][m] = grid[n+i][m+k];
                        }
                        Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
                        boolean break_loop = false;
                        System.out.println("("+i+","+j+","+k+","+l+")");
                        System.out.println(Arrays.deepToString(subgrid));
                        for (int n = 0; n<subgrid.length; n++){
                            for (int m = 0; m<subgrid[0].length; m++){
                                if (!Objects.equals(subgrid[n][m], ".")) {
                                    ht.put(subgrid[n][m], ht.getOrDefault(subgrid[n][m], 0) + 1);
                                    floodFill(subgrid, subgrid.length, subgrid[0].length, n, m, subgrid[n][m]);
                                    if (!pcl(ht, false)){
                                        break_loop = true;
                                        break;
                                    }
                                }
                            }
                            if (break_loop) break;
                        }
                        if (pcl(ht, true)){
                            ArrayList<Integer> pcl = new ArrayList<>();
                            pcl.add(i);
                            pcl.add(j);
                            pcl.add(k);
                            pcl.add(l);
                            pcls.add(pcl);
                            System.out.println("PCL ^^ ");
                            break;
                        }
                    }
                }
            }
        }

        ArrayList<Integer> weak_index = new ArrayList<>();
        for (int i = 0; i<pcls.size(); i++) {
            //for (int j = i+1; j<pcls.get(i).size(); j++) {
            for (int j = 0; j<pcls.size(); j++) {
                if (i==j) continue;
                if ((pcls.get(i).get(0) <= pcls.get(j).get(0) )&& (pcls.get(i).get(2) <= pcls.get(j).get(2)) &&
                        pcls.get(i).get(1) >= pcls.get(j).get(1) && pcls.get(i).get(3) >= pcls.get(j).get(3)) {
                    weak_index.add(j);
                    System.out.println("EATEN - ("+pcls.get(j).get(0)+", "+pcls.get(j).get(1)+", "+pcls.get(j).get(2)+", "+pcls.get(j).get(3)+")");
                    //break;
                }else{
                    System.out.println("SURVIVED- ("+pcls.get(j).get(0)+", "+pcls.get(j).get(1)+", "+pcls.get(j).get(2)+", "+pcls.get(j).get(3)+")");

                }
            }
        }
        for (int i = 0; i<weak_index.size(); i++) {
            pcls.remove(weak_index.get(i));
        }


        System.out.println(pcls.size());
    }
}
