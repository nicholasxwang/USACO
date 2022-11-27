import java.io.*;
import java.util.*;
// for timestampts

public class ConnectingTwoBarns2 {
    static int skip = 0;
    static int nonSkip = 0;
    public static int oldnewdifffind(ArrayList<Integer> one, ArrayList<Integer> two){
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
        int two_pointer = -1;
        int one_pointer = -1;
        int smallest_distance = Integer.MAX_VALUE;
        for (int i = 0; i<large.size(); i++){
            if (large.get(i) == 2){
                two_pointer = i;
            }else if (large.get(i) == 1){
                one_pointer = i;
            }
            if (two_pointer != -1 && one_pointer != -1){
                if (Math.abs(two_pointer - one_pointer) < smallest_distance){
                    smallest_distance = Math.abs(two_pointer - one_pointer);
                }
                if (smallest_distance == 1) return 1;
            }
        }
        if (two_pointer != -1 && one_pointer != -1){
            if (Math.abs(two_pointer - one_pointer) < smallest_distance){
                smallest_distance = Math.abs(two_pointer - one_pointer);
            }
        }
        if (smallest_distance == Integer.MAX_VALUE) return 0;
        return smallest_distance*smallest_distance;
    }
    public static int newdifffind(ArrayList<Integer> one, ArrayList<Integer> two, int max, int[] boundary1,int[] boundary2){
        int current_one = 0;
        int current_two = 0;
        //int smallest = max;
        //check if the two intervals intersect
//        if (max  < Integer.MAX_VALUE){
//            max *= 100;
//        }
        if (Math.abs(boundary1[0] - boundary2[1])>max || Math.abs(boundary1[1] - boundary2[0])>max){
            //if (Math.abs(boundary1[0] - boundary2[1])>max*10000){
            // no intersection
            //System.out.println("skipped :P");
            skip++;

            return max;
        }
       // System.out.println("not skipped :P");
        System.out.println(Arrays.toString(boundary1));
        System.out.println(Arrays.toString(boundary2));
        System.out.println(max);
        nonSkip++;
        //int smallest = max
        int smallest = Integer.MAX_VALUE;
        Collections.sort(one);
        Collections.sort(two);
        while (current_one < one.size() && current_two < two.size()){
            if (Math.abs(one.get(current_one) - two.get(current_two)) < smallest){
                smallest = Math.abs(one.get(current_one) - two.get(current_two));
            }
            if (one.get(current_one) < two.get(current_two)){
                current_one++;
            }else{
                current_two++;
            }
            if (smallest == 1) return 1;
            
        }
        return smallest*smallest;
        
    }
    public static void main(String[] args) throws IOException {
         //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("INPUT.TXT"));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] neighbours = new ArrayList[N+1];
            for (int i = 0; i<N+1; i++){
                neighbours[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                int first =  Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                neighbours[first].add(second);
                neighbours[second].add(first);
            }
            ArrayList<ArrayList<Integer>> connected_components = new ArrayList<>();
            ArrayList<int[]> boundaries = new ArrayList<>();

            boolean[] visited = new boolean[N+1];
            int initial_one = 0;
            int final_one = 0;
            for (int current_node = 1; current_node <= N; current_node++){
                if (visited[current_node]) continue;
                ArrayList<Integer> component = new ArrayList<>();
                int[] boundary = new int[2];
                // create a queue
                // bfs algorithm
                Queue<Integer> queue = new LinkedList<>();
                queue.add(current_node);
                component.add(current_node);
                boundary[0] = current_node;
                boundary[1] = current_node;
                if (current_node == N) final_one = connected_components.size();
                while (!queue.isEmpty()){
                    int current = queue.remove();
                    visited[current] = true;
                    component.add(current);
                    if (current == N) final_one = connected_components.size();
                    for (int i = 0; i<neighbours[current].size(); i++){
                        if (!visited[neighbours[current].get(i)]){
                            queue.add(neighbours[current].get(i));
                            if (neighbours[current].get(i) < boundary[0]) boundary[0] = neighbours[current].get(i);
                            if (neighbours[current].get(i) > boundary[1]) boundary[1] = neighbours[current].get(i);
                        }
                    }
                }
                connected_components.add(component);
                boundaries.add(boundary);
            }
//            System.out.println("There are "+connected_components.size()+" islands");
//            System.out.println(connected_components);
            if (connected_components.size() == 1){
                System.out.println("0");
            }else if (connected_components.size() == 2){
                int smallest = Integer.MAX_VALUE;
                ArrayList<Integer> initial_component = connected_components.get(initial_one);
                ArrayList<Integer> final_component = connected_components.get(final_one);
                smallest = newdifffind(initial_component, final_component, smallest, boundaries.get(initial_one), boundaries.get(final_one));
             // find smallest usign O(N) complexity
                System.out.println(smallest);
            }else{
                int smallest_direct_connection = Integer.MAX_VALUE;
                int smallest_indirect_connection = Integer.MAX_VALUE;
                ArrayList<Integer> initial_component = connected_components.get(initial_one);
                ArrayList<Integer> final_component = connected_components.get(final_one);
                smallest_direct_connection = newdifffind(initial_component, final_component, Integer.MAX_VALUE, boundaries.get(initial_one), boundaries.get(final_one));
                //System.out.println("smallest_direct_connection: " + smallest_direct_connection);
                for (int intermediate_one = 0; intermediate_one < connected_components.size(); intermediate_one++){
                    if (intermediate_one == 0 || intermediate_one == final_one) continue;
                    int smallest_toward_indirect = Integer.MAX_VALUE; // first to intermediate + intermediate to final
                    int smallest_from_indirect = Integer.MAX_VALUE; // final to intermediate + intermediate to first
                    ArrayList<Integer> other_component = connected_components.get(intermediate_one);
                    smallest_toward_indirect = newdifffind(initial_component, other_component,Math.min(smallest_toward_indirect, smallest_from_indirect), boundaries.get(initial_one), boundaries.get(intermediate_one));
                    if (smallest_toward_indirect > smallest_indirect_connection) continue;
                    smallest_from_indirect = newdifffind(other_component, final_component, Math.min(smallest_toward_indirect, smallest_from_indirect), boundaries.get(intermediate_one), boundaries.get(final_one));
                    if (smallest_from_indirect > smallest_indirect_connection) continue;
//                     System.out.println("smallest_toward_indirect: " + smallest_toward_indirect);
//                    System.out.println("smallest_from_indirect: " + smallest_from_indirect);
//                    System.out.println("smallest_indirect: " + (smallest_toward_indirect + smallest_from_indirect));
                    if (smallest_toward_indirect + smallest_from_indirect < smallest_indirect_connection){
                        smallest_indirect_connection = smallest_toward_indirect + smallest_from_indirect;
                    }

                }
                int smallest = Math.min(smallest_direct_connection, smallest_indirect_connection);
                System.out.println(smallest);
                System.out.println("<---");
                System.out.println(skip);
                System.out.println(nonSkip);
                System.out.println("--->");
                skip = 0;
                nonSkip = 0;
            }
        }
    }
}
