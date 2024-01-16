# Breadth First Search

## Introduction to Breadth First Search

Breadth First Search (BFS) is an algorithm used to traverse or search tree or graph data structures. It starts at the root node (or an arbitrary node in a graph) and explores all the neighboring nodes at the current depth before moving on to nodes at the next depth level.

BFS uses a queue data structure to keep track of the nodes to be visited. It visits all the nodes at the current level before moving to the next level. This algorithm is useful for finding the shortest path between two nodes in an unweighted graph.

BFS can be implemented using iterative or recursive approaches. It guarantees that all the nodes at a certain depth will be visited before moving on to deeper levels.

Overall, BFS is a versatile algorithm that finds wide applications in various domains, including network routing, web crawling, and social network analysis.

## Overview of Breadth First Search

Here's a high-level overview of how BFS works:

1. **Queue Data Structure:** BFS uses a queue to keep track of the vertices to be visited. The algorithm starts by enqueueing the initial or source vertex.
2. **Visited Set:** Maintain a set or array to keep track of visited vertices to avoid revisiting them.
3. **Traversal:** While the queue is not empty, dequeue a vertex and visit it. For each unvisited neighbor of the current vertex, enqueue it and mark it as visited.
4. **Level Order Traversal:** BFS naturally produces a level order traversal of the graph, meaning it visits all the vertices at level 1 before moving on to level 2, and so on.

Here's a step-by-step breakdown:

- Enqueue the starting vertex into the queue and mark it as visited.
- Dequeue a vertex from the queue, visit it, and enqueue all its unvisited neighbors.
- Repeat the process until the queue is empty.


## Code:

#### Python

```Python
/* Copyrights to venkys.io
For more information, visit https://venkys.io */

// Python program for performing Breadth First Search
// Stable: No
// Inplace: No
// Adaptive: No

// Space complexity: O(V+E)
// Time complexity: O (V+E)
# program to traverse the graph using BFS
# Function takes graph as a input parameters

from collections import defaultdict

def BFS(graph):
    queue = []  # Is used to implement the BFS logic
    visited = []  # Is used to store visited vertices
    first = list(graph.keys())[0]
    queue.append(first)
    while queue:
        for vertex in graph[queue[0]]:
            if vertex not in visited and vertex not in queue:
                queue.append(vertex)
        visited.append(queue.pop(0))
    return visited

# Test drive code:
graph = defaultdict(list)

vertices = int(input("Enter the number of vertices: "))
edges = int(input("Enter the number of edges: "))

print("Enter edges (format: source destination):")
for _ in range(edges):
    source, destination = map(int, input().split())
    graph[source].append(destination)

print("The BFS traversal of the graph is:", BFS(graph))

```

**step by step explaination**

- Here's a step-by-step explanation of the provided code:

1. The code begins by defining the `BFS` function, which takes a `graph` as input.
2. Inside the function, an empty `queue` and `visited` list are initialized.
3. The starting vertex of the graph is obtained by extracting the first key from the `graph` dictionary.
4. The starting vertex is enqueued into the `queue` and marked as visited.
5. The main loop begins, which continues as long as the `queue` is not empty.
6. For each vertex in the adjacency list of the vertex at the front of the `queue`, the following steps are performed:
    - If the vertex has not been visited and is not already in the `queue`, it is enqueued.
7. The vertex at the front of the `queue` is dequeued and added to the `visited` list.
8. The process continues until the `queue` is empty.
9. Finally, the `visited` list is returned, which represents the order in which the vertices were visited during the BFS traversal.

This implementation of BFS ensures that all the vertices are visited in a breadth-first manner, meaning that vertices at the same level are visited before moving on to deeper levels.

The provided code demonstrates the BFS traversal for a sample graph, which is represented using an adjacency list. The graph has four vertices (0, 1, 2, and 3) with corresponding adjacency lists. The BFS traversal of this graph is printed as the output of the code.

It's important to note that the given code is written in Python and assumes a basic understanding of data structures and control flow in the Python programming language.


## CODE:

#### Java

```java
/* Copyrights to venkys.io
For more information, visit https://venkys.io */

// Python program for performing Breadth First Search
// Stable: No
// Inplace: No
// Adaptive: No

// Space complexity: O(V+E)
// Time complexity: O (V+E)

import java.util.*;

public class Main {
    private int v;
    private LinkedList<Integer> lst[];

    // Create a graph
    Main(int ver) {
        v = ver;
        lst = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            lst[i] = new LinkedList<>();
        }
    }

    // Add edges to the graph
    public void addEdge(int ver, int ele) {
        lst[ver].add(ele);
    }

    // BFS algorithm
    public void bfs(int s) {
        boolean[] visited = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while (queue.size() != 0) {
            // Removing and printing the removed element
            s = queue.poll();
            System.out.print(s + " ");
            // Iterating the graph
            Iterator<Integer> i = lst[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // Driver code
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        Main obj = new Main(vertices);

        System.out.println("Enter the edges in the format (vertex1 vertex2), enter -1 -1 to stop:");
        while (true) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            if (vertex1 == -1 && vertex2 == -1) {
                break;
            }
            obj.addEdge(vertex1, vertex2);
        }

        System.out.print("Enter the starting vertex for BFS: ");
        int startVertex = scanner.nextInt();

        System.out.println("The Breadth First Traversal of the graph is as follows (from " + startVertex + "th vertex):");
        obj.bfs(startVertex);

        scanner.close();
    }
}

```

**Step by step explaination:**

The code provided implements the breadth-first traversal algorithm in Java. Let's break down the code structure and understand each component:

