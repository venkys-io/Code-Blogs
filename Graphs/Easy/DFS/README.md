<h1>DEPTH FIRST SEARCH</h1>

DEPTH FIRST SEARCH (DFS) is a graph traversal algorithm that explores as far as possible along each branch before backtracking. It starts at a selected node (root) and explores as far as possible along each branch before backtracking.

<h2>INTRODUCTION</h2>

Depth First Search (DFS) is a graph traversal algorithm that is commonly used to traverse or search through a graph or tree data structure. It starts at a selected node, often referred to as the root, and explores as far as possible along each branch before backtracking.

DFS follows a depth-first approach, meaning it explores the deepest nodes of a graph or tree first before backtracking to explore other branches. This algorithm is often used to solve problems such as finding connected components, detecting cycles, and determining paths between nodes.

By employing a stack or recursion, DFS explores a graph or tree in a systematic manner, visiting each node and its adjacent nodes until all possible paths have been explored or a specific condition is met. This algorithm is widely used in various applications, including maze-solving, network analysis, and graph theory.

In summary, DFS is an efficient algorithm for traversing or searching through a graph or tree structure, providing a systematic way to explore all the nodes and their connections. Its depth-first approach makes it particularly useful for solving certain types of problems and analyzing complex data structures.

<h2>CODE</h2>
<h2>Python</h2>

```

#Copyrights to venkys.io
#For more programs visit venkys.io 
#Python program for DFS

def DFS(graph):
    stack = []   # Used to implement the DFS logic
    visited = []  # Used to store visited vertices
    first = list(graph.keys())[0]  # Choose the first vertex in the graph as the starting point
    stack.append(first)

    while stack:
        current_vertex = stack.pop()  # Pop the top vertex from the stack
        visited.append(current_vertex)  # Mark the current vertex as visited

        # Explore neighbors of the current vertex
        for neighbor in graph[current_vertex]:
            if neighbor not in stack and neighbor not in visited:
                stack.append(neighbor)

    return visited

# Test drive code:
graph = {
    0: [1, 2],
    1: [2],
    2: [0, 3],
    3: [3]
}

print("The DFS traversal of the graph is:", DFS(graph))

```

<h2>Step-by-Step Explanation:</h2>

1. **Initialization:**
    - stack : This is used as a stack to keep track of the vertices to be explored in the DFS traversal.
    - visited : This list is used to store the vertices that have been visited during the traversal.
    - first : The starting vertex is chosen as the first vertex in the graph (based on the assumption that the graph is non-empty).
2. **DFS Traversal:**
    - The DFS traversal starts with the chosen starting vertex. It is pushed onto the stack.
    - The traversal continues until the stack is empty.
    - In each iteration, the top vertex is popped from the stack (current_vertex), and it is marked as visited.
    - The neighbors of the current vertex that have not been visited or are not in the stack are added to the stack for further exploration.
3. **Return:**
    - The final result is the list of visited vertices, representing the DFS traversal order.
4. **Test Drive:**
    - The provided graph is an example graph with vertices 0, 1, 2, and 3, and their corresponding edges.
    - The DFS traversal is printed as the output.

<h2>JAVA</h2>

```
//Copyrights to venkys.io
//For more programs visit venkys.io 
//java program for DFS

import java.util.*;

public class DFSGraphTraversal {

    // Function to perform DFS traversal on a graph
    public static List<Integer> dfs(Map<Integer, List<Integer>> graph) {
        Stack<Integer> stack = new Stack<>();  // Used to implement the DFS logic
        List<Integer> visited = new ArrayList<>();  // Used to store visited vertices

        // Choose the first vertex in the graph as the starting point
        int first = new ArrayList<>(graph.keySet()).get(0);
        stack.push(first);

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();  // Pop the top vertex from the stack
            visited.add(currentVertex);  // Mark the current vertex as visited

            // Explore neighbors of the current vertex
            for (int neighbor : graph.get(currentVertex)) {
                if (!stack.contains(neighbor) && !visited.contains(neighbor)) {
                    stack.push(neighbor);
                }
            }
        }

        return visited;
    }

    public static void main(String[] args) {
        // Test drive code
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Collections.singletonList(2));
        graph.put(2, Arrays.asList(0, 3));
        graph.put(3, Collections.singletonList(3));

        // Perform DFS traversal
        List<Integer> dfsTraversal = dfs(graph);

        // Print the DFS traversal result
        System.out.print("The DFS traversal of the graph is: ");
        for (int vertex : dfsTraversal) {
            System.out.print(vertex + " ");
        }
    }
}

```

