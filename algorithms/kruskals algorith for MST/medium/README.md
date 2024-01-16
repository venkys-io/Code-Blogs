# **Kruskal's Algorithm for Minimum Spanning Tree**

---

# Overview:

Kruskal's algorithm is a greedy algorithm used for finding the Minimum Spanning Tree (MST) of a connected, undirected graph. A Minimum Spanning Tree is a subset of the edges of a graph that connects all the vertices without any cycles and with the minimum possible total edge weight.

- Kruskal's algorithm relies on efficiently checking for cycles, which is often done using a Union-Find data structure.
- The Union-Find data structure keeps track of a partition of a set into disjoint subsets and supports two operations: Union (to merge two subsets) and Find (to determine which subset an element belongs to).

### **Time Complexity:**

- The overall time complexity of Kruskal's algorithm is often dominated by the sorting of edges, resulting in O(E log E) time complexity, where E is the number of edges.

### **Space Complexity:**

- The space complexity is typically O(V + E), where V is the number of vertices.

### **Key Properties:**

- Kruskal's algorithm is a greedy algorithm that consistently chooses the smallest edge that does not form a cycle.
- The resulting Minimum Spanning Tree is not unique, as long as it satisfies the conditions of spanning all vertices without cycles and with the minimum possible total weight.

Kruskal's algorithm is widely used and efficient for finding minimum spanning trees in various applications, such as network design and clustering. It's known for its simplicity and effectiveness in solving the MST problem.

# Python code:

```python
class UnionFind:
    def __init__(self, vertices):
        self.parent = {v: v for v in vertices}
        self.rank = {v: 0 for v in vertices}

    def find(self, vertex):
        if self.parent[vertex] != vertex:
            self.parent[vertex] = self.find(self.parent[vertex])
        return self.parent[vertex]

    def union(self, root1, root2):
        if self.rank[root1] < self.rank[root2]:
            self.parent[root1] = root2
        elif self.rank[root1] > self.rank[root2]:
            self.parent[root2] = root1
        else:
            self.parent[root1] = root2
            self.rank[root2] += 1

def kruskal(graph):
    edges = []
    for vertex in graph:
        for neighbor, weight in graph[vertex]:
            edges.append((vertex, neighbor, weight))

    edges.sort(key=lambda x: x[2])  # Sort edges by weight

    vertices = set()
    for edge in edges:
        vertices.add(edge[0])
        vertices.add(edge[1])

    minimum_spanning_tree = []
    union_find = UnionFind(vertices)

    for edge in edges:
        root1 = union_find.find(edge[0])
        root2 = union_find.find(edge[1])

        if root1 != root2:
            minimum_spanning_tree.append(edge)
            union_find.union(root1, root2)

    return minimum_spanning_tree

# Example usage:
graph = {
    'A': [('B', 4), ('H', 8)],
    'B': [('A', 4), ('C', 8), ('H', 11)],
    'C': [('B', 8), ('D', 7), ('F', 4), ('I', 2)],
    'D': [('C', 7), ('E', 9), ('F', 14)],
    'E': [('D', 9), ('F', 10)],
    'F': [('C', 4), ('D', 14), ('E', 10), ('G', 2)],
    'G': [('F', 2), ('H', 1), ('I', 6)],
    'H': [('A', 8), ('B', 11), ('G', 1), ('I', 7)],
    'I': [('C', 2), ('G', 6), ('H', 7)]
}

result = kruskal(graph)
print("Minimum Spanning Tree:")
for edge in result:
    print(edge)
```

## Step-By-Step explanation:

1.The class represents a Union-Find data structure. It has methods for initializing the structure (—init—), finding the root of a set (find), and performing union operation (union). The find method uses path compression to optimize future finds.

2.The kruskal function takes a graph as input, where each vertex is associated with a list of its neighbors and corresponding edge weights.

- It initializes an empty list edges to store all edges and populates it by iterating through the vertices and their neighbors.
- The edges are then sorted in ascending order based on their weights.
- It initializes an empty set vertices to keep track of all vertices.
- The minimum spanning tree is stored in the list minimum spanning tree.
- A Union-Find data structure is created using the UnionFind class, and each vertex is initially its own set.
- The sorted edges are iterated, and for each edge, the roots of the sets containing its two vertices are determined.
- If the roots are different (i.e., adding the edge does not create a cycle), the edge is added to the minimum spanning tree, and the two sets are unioned.
- The final minimum spanning tree is returned.

3.

- An example graph is provided, and the kruskal function is called to find the minimum spanning tree.
- The resulting minimum spanning tree edges are printed.

# Java code:

