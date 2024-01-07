# A Star Algorithm

## Problem Statement
The A* algorithm problem in graphs involves finding the shortest path from a starting node to a goal node while efficiently exploring the graph's nodes and edges. This algorithm is particularly useful for pathfinding and optimization in various applications, including robotics, gaming, and route planning.

## Introduction
The A* algorithm, a widely acclaimed pathfinding algorithm, addresses the intricate challenge of finding the most efficient route from a starting point to a goal within a graph. Standing at the crossroads of Dijkstra's algorithm and greedy best-first search, A* incorporates a heuristic function that intelligently guides exploration toward the most promising paths, balancing the pursuit of the optimal solution with computational efficiency. This algorithm plays a pivotal role in diverse fields, from robotics and gaming to route planning. 

By estimating the cost from the current node to the goal, A* excels in scenarios where both accuracy and speed are paramount. Its adaptability and effectiveness make it a go-to solution for applications requiring intelligent pathfinding, contributing significantly to advancements in autonomous systems, video games, and GPS navigation. As we delve into A*'s implementations in Java, Python, and C++, we unravel the intricacies of this algorithm and its real-world impact across a spectrum of industries.

## Overview
The A* algorithm in graphs is a versatile and widely used pathfinding algorithm that efficiently navigates through nodes and edges to find the shortest path from a starting point to a goal. By employing a heuristic function, A* intelligently explores potential paths, prioritizing those with lower estimated costs. This amalgamation of Dijkstra's algorithm and greedy best-first search enables A* to strike a balance between optimality and efficiency. Its application extends across diverse domains, including robotics, gaming, and route planning, where the algorithm's ability to determine the most promising paths makes it an invaluable tool for optimizing navigation and resource utilization in various real-world scenarios.
## Code
### Java Implementation
```java
/* Copyrights to venkys.io
For more information, visit https://venkys.io */

// Space complexity: O(E + V)
// Time complexity: O(E log E)
import java.util.*;

// Graph class represents a graph with weighted edges using an adjacency list
class Graph {
    Map<String, List<Pair<String, Integer>>> adjacencyList;

    // Constructor to initialize the graph with an adjacency list
    public Graph(Map<String, List<Pair<String, Integer>>> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    // Method to get neighbors of a given node
    public List<Pair<String, Integer>> getNeighbors(String v) {
        return adjacencyList.get(v);
    }

    // Heuristic function with equal values for all nodes
    public int h(String n) {
        // Heuristic values for each node
        Map<String, Integer> H = new HashMap<>();
        H.put("A", 1);
        H.put("B", 1);
        H.put("C", 1);
        H.put("D", 1);

        // Return the heuristic value for the given node, defaulting to 0 if not found
        return H.getOrDefault(n, 0);
    }

    // A* algorithm to find the shortest path from startNode to stopNode
    public List<String> aStarAlgorithm(String startNode, String stopNode) {
        Set<String> openList = new HashSet<>();
        Set<String> closedList = new HashSet<>();

        Map<String, Integer> g = new HashMap<>();
        g.put(startNode, 0);

        Map<String, String> parents = new HashMap<>();
        parents.put(startNode, startNode);

        openList.add(startNode);

        // A* algorithm loop
        while (!openList.isEmpty()) {
            String n = null;

            // Find a node with the lowest value of f() - evaluation function
            for (String v : openList) {
                if (n == null || g.getOrDefault(v, Integer.MAX_VALUE) + h(v) < g.getOrDefault(n, Integer.MAX_VALUE) + h(n)) {
                    n = v;
                }
            }

            // If no node is found, the path does not exist
            if (n == null) {
                System.out.println("Path does not exist!");
                return null;
            }

            // If the current node is the stopNode, reconstruct the path
            if (n.equals(stopNode)) {
                List<String> reconstPath = new ArrayList<>();

                while (!n.equals(startNode)) {
                    reconstPath.add(n);
                    n = parents.get(n);
                }

                reconstPath.add(startNode);
                Collections.reverse(reconstPath);

                System.out.println("Path found: " + reconstPath);
                return reconstPath;
            }

            // Explore neighbors of the current node
            for (Pair<String, Integer> neighbor : getNeighbors(n)) {
                String m = neighbor.getKey();
                int weight = neighbor.getValue();

                // If the current node isn't in both openList and closedList
                if (!openList.contains(m) && !closedList.contains(m)) {
                    openList.add(m);
                    parents.put(m, n);
                    g.put(m, g.getOrDefault(n, 0) + weight);
                } else {
                    // Check if it's quicker to first visit n, then m
                    if (g.getOrDefault(m, Integer.MAX_VALUE) > g.getOrDefault(n, Integer.MAX_VALUE) + weight) {
                        g.put(m, g.getOrDefault(n, 0) + weight);
                        parents.put(m, n);

                        if (closedList.contains(m)) {
                            closedList.remove(m);
                            openList.add(m);
                        }
                    }
                }
            }

            // Remove n from the openList and add it to closedList
            openList.remove(n);
            closedList.add(n);
        }

        System.out.println("Path does not exist!");
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get start and stop nodes from user input
        String startNode = scanner.next();
        String stopNode = scanner.next();

        // Example adjacency list
        Map<String, List<Pair<String, Integer>>> adjacencyList = new HashMap<>();
        List<Pair<String, Integer>> neighborsA = Arrays.asList(new Pair<>("B", 1), new Pair<>("C", 3), new Pair<>("D", 7));
        List<Pair<String, Integer>> neighborsB = Collections.singletonList(new Pair<>("D", 5));
        List<Pair<String, Integer>> neighborsC = Collections.singletonList(new Pair<>("D", 12));

        adjacencyList.put("A", neighborsA);
        adjacencyList.put("B", neighborsB);
        adjacencyList.put("C", neighborsC);

        // Create a graph instance
        Graph graph1 = new Graph(adjacencyList);

        // Run A* algorithm to find the shortest path
        graph1.aStarAlgorithm(startNode, stopNode);
    }
}

// Pair class for representing key-value pairs
class Pair<K, V> {
    private final K key;
    private final V value;

    // Constructor to create a Pair
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // Getter method for the key
    public K getKey() {
        return key;
    }

    // Getter method for the value
    public V getValue() {
        return value;
    }
}

```

