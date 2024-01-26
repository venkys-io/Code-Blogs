import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Scanner;

public class tsort {
    // Comment: This method performs a depth-first search traversal of the graph starting from vertex v.
    public static void util(int v, List<List<Integer>> graph, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (int i : graph.get(v)) {
            if (!visited[i]) {
                util(i, graph, visited, stack);
            }
        }
        stack.push(v);
    }

    // Comment: This method performs a topological sort on the given graph.
    public static void topologicalsort(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                util(i, graph, visited, stack);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            System.out.print("Enter neighbors of vertex " + i + " separated by space (or press Enter for no neighbors): ");
            List<Integer> neighbors = new ArrayList<>();
            String[] input = scanner.nextLine().split("\\s+");
            for (String neighbor : input) {
                neighbors.add(Integer.parseInt(neighbor));
            }
            graph.add(neighbors);
        }

        topologicalsort(graph);

        scanner.close();
    }
}