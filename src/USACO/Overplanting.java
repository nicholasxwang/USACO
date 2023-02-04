import java.io.*; import java.util.*;
public class Overplanting {
    public static boolean in_between(int lower, int upper, int point){ return lower<=point && point <= upper;}
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int smallest = 999999999;
        int biggest = -1;
        int[][] rects = new int[N][4];
        for (int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            if (x1 < smallest) smallest = x1;
            if (x2 > biggest) biggest = x2;
            int[] temp = {x1, y1, x2, y2};
            rects[i] = temp;
        }
        HashMap<Integer, ArrayList<ArrayList<Integer>>> starting = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
        HashMap<Integer, ArrayList<ArrayList<Integer>>> ending = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
        for (int j = 0; j<N; j++){
            int[] rect = rects[j];
            ArrayList<Integer> coordinate = new ArrayList<Integer>();
            coordinate.add(rect[1]);
            coordinate.add(rect[3]);
            if (starting.containsKey(rect[0])){
                starting.get(rect[0]).add(coordinate);
            } else{
                ArrayList<ArrayList<Integer>> temp2 = new ArrayList<ArrayList<Integer>>();
                temp2.add(coordinate);
                starting.put(rect[0], temp2);
            }
            if (ending.containsKey(rect[2])){
                ending.get(rect[2]).add(coordinate);
            } else{
                ArrayList<ArrayList<Integer>> temp2 = new ArrayList<ArrayList<Integer>>();
                temp2.add(coordinate);
                ending.put(rect[2], temp2);
            }
        }
        int sum = 0;
        ArrayList<ArrayList<Integer>> active = new ArrayList<ArrayList<Integer>>();
        for (int j = smallest; j<=biggest; j++) {
            if (starting.containsKey(j)){
                for (ArrayList<Integer> coordinate : starting.get(j)){
                    active.add(coordinate);
                }
            }
            if (ending.containsKey(j)){
                for (ArrayList<Integer> coordinate : ending.get(j)){
                    active.remove(coordinate);
                }
            }
            int upper = -1;
            int lower = Integer.MAX_VALUE;
            for (int k = 0; k<active.size(); k++){
                ArrayList<Integer> coordinate = active.get(k);
                if (coordinate.get(0) > upper) upper = coordinate.get(0);
                if (coordinate.get(1) < lower) lower = coordinate.get(1);
            }
            if (active.size() > 0) sum += upper - lower;
        }


        System.out.println(sum);

    }
}
