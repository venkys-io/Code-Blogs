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