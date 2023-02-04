import java.io.*;
import java.util.*;

class Book{
    int height;
    int width;
    public Book(int height, int width){
        this.height = height;
        this.width = width;
    }
    // custom sort function, first sort by height, then by width
    public static Comparator<Book> BookComparator = new Comparator<Book>() {
        @Override
        public int compare(Book b1, Book b2) {
            if (b1.height == b2.height){
                return b1.width - b2.width;
            }
            return b2.height - b1.height;
        }
    };
    // custom print function
    public String toString(){
        return "(H: " + this.height + ", W: " + this.width + ")";
    }

}
public class Bookshelf2 {
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int books = Integer.parseInt(st.nextToken());
        int width_limit = Integer.parseInt(st.nextToken());
        Book[] bookshelf = new Book[books];
        for (int i = 0; i<books; i++){
            st = new StringTokenizer(in.readLine());
            bookshelf[i] = new Book(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int[][] dp = new int[books+1][width_limit+1];
        int[][] widths = new int[books+1][width_limit+1];
        dp[0][0] = 0;
        dp[1][width_limit] = bookshelf[0].height;
        Arrays.sort(bookshelf, Book.BookComparator);
        for (int i = 2; i<=books; i++){
            for (int j = 0; j<=width_limit; j++){
                if (j + bookshelf[i-1].width <= width_limit){
                    if (dp[i-1][j] + bookshelf[i-1].height > dp[i-1][j + bookshelf[i-1].width]){
                        dp[i][j] = dp[i-1][j] + bookshelf[i-1].height;
                        widths[i][j] = j;
                    }else{
                        dp[i][j] = dp[i-1][j + bookshelf[i-1].width];
                        widths[i][j] = j + bookshelf[i-1].width;
                    }
                }else{
                    dp[i][j] = dp[i-1][j];
                    widths[i][j] = j;
                }
            }
        }
        System.out.println(dp[books][width_limit]);
    }
}