### Python Implementation
```python
# Copyrights to venkys.io
# For more information, visit https://venkys.io 

# Space complexity: O(E + V)
# Time complexity:  O(E log E)
from collections import deque

class Graph:
    # Class representing a graph with an A* algorithm implementation

    def __init__(self, adjacency_list):
        # Constructor to initialize the graph with an adjacency list
        self.adjacency_list = adjacency_list

    def get_neighbors(self, v):
        # Method to get neighbors of a given node
        return self.adjacency_list[v]

    def h(self, n):
        # Heuristic function with equal values for all nodes
        H = {
            'A': 1,
            'B': 1,
            'C': 1,
            'D': 1
        }
        return H[n]

    def a_star_algorithm(self, start_node, stop_node):
        # A* algorithm to find the shortest path from start_node to stop_node

        # open_list is a set of nodes that have been visited but whose neighbors haven't all been inspected; starts with the start node
        # closed_list is a set of nodes that have been visited, and whose neighbors have been inspected
        open_list = set([start_node])
        closed_list = set([])

        # g contains current distances from start_node to all other nodes; the default value (if not found in the map) is +infinity
        g = {}
        g[start_node] = 0

        # parents contain an adjacency map of all nodes
        parents = {}
        parents[start_node] = start_node

        while len(open_list) > 0:
            n = None

            # find a node with the lowest value of f() - evaluation function
            for v in open_list:
                if n is None or g[v] + self.h(v) < g[n] + self.h(n):
                    n = v

            if n is None:
                print('Path does not exist!')
                return None

            # if the current node is the stop_node, then reconstruct the path from it to the start_node
            if n == stop_node:
                reconst_path = []

                while parents[n] != n:
                    reconst_path.append(n)
                    n = parents[n]

                reconst_path.append(start_node)

                reconst_path.reverse()

                print('Path found: {}'.format(reconst_path))
                return reconst_path

            # for all neighbors of the current node do
            for (m, weight) in self.get_neighbors(n):
                # if the current node isn't in both open_list and closed_list
                # add it to open_list and note n as its parent
                if m not in open_list and m not in closed_list:
                    open_list.add(m)
                    parents[m] = n
                    g[m] = g[n] + weight

                # otherwise, check if it's quicker to first visit n, then m
                # and if it is, update parent data and g data
                # and if the node was in the closed_list, move it to open_list
                else:
                    if g[m] > g[n] + weight:
                        g[m] = g[n] + weight
                        parents[m] = n

                        if m in closed_list:
                            closed_list.remove(m)
                            open_list.add(m)

            # remove n from the open_list and add it to closed_list
            # because all of its neighbors were inspected
            open_list.remove(n)
            closed_list.add(n)

        print('Path does not exist!')
        return None

def main():
    # Main function to run the A* algorithm on a graph

    # Example adjacency list
    adjacency_list = {
        'A': [('B', 1), ('C', 3), ('D', 7)],
        'B': [('D', 5)],
        'C': [('D', 12)]
    }

    # Create a graph instance
    graph1 = Graph(adjacency_list)

    # Prompt user to input start and stop nodes
    start_node = str(input())
    stop_node = str(input())

    # Run the A* algorithm
    graph1.a_star_algorithm(start_node, stop_node)

if __name__ == "__main__":
    main()

```

