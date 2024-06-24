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
