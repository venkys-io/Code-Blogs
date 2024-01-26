#include<bits/stdc++.h>

using namespace std;
// Function to implement Prim's algorithm for Minimum Spanning Tree
void prims(int** graph, int n) {
    bool* visited = new bool[n]{false}; // Array to keep track of visited vertices
    int edge_count = 0; // Variable to keep track of the number of edges in the MST
    int cost = 0; // Variable to store the total cost of the MST
    visited[0] = true; // Mark the first vertex as visited

    while (edge_count < n - 1) {
        int mini = INT_MAX; // Variable to store the minimum weight of an edge
        int x = 0; // Variable to store the first vertex of the edge with minimum weight
        int y = 0; // Variable to store the second vertex of the edge with minimum weight
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                for (int j = 0; j < n; j++) {
                    if (!visited[j] && graph[i][j] != 0) {
                        if (mini > graph[i][j]) {
                            mini = graph[i][j];
                            x = i;
                            y = j;
                        }
                    }
                }
            }
        }
        cout << "Edge pair is " << x << " " << y << " " << "Weight is " << graph[x][y] << endl; // Print the edge pair and its weight
        cost += graph[x][y]; // Add the weight of the edge to the total cost
        visited[y] = true; // Mark the second vertex of the edge as visited
        edge_count += 1; // Increment the edge count
    }
    cout << "The total cost of Prim's MST is " << cost; // Print the total cost of the MST
}

// Main function
int main() {
    int v;
    cout << "Enter the number of vertices: ";
    cin >> v;

    int** graph = new int*[v];
    for (int i = 0; i < v; i++) {
        graph[i] = new int[v];
    }

    cout << "Enter the adjacency matrix of the graph:" << endl;
    for (int i = 0; i < v; i++) {
        for (int j = 0; j < v; j++) {
            cin >> graph[i][j];
        }
    }

    prims(graph, v); // Call the prims function to find the MST

    // Free allocated memory
    for (int i = 0; i < v; i++) {
        delete[] graph[i];
    }
    delete[] graph;

    return 0;
}