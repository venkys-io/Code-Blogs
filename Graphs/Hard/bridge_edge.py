from collections import defaultdict

class Graph:
    def __init__(self, vertices):
        # Initialize a graph with the given number of vertices
        self.V = vertices
        # Create a defaultdict to represent an adjacency list for the graph
        self.graph = defaultdict(list)

    def add_edge(self, u, v):
        # Add an undirected edge between vertices u and v
        self.graph[u].append(v)
        self.graph[v].append(u)

    def find_bridges(self):
        # List to store bridges found in the graph
        bridges = []

        def bridge_util(current, visited, parent, low, disc):
            nonlocal bridges
            # Mark the current node as visited
            visited[current] = True
            # Set discovery time and low value for the current node
            disc[current] = low[current] = self.time
            self.time += 1

            for neighbor in self.graph[current]:
                if not visited[neighbor]:
                    # Recur for the unvisited neighbor
                    parent[neighbor] = current
                    bridge_util(neighbor, visited, parent, low, disc)

                    # Update low value
                    low[current] = min(low[current], low[neighbor])

                    # Check for a bridge
                    if low[neighbor] > disc[current]:
                        bridges.append((current, neighbor))
                elif neighbor != parent[current]:
                    # Update low value for the visited neighbor
                    low[current] = min(low[current], disc[neighbor])

        # Initialize data structures
        visited = [False] * self.V
        parent = [-1] * self.V
        low = [float('inf')] * self.V
        disc = [float('inf')] * self.V
        self.time = 0

        # Call the bridge utility function for each unvisited vertex
        for vertex in range(self.V):
            if not visited[vertex]:
                bridge_util(vertex, visited, parent, low, disc)

        return bridges

# Prompt user input for the graph
num_vertices = int(input("Enter the number of vertices: "))
g1 = Graph(num_vertices)

num_edges = int(input("Enter the number of edges: "))
print("Enter the edges (format: vertex1 vertex2):")
for _ in range(num_edges):
    edge_input = input().split()
    edge = tuple(map(int, edge_input))
    g1.add_edge(*edge)

# Find and print bridges
print("\nBridges in the graph:")
bridges = g1.find_bridges()
for bridge in bridges:
    print(bridge)

# Enter the number of vertices: 8
# Enter the number of edges: 10
# Enter the edges (format: vertex1 vertex2):
# 0 1
# 1 2
# 2 0
# 1 3
# 3 4
# 4 5
# 5 3
# 6 7
# 7 6
# 5 6
# Bridges in the graph:
# 6 7
# 5 6
# 1 3