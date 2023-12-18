import java.util.*;

public class bridge_edge {
    private static class Graph {
        private int V; // Number of vertices
        private LinkedList<Integer> adj[]; // Adjacency list to represent the graph
        private int time = 0;
        private static final int NIL = -1;

        // Constructor
        @SuppressWarnings("unchecked")
        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList<>();
        }

        // Function to add an edge into the graph
        void addEdge(int v, int w) {
            adj[v].add(w); // Add w to v's list.
            adj[w].add(v); // Add v to w's list
        }

        // A recursive function that finds and prints bridges using DFS traversal
        void bridgeUtil(int u, boolean visited[], int disc[], int low[], int parent[]) {
            // Mark the current node as visited
            visited[u] = true;

            // Initialize discovery time and low value
            disc[u] = low[u] = ++time;

            // Go through all vertices adjacent to this
            Iterator<Integer> i = adj[u].iterator();
            while (i.hasNext()) {
                int v = i.next(); // v is the current adjacent of u

                // If v is not visited yet, then make it a child of u in DFS tree and recur for
                // it.
                // If v is not visited yet, then recur for it
                if (!visited[v]) {
                    parent[v] = u;
                    bridgeUtil(v, visited, disc, low, parent);

                    // Check if the subtree rooted with v has a connection to one of the ancestors
                    // of u
                    low[u] = Math.min(low[u], low[v]);

                    // If the lowest vertex reachable from the subtree under v is below u in DFS
                    // tree, then u-v is a bridge
                    if (low[v] > disc[u])
                        System.out.println(u + " " + v);
                }

                // Update the low value of u for parent function calls.
                else if (v != parent[u])
                    low[u] = Math.min(low[u], disc[v]);
            }
        }

        // DFS based function to find all bridges. It uses the recursive function
        // bridgeUtil()
        void bridge() {
            // Mark all the vertices as not visited
            boolean visited[] = new boolean[V];
            int disc[] = new int[V];
            int low[] = new int[V];
            int parent[] = new int[V];

            // Initialize parent and visited arrays
            Arrays.fill(parent, NIL);

            // Call the recursive helper function to find Bridges in DFS tree rooted with
            // vertex 'i'
            for (int i = 0; i < V; i++)
                if (!visited[i])
                    bridgeUtil(i, visited, disc, low, parent);
        }
    }

    public static void main(String args[]) {
        // Create graphs given in above diagrams
        System.out.println("Bridges in the graph ");
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.bridge();
        System.out.println();

    }
}
