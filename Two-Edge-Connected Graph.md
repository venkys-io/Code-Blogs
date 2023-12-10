# Two Edge Connected Graph

# Introduction:

A two-edge-connected graph (also known as biconnected graph) is a type of graph that remains connected even after the removal of any single edge. In other words, a graph is two-edge-connected if there are at least two edge-disjoint paths between every pair of vertices.

1. **Edge Connectivity:**
    - A graph is said to be two-edge-connected if its edge connectivity is at least 2. Edge connectivity is the minimum number of edges that must be removed to disconnect the graph.
2. **Cut Vertex:**
    - A cut vertex (or articulation point) is a vertex whose removal would increase the number of connected components in the graph. A two-edge-connected graph does not have any cut vertices.
3. **Biconnected Components:**
    - A biconnected component is a maximal subgraph that is itself two-edge-connected. In other words, it is a connected subgraph that remains connected even after the removal of any single edge.
4. **Articulation Bridge:**
    - An articulation bridge (or bridge) is an edge whose removal increases the number of connected components in the graph. In a two-edge-connected graph, there are no articulation bridges.
5. **Properties:**
    - Two-edge-connected graphs have the property that every pair of vertices is connected by at least two edge-disjoint paths. This makes them resilient to the removal of a single edge.
6. **Applications:**
    - Two-edge-connected graphs have applications in network design, communication networks, and transportation systems. Ensuring multiple edge-disjoint paths between critical points can improve the robustness and fault tolerance of a system.

Algorithms for detecting whether a graph is two-edge-connected often involve depth-first search (DFS) or related techniques. The concept of biconnected components is crucial in understanding the structure of two-edge-connected graphs.

In summary, a two-edge-connected graph is a type of graph that exhibits a high level of connectivity, ensuring redundancy in the paths between vertices. The absence of cut vertices and articulation bridges contributes to the resilience of these graphs.

# Algorithm:

### 2-Edge-Connected Graph Algorithm:

1. **Initialization:**
    - For each edge, mark it as unvisited.
2. **DFS to Identify Bridges:**
    - Perform a DFS traversal of the graph, marking each visited edge.
    - During the DFS, identify bridges (cut edges) in the graph. A bridge is an edge whose removal increases the number of connected components in the graph.
    - Store the information about bridges.
3. **Check for Bridges:**
    - If there are no bridges in the graph, it means that removing any single edge does not disconnect the graph.
4. **Check for Connectivity:**
    - For each edge, if it is not a bridge, temporarily remove it from the graph.
    - Check if the remaining graph is still connected. If it is not, then the removed edge is a 2-edge-cut (an edge whose removal disconnects the graph).
5. **Result:**
    - If the graph passes the connectivity check for all non-bridge edges, then it is 2-edge-connected. Otherwise, it is not.

### Pseudocode:

```
function is2EdgeConnected(graph):
    initialize all edges as unvisited
    bridges = identifyBridges(graph)

    if no bridges in bridges:
        return true  // Graph is 2-edge-connected

    for each edge in graph.edges:
        if edge is not a bridge:
            temporaryRemove(edge)
            if graph is still connected:
                return false  // Graph is not 2-edge-connected
            restore(edge)

    return true  // Graph is 2-edge-connected

function identifyBridges(graph):
    perform DFS traversal to identify bridges
    return list of identified bridges

```

- The DFS traversal helps identify bridges by determining which edges are part of cycles in the graph.
- The algorithm tests the graph's connectivity after temporarily removing each non-bridge edge.
- If the graph remains connected after removing all non-bridge edges, it is 2-edge-connected.

# Program in `cpp`:

