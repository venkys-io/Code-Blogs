#include <iostream>
#include <vector>
#include <queue>
#include <climits>
#include <unordered_map>

using namespace std;

typedef pair<int, int> Edge;  // pair representing (weight, destination vertex)

void dijkstra(const unordered_map<int, vector<Edge>>& graph, int start, unordered_map<int, int>& distances, unordered_map<int, int>& predecessors) {
    priority_queue<Edge, vector<Edge>, greater<Edge>> pq;  // Min-heap to get the minimum distance

    distances[start] = 0;
    pq.push({0, start});

    while (!pq.empty()) {
        int current_vertex = pq.top().second;
        int current_distance = pq.top().first;
        pq.pop();

        // If current distance is greater than the known distance, skip
        if (current_distance > distances[current_vertex]) {
            continue;
        }

        // Explore neighbors
        for (const Edge& neighbor : graph.at(current_vertex)) {
            int neighbor_vertex = neighbor.second;
            int weight = neighbor.first;
            int distance = current_distance + weight;

            // If a shorter path is found, update the distance and predecessor
            if (distance < distances[neighbor_vertex]) {
                distances[neighbor_vertex] = distance;
                predecessors[neighbor_vertex] = current_vertex;
                pq.push({distance, neighbor_vertex});
            }
        }
    }
}

void printPath(const unordered_map<int, int>& predecessors, int target) {
    vector<int> path;
    int current = target;
    while (current != -1) {
        path.insert(path.begin(), current);
        current = predecessors.at(current);
    }

    cout << "Shortest path: ";
    for (int vertex : path) {
        cout << vertex << " -> ";
    }
    cout << "\b\b  \n";
}

int main() {
    unordered_map<int, vector<Edge>> graph;

    // Taking user-defined input for the graph
    int numEdges;
    cout << "Enter the number of edges: ";
    cin >> numEdges;

    cout << "Enter the edges (source destination weight):\n";
    for (int i = 0; i < numEdges; ++i) {
        int source, destination, weight;
        cin >> source >> destination >> weight;
        graph[source].push_back({weight, destination});
        // Assuming an undirected graph
        graph[destination].push_back({weight, source});
    }

    int startNode, endNode;
    cout << "Enter the start node: ";
    cin >> startNode;
    cout << "Enter the end node: ";
    cin >> endNode;

    // Initialize distances and predecessors
    unordered_map<int, int> distances, predecessors;
    for (const auto& pair : graph) {
        distances[pair.first] = INT_MAX;
        predecessors[pair.first] = -1;  // -1 represents no predecessor
    }

    dijkstra(graph, startNode, distances, predecessors);

    if (distances[endNode] != INT_MAX) {
        cout << "Shortest distance from " << startNode << " to " << endNode << ": " << distances[endNode] << endl;
        printPath(predecessors, endNode);
    } else {
        cout << "There is no path from " << startNode << " to " << endNode << "." << endl;
    }

    return 0;
}