### C++ Implementation
```cpp
/* Copyrights to venkys.io
For more information, visit https://venkys.io */

// Space complexity: O(E + V)
// Time complexity: O(E log E)

#include <iostream>
#include <unordered_set>
#include <unordered_map>
#include <vector>
#include <queue>
#include <algorithm> // Include for reverse function

using namespace std;

class Graph {
public:
    // Constructor to initialize the graph with an adjacency list
    Graph(unordered_map<char, vector<pair<char, int>>> adjacency_list) : adjacency_list(adjacency_list) {}

    // Get neighbors for a node
    vector<pair<char, int>> get_neighbors(char v) {
        return adjacency_list[v];
    }

    // Heuristic function with equal values for all nodes
    int h(char n) {
        unordered_map<char, int> H = {
            {'A', 1},
            {'B', 1},
            {'C', 1},
            {'D', 1}
        };

        return H[n];
    }

    // A* algorithm implementation
    vector<char> a_star_algorithm(char start_node, char stop_node) {
        unordered_set<char> open_list{start_node};
        unordered_set<char> closed_list;

        unordered_map<char, int> g{{start_node, 0}};
        unordered_map<char, char> parents{{start_node, start_node}};

        while (!open_list.empty()) {
            char n = '\0';

            // Find a node with the lowest value of f() - evaluation function
            for (char v : open_list) {
                if (n == '\0' || g[v] + h(v) < g[n] + h(n)) {
                    n = v;
                }
            }

            if (n == '\0') {
                cout << "Path does not exist!" << endl;
                return {};
            }

            // If the current node is the stop_node, reconstruct the path
            if (n == stop_node) {
                vector<char> reconst_path;

                while (parents[n] != n) {
                    reconst_path.push_back(n);
                    n = parents[n];
                }

                reconst_path.push_back(start_node);

                reverse(reconst_path.begin(), reconst_path.end());

                cout << "Path found: ";
                for (char node : reconst_path) {
                    cout << node << " ";
                }
                cout << endl;
                return reconst_path;
            }

            // For all neighbors of the current node
            for (auto& neighbor : get_neighbors(n)) {
                char m = neighbor.first;
                int weight = neighbor.second;

                // If the current node isn't in both open_list and closed_list
                if (open_list.find(m) == open_list.end() && closed_list.find(m) == closed_list.end()) {
                    open_list.insert(m);
                    parents[m] = n;
                    g[m] = g[n] + weight;
                } else {
                    // Otherwise, check if it's quicker to first visit n, then m
                    if (g[m] > g[n] + weight) {
                        g[m] = g[n] + weight;
                        parents[m] = n;

                        // If the node was in the closed_list, move it to open_list
                        if (closed_list.find(m) != closed_list.end()) {
                            closed_list.erase(m);
                            open_list.insert(m);
                        }
                    }
                }
            }

            // Remove n from the open_list, and add it to the closed_list
            open_list.erase(n);
            closed_list.insert(n);
        }

        cout << "Path does not exist!" << endl;
        return {};
    }

private:
    unordered_map<char, vector<pair<char, int>>> adjacency_list;
};

int main() {
    // Example adjacency list
    unordered_map<char, vector<pair<char, int>>> adjacency_list = {
        {'A', {{'B', 1}, {'C', 3}, {'D', 7}}},
        {'B', {{'D', 5}}},
        {'C', {{'D', 12}}}
    };

    // Create a graph instance
    Graph graph1(adjacency_list);

    // Prompt user to input start and stop nodes
    char start_node, stop_node;
    cin >> start_node;
    cin >> stop_node;

    // Run the A* algorithm
    graph1.a_star_algorithm(start_node, stop_node);

    return 0;
}


```

## Step-by-Step Explanation

#### 1. **Initialization:**
   - The graph is represented as an adjacency list.
   - The heuristic function `h(n)` assigns equal values for all nodes.
   - Open list and closed list are initialized.

