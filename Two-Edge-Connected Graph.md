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
    void printGraph();

private:
    int vertices;
    vector<vector<int>> adjList;
};

Graph::Graph(int vertices) : vertices(vertices), adjList(vertices) {}

void Graph::addEdge(int u, int v) {
    // Adding edge from u to v
    adjList[u].push_back(v);

    // Adding edge from v to u (making it bidirectional)
    adjList[v].push_back(u);
}

void Graph::printGraph() {
    for (int i = 0; i < vertices; ++i) {
        cout << "Vertex " << i << ": ";
        for (int neighbor : adjList[i]) {
            cout << neighbor << " ";
        }
        cout << endl;
    }
}

int main() {
    int vertices, edges;
    
    // Input the number of vertices and edges
    cout << "Enter the number of vertices: ";
    cin >> vertices;
    
    cout << "Enter the number of edges: ";
    cin >> edges;

    Graph g(vertices);

    // Input edges
    cout << "Enter edges (format: u v):" << endl;
    for (int i = 0; i < edges; ++i) {
        int u, v;
        cin >> u >> v;
        g.addEdge(u, v);
    }

    // Print the double-edge graph
    cout << "Double-Edge Graph:" << endl;
    g.printGraph();

    return 0;
}


```

## **Step-by-Step Explanation:**

1. Include Header Files
```cpp
#include <iostream>
#include <vector>
using namespace std;
```
Include necessary header files for input/output and vector.

2. Define the Graph Class
```cpp
class Graph {
public:
    Graph(int vertices);
    void addEdge(int u, int v);
    void printGraph();
private:
    int vertices;
    vector<vector<int>> adjList;
};
```
Define a `Graph` class with public methods for adding edges and printing the graph. The private members include the number of vertices (`vertices`) and an adjacency list (`adjList`) to represent the graph.

3. Implement the Graph Constructor
```cpp
Graph::Graph(int vertices) : vertices(vertices), adjList(vertices) {}
```
Implement the constructor for the `Graph` class. It initializes the number of vertices and resizes the adjacency list vector to accommodate the given number of vertices.

4. Implement the `addEdge` Method
```cpp
void Graph::addEdge(int u, int v) {
    adjList[u].push_back(v);
    adjList[v].push_back(u); // Add the reverse edge for a double-edged graph
}
```
Implement the `addEdge` method to add an undirected edge between vertices `u` and `v`. Since it's a double-edged graph, the method adds the reverse edge as well.

5. Implement the `printGraph` Method
```cpp
void Graph::printGraph() {
    for (int i = 0; i < vertices; ++i) {
        cout << "Vertex " << i << " connected to:";
        for (int neighbor : adjList[i]) {
            cout << " " << neighbor;
        }
        cout << endl;
    }
}
```
Implement the `printGraph` method to print the adjacency list representation of the graph. It prints each vertex and its connected neighbors.

6. Implement the `main` Function
```cpp
int main() {
    int numVertices, numEdges;
    cout << "Enter the number of vertices and edges: ";
    cin >> numVertices >> numEdges;

    Graph g(numVertices);

    cout << "Enter the edges (format: u v):" << endl;
    for (int i = 0; i < numEdges; ++i) {
        int u, v;
        cin >> u >> v;
        g.addEdge(u, v);
    }

    cout << "Double-edged graph representation:" << endl;
    g.printGraph();

    return 0;
}
```
In the `main` function:
- Get the number of vertices and edges from the user.
- Create a `Graph` object `g` with the specified number of vertices.
- Prompt the user to enter edges and call `addEdge` for each edge.
- Print the adjacency list representation of the double-edged graph.

7. Example Input and Output
Example Input:
```
Enter the number of vertices and edges: 4 5
Enter the edges (format: u v):
0 1
1 2
2 3
3 0
0 2
```
Example Output:
```
Double-edged graph representation:
Vertex 0 connected to: 1 3 2
Vertex 1 connected to: 0 2
Vertex 2 connected to: 1 0 3
Vertex 3 connected to: 2 0
```


# Program in `python`:

```python
class DoubleEdgeGraph:
    def __init__(self):
        self.graph = {}

    def add_edge(self, u, v):
        if u not in self.graph:
            self.graph[u] = []
        if v not in self.graph:
            self.graph[v] = []

        self.graph[u].append(v)
        self.graph[v].append(u)

    def display_graph(self):
        for vertex, edges in self.graph.items():
            print(f"Vertex {vertex}: {edges}")

