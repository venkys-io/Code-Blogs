import java.util.*;

public class Main {
    private int v;
    private LinkedList<Integer> lst[];

    // Create a graph
    Main(int ver) {
        v = ver;
        lst = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            lst[i] = new LinkedList<>();
        }
    }

    // Add edges to the graph
    public void addEdge(int ver, int ele) {
        lst[ver].add(ele);
    }

    // BFS algorithm
    public void bfs(int s) {
        boolean[] visited = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while (queue.size() != 0) {
            // Removing and printing the removed element
            s = queue.poll();
            System.out.print(s + " ");
            // Iterating the graph
            Iterator<Integer> i = lst[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // Driver code
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        Main obj = new Main(vertices);

        System.out.println("Enter the edges in the format (vertex1 vertex2), enter -1 -1 to stop:");
        while (true) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            if (vertex1 == -1 && vertex2 == -1) {
                break;
            }
            obj.addEdge(vertex1, vertex2);
        }

        System.out.print("Enter the starting vertex for BFS: ");
        int startVertex = scanner.nextInt();

        System.out.println("The Breadth First Traversal of the graph is as follows (from " + startVertex + "th vertex):");
        obj.bfs(startVertex);

        scanner.close();
    }
}