#### 2. **Start Node Initialization:**
   - The start node is added to the open list.
   - The cost `g` from the start node to itself is set to 0.
   - Parent information is initialized, indicating that the start node is its own parent.

#### 3. **Main Loop:**
   - The algorithm enters a loop that continues until the open list is empty.
   - In each iteration, it selects the node `n` with the lowest cost function `f(n) = g(n) + h(n)` from the open list.

#### 4. **Path Found Check:**
   - If `n` is the stop node, the algorithm reconstructs the path from the start node to the stop node using the parent information.

#### 5. **Neighbor Exploration:**
   - For each neighbor `m` of the current node `n`:
     - If `m` is not in both open and closed lists, it is added to the open list.
     - If it is quicker to reach `m` through `n`, update parent and cost information.
     - If `m` is in the closed list, move it back to the open list.

#### 6. **List Management:**
   - Remove the current node `n` from the open list and add it to the closed list.

#### 7. **Path Reconstruction:**
   - If the stop node is reached, the algorithm reconstructs the final path from start to stop using the parent information.

#### 8. **Print Result:**
   - The algorithm prints the final path if it exists; otherwise, it prints that the path does not exist.

### Common Features:
   - All implementations use a priority queue or a set to efficiently select nodes with the lowest cost.
   - The heuristic function `h(n)` provides an estimate of the cost from `n` to the goal.
   - The algorithm dynamically updates the cost and parent information as it explores the graph.

## Time and Space Complexity Analysis


**Time Complexity:**

The time complexity of the A* algorithm is **O(E log E)**, where E is the number of edges in the graph and V is the number of nodes in the graph. This is because the algorithm maintains two priority queues, one for open nodes and one for closed nodes. The open queue is implemented using a heap data structure, which has a worst-case time complexity of O(log E) for insertion and deletion operations. The closed queue is implemented using a set data structure, which has a worst-case time complexity of O(1) for insertion and deletion operations.

The A* algorithm iteratively removes the node with the lowest f-value from the open queue and adds it to the closed queue. The f-value of a node is the sum of its g-value and its h-value. The g-value of a node is the distance from the start node to the current node, and the h-value of a node is an estimate of the distance from the current node to the goal node.

The algorithm continues iterating until the goal node is reached. At this point, the closed queue contains the shortest path from the start node to the goal node. The time complexity of the algorithm is dominated by the time it takes to maintain the open and closed queues, which is O(E log E).

**Space Complexity:**

The space complexity of the A* algorithm is **O(E + V)**, where E is the number of edges in the graph and V is the number of nodes in the graph. This is because the algorithm maintains two data structures: the open list and the closed list. The open list is implemented using a priority queue, which requires O(V) space. The closed list is implemented using a set data structure, which also requires O(V) space.

**Space Complexity:** O(E + V)

**Time Complexity:** O(E log E)

## Real-World Applications

1. **Pathfinding in Games:**
   - A* is widely used in video games for pathfinding by characters or entities. It helps game developers create intelligent and realistic movements for characters within the game world. This is essential for non-player characters (NPCs) to navigate around obstacles and reach their destinations efficiently.

2. **Robotics and Autonomous Vehicles:**
   - A* is employed in robotics for motion planning and navigation of autonomous vehicles. It helps robots and self-driving cars find optimal paths through environments, avoiding obstacles and efficiently reaching their goals. The algorithm is crucial for ensuring safe and efficient movement in dynamic and unknown spaces.

3. **Network Routing:**
   - A* is used in computer networks for routing data packets from source to destination. It helps in finding the most efficient and least congested path through a network, considering factors like latency and bandwidth. This application is crucial for the smooth functioning of communication networks.

4. **Digital Terrain Modeling:**
   - In geographic information systems (GIS) and cartography, A* is utilized for modeling digital terrains. It assists in finding optimal routes through geographical landscapes, considering factors such as elevation, terrain difficulty, and slope. This is beneficial for applications like outdoor navigation and route planning.

5. **Maze Solving and Puzzle Games:**
   - A* is commonly employed in solving mazes and puzzles. It helps find the shortest path from the starting point to the exit in a maze or puzzle game. This application is not only limited to entertainment but also extends to areas like robotics, where robots need to navigate through complex environments.

6. **Traffic Engineering and Route Planning:**
   - A* plays a crucial role in traffic engineering and route planning applications. It aids in optimizing traffic flow by determining the most efficient routes for vehicles, considering factors such as road conditions, traffic congestion, and real-time data. This application is vital for urban planning and managing traffic in smart cities.
