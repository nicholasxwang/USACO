import java.io.*;
import java.util.*;

public class FakeFollowingDirections {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N == 2) System.out.println("RRLRLL");
        if (N == 3) System.out.println("RRRLLRRLLL");
    }
}
