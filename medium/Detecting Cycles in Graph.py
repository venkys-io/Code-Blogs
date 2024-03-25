# Python


class Graph:
    def __init__(self, vertices):
        # Initialize graph with a given number of vertices
        self.vertices = vertices
        # Graph represented as an adjacency list
        self.graph = {i: [] for i in range(vertices)}

    def add_edge(self, u, v):
        # Check for null safety before adding an edge
        if u is not None and v is not None:
            # Add an edge between vertices u and v (undirected graph)
            self.graph[u].append(v)
            self.graph[v].append(u)

    def is_cyclic_util(self, node, visited, parent):
        visited[node] = True  # Mark the current node as visited
        for neighbor in self.graph[node]:
            if neighbor is not None:  # Null safety check
                if not visited[neighbor]:
                    # If neighbor not visited, perform DFS recursively
                    if self.is_cyclic_util(neighbor, visited, node):
                        return True
                elif neighbor != parent:
                    # If neighbor visited and not parent (back edge), cycle found
                    return True
        return False

    def is_cyclic(self):
        visited = [False] * self.vertices  # Initialize visited array for all vertices
        for node in range(self.vertices):
            if not visited[node] and self.is_cyclic_util(node, visited, -1):
                # If node not visited and contains a cycle, return True
                return True
        return False  # No cycle found in the graph

def main():
    # Input vertices and edges
    vertices = int(input("Enter the number of vertices: "))
    graph = Graph(vertices)
    
    # Adding edges to the graph
    edges = int(input("Enter the number of edges: "))
    for _ in range(edges):
        u, v = map(int, input("Enter edge (u, v): ").split())
        graph.add_edge(u, v)
    
    # Perform cycle detection and print result
    result = graph.is_cyclic()
    print("Cycle present:", result)

if __name__ == "__main__":
    main()