# Example Input
if __name__ == "__main__":
    # Create a double edge graph
    double_edge_graph = DoubleEdgeGraph()

    # Input the number of edges
    num_edges = int(input("Enter the number of edges: "))

    # Input edges
    for _ in range(num_edges):
        u, v = map(int, input("Enter edge (u v): ").split())
        double_edge_graph.add_edge(u, v)

    # Display the graph
    print("\nDouble Edge Graph:")
    double_edge_graph.display_graph()

```

### Step-by-Step Explanation:

1. **`DoubleEdgeGraph` Class:**
   - Defines a class `DoubleEdgeGraph` to represent a double edge graph.
   - The `__init__` method initializes an empty graph represented as a dictionary.

2. **`add_edge` Method:**
   - The `add_edge` method adds double edges to the graph.
   - Checks if vertices `u` and `v` are already in the graph; if not, adds them.
   - Appends `v` to the list of edges for vertex `u` and vice versa.

3. **`display_graph` Method:**
   - The `display_graph` method prints the vertices and their corresponding edges.

4. **Input Section:**
   - `if __name__ == "__main__":` ensures that the following code is executed only if the script is run directly, not if it's imported as a module.

5. **Create an Instance of `DoubleEdgeGraph`:**
   - Creates an instance of the `DoubleEdgeGraph` class named `double_edge_graph`.

6. **Input Number of Edges:**
   - Asks the user to input the number of edges in the graph.

7. **Input Edges:**
   - Uses a loop to iterate over the number of edges specified by the user.
   - For each iteration, takes input for the edge in the format "u v" and adds the double edge to the graph using the `add_edge` method.

8. **Display the Graph:**
   - Prints the double edge graph using the `display_graph` method.

9. **Example Input and Output:**
   - The user provides the number of edges (e.g., 4) and enters the edges (e.g., 0 1, 1 2, 2 3, 3 0) when prompted.
   - The program displays the resulting double edge graph.

10. **Final Output:**
   - Prints the vertices and their corresponding edges in the double edge graph.


# Program in `java`:

```java
import java.util.ArrayList;
import java.util.Scanner;

class Graph {
    private int vertices;
    private ArrayList<ArrayList<Integer>> adjList;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjList = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u); // Adding the reverse edge
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (int neighbor : adjList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}

public class DoubleEdgeGraphExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        Graph graph = new Graph(vertices);

        System.out.println("Enter edges (vertex pairs, -1 to stop):");
        while (true) {
            int u = scanner.nextInt();
            if (u == -1) break;
            int v = scanner.nextInt();
            if (v == -1) break;

            graph.addEdge(u, v);
        }

        System.out.println("Double Edge Graph:");
        graph.printGraph();
    }
}


```

## **Step-by-step Explanation:**

1. **Graph Class:**
   - `Graph` class represents an undirected graph using an adjacency list.
   - It has a constructor that initializes the number of vertices and creates an empty adjacency list for each vertex.

```java
class Graph {
    private int vertices;
    private ArrayList<ArrayList<Integer>> adjList;

    // Constructor
    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjList = new ArrayList<>(vertices);

        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Methods for adding edges and printing the graph
    // ...
}
```

2. **addEdge Method:**
   - The `addEdge` method adds an undirected edge between two vertices, updating the adjacency list for both vertices.

```java
    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u); // Adding the reverse edge
    }
```

3. **printGraph Method:**
   - The `printGraph` method prints the adjacency list representation of the graph.

```java
    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (int neighbor : adjList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}
```

4. **DoubleEdgeGraphExample Class (Main Class):**
   - `DoubleEdgeGraphExample` class contains the `main` method, which is the entry point of the program.
   - It creates a `Scanner` object to read user input.

```java
import java.util.Scanner;

public class DoubleEdgeGraphExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ...
    }
}
```

5. **User Input:**
   - The program prompts the user to enter the number of vertices.

```java
        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();
```

6. **Graph Initialization:**
   - It creates a `Graph` object with the specified number of vertices.

```java
        Graph graph = new Graph(vertices);
```

7. **Edge Input Loop:**
   - The program then prompts the user to enter edges (vertex pairs) until they enter `-1`.

```java
        System.out.println("Enter edges (vertex pairs, -1 to stop):");
        while (true) {
            int u = scanner.nextInt();
            if (u == -1) break;
            int v = scanner.nextInt();
            if (v == -1) break;

            graph.addEdge(u, v);
        }
```

8. **Print Graph:**
   - Finally, it prints the double-edge graph using the `printGraph` method.

```java
        System.out.println("Double Edge Graph:");
        graph.printGraph();
```

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
