import java.io.*;
import java.util.*;

public class ConnectingTwoBarns2 {
    public static int olddifffind(ArrayList<Integer> one, ArrayList<Integer> two){
        int smallest = 0;
        for (int i = 0; i<one.size(); i++){
            for (int j = 0; j<two.size(); j++){
                if (Math.abs(one.get(i) - two.get(j)) < Math.abs(one.get(i) - two.get(smallest))){
                    smallest = j;
                }
            }
        }
        return Math.abs(one.get(0) - two.get(smallest));
    }
    public static int difffind(ArrayList<Integer> one, ArrayList<Integer> two){
        // [2, 3, 5, 7]
        // [4, 6, 8, 10]
        // Create a large array that is like [0, 1, 1, 2, 1, 2, 1, 2, 0, 2]
        ArrayList<Integer> large = new ArrayList<Integer>();
        int largest = 0;
        for (int i = 0; i<one.size(); i++){
            if (one.get(i) > largest) largest = one.get(i);
        }
        for (int i = 0; i<two.size(); i++){
            if (two.get(i) > largest) largest = two.get(i);
        }
        for (int i = 0; i<= largest; i++){
            large.add(0);
        }
        for (int i = 0; i<one.size(); i++){
            large.set(one.get(i), 1);
        }
        for (int i = 0; i<two.size(); i++){
           large.set(two.get(i), 2);
        }
        int twopointer = -1;
        int onepointer = -1;
        int smallest_distance = Integer.MAX_VALUE;
        for (int i = 0; i<large.size(); i++){
            if (large.get(i) == 2){
                twopointer = i;
            }else if (large.get(i) == 1){
                onepointer = i;
            }
            if (twopointer != -1 && onepointer != -1){
                if (Math.abs(twopointer - onepointer) < smallest_distance){
                    smallest_distance = Math.abs(twopointer - onepointer);
                }
            }
        }
        if (twopointer != -1 && onepointer != -1){
            if (Math.abs(twopointer - onepointer) < smallest_distance){
                smallest_distance = Math.abs(twopointer - onepointer);
            }
        }
        if (smallest_distance == Integer.MAX_VALUE) return 0;
        return smallest_distance;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] edges = new int[M][2];
            for (int i = 0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                edges[i][0] = Integer.parseInt(st.nextToken());
                edges[i][1] = Integer.parseInt(st.nextToken());
            }
            ArrayList<ArrayList<Integer>> connected_components = new ArrayList<>();
            ArrayList<Integer> visited = new ArrayList<>();
            int initial_one = 0;
            int final_one = 0;
            for (int current_node = 1; current_node <= N; current_node++){
                if (visited.contains(current_node)) continue;
                ArrayList<Integer> component = new ArrayList<>();
                // create a queue
                // bfs algorithm
                Queue<Integer> queue = new LinkedList<>();
                queue.add(current_node);
                component.add(current_node);
                if (current_node == N) final_one = connected_components.size();
                while (queue.isEmpty() == false){
                    int current = queue.remove();
                    visited.add(current);
                    component.add(current);
                    if (current == N) final_one = connected_components.size();
                    for (int i = 0; i<M; i++){
                        if (edges[i][0] == current && visited.contains(edges[i][1]) == false){
                            queue.add(edges[i][1]);
                        }
                        if (edges[i][1] == current && visited.contains(edges[i][0]) == false){
                            queue.add(edges[i][0]);
                        }
                    }
                }
                connected_components.add(component);
            }
            if (connected_components.size() == 1){
                System.out.println("0");
            }else if (connected_components.size() == 2){
                int smallest = Integer.MAX_VALUE;
                ArrayList<Integer> initial_component = connected_components.get(initial_one);
                ArrayList<Integer> final_component = connected_components.get(final_one);
                smallest = difffind(initial_component, final_component);
             // find smallest usign O(N) complexity
                System.out.println(smallest);
            }else{
                int smallest_direct_connection = Integer.MAX_VALUE;
                ArrayList<Integer> initial_component = connected_components.get(initial_one);
                ArrayList<Integer> final_component = connected_components.get(final_one);
                smallest_direct_connection = difffind(initial_component, final_component);
                int smallest_toward_indirect = Integer.MAX_VALUE; // first to intermediate + intermediate to final
                int smallest_from_indirect = Integer.MAX_VALUE; // final to intermediate + intermediate to first
                int intermediate_one = 1;
                if (final_one == 1) intermediate_one = 2;
                ArrayList<Integer> other_component = connected_components.get(intermediate_one);
               smallest_toward_indirect = difffind(initial_component, other_component);
                smallest_from_indirect = difffind(other_component, final_component);

//                System.out.println("smallest_direct_connection: " + smallest_direct_connection);
//                System.out.println("smallest_toward_indirect: " + smallest_toward_indirect);
//                System.out.println("smallest_from_indirect: " + smallest_from_indirect);
                int smallest = Math.min(smallest_direct_connection, (smallest_toward_indirect + smallest_from_indirect));
                System.out.println(smallest);
            }
        }
    }
}
