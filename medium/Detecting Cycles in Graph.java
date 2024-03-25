import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Depth-First Search (DFS) function to check for cycles
    static boolean dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited, int parent) {
        visited[node] = true;  // Mark the current node as visited
        for (int neighbour : graph.get(node)) {  // Iterate through neighbors of the current node
            if (!visited[neighbour]) {  // If the neighbor is not visited
                if (dfs(neighbour, graph, visited, node))  // Recursive DFS call
                    return true;  // If a cycle is found in the recursive call, return true
            } else if (neighbour != parent) {  // If the neighbor is visited and not the parent (back edge)
                return true;  // Cycle is found, return true
            }
        }
        return false;  // No cycle found for the current node
    }

    // Function to check if there is any cycle in the graph
    static boolean isCycle(ArrayList<ArrayList<Integer>> graph) {
        int v = graph.size();  // Number of vertices in the graph
        boolean[] visited = new boolean[v];  // Initialize visited array for all vertices
        for (int node = 0; node < v; node++) {  // Iterate through all nodes in the graph
            if (!visited[node] && dfs(node, graph, visited, -1))  // If the node is not visited and contains a cycle
                return true;  // Return true indicating the presence of a cycle
        }
        return false;  // No cycle found in the graph
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input vertices and edges
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(vertices);

        // Adding edges to the graph
        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
        System.out.println("Enter edges (u v): ");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        System.out.println(isCycle(graph));  // Check and print whether the graph contains a cycle
    }
}
