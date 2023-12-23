# DETECTING CYCLE IN A GRAPH.....
# Introduction
Decrypting a cycle in a graph involves understanding how to identify and interpret cycles within the graph structure. A cycle in a graph is a closed path where the start and end vertices are the same, and it passes through distinct vertices without revisiting any vertex (except for the starting and ending vertex).
Other way of explanation
The detection of cycles in a graph involves identifying if there's a closed loop (cycle) formed by traversing through the vertices and edges of the graph. Cycles can provide insights into connectivity or dependencies within a graph structure.

# Step-by-step Solution with Real-world Scenario
 - Initialize an empty set to store the visited vertices and a stack to store the current path.
 - Start at an arbitrary vertex in the graph.
 - Mark the current vertex as visited and push it onto the current path stack.
 - For each neighboring vertex, if it is not visited, recursively perform DFS. If the neighboring vertex is part of the current path, a cycle is detected.
 - Pop the current vertex from the current path stack, as we are backtracking.

# Overview of Detecting Cycles in a Graph:
  - Graph Representation:
      Graphs consist of vertices (nodes) and edges (connections between nodes).
      The detection of cycles typically applies to both directed and undirected graphs.
  - Objective:
      The primary goal is to identify whether a graph contains any cycles.
  - Algorithms:
      Various algorithms tackle this problem, including Depth-First Search (DFS), Breadth-First Search (BFS), and Union-Find (Disjoint Set).
      DFS explores the graph depth-wise, marking visited nodes and backtracking when necessary to find cycles.
      Union-Find maintains sets of connected components and tracks if adding an edge forms a cycle.
  - Traversing and Marking:
      During traversal, algorithms mark visited nodes or use data structures to keep track of visited vertices.
      These methods detect when a vertex is revisited, indicating the existence of a cycle.
  - Cycle Identification:
      Detecting a cycle involves recognizing a closed loop, meaning traversal leads back to a previously visited vertex, forming a cycle.
  - Complexities:
      The time complexity for cycle detection algorithms varies:
      DFS and BFS generally have a complexity of O(V + E), where V represents vertices and E represents edges.
      Union-Find often performs with a similar time complexity.
  - Applications:
      Crucial in various domains like network analysis, project scheduling, software engineering, and resource allocation.
      Helps identify and prevent circular dependencies or loops that might cause issues in systems.
  - Importance:
      Plays a critical role in understanding the structure of graphs and preventing unintended or problematic connections.
      Facilitates error detection, loop avoidance, and efficient resource allocation.


# Algorithm:

        (1) Create data structures to track visited nodes and parent nodes during the traversal. This can be done using arrays, sets, or dictionaries.
        (2) Start a DFS traversal from any unvisited node in the graph.
            During the traversal, mark each visited node and keep track of the parent node that led to the current node.
        (3) During the DFS traversal, if you encounter an already visited node that is not the parent of the current node, you have detected a back edge.
        (4) The presence of a back edge indicates the existence of a cycle in the graph.
        (5) Once a back edge is detected, backtrack from the current node to the node where the back edge was found.
            The nodes encountered during the backtracking form the cycle.
        (6) Extract and store the cycle found during the backtracking process. The cycle is now decrypted from the graph.
        (7) If there are unvisited nodes in the graph, repeat the DFS traversal starting from an unvisited node to identify and decrypt additional cycles.

# Advantages :
        Simple Implementation
        Memory Efficiency
        Flexibility

# Drawbacks : 
        Limited to Undirected Graphs
        May Detect One Cycle
        Performance for Dense Graphs

####   PYTHON Code   ####
```python

class Graph:
    def __init__(self, vertices):
        # Initialize graph with a given number of vertices
        self.vertices = vertices
        # Graph represented as an adjacency list
        self.graph = {i: [] for i in range(vertices)}

    def add_edge(self, u, v):
        # Check for null safety before adding an edge
        if u is not None and v is not None:
            # Add an edge between vertices u and v (undirected graph)
            self.graph[u].append(v)
            self.graph[v].append(u)

    def is_cyclic_util(self, node, visited, parent):
        visited[node] = True  # Mark the current node as visited
        for neighbor in self.graph[node]:
            if neighbor is not None:  # Null safety check
                if not visited[neighbor]:
                    # If neighbor not visited, perform DFS recursively
                    if self.is_cyclic_util(neighbor, visited, node):
                        return True
                elif neighbor != parent:
                    # If neighbor visited and not parent (back edge), cycle found
                    return True
        return False

    def is_cyclic(self):
        visited = [False] * self.vertices  # Initialize visited array for all vertices
        for node in range(self.vertices):
            if not visited[node] and self.is_cyclic_util(node, visited, -1):
                # If node not visited and contains a cycle, return True
                return True
        return False  # No cycle found in the graph

def main():
    # Input vertices and edges
    vertices = int(input("Enter the number of vertices: "))
    graph = Graph(vertices)
    
    # Adding edges to the graph
    edges = int(input("Enter the number of edges: "))
    for _ in range(edges):
        u, v = map(int, input("Enter edge (u, v): ").split())
        graph.add_edge(u, v)
    
    # Perform cycle detection and print result
    result = graph.is_cyclic()
    print("Cycle present:", result)

if __name__ == "__main__":
    main()
```

