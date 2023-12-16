#include <bits/stdc++.h>
using namespace std;

class Graph
{
    int V;          // Number of vertices
    list<int> *adj; // Adjacency list to represent the graph

    // Utility function to find bridges using DFS traversal
    void bridgeUtil(int u, vector<bool> &visited, vector<int> &disc,
                    vector<int> &low, int parent);

public:
    Graph(int V);               // Constructor
    void addEdge(int v, int w); // Add an edge to the graph
    void bridge();              // Find and print all bridges
};

Graph::Graph(int V)
{
    this->V = V;
    adj = new list<int>[V];
}

void Graph::addEdge(int v, int w)
{
    adj[v].push_back(w);
    adj[w].push_back(v); // Graph is undirected
}

void Graph::bridgeUtil(int u, vector<bool> &visited, vector<int> &disc,
                       vector<int> &low, int parent)
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
            low[u] = min(low[u], disc[v]);
        }
        else
        {
            // Recur for the unvisited neighbor
            parent = u;
            bridgeUtil(v, visited, disc, low, parent);

            // Update the low value of u
            low[u] = min(low[u], low[v]);

            // Check for a bridge
            if (low[v] > disc[u])
                cout << u << " " << v << endl;
        }
    }
}

void Graph::bridge()
{
    vector<bool> visited(V, false);
    vector<int> disc(V, -1);
    vector<int> low(V, -1);

    int parent = -1; // No parent for the initial call

    // Call the recursive helper function for each unvisited vertex
    for (int i = 0; i < V; ++i)
    {
        if (!visited[i])
        {
            bridgeUtil(i, visited, disc, low, parent);
        }
    }
}

int main()
{
    cout << "\nBridges in the graph\n";
    Graph g1(5);
    g1.addEdge(1, 0);
    g1.addEdge(0, 2);
    g1.addEdge(2, 1);
    g1.addEdge(0, 3);
    g1.addEdge(3, 4);
    g1.bridge();

    return 0;
}
