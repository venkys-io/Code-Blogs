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

def main():
    # Take input for the graph
    graph = {}
    n = int(input("Enter the number of vertices: "))
    for i in range(n):
        vertex = int(input(f"Enter neighbors for vertex {i}: "))
        neighbors = list(map(int, input().split()))
        graph[vertex] = neighbors

    # Call DFS function and print the result
    print("The DFS traversal of the graph is:", DFS(graph))

if __name__ == "__main__":
    main()

```

<h2>Step-by-Step Explanation:</h2>

1.Import Libraries:
The code doesn't require any external libraries, so there are no import statements.

2.Define DFS Function:

DFS(graph): This function performs Depth-First Search on a graph.
stack: A stack is used to keep track of vertices to be visited.
visited: A list to store visited vertices.
first: Selects the first vertex in the graph as the starting point.
stack.append(first): Adds the starting vertex to the stack.

3.DFS Traversal:

while stack:: This loop continues until the stack is empty.
current_vertex = stack.pop(): Pops the top vertex from the stack.
visited.append(current_vertex): Marks the current vertex as visited.

4.Explore Neighbors:

for neighbor in graph[current_vertex]:: Iterates through neighbors of the current vertex.
if neighbor not in stack and neighbor not in visited:: Checks if the neighbor is not already in the stack or visited.
stack.append(neighbor): Adds the neighbor to the stack for further exploration.

5.Return Visited List:

return visited: Returns the list of visited vertices after DFS traversal.

6.Define Main Function:

main(): Takes input for the graph and calls the DFS function.
graph = {}: Initializes an empty dictionary to represent the graph.

7.Input Graph:

n = int(input("Enter the number of vertices: ")): Takes the number of vertices as input.
for i in range(n):: Loops through each vertex to input neighbors.
vertex = int(input(f"Enter neighbors for vertex {i}: ")): Takes the vertex as input.
neighbors = list(map(int, input().split())): Takes a list of neighbors as input.
graph[vertex] = neighbors: Adds the vertex and its neighbors to the graph.

8.Call DFS Function:

print("The DFS traversal of the graph is:", DFS(graph)): Calls the DFS function and prints the result.

9.Run Main Function:

if __name__ == "__main__":: Ensures that the main() function is executed when the script is run.

10.Execution:

The script is executed, prompting the user to input the graph information.
DFS is performed on the input graph.
The DFS traversal result is printed.

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
        // Take input for the graph
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Enter neighbors for vertex " + i + ": ");
            int vertex = scanner.nextInt();
            List<Integer> neighbors = new ArrayList<>();

            // Input neighbors for the current vertex
            while (scanner.hasNextInt()) {
                neighbors.add(scanner.nextInt());
            }

            graph.put(vertex, neighbors);
        }

        // Close the scanner to prevent resource leaks
        scanner.close();

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
#include <vector>
#include <unordered_map>
#include <stack>
#include <algorithm>

// Function to perform DFS traversal on a graph
std::vector<int> dfs(const std::unordered_map<int, std::vector<int>>& graph) {
    std::stack<int> dfsStack;  // Used to implement the DFS logic
    std::vector<int> visited;   // Used to store visited vertices

    // Choose the first vertex in the graph as the starting point
    int first = graph.begin()->first;
    dfsStack.push(first);

    while (!dfsStack.empty()) {
        int currentVertex = dfsStack.top();  // Get the top vertex from the stack
        dfsStack.pop();
        visited.push_back(currentVertex);    // Mark the current vertex as visited

        // Explore neighbors of the current vertex
        for (int neighbor : graph.at(currentVertex)) {
            // Check if the neighbor is not already in the stack or visited
            if (std::find(dfsStack.begin(), dfsStack.end(), neighbor) == dfsStack.end() &&
                std::find(visited.begin(), visited.end(), neighbor) == visited.end()) {
                dfsStack.push(neighbor);
            }
        }
    }

    return visited;
}

int main() {
    // Take input for the graph
    int numVertices;
    std::cout << "Enter the number of vertices: ";
    std::cin >> numVertices;

    std::unordered_map<int, std::vector<int>> graph;
    for (int i = 0; i < numVertices; ++i) {
        int vertex, numNeighbors;
        std::cout << "Enter vertex " << i << " and the number of neighbors: ";
        std::cin >> vertex >> numNeighbors;

        std::vector<int> neighbors(numNeighbors);
        std::cout << "Enter the neighbors for vertex " << i << ": ";
        for (int j = 0; j < numNeighbors; ++j) {
            std::cin >> neighbors[j];
        }

        graph[vertex] = neighbors;
    }

    // Perform DFS traversal
    std::vector<int> dfsTraversal = dfs(graph);

    // Print the DFS traversal result
    std::cout << "The DFS traversal of the graph is: ";
    for (int vertex : dfsTraversal) {
        std::cout << vertex << " ";
    }

    return 0;
}

```

<h2>Step-By-Step Explanation:</h2>

1Include Headers:

#include <iostream>
#include <vector>
#include <unordered_map>
#include <stack>
#include <algorithm>
Include necessary C++ standard library headers for input/output, vectors, unordered_map, stack, and algorithm.

2.DFS Function:

std::vector<int> dfs(const std::unordered_map<int, std::vector<int>>& graph) {
    // Function code...
}
Define a function named dfs that takes an unordered_map representing the graph and returns a vector of integers (the DFS traversal result).
The function uses a stack to implement the DFS logic and a vector to store visited vertices.

3.DFS Logic:

int first = graph.begin()->first;
dfsStack.push(first);
Choose the first vertex in the graph as the starting point and push it onto the stack.

4.DFS Traversal Loop:

while (!dfsStack.empty()) {
    int currentVertex = dfsStack.top();
    dfsStack.pop();
    // DFS logic...
}
Continue the loop until the stack is empty.
Pop the top vertex from the stack and mark it as visited.

5.Explore Neighbors:

for (int neighbor : graph.at(currentVertex)) {
    // Check if the neighbor is not already in the stack or visited
    if (std::find(dfsStack.begin(), dfsStack.end(), neighbor) == dfsStack.end() &&
        std::find(visited.begin(), visited.end(), neighbor) == visited.end()) {
        dfsStack.push(neighbor);
    }
}
Iterate through the neighbors of the current vertex.
Check if the neighbor is not already in the stack or visited, then push it onto the stack.

6.Main Function:

int main() {
    // Main function code...
}
Entry point of the program.

7.Take Input for the Graph:

int numVertices;
std::cout << "Enter the number of vertices: ";
std::cin >> numVertices;
Prompt the user to enter the number of vertices.

8.Build the Graph:

std::unordered_map<int, std::vector<int>> graph;
// Loop to input vertices and neighbors...
Use an unordered_map to represent the graph.
Prompt the user to enter each vertex and its neighbors.

9.Perform DFS Traversal:

std::vector<int> dfsTraversal = dfs(graph);
Call the dfs function to perform DFS traversal on the input graph.

10.Print DFS Traversal Result:

std::cout << "The DFS traversal of the graph is: ";
for (int vertex : dfsTraversal) {
    std::cout << vertex << " ";
}
Print the DFS traversal result.

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
