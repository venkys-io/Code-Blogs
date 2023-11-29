# DETECTING CYCLE IN A GRAPH.....
# Introduction
Decrypting a cycle in a graph involves understanding how to identify and interpret cycles within the graph structure. A cycle in a graph is a closed path where the start and end vertices are the same, and it passes through distinct vertices without revisiting any vertex (except for the starting and ending vertex).
Other way of explanation
The detection of cycles in a graph involves identifying if there's a closed loop (cycle) formed by traversing through the vertices and edges of the graph. Cycles can provide insights into connectivity or dependencies within a graph structure.

# Step-by-step Solution with Real-world Scenario
Initialize an empty set to store the visited vertices and a stack to store the current path.
Start at an arbitrary vertex in the graph.
Mark the current vertex as visited and push it onto the current path stack.
For each neighboring vertex, if it is not visited, recursively perform DFS. If the neighboring vertex is part of the current path, a cycle is detected.
Pop the current vertex from the current path stack, as we are backtracking.

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


# Step-by-Step Algorithm:

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
        # Constructor initializes the graph with a given number of vertices
        self.vertices = vertices
        # Graph represented as an adjacency list
        self.graph = {i: [] for i in range(vertices)}

    def add_edge(self, u, v):
        # Method to add an undirected edge between vertices u and v
        self.graph[u].append(v)
        self.graph[v].append(u)

    def is_cyclic_util(self, node, visited, parent):
        # Utility function to perform DFS and detect cycles starting from a given node
        visited[node] = True  # Mark the current node as visited
        for neighbor in self.graph[node]:  # Iterate through neighbors of the current node
            if not visited[neighbor]:  # If the neighbor is not visited
                if self.is_cyclic_util(neighbor, visited, node):  # Recursive DFS call
                    return True  # If a cycle is found in the recursive call, return True
            elif neighbor != parent:  # If the neighbor is visited and not the parent (back edge)
                return True  # Cycle is found, return True
        return False  # No cycle found for the current node

    def is_cyclic(self):
        # Method to check if the graph contains any cycles
        visited = [False] * self.vertices  # Initialize visited array for all vertices
        for node in range(self.vertices):  # Iterate through all nodes in the graph
            if not visited[node] and self.is_cyclic_util(node, visited, -1):  # If the node is not visited and contains a cycle
                return True  # Return True indicating the presence of a cycle
        return False  # No cycle found in the graph

# Example usage:
graph = Graph(4)  # Create a graph with 4 vertices
graph.add_edge(0, 1)  # Add edges to the graph
graph.add_edge(1, 2)
graph.add_edge(1, 3)

print(graph.is_cyclic())  # Check and print whether the graph contains a cycle
```
### Output
![Alt text](../Outputs/DCGPY.png)

# Clear Explnanation
        - Graph Class
                __init__(self, vertices): Initializes the graph with a given number of vertices.
                self.vertices: Stores the number of vertices.
                self.graph: Represents the graph as an adjacency list using a dictionary.
        - Methods:
                add_edge(self, u, v):
                Adds an undirected edge between vertices u and v in the graph.
        - is_cyclic_util(self, node, visited, parent):
                Utility function to perform Depth-First Search (DFS) and detect cycles starting from a given node.
                visited: An array marking nodes as visited or not.
                parent: Tracks the parent node during traversal to identify back edges (cycles).
                Uses recursive DFS to traverse the graph.
        - is_cyclic(self):
                Checks if the graph contains any cycles.
                Initializes visited array for all vertices.
                Iterates through all nodes and calls is_cyclic_util for unvisited nodes.
                Returns True if any cycle is detected, otherwise False.
        - Example Usage:
                Creates a Graph object with 4 vertices.
                Adds edges between vertices (0-1), (1-2), and (1-3).
                Checks and prints whether the graph contains a cycle using the is_cyclic() method.
        - Explanation:
                The graph is represented using an adjacency list.
                add_edge() method populates this list by adding edges between vertices.
                The is_cyclic_util() method utilizes DFS to traverse the graph.
                It marks nodes as visited, explores neighboring nodes, and identifies cycles by checking for back edges.
                The is_cyclic() method initiates DFS from unvisited nodes and returns True if any cycle is found, otherwise False.


#    JAVA Code   

```java
import java.util.ArrayList;
import java.util.List;

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
        // Create an adjacency list to represent the graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>() {{
            add(new ArrayList<>(List.of(1, 3)));  // Neighbors of node 0
            add(new ArrayList<>(List.of(0, 3)));  // Neighbors of node 1
            add(new ArrayList<>(List.of(0)));     // Neighbors of node 2
            add(new ArrayList<>(List.of(1)));     // Neighbors of node 3
        }};

        System.out.println(isCycle(graph));  // Check and print whether the graph contains a cycle
    }
}
```
### Output
![Alt text](../Outputs/DCGJAVA.png)


# Java Code Explanation:
        dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited, int parent)
        - This method performs a Depth-First Search (DFS) starting from a given node in the graph.
        - visited array is used to keep track of visited nodes.
        - The method iterates through the neighbors of the current node.
        - If a neighbor is not visited, it recursively calls dfs() on that neighbor.
        - It detects cycles by identifying back edges when a neighbor is visited and is not the parent.
        isCycle(ArrayList<ArrayList<Integer>> graph)
        - This method checks if there's any cycle in the graph using DFS.
        - It initializes a visited array to keep track of visited nodes.
        - Iterates through all nodes and calls dfs() on unvisited nodes to detect cycles.
        - Returns true if any cycle is detected, otherwise false.
        main()
        - Initializes an adjacency list (graph) representing the graph structure.
        - The graph has 4 nodes (0, 1, 2, 3) with corresponding edges.
        - Calls isCycle(graph) to check whether the graph contains a cycle and prints the result.
# Key Points:
        - The code represents the graph using an adjacency list (ArrayList<ArrayList<Integer>>).
        - dfs() performs DFS traversal and cycle detection in the graph.
        - isCycle() initiates DFS from unvisited nodes and returns true if any cycle is found.
        - The main() method demonstrates the usage by creating a sample graph and checking for cycles.


#    C++ Code    
```c++
#include<bits/stdc++.h>

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
    // Create an adjacency list to represent the graph
    std::vector<std::vector<int>> graph = {
        {1, 2},
        {0, 3},
        {0},
        {1}
    };

    std::cout << isCycle(graph);  // Check and print whether the graph contains a cycle
    return 0;
}
```
### Output
![Alt text](../Outputs/DCGC++.png)

# C++ Code Explanation:
        dfs(int node, std::vector<std::vector<int>>& graph, bool visited[], int parent)
        - This function performs Depth-First Search (DFS) starting from a given node in the graph.
        - visited array is used to track visited nodes.
        - It iterates through the neighbors of the current node using the adjacency list (graph).
        - Recursively explores unvisited neighbors and checks for cycles using back edges.
        isCycle(std::vector<std::vector<int>>& graph)
        - This function checks if there's any cycle in the graph using DFS.
        - Initializes a visited array to track visited nodes.
        - Iterates through all nodes and calls dfs() on unvisited nodes to detect cycles.
        - Returns true if any cycle is detected, otherwise false.
        main()
        - Creates an adjacency list (graph) representing the graph structure.
        - The graph has 4 nodes (0, 1, 2, 3) with corresponding edges.
        - Calls isCycle(graph) to check whether the graph contains a cycle and prints the result.
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
        The time complexity of cycle detection algorithms varies based on the approach used. For DFS-based cycle detection in a graph with 'V' vertices and 'E' edges, the complexity is typically O(V + E). Union-Find-based algorithms often have a similar time complexity.

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