```cpp
#include <iostream>
#include <vector>

using namespace std;

class Graph {
public:
    Graph(int vertices);

    void addEdge(int u, int v);
    bool is2EdgeConnected();

private:
    int vertices;
    vector<vector<int>> adjList;

    void DFS(int u, vector<bool>& visited, vector<int>& disc, vector<int>& low, vector<int>& parent, vector<pair<int, int>>& bridges);
    bool isBridge(int u, int v, const vector<pair<int, int>>& bridges);
};

Graph::Graph(int vertices) : vertices(vertices), adjList(vertices) {}

void Graph::addEdge(int u, int v) {
    adjList[u].push_back(v);
    adjList[v].push_back(u);
}

void Graph::DFS(int u, vector<bool>& visited, vector<int>& disc, vector<int>& low, vector<int>& parent, vector<pair<int, int>>& bridges) {
    static int time = 0;

    visited[u] = true;
    disc[u] = low[u] = ++time;

    for (int v : adjList[u]) {
        if (!visited[v]) {
            parent[v] = u;
            DFS(v, visited, disc, low, parent, bridges);

            low[u] = min(low[u], low[v]);

            if (low[v] > disc[u])
                bridges.push_back({u, v});
        } else if (v != parent[u]) {
            low[u] = min(low[u], disc[v]);
        }
    }
}

bool Graph::isBridge(int u, int v, const vector<pair<int, int>>& bridges) {
    for (const auto& bridge : bridges) {
        if ((bridge.first == u && bridge.second == v) || (bridge.first == v && bridge.second == u)) {
            return true;
        }
    }
    return false;
}

bool Graph::is2EdgeConnected() {
    vector<bool> visited(vertices, false);
    vector<int> disc(vertices, -1);
    vector<int> low(vertices, -1);
    vector<int> parent(vertices, -1);
    vector<pair<int, int>> bridges;

    for (int i = 0; i < vertices; ++i) {
        if (!visited[i]) {
            DFS(i, visited, disc, low, parent, bridges);
        }
    }

    // Check connectivity after removing non-bridge edges
    for (int u = 0; u < vertices; ++u) {
        for (int v : adjList[u]) {
            if (!isBridge(u, v, bridges)) {
                // Temporarily remove the non-bridge edge (u, v)
                int temp = adjList[u].back();
                adjList[u].pop_back();
                int temp2 = adjList[v].back();
                adjList[v].pop_back();

                // Check connectivity
                vector<bool> tempVisited(vertices, false);
                DFS(0, tempVisited, disc, low, parent, bridges);
                for (bool visitedVertex : tempVisited) {
                    if (!visitedVertex) {
                        // Restore the edge and return false
                        adjList[u].push_back(temp);
                        adjList[v].push_back(temp2);
                        return false;
                    }
                }

                // Restore the removed edge
                adjList[u].push_back(temp);
                adjList[v].push_back(temp2);
            }
        }
    }

    // If the graph passes all checks, it is 2-edge-connected
    return true;
}

int main() {
    Graph g(4);
    g.addEdge(0, 1);
    g.addEdge(1, 2);
    g.addEdge(2, 3);
    g.addEdge(3, 0);

    if (g.is2EdgeConnected()) {
        cout << "The graph is 2-edge-connected." << endl;
    } else {
        cout << "The graph is not 2-edge-connected." << endl;
    }

    return 0;
}

```

## **Step-by-Step Explanation:**

1. **Graph Class:**
    - The `Graph` class is created to represent an undirected graph using an adjacency list.
2. **DFS Function:**
    - The `DFS` function is implemented to perform a depth-first search and identify bridges in the graph.
3. **Bridge Identification:**
    - The `DFS` function marks edges as bridges based on the low and discovery times.
4. **isBridge Function:**
    - The `isBridge` function checks if an edge is a bridge.
5. **is2EdgeConnected Function:**
    - The `is2EdgeConnected` function utilizes DFS and bridge identification to check the graph's 2-edge-connectedness.
    - It also checks the graph's connectivity after temporarily removing non-bridge edges.
6. **Main Function:**
    - The `main` function creates a graph, adds edges, and checks if the graph is 2-edge-connected.

# Program in `python`:

