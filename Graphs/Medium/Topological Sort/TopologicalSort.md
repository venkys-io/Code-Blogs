# Topological Sort

## Introduction to Topological Sort

Topological sort is a useful algorithm in graph theory that orders the vertices of a directed graph in such a way that for every directed edge (u, v), vertex u comes before vertex v in the ordering. It is often used to solve problems that have dependencies between tasks or events.

The algorithm starts by identifying vertices with no incoming edges and adds them to the sorted list. Then, it removes these vertices and their outgoing edges from the graph. This process is repeated until all vertices have been processed.

Topological sort has applications in various fields, such as project management, task scheduling, and resolving dependencies in software development. It helps identify the order in which tasks or events should be executed to satisfy all dependencies.

## Overview of Topological Sort

Topological sort is an algorithm used in graph theory to order the vertices of a directed graph based on their dependencies. It is commonly used in project management, task scheduling, and software development to determine the order of execution for tasks or events while satisfying all dependencies.

The algorithm begins by identifying vertices without incoming edges and adding them to the sorted list. These vertices are then removed, along with their outgoing edges, from the graph. This process repeats until all vertices have been processed, resulting in a sorted order that satisfies the dependencies of the graph.

By applying topological sort, we can effectively manage dependencies and ensure that tasks or events are executed in the correct order, optimizing efficiency and avoiding conflicts.

**Code:**

```python
def util(v, graph, visited, stack):
    visited[v] = True 
    for i in graph[v]:
        if not visited[i]:
            util(i, graph, visited, stack)
    stack.append(v)

def topological_sort(graph):
    visited = [False] * len(graph)
    stack = []

    for i in range(len(graph)):
        if not visited[i]:
            util(i, graph, visited, stack)

    print(stack[::-1])

if __name__ == "__main__":
    graph = {}

    print("Enter the number of vertices: ")
    vertices = int(input())

    for i in range(vertices):
        print(f"Enter the neighbors of vertex {i} separated by space (or press Enter for no neighbors):")
        neighbors = list(map(int, input().split()))
        graph[i] = neighbors

    topological_sort(graph)

```

**Step-by-Step Explanation**

1. Start by initializing the graph and the visited array. In this case, the graph is represented as a dictionary where the keys are the vertices and the values are lists of the adjacent vertices.
2. Define the utility function **util(v, graph, visited, stack)** that performs a depth-first search (DFS) traversal of the graph starting from vertex **v**. In this function, mark the current vertex as visited and recursively call the **util()** function for all unvisited adjacent vertices.
3. Define the **topologicalsort(graph)** function that implements the topological sort algorithm. Initialize an empty stack and iterate through all the vertices of the graph. For each unvisited vertex, call the **util()** function to perform a DFS traversal and add the visited vertices to the stack.
4. Finally, print the contents of the stack in reverse order to obtain the topological sorting of the graph.

The given code demonstrates the implementation of the topological sort algorithm in Python. It uses a depth-first search approach to traverse the graph and build the sorted order.

By executing the **topologicalsort(graph)** function on the given graph, the output will be the topological sorting of the vertices: **[5, 4, 0, 2, 3, 1]**. This represents the order in which the tasks or events should be executed to satisfy all dependencies in the graph.


**Code:**

```java

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Scanner;

public class tsort {
    // Comment: This method performs a depth-first search traversal of the graph starting from vertex v.
    public static void util(int v, List<List<Integer>> graph, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (int i : graph.get(v)) {
            if (!visited[i]) {
                util(i, graph, visited, stack);
            }
        }
        stack.push(v);
    }

    // Comment: This method performs a topological sort on the given graph.
    public static void topologicalsort(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                util(i, graph, visited, stack);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            System.out.print("Enter neighbors of vertex " + i + " separated by space (or press Enter for no neighbors): ");
            List<Integer> neighbors = new ArrayList<>();
            String[] input = scanner.nextLine().split("\\s+");
            for (String neighbor : input) {
                neighbors.add(Integer.parseInt(neighbor));
            }
            graph.add(neighbors);
        }

        topologicalsort(graph);

        scanner.close();
    }
}



```

**Step-by-Step Explanation**
1. The code provided implements the topological sort algorithm using a depth-first search (DFS) approach. Here's a breakdown of the code structure:

2. The util method is a recursive helper function that performs the DFS traversal and pushes the visited vertices onto a stack.

3. The topologicalsort method initializes the necessary data structures and iterates through each vertex in the graph. If a vertex has not been visited, it calls the util method to perform the DFS traversal.

4. The main method creates a sample directed graph represented as a list of lists. Each inner list represents the outgoing edges from a vertex. Finally, it calls the topologicalsort method to obtain the topological ordering of the graph.



**Code:**

```cpp

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



```

**Step-by-Step Explanation**

1. The provided code consists of two main functions: util and topologicalsort, along with the main function.

2. util function: This function is a helper function used to perform a depth-first search (DFS) traversal of the graph and push the visited vertices onto a stack. It takes the following parameters:

- v: The current vertex being visited.
- graph: The adjacency list representation of the graph.
- visited: A boolean vector to keep track of visited vertices.
- st: A stack to store the topological ordering.
- topologicalsort function: This function initializes the necessary data structures and calls the util function for each unvisited vertex in the graph. After the DFS traversal is complete, it prints the vertices in the order they were pushed onto the stack.

- main function: This is the entry point of the program. It initializes a sample directed graph represented by an adjacency list and calls the topologicalsort function.


**Real world Applications of Topological Sort:**

Topological sort has numerous real-world applications across different domains. Here are some notable applications:

- **Task Scheduling**: Topological sort can be used to schedule tasks in project management. By representing tasks as vertices and dependencies as edges in a directed graph, topological sort helps determine the order in which tasks should be executed to meet project deadlines.
- **Course Prerequisites**: In academic settings, topological sort can help determine the sequence of courses that students need to take based on their prerequisites. By representing courses as vertices and prerequisites as edges, topological sort ensures that students take courses in the correct order.
- **Dependency Resolution**: In software development, topological sort can be used to resolve dependencies between modules or libraries. By representing dependencies as vertices and dependent modules as edges, topological sort helps determine the correct order of installation or compilation.
- **Event Scheduling**: Topological sort can assist in scheduling events that have dependencies. For example, in a conference with multiple sessions and speakers, topological sort can determine the order in which sessions should be scheduled to accommodate speaker availability and dependencies between sessions.
- **Build Systems**: Build systems, such as make or Ant, often use topological sort to determine the correct order of building components or tasks. By representing dependencies between components as a graph, topological sort ensures that components are built in the correct sequence.

These are just a few examples of how topological sort can be applied in real-world scenarios. Its ability to handle dependencies and determine the correct order of execution makes it a valuable algorithm in various fields.
