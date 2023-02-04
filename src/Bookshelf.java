import java.io.*;
import java.util.*;

/*
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
*/
public class Bookshelf {
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
        Arrays.sort(bookshelf, Book.BookComparator);
        System.out.println(Arrays.toString(bookshelf));
        int book_index = 0;
        int total_height = 0;
        int current_height = 0;
        int current_width = 0;
        while (book_index < books){
            if (current_height == 0){
                current_height = bookshelf[book_index].height;
                current_width = bookshelf[book_index].width;
            }else{
                if (current_width + bookshelf[book_index].width <= width_limit){
                    current_width += bookshelf[book_index].width;
                    current_height = Math.max(current_height, bookshelf[book_index].height);
                }else{
                    total_height += current_height;
                    current_height = bookshelf[book_index].height;
                    current_width = bookshelf[book_index].width;
                }
            }
            book_index++;

        }
        total_height += current_height;
        System.out.println(total_height);
    }
}
