#include <iostream>
#include <list>
#include <vector>

class Graph
{
    int V;               // Number of vertices
    std::list<int> *adj; // Adjacency list to represent the graph

    // Utility function to find bridges using DFS traversal
    void bridgeUtil(int u, std::vector<bool> &visited, std::vector<int> &disc,
                    std::vector<int> &low, int parent);

public:
    Graph(int V);               // Constructor
    void addEdge(int v, int w); // Add an edge to the graph
    void bridge();              // Find and print all bridges
};

Graph::Graph(int V)
{
    this->V = V;
    adj = new std::list<int>[V];
}

void Graph::addEdge(int v, int w)
{
    adj[v].push_back(w);
    adj[w].push_back(v); // Graph is undirected
}

void Graph::bridgeUtil(int u, std::vector<bool> &visited, std::vector<int> &disc,
                       std::vector<int> &low, int parent)
{
    static int time = 0; // Static variable for simplicity

    // Mark the current node as visited
    visited[u] = true;

    // Initialize discovery time and low value
    disc[u] = low[u] = ++time;

    // Explore all neighbors of the current node
    for (int v : adj[u])
    {
        if (v == parent) // Skip the edge to the parent
            continue;

        if (visited[v])
        {
            // If v is already visited, update the low value of u
            low[u] = std::min(low[u], disc[v]);
        }
        else
        {
            // Recur for the unvisited neighbor
            bridgeUtil(v, visited, disc, low, u);

            // Update the low value of u
            low[u] = std::min(low[u], low[v]);

            // Check for a bridge and store it
            if (low[v] > disc[u])
                std::cout << "Bridge: " << u << " " << v << std::endl;
        }
    }
}

void Graph::bridge()
{
    std::vector<bool> visited(V, false);
    std::vector<int> disc(V, -1);
    std::vector<int> low(V, -1);

    std::cout << "\nBridges in the graph:\n";

    // Call the recursive helper function for each unvisited vertex
    for (int i = 0; i < V; ++i)
    {
        if (!visited[i])
        {
            bridgeUtil(i, visited, disc, low, -1);
        }
    }
}

int main()
{
    int vertices, edges;
    std::cout << "Enter the number of vertices: ";
    std::cin >> vertices;

    std::cout << "Enter the number of edges: ";
    std::cin >> edges;

    std::cout << "\nEnter the edges (format: vertex1 vertex2):\n";
    Graph g(vertices);
    for (int i = 0; i < edges; ++i)
    {
        int v, w;
        std::cin >> v >> w;
        g.addEdge(v, w);
    }

    g.bridge();

    return 0;
}

// Enter the number of vertices: 8
// Enter the number of edges: 10
// Enter the edges (format: vertex1 vertex2):
// 0 1
// 1 2
// 2 0
// 1 3
// 3 4
// 4 5
// 5 3
// 6 7
// 7 6
// 5 6
// Bridges in the graph:
// 6 7
// 5 6
// 1 3