# Clear Explnanation
  Let's break down the code:

   - Graph Class:
     - __init__ Method: Initializes the graph with a given number of vertices. The graph is represented as an adjacency list (self.graph) where each vertex is a key in the dictionary, and its value is an empty list representing edges.
     - add_edge Method: Adds an undirected edge between two vertices u and v to the graph. It performs a null safety check and appends the vertices to each other's adjacency lists.
     - is_cyclic_util Method: A utility method used by is_cyclic. Performs Depth-First Search (DFS) recursively to detect cycles within the graph. It marks nodes as visited and checks for cycles using a recursive approach.
     - is_cyclic Method: Initializes a visited array, performs DFS traversal on each unvisited node, and calls the utility method is_cyclic_util to check for cycles. Returns True if a cycle is found; otherwise, returns False.
   - main Function:
     - Takes User Input: Asks for the number of vertices and edges in the graph through standard input.
     - Creates Graph: Initializes a Graph object with the specified number of vertices.
     - Adds Edges: Takes input for edges and adds them to the graph using the add_edge method.
     - Performs Cycle Detection: Calls the is_cyclic method to detect cycles in the graph and prints whether a cycle is present or not.
   - Overall Flow:
     - Input: User inputs the number of vertices and edges for the graph.
     - Graph Initialization: A graph object is created with the specified number of vertices.
     - Edge Addition: Edges are added to the graph according to user input.
     - Cycle Detection: The code checks for cycles in the graph using DFS.
     - Output: Prints whether a cycle is present in the graph based on the detected result.

#    JAVA Code   

```java
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
```


# Java Code Explanation:
    - Main Class:
      - dfs Method: A Depth-First Search function that checks for cycles in the graph. It recursively traverses the graph and marks visited nodes. If a node is already visited and it's not the parent (back edge), it indicates a cycle.
      - isCycle Method: Checks if there's any cycle in the provided graph by iterating through all nodes and calling the dfs method for unvisited nodes.
      - main Method: The entry point of the program. It prompts the user to input the number of vertices and edges. Then, it takes input for edge connections and constructs an adjacency list representing the graph. Finally, it invokes isCycle to determine if a cycle exists and prints the result.
    - Input and Processing:
      - Vertex and Edge Input: Prompts the user to enter the number of vertices and edges in the graph via the console (System.in).
      - Graph Representation: Constructs an adjacency list (graph) using an ArrayList of ArrayLists. Each index in the outer list represents a vertex, and the inner list contains its adjacent vertices.
      - Edge Connections Input: Takes user input for the edges, assuming a 0-based indexing system, and adds connections between vertices in the adjacency list.
      - Cycle Detection: Uses Depth-First Search to traverse the graph and detect cycles.
      - Output: Prints whether the provided graph contains a cycle or not based on the detected result.
    - Key Enhancements:
      - STDIN Usage: Utilizes Scanner to receive input from the user via the console.
      - Null Safety: Ensures the input is within the range of vertices to avoid potential IndexOutOfBoundsException.
      - Comments: The code includes comments that explain the purpose and functionality of each significant section or method.
# Key Points:
        - The code represents the graph using an adjacency list (ArrayList<ArrayList<Integer>>).
        - dfs() performs DFS traversal and cycle detection in the graph.
        - isCycle() initiates DFS from unvisited nodes and returns true if any cycle is found.
        - The main() method demonstrates the usage by creating a sample graph and checking for cycles.