```python
class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adj_list = {v: [] for v in range(vertices)}
        self.edges = set()

    def add_edge(self, u, v):
        self.adj_list[u].append(v)
        self.adj_list[v].append(u)
        self.edges.add((u, v))

    def dfs(self, u, parent, visited, disc, low, bridges):
        visited[u] = True
        disc[u] = low[u] = self.time
        self.time += 1

        for v in self.adj_list[u]:
            if not visited[v]:
                self.dfs(v, u, visited, disc, low, bridges)

                low[u] = min(low[u], low[v])

                if low[v] > disc[u]:
                    bridges.add((u, v))
            elif v != parent:
                low[u] = min(low[u], disc[v])

    def is_2_edge_connected(self):
        visited = [False] * self.vertices
        disc = [float("inf")] * self.vertices
        low = [float("inf")] * self.vertices
        bridges = set()
        self.time = 0

        self.dfs(0, -1, visited, disc, low, bridges)

        if not bridges:
            return True  # No bridges, so the graph is 2-edge-connected

        for edge in self.edges:
            if edge not in bridges:
                u, v = edge
                self.edges.remove(edge)

                visited = [False] * self.vertices
                self.dfs(0, -1, visited, disc, low, set())

                self.edges.add(edge)

                if any(not visited[i] for i in range(self.vertices)):
                    return False  # Removing the edge disconnects the graph

        return True  # All edges were tested and the graph is 2-edge-connected

# Example usage:
if __name__ == "__main__":
    g = Graph(5)
    g.add_edge(0, 1)
    g.add_edge(1, 2)
    g.add_edge(2, 3)
    g.add_edge(3, 0)
    g.add_edge(1, 4)

    result = g.is_2_edge_connected()

    if result:
        print("The graph is 2-edge-connected.")
    else:
        print("The graph is not 2-edge-connected.")

```

## **Step-by-Step Explanation:**

1. **Initialization:**
    - The `Graph` class is initialized with an adjacency list and a set to store edges.
2. **Adding Edges:**
    - Edges are added to the graph using the `add_edge` method.
3. **Depth-First Search (DFS):**
    - The `dfs` method performs a depth-first search to identify bridges in the graph.
4. **Bridges Identification:**
    - The set `bridges` stores identified bridges.
5. **Connectivity Check:**
    - The graph's connectivity is checked after temporarily removing each non-bridge edge.
6. **Result:**
    - The result is determined based on the presence of bridges and the connectivity check.

# Program in `java`:

```java
import java.util.ArrayList;
import java.util.List;

class Edge {
    int u, v;

    public Edge(int u, int v) {
        this.u = u;
        this.v = v;
    }
}

public class TwoEdgeConnectedGraph {

    private int vertices;
    private List<List<Integer>> adjList;

    public TwoEdgeConnectedGraph(int vertices) {
        this.vertices = vertices;
        this.adjList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public boolean is2EdgeConnected() {
        int[] discoveryTime = new int[vertices];
        int[] low = new int[vertices];
        boolean[] visited = new boolean[vertices];

        int time = 0;

        // DFS from the first vertex (can be any vertex)
        dfs(0, -1, discoveryTime, low, visited, time);

        // Check for any unvisited vertex, indicating disconnected components
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    private void dfs(int current, int parent, int[] discoveryTime, int[] low, boolean[] visited, int time) {
        visited[current] = true;
        discoveryTime[current] = low[current] = ++time;

        for (int neighbor : adjList.get(current)) {
            if (!visited[neighbor]) {
                dfs(neighbor, current, discoveryTime, low, visited, time);

                low[current] = Math.min(low[current], low[neighbor]);

                if (low[neighbor] > discoveryTime[current]) {
                    // (current, neighbor) is a bridge
                    return;
                }
            } else if (neighbor != parent) {
                low[current] = Math.min(low[current], discoveryTime[neighbor]);
            }
        }
    }

    public static void main(String[] args) {
        // Example usage
        TwoEdgeConnectedGraph graph = new TwoEdgeConnectedGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        boolean is2EdgeConnected = graph.is2EdgeConnected();
        System.out.println("Is the graph 2-edge-connected? " + is2EdgeConnected);
    }
}

```

## **Step-by-step Explanation:**

1. **Class Setup:**
    - `Edge` class represents an edge between two vertices.
    - `TwoEdgeConnectedGraph` class is the main class for the graph.
2. **Graph Initialization:**
    - Constructor initializes the graph with the specified number of vertices.