1. Class Declaration: The code starts with the declaration of the `Main` class.
2. Instance Variables: The class has two instance variables: `v` (number of vertices) and `lst` (an array of linked lists to represent the graph).
3. Constructor: The constructor initializes the instance variables and creates an empty linked list for each vertex.
4. `addEdge` Method: This method is used to add edges between vertices in the graph. It takes two parameters: `ver` (the vertex to which the edge is added) and `ele` (the element to be added).
5. `bfs` Method: This method implements the breadth-first traversal algorithm. It takes a starting vertex `s` as a parameter and performs the traversal. It uses a boolean array `visited` to keep track of visited vertices and a queue `queue` to store the vertices to be visited.
6. `main` Method: The `main` method is the entry point of the program. It creates an instance of the `Main` class, adds edges to the graph, and calls the `bfs` method to perform the breadth-first traversal.



## CODE:

#### CPP

```cpp
/* Copyrights to venkys.io
For more information, visit https://venkys.io */

// Python program for performing Breadth First Search
// Stable: No
// Inplace: No
// Adaptive: No

// Space complexity: O(V+E)
// Time complexity: O (V+E)

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
```

**Step by step explaination:**

The code provided consists of a `Graph` class that represents a graph and implements the BFS algorithm. Here's a breakdown of the code structure:

1. `Graph` class: This class represents a graph and contains the following members:
    - `size`: An integer variable that stores the number of vertices in the graph.
    - `graph`: A 2D vector that represents the adjacency list of the graph.
    - `addEdge` function: This function is used to add an edge between two vertices in the graph.
    - `bfs` function: This function performs the BFS traversal of the graph starting from a given vertex.
2. `main` function: This is the entry point of the program. It creates an instance of the `Graph` class, adds edges to the graph, and calls the `bfs` function to perform the BFS traversal starting from vertex 2.


## Test Cases
### Test Case 1(Empty graph):
#### sample input:
1. no.of vertices=0
2. no.of vertices=0
#### sample output:
1. The BFS traversal of the graph is: []

### Test Case 2(Connected Graph):
#### sample input:
1. no.of vertices=4
2. no.of edges=3
3. Enter edges (format: source destination):
- 0 1
- 1 2
- 2 3
#### sample output(Disconnected Graph):
1. The BFS traversal of the graph is: [0, 1, 2, 3]

### Test Case 3:
#### sample input:
1. no.of vertices=5
2. no.of edges=3
3. Enter edges (format: source destination):
- 0 1
- 2 3
- 4 4
#### sample output:
1. The BFS traversal of the graph is: [0, 1, 2, 3, 4]

### Explanation of Testcases:
- In first case, the graph is empty, so the BFS traversal should result in an empty list of visited vertices.
- In second case, the graph is a connected path, so the BFS traversal should visit all vertices in the order 0, 1, 2, 3.
- In third case, the graph is disconnected, but the BFS traversal still visits all vertices in the order 0, 1, 2, 3, 4. The disconnected component (vertex 4) is also included in the traversal.



**Time and Space Complexity Analysis:**

The time and space complexity of Breadth-First Search (BFS) depends on the representation of the graph.

### **Time Complexity:**

- **Adjacency List Representation:** If the graph is represented using an adjacency list, the time complexity of BFS is *O*(*V*+*E*), where *V* is the number of vertices, and *E* is the number of edges. In the worst case, every vertex and every edge is explored.
- **Adjacency Matrix Representation:** If the graph is represented using an adjacency matrix, the time complexity is *O*(*V*2), where *V* is the number of vertices. This is because, in the worst case, every vertex is connected to every other vertex.

### **Space Complexity:**

- **Adjacency List Representation:** The space complexity of BFS using an adjacency list is *O*(*V*+*E*) due to the space required for the adjacency list and the queue used for BFS traversal.
- **Adjacency Matrix Representation:** The space complexity of BFS using an adjacency matrix *O*(*V*2) since it requires a matrix of size *V*×*V* to represent the graph, and additional space is needed for the queue.

In summary, the choice of graph representation affects both time and space complexity. Adjacency lists are generally more space-efficient, especially for sparse graphs, and result in a more favorable time complexity. However, the actual performance can also be influenced by the specific implementation details and the efficiency of the data structures used (e.g., the queue implementation).

## Real-World Applications of Breadth First Search

Breadth First Search (BFS) has numerous applications in real-world scenarios. Some of the common applications include:

1. **Social Network Analysis:** BFS can be used to explore social networks and analyze relationships between individuals. It helps identify mutual friends, find the shortest path between two users, and analyze network structures.
2. **Web Crawling:** BFS is used by web crawlers to discover and index web pages. It starts at a given page and follows links to other pages, ensuring that all pages within a certain depth are visited before moving deeper into the website.
3. **Network Routing:** BFS is used in network routing algorithms to find the shortest path between source and destination nodes. It helps optimize data transmission and reduce latency in computer networks.
4. **Puzzle Solving:** BFS can be used to solve puzzles such as the sliding tile puzzle or the 8-puzzle problem. It explores different states and finds the shortest path to the solution.
5. **Game AI:** BFS is commonly used in game development for pathfinding and game AI. It helps characters navigate game environments efficiently and find optimal routes.
6. **Recommendation Systems:** BFS can be utilized in recommendation systems to find similar items or users based on their relationships or preferences. It helps make personalized recommendations and improve user experience.

These are just a few examples of how BFS is applied in various domains. Its ability to explore data structures in a systematic and efficient manner makes it a valuable algorithm in many problem-solving scenarios.