#    C++ Code    
```c++
#include <iostream>
#include <vector>

// Depth-first search(dfs) function to check for cycles in the graph
bool dfs(int node, std::vector<std::vector<int>>& graph, bool visited[], int parent) {
    visited[node] = true;  // Mark the current node as visited

    for (int neighbour : graph[node]) {
        if (!visited[neighbour]) {
            // If the neighbour is not visited, recursively call DFS
            if (dfs(neighbour, graph, visited, node))
                return true;
        } else if (neighbour != parent) {
            // If the neighbour is visited and not the parent (back edge), a cycle is found
            return true;
        }
    }
    return false;  // No cycle found for the current node
}

// Function to check whether the graph contains a cycle
bool isCycle(std::vector<std::vector<int>>& graph) {
    int v = graph.size();
    bool visited[v]{false};  // Initialize visited array for all vertices

    for (int i = 0; i < v; i++) {
        if (!visited[i] && dfs(i, graph, visited, -1)) {
            // If the node is not visited and contains a cycle, return true
            return true;
        }
    }
    return false;  // No cycle found in the graph
}

int main() {
    // Input vertices and edges from STDIN (assumed format)
    int numVertices, numEdges;
    std::cin >> numVertices >> numEdges;

    // Create an adjacency list to represent the graph
    std::vector<std::vector<int>> graph(numVertices);

    // Input edges
    for (int i = 0; i < numEdges; ++i) {
        int u, v;
        std::cin >> u >> v;
        // Assuming vertices are 0-indexed
        graph[u].push_back(v);
        graph[v].push_back(u); // For an undirected graph
    }

    // Check and print whether the graph contains a cycle
    std::cout << isCycle(graph);

    return 0;
}
```


# C++ Code Explanation:
     - Libraries
       - <iostream> and <vector>: Standard C++ libraries for input/output and managing dynamic arrays.
     - Functions
       - dfs: Performs a Depth-First Search traversal on the graph, marking visited nodes and detecting cycles by tracking back edges.
       - isCycle: Initiates the cycle detection process by traversing through all nodes in the graph and calling dfs if the node hasn't been visited.
     - Main Function
       - Input: Reads the number of vertices and edges from standard input (std::cin).
       - Graph Representation: Constructs an adjacency list (std::vector<std::vector<int>>) to represent the graph.
       - Input Edges: Reads edge connections from input and populates the adjacency list.
       - Cycle Detection: Executes isCycle(graph) to check for cycles in the input graph.
       - Output: Prints the result (1 if a cycle is detected, 0 otherwise) to the standard output (std::cout).
     - Workflow
       - The code expects input in the format of the number of vertices followed by the number of edges. Then it reads pairs of vertices representing edges.
       - It constructs an adjacency list where each vertex maintains a list of its adjacent vertices.
       - The DFS algorithm visits each node to detect cycles in the graph by traversing edges and marking visited nodes.
       - The main function prints 1 if a cycle is present and 0 if the graph is cycle-free.
     - Assumptions
       - Assumes the input format is correct (vertices, edges, edge connections) and that the vertices are 0-indexed.
# Key Points:
   - The code represents the graph using a vector of vectors (std::vector<std::vector<int>>).
   - dfs() performs DFS traversal and cycle detection in the graph.
   - isCycle() initiates DFS from unvisited nodes and returns true if any cycle is found.
   - The main() method demonstrates the usage by creating a sample graph and checking for cycles.
   - This C++ code utilizes a DFS-based approach to identify cycles in an undirected graph. It employs an adjacency list to represent the graph structure and detects cycles by traversing the graph using DFS.


# Time Complexities of Detecting Cycle in a Graph 
        - Worst Case : O(V + E)
        - Best Case : O(1)
        - Average Case : O(V + E)
        The time complexity of cycle detection algorithms varies based on the approach used. 
        For DFS-based cycle detection in a graph with 'V' vertices and 'E' edges, the complexity 
        is typically O(V + E). Union-Find-based algorithms often have a similar time complexity.

# Uses : 
        Graph Theory
        Compiler Design
        Network Routing
        Data Validation
        Circuit Design

# Real-time applications:
        - Software Engineering: Detecting cycles in dependency graphs helps manage software modules or libraries with interdependent relationships.
        - Networking: Identifying cycles in network topologies assists in avoiding routing loops in communication networks.
        - Resource Allocation: Graphs representing resource allocation can avoid circular allocations through cycle detection.
# Summary:
        - Cycle detection in a graph involves identifying closed loops or cycles formed by traversing through vertices and edges.
        - Various algorithms like DFS or Union-Find are used to detect cycles efficiently.
        - It's crucial in various domains, especially in scenarios where avoiding circular dependencies or loops is essential, like project scheduling, software engineering, or network management.
