#include<bits/stdc++.h>

using namespace std;

class Graph{
    
    public:
        int size;
        vector<vector<int>> graph;
        
        // Create a graph
        Graph(int v){
            size=v;
            graph.resize(v);
        }
        
        // Add edges to graph
        void addEdge(int v, int child){
            graph[v].push_back(child);
        }
        
        // BFS algorithm
        void bfs(int start){
            queue<int> q;
            vector<bool> visited(size, false);
            q.push(start);
            visited[start] = true;
            while (!q.empty()){    
               start = q.front();
               q.pop();
               cout << start << " ";
                for(auto it : graph[start]){
                    if(!visited[it]){
                        visited[it] = true;
                        q.push(it);
                    }
                }
            }
        }

};

// Driver code
int main(){
    int vertices, edges;
    cout << "Enter the number of vertices: ";
    cin >> vertices;

    Graph g(vertices);

    cout << "Enter the number of edges: ";
    cin >> edges;

    cout << "Enter edges (format: source destination):" << endl;
    for (int i = 0; i < edges; ++i){
        int source, destination;
        cin >> source >> destination;
        g.addEdge(source, destination);
    }

    int startVertex;
    cout << "Enter the starting vertex for BFS: ";
    cin >> startVertex;

    cout << "BFS starting from vertex " << startVertex << ": ";
    g.bfs(startVertex);

    return 0;
}