3. **Adding Edges:**
    - `addEdge` method adds an undirected edge between two vertices.
4. **DFS for Bridge Identification:**
    - `dfs` method performs a depth-first search (DFS) to identify bridges (cut edges) in the graph.
5. **DFS Initialization:**
    - Arrays `discoveryTime`, `low`, and `visited` are used to keep track of DFS information.
6. **Bridge Identification:**
    - The algorithm identifies bridges during the DFS traversal.
7. **Connectivity Check:**
    - After DFS, check if any vertex is unvisited, indicating disconnected components.
8. **Main Method:**
    - Creates an example graph, adds edges, and checks whether it is 2-edge-connected.

This Java program uses Tarjan's algorithm for finding bridges in an undirected graph. The `is2EdgeConnected` method returns `true` if the graph is 2-edge-connected and `false` otherwise.

# Time and Space Complexities:

### Time Complexity:

### C++:

- The time complexity is often determined by the DFS traversal and the bridge identification process.
- Assuming an adjacency list representation for the graph:
    - DFS: O(V + E) where V is the number of vertices and E is the number of edges.
    - Identifying bridges: O(V + E)
- The overall time complexity is typically O(V + E).

### Python:

- Python has similar complexities to C++ for the DFS traversal and bridge identification.
- The time complexity is often O(V + E).

### Java:

- Similar to C++ and Python, the time complexity is dominated by the DFS traversal and bridge identification.
- The time complexity is typically O(V + E).

### Space Complexity:

### C++:

- The space complexity involves storing the adjacency list and additional data structures for DFS.
- Assuming an adjacency list representation:
    - O(V + E) for the graph representation.
    - O(V) for the DFS recursive call stack.
- The overall space complexity is typically O(V + E).

### Python:

- Python has similar space complexities to C++.
- O(V + E) for the graph representation and O(V) for the DFS recursive call stack.

### Java:

- Similar to C++ and Python, the space complexity involves storing the graph and DFS data structures.
- O(V + E) for the graph representation.
- O(V) for the DFS recursive call stack.
- The overall space complexity is typically O(V + E).

# Real Time Applications:

1. **Network Reliability:**
    - In communication networks, ensuring 2-edge connectivity can enhance reliability. For example, in a telecommunications network, maintaining 2-edge connectivity ensures that the failure of a single communication link does not isolate any part of the network.
2. **Transportation Networks:**
    - In transportation systems, a 2-edge-connected graph ensures robustness. If each road or rail segment is considered an edge, ensuring 2-edge connectivity helps maintain alternate routes in case of road closures or disruptions.
3. **Power Distribution Grids:**
    - In power distribution systems, a 2-edge-connected graph helps ensure that the failure of a single power line does not lead to isolated segments. This is crucial for maintaining a reliable power supply to consumers.
4. **Circuit Board Design:**
    - In electronics, the concept of 2-edge connectivity is important for ensuring that the failure of a single connection (trace) on a circuit board does not result in the isolation of components.
5. **Emergency Evacuation Planning:**
    - In emergency management and evacuation planning, a 2-edge-connected road network ensures that there are alternative routes for evacuation in case certain roads become impassable due to disasters or accidents.
6. **Telecommunication Networks:**
    - In telecommunications, ensuring 2-edge connectivity helps maintain redundancy in the network, preventing the isolation of communication nodes or segments due to the failure of a single link.
7. **Water Supply Networks:**
    - In water supply systems, a 2-edge-connected graph helps ensure the reliability of water distribution by providing alternative paths in case of pipe failures or maintenance.
8. **Urban Planning:**
    - In urban planning, ensuring 2-edge connectivity in public transportation networks (e.g., bus routes) helps maintain service reliability in the event of disruptions.
9. **Internet and Data Networks:**
    - In computer networks, ensuring 2-edge connectivity is important for maintaining redundancy and fault tolerance, ensuring that the failure of a single communication link does not disrupt connectivity.
10. **Robotics and Autonomous Systems:**
    - In robotics, maintaining 2-edge connectivity in the connectivity map helps autonomous systems navigate and plan paths in dynamic environments by providing alternative routes.