```java
import java.util.*;

class Edge implements Comparable<Edge> {
    int source;
    int destination;
    double weight;

    public
 
Edge(int source, int destination, double
 
weight)
 
{
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    @Override

    
public
 
int
 
compareTo(Edge other)
 
{
        return Double.compare(this.weight, other.weight);
    }
}

class
 
DisjointSet
 
{
    private
 
int[] parent;

    public
 
DisjointSet(int n)
 
{
        parent = new
 
int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public
 
int
 
find(int u)
 
{
        if (u == parent[u]) {
            return u;
        }
        return parent[u] = find(parent[u]);
    }

    public
 
void
 
union(int u, int v) {
        int uRoot = find(u);
        int vRoot = find(v);
        if (uRoot != vRoot) {
            parent[uRoot] = vRoot;
        }
    }
}

public class KruskalMST {

    public static List<Edge> kruskalMST(List<Edge> edges, int numVertices) {
        List<Edge> mst = new ArrayList<>();
        Collections.sort(edges);
        DisjointSet ds = new DisjointSet(numVertices);

        for (Edge edge : edges) {
            if (ds.find(edge.source) != ds.find(edge.destination)) {
                mst.add(edge);
                ds.union(edge.source, edge.destination);
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        // Add your graph data here
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(1, 2, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        int numVertices = 4;

        List<Edge> mst = kruskalMST(edges, numVertices);

        for (Edge edge : mst) {
            System.out.println(edge.source + "-" + edge.destination + " " + edge.weight);
        }
    }
}
```

## Step-By-Step Explanation:

1. **`Edge`** Class Definition:

- The **`Edge`** class represents an edge in the graph.
- It implements the **`Comparable`** interface to enable sorting based on edge weights.

### 1.2. Constructor:

- The constructor initializes the source, destination, and weight of the edge.

### 1.3. **`compareTo`** Method:

- The **`compareTo`** method is overridden to compare edges based on their weights.
- It returns a negative integer, zero, or a positive integer if the current object is less than, equal to, or greater than the specified object (the **`other`** edge).

### 2.**`DisjointSet`** Class Definition:

- The **`DisjointSet`** class represents a disjoint-set data structure (also known as Union-Find).
- It is used in Kruskal's algorithm for efficient cycle detection.

### 2.2. Constructor:

- The constructor initializes the parent array such that each element is its own parent initially.

### 2.3. **`find`** Method:

- The **`find`** method performs the find operation in the disjoint-set data structure.
- It uses path compression to find the root of the set to which the element **`u`** belongs.

### 2.4. **`union`** Method:

- The **`union`** method performs the union operation in the disjoint-set data structure.
- It joins the sets containing elements **`u`** and **`v`** by making the root of one set the parent of the root of the other set.

### 3. **`kruskalMST`** Method:

- The **`kruskalMST`** method implements Kruskal's algorithm to find the Minimum Spanning Tree (MST).
- It sorts the edges in ascending order based on their weights.
- It uses the **`DisjointSet`** class for efficient cycle detection.
- It iterates through the sorted edges, adding an edge to the MST only if it does not create a cycle.

### 3.2. **`main`** Method:

- The **`main`** method is the entry point of the program.
- It initializes a list of edges representing a graph and the number of vertices.
- It calls the **`kruskalMST`** method to find the MST and prints the result.

### **4. Running the Code:**

- The **`main`** method creates a sample graph with edges and vertices.
- It then calls **`kruskalMST`** to find the Minimum Spanning Tree.
- The resulting MST edges are printed in the format "source-destination weight."

# C++ Code:

```cpp
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// Structure to represent an edge
struct Edge {
  int source;
  int destination;
  double weight;
};

// Comparator function for sorting edges by weight
bool compare(const Edge& a, const Edge& b) {
  return a.weight < b.weight;
}

// Disjoint-set data structure with union-find
class DisjointSet {
  vector<int> parent;
  vector<int> rank;

public:
  DisjointSet(int n) : parent(n), rank(n, 1) {
    for (int i = 0; i < n; ++i) {
      parent[i] = i;
    }
  }

  int
 
find(int u)
 
{
    if (u == parent[u]) {
      return u;
    }
    return parent[u] = find(parent[u]);
  }

  void unionSet(int u, int v)
 
{
    int uRoot = find(u);
    int vRoot = find(v);

    if (uRoot == vRoot) {
      return;
    }

    if (rank[uRoot] < rank[vRoot]) {
      parent[uRoot] = vRoot;
    } else
 
if (rank[uRoot] > rank[vRoot]) {
      parent[vRoot] = uRoot;
    } else {
      parent[vRoot] = uRoot;
      rank[uRoot]++;
    }
  }
};

// Kruskal's algorithm to find MST
vector<Edge> kruskalMST(vector<Edge>& edges, int numVertices) {
  vector<Edge> mst;
  sort(edges.begin(), edges.end(), compare);

  DisjointSet ds(numVertices);

  for (const Edge& edge : edges) {
    if (ds.find(edge.source) != ds.find(edge.destination)) {
      ds.unionSet(edge.source, edge.destination);
      mst.push_back(edge);
    }
  }

  return mst;
}

int main() {
  // Add your graph data here
  vector<Edge> edges;
  edges.push_back({0, 1, 10});
  edges.push_back({0, 2, 6});
  edges.push_back({1, 2, 5});
  edges.push_back({1, 3, 15});
  edges.push_back({2, 3, 4});

  int numVertices = 4;

  vector<Edge> mst = kruskalMST(edges, numVertices);

  for (const Edge& edge : mst) {
    cout << edge.source << " - " << edge.destination << " (" << edge.weight << ")" << endl;
  }

  return 0;
}
```

