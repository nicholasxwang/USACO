import java.io.*;
import java.util.*;

public class ConnectingTwoBarns2 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("INPUT.txt"));
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
                for (int i = 0; i<initial_component.size(); i++){
                    for (int j = 0; j<final_component.size(); j++){
                        int current = (initial_component.get(i) - final_component.get(j))*(initial_component.get(i) - final_component.get(j));
                        if (current < smallest) smallest = current;
                    }
                }
                System.out.println(smallest);
            }else{
                int smallest_direct_connection = Integer.MAX_VALUE;
                ArrayList<Integer> initial_component = connected_components.get(initial_one);
                ArrayList<Integer> final_component = connected_components.get(final_one);
                for (int i = 0; i<initial_component.size(); i++){
                    for (int j = 0; j<final_component.size(); j++){
                        int current = (initial_component.get(i) - final_component.get(j))*(initial_component.get(i) - final_component.get(j));
                        if (current < smallest_direct_connection) smallest_direct_connection = current;
                    }
                }
                int smallest_toward_indirect = Integer.MAX_VALUE; // first to intermediate + intermediate to final
                int smallest_from_indirect = Integer.MAX_VALUE; // final to intermediate + intermediate to first
                int intermediate_one = 1;
                if (final_one == 1) intermediate_one = 2;
                ArrayList<Integer> other_component = connected_components.get(intermediate_one);
                for (int i = 0; i<initial_component.size(); i++){
                    for (int j = 0; j<other_component.size(); j++){
                        int current = (initial_component.get(i) - other_component.get(j))*(initial_component.get(i) - other_component.get(j));
                        if (current < smallest_toward_indirect) smallest_toward_indirect = current;
                    }
                }
                for (int i = 0; i<final_component.size(); i++){
                    for (int j = 0; j<other_component.size(); j++){
                        int current = (final_component.get(i) - other_component.get(j))*(final_component.get(i) - other_component.get(j));
                        if (current < smallest_from_indirect) smallest_from_indirect = current;
                    }
                }
//                System.out.println("smallest_direct_connection: " + smallest_direct_connection);
//                System.out.println("smallest_toward_indirect: " + smallest_toward_indirect);
//                System.out.println("smallest_from_indirect: " + smallest_from_indirect);
                int smallest = Math.min(smallest_direct_connection, (smallest_toward_indirect + smallest_from_indirect));
                System.out.println(smallest);
            }
        }
    }
}
