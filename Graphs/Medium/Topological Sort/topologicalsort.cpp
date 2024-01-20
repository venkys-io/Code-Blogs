#include <iostream>
#include <vector>
#include <stack>
using namespace std;

void util(int v, vector<vector<int>>& graph, vector<bool>& visited, stack<int>& st) {
    visited[v] = true;
    for (int i : graph[v]) {
        if (!visited[i]) {
            util(i, graph, visited, st);
        }
    }
    st.push(v); // Add the current vertex to the stack
}

void topologicalsort(vector<vector<int>>& graph) {
    int n = graph.size();
    vector<bool> visited(n, false);
    stack<int> st;
    for (int i = 0; i < n; i++) {
        if (!visited[i]) {
            util(i, graph, visited, st);
        }
    }
    while (!st.empty()) {
        cout << st.top() << " "; // Print the top element of the stack
        st.pop(); // Remove the top element from the stack
    }
    cout << endl;
}

int main() {
    int vertices;
    cout << "Enter the number of vertices: ";
    cin >> vertices;

    vector<vector<int>> graph(vertices);

    for (int i = 0; i < vertices; i++) {
        int num_neighbors;
        cout << "Enter the number of neighbors for vertex " << i << ": ";
        cin >> num_neighbors;

        graph[i].resize(num_neighbors);

        cout << "Enter neighbors for vertex " << i << ": ";
        for (int j = 0; j < num_neighbors; j++) {
            cin >> graph[i][j];
        }
    }

    topologicalsort(graph);

    return 0;
}