## Step-By-Step Explanation:

1. **`#include`** Statements:

- The **`#include`** statements are used to include necessary header files. **`iostream`** is included for input/output operations, and **`vector`** and **`algorithm`** are included for working with vectors and sorting, respectively.
- **`using namespace std;`**
- The **`using namespace std;`** statement allows the use of standard C++ identifiers (such as **`cout`** and **`endl`**) without the **`std::`** prefix.

****2. `Edge` Structure:**

The **`Edge`** structure represents an edge in a graph, containing information about the source vertex, destination vertex, and weight of the edge.

****3. `compare` Function:**

The **`compare`** function is a comparator used for sorting edges. It returns **`true`** if the weight of edge **`a`** is less than the weight of edge **`b`**.

****4. `DisjointSet` Class:**

- The **`DisjointSet`** class represents a disjoint-set data structure (also known as Union-Find).
- It contains vectors for storing parent pointers and ranks of elements.

4.2. Constructor:

- The constructor initializes the parent vector such that each element is initially its own parent, and the rank vector is initialized with 1.

4.3. **`find`** Method:

- The **`find`** method performs the find operation in the disjoint-set data structure. It uses path compression to find the root of the set to which the element **`u`** belongs.

4.4. **`unionSet`** Method:

- The **`unionSet`** method performs the union operation in the disjoint-set data structure. It joins the sets containing elements **`u`** and **`v`** by making the root of one set the parent of the root of the other set.

****5. `kruskalMST` Function:**

- The **`kruskalMST`** function implements Kruskal's algorithm to find the Minimum Spanning Tree (MST) of a graph.
- It sorts the edges based on their weights using the **`compare`** function.
- It uses the **`DisjointSet`** class to efficiently detect and avoid cycles.
- It iterates through the sorted edges, adding an edge to the MST only if it does not create a cycle.

****6. `main` Function:**

- The **`main`** function is the entry point of the program.
- It initializes a vector of edges representing a graph and the number of vertices.
- It calls the **`kruskalMST`** function to find the MST and prints the result.

**7. Running the Code:**

- The **`main`** function creates a sample graph with edges and vertices.
- It then calls **`kruskalMST`** to find the Minimum Spanning Tree.
- The resulting MST edges are printed in the format "source - destination (weight)."

# Real-World Applications of Kruskals Algorithm:

1. **Network Design:**
    - **Telecommunications Networks:** Kruskal's algorithm can be used to lay down the most cost-effective network of cables or fiber optics to connect various communication points.
    - **Computer Networks:** In computer networks, where routers or switches need to be connected, Kruskal's algorithm helps minimize the cost or latency of data transmission.
2. **Circuit Design:**
    - **Printed Circuit Boards (PCBs):** In electronics, Kruskal's algorithm can be applied to design PCBs by connecting components with traces to minimize the total length of connections.
3. **Transportation Networks:**
    - **Road Networks:** For designing road systems between cities or towns to minimize construction costs.
    - **Railway Networks:** To lay down tracks between stations with the least overall cost.
4. **Water Supply Networks:**
    - **Pipelines:** Kruskal's algorithm can be used to design water supply networks by minimizing the total length of pipelines required.
5. **Robotics and Sensor Networks:**
    - **Robotics Path Planning:** In robotics, Kruskal's algorithm can be used to find the most efficient path for a robot to traverse a set of locations.
    - **Sensor Networks:** For deploying a set of sensors in an area to monitor various points with minimal wiring or connectivity costs.
6. **Image Segmentation:**
    - **Medical Imaging:** Kruskal's algorithm can be applied in medical image segmentation, where pixels or regions are connected based on similarity to create a meaningful representation.
7. **Power Distribution Networks:**
    - **Electric Power Grids:** Kruskal's algorithm can help in designing the power distribution network by connecting power stations and substations with the least overall cost.
8. **Spanning Tree Protocol in Computer Networks:**
    - **Ethernet Networks:** In computer networks, Kruskal's algorithm is used as part of the Spanning Tree Protocol to ensure loop-free topologies, preventing broadcast storms.
9. **Molecular Structure Determination:**
    - **Chemistry and Bioinformatics:** In determining the structure of molecules, Kruskal's algorithm can be applied to identify the most important connections between atoms.
10. **Cluster Analysis:**
    - **Data Mining:** Kruskal's algorithm can be employed in cluster analysis to identify relationships and dependencies between data points.