<h2>Step-by-Step Explanation:</h2>

1.Imports:

import java.util.*;: Importing necessary classes from the java.util package, including Stack, List, ArrayList, Map, HashMap, and Arrays.

2.Class Declaration:

public class DFSGraphTraversal {: Declares a class named DFSGraphTraversal.

3.DFS Function:

public static List<Integer> dfs(Map<Integer, List<Integer>> graph) {: Declares a function dfs that takes a graph represented as a map of integers to lists of integers.

4.Initialize Stack and Visited List:

Stack<Integer> stack = new Stack<>();: Creates a stack to implement DFS logic.
List<Integer> visited = new ArrayList<>();: Creates a list to store visited vertices.

5.Choose Starting Vertex:

int first = new ArrayList<>(graph.keySet()).get(0);: Chooses the first vertex in the graph as the starting point.

6.DFS Traversal Loop:

while (!stack.isEmpty()) {: Initiates a loop until the stack is empty.
int currentVertex = stack.pop();: Pops the top vertex from the stack.
visited.add(currentVertex);: Marks the current vertex as visited.

7.Explore Neighbors:

for (int neighbor : graph.get(currentVertex)) {: Iterates over the neighbors of the current vertex.
Checks if the neighbor is not in the stack and not visited before pushing it onto the stack.

8.Return Visited List:

return visited;: Returns the list of visited vertices after the DFS traversal.

9.Main Method:

public static void main(String[] args) {: Declares the main method for test drive.
Creates a graph using a Map with integer keys and lists of integers as values.
Calls the dfs function to perform DFS traversal.
Prints the DFS traversal result.

10.Print Result:

System.out.print("The DFS traversal of the graph is: ");: Prints a message.
Iterates over the DFS traversal result and prints each vertex.

NOTE: In Java, Map is used to represent the graph, and ArrayList and LinkedList are used to represent the lists of visited vertices and neighbors, respectively. The Stack class is used for the stack data structure.

<h2>CPP</h2>

```

//Copyrights to venkys.io
//For more programs visit venkys.io 
//CPP program for DFS

#include <iostream>
#include <unordered_map>
#include <vector>
#include <stack>

using namespace std;

// Function to perform DFS traversal on a graph
vector<int> dfs(const unordered_map<int, vector<int>>& graph) {
    stack<int> stk;    // Used to implement the DFS logic
    vector<int> visited; // Used to store visited vertices

    // Choose the first vertex in the graph as the starting point
    int first = graph.begin()->first;
    stk.push(first);

    // DFS traversal loop
    while (!stk.empty()) {
        int currentVertex = stk.top();  // Get the top vertex from the stack
        stk.pop();  // Pop the top vertex from the stack
        visited.push_back(currentVertex);  // Mark the current vertex as visited

        // Explore neighbors of the current vertex
        for (int neighbor : graph.at(currentVertex)) {
            // If neighbor is not in the stack and not visited, push it onto the stack
            if (find(stk.begin(), stk.end(), neighbor) == stk.end() &&
                find(visited.begin(), visited.end(), neighbor) == visited.end()) {
                stk.push(neighbor);
            }
        }
    }

    return visited;  // Return the list of visited vertices
}

int main() {
    // Test drive code
    unordered_map<int, vector<int>> graph = {
        {0, {1, 2}},
        {1, {2}},
        {2, {0, 3}},
        {3, {3}}
    };

    // Perform DFS traversal
    vector<int> dfsTraversal = dfs(graph);

    // Print the DFS traversal result
    cout << "The DFS traversal of the graph is: ";
    for (int vertex : dfsTraversal) {
        cout << vertex << " ";
    }

    return 0;
}

```

<h2>Step-by-Step Explanation:</h2>

1.Include Statements:

#include <iostream>: Includes the necessary header file for input/output operations.
#include <unordered_map>: Includes the header file for unordered maps.
#include <vector>: Includes the header file for vectors.
#include <stack>: Includes the header file for stacks.

2.Namespace:

using namespace std;: Declares that the code will be using the standard namespace.

3.DFS Function:

vector<int> dfs(const unordered_map<int, vector<int>>& graph) {: Declares a function dfs that takes an unordered map representing the graph and 	returns a vector of integers.

4.Initialize Stack and Visited List:

stack<int> stk;: Creates a stack to implement DFS logic.
vector<int> visited;: Creates a vector to store visited vertices.

5.Choose Starting Vertex:

int first = graph.begin()->first;: Chooses the first vertex in the graph as the starting point.
stk.push(first);: Pushes the starting vertex onto the stack.

6.DFS Traversal Loop:

while (!stk.empty()) {: Initiates a loop until the stack is empty.
int currentVertex = stk.top();: Gets the top vertex from the stack.
stk.pop();: Pops the top vertex from the stack.
visited.push_back(currentVertex);: Marks the current vertex as visited.

7.Explore Neighbors:

for (int neighbor : [graph.at](http://graph.at/)(currentVertex)) {: Iterates over the neighbors of the current vertex.
Checks if the neighbor is not in the stack and not visited before pushing it onto the stack.

8.Return Visited List:

return visited;: Returns the list of visited vertices after the DFS traversal.

9.Main Method:

int main() {: Declares the main method for test drive.
Creates an unordered map representing the graph.
Calls the dfs function to perform DFS traversal.
Prints the DFS traversal result.

10.Print Result:

"The DFS traversal of the graph is: " Prints a message.
Iterates over the DFS traversal result and prints each vertex.

<h2>OUTPUT</h2>

The DFS traversal of the graph is: 0 2 3 1

<h2>Time and Space complexity analysis:</h2>

The time complexity of the DFS traversal is O(V + E), where V is the number of vertices and E is the number of edges in the graph. Here's the breakdown:

Traversal Loop: The while loop iterates through all the vertices and edges, with each vertex and edge being processed once. This contributes O(V + E) to the time complexity.
Finding Neighbors: The for loop that iterates over the neighbors of the current vertex takes O(E) time in the worst case, where E is the number of edges.
The dominant factor is the traversal loop, making the overall time complexity O(V + E).

Space Complexity:
The space complexity is O(V), where V is the number of vertices. Here's why:

Stack: The stack is used to keep track of vertices to be visited. In the worst case, all vertices may be pushed onto the stack, contributing O(V) to the space complexity.
Visited List: The visited vector stores the visited vertices, which also takes O(V) space.
The overall space complexity is determined by the storage required for the vertices, making it O(V).

In summary, the provided DFS traversal code has a time complexity of O(V + E) and a space complexity of O(V).

<h2>Real-World Applications of Depth First Search:</h2>

Depth First Search (DFS) algorithm has various real-world applications in different domains. Some of the notable applications include:

1. **Maze Solving**: DFS can be used to solve mazes by exploring each possible path until the exit is found. It is often used in video games or puzzle-solving applications.
2. **Graph Traversal**: DFS is commonly used to traverse and explore graphs, especially when searching for specific nodes or paths. It helps in finding connected components, detecting cycles, and determining paths between nodes.
3. **Web Crawling**: DFS is used in web crawling or web scraping to navigate through websites and collect data. It allows the crawler to follow hyperlinks to new pages and explore the web in a systematic manner.
4. **Social Network Analysis**: DFS can be applied to analyze social networks by exploring connections between individuals or groups. It helps in identifying influential individuals, community detection, and studying the spread of information or diseases.
5. **Compiler Design**: DFS plays a crucial role in compiler design for tasks such as syntax analysis and code optimization. It helps in traversing abstract syntax trees and symbol tables to generate optimized code.
6. **Artificial Intelligence**: DFS is utilized in various AI algorithms, such as in-depth search algorithms for game-playing agents, constraint satisfaction problems, and planning algorithms.
7. **Image Processing**: DFS can be used in image processing tasks like region growing or connected component labeling. It helps in identifying and segmenting connected regions in an image.

These are just a few examples of the wide range of applications of the Depth First Search algorithm. DFS provides a powerful tool for exploring and analyzing various types of data structures and networks.
