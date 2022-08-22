import java.io.*; import java.util.*;

class Entry{
    int value;
    int index;

    public Entry(int value, int index){
        this.value = value;
        this.index = index;
    }
}
public class OutOfSorts {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("sort.in"));
        int N = Integer.parseInt(br.readLine());
        Entry[] A = new Entry[N];
        for (int i = 0; i<N; i++){
            A[i] = new Entry(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(A, new Comparator<Entry>(){
            public int compare(Entry e1, Entry e2){
                if (e1.value == e2.value){
                    return e1.index - e2.index;
                }
                return e1.value - e2.value;
            }
        });

        int max = 0;
        for (int i = 0; i<N; i++){
            if (A[i].value - A[i].index > max){
                max = A[i].value - A[i].index;
            }
        }

        PrintWriter pw = new PrintWriter("sort.out");
        pw.println(max+1);
        pw.close();

    }
}
