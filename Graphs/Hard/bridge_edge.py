from collections import defaultdict

class Graph:
    def __init__(self, vertices):
        self.V = vertices
        self.graph = defaultdict(list)

    def add_edge(self, u, v):
        # Add an undirected edge between vertices u and v
        self.graph[u].append(v)
        self.graph[v].append(u)

    def find_bridges(self):
        bridges = []

        def bridge_util(current, visited, parent, low, disc):
            nonlocal bridges
            visited[current] = True
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

# Example usage:
g1 = Graph(5)
g1.add_edge(1, 0)
g1.add_edge(0, 2)
g1.add_edge(2, 1)
g1.add_edge(0, 3)
g1.add_edge(3, 4)

print("Bridges in the graph:")
bridges = g1.find_bridges()
for bridge in bridges:
    print(bridge)


