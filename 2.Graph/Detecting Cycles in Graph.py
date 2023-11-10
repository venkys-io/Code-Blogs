# Python

class Graph:
    def __init__(self, vertices):
        # Constructor initializes the graph with a given number of vertices
        self.vertices = vertices
        # Graph represented as an adjacency list
        self.graph = {i: [] for i in range(vertices)}

    def add_edge(self, u, v):
        # Method to add an undirected edge between vertices u and v
        self.graph[u].append(v)
        self.graph[v].append(u)

    def is_cyclic_util(self, node, visited, parent):
        # Utility function to perform DFS and detect cycles starting from a given node
        visited[node] = True  # Mark the current node as visited
        for neighbor in self.graph[node]:  # Iterate through neighbors of the current node
            if not visited[neighbor]:  # If the neighbor is not visited
                if self.is_cyclic_util(neighbor, visited, node):  # Recursive DFS call
                    return True  # If a cycle is found in the recursive call, return True
            elif neighbor != parent:  # If the neighbor is visited and not the parent (back edge)
                return True  # Cycle is found, return True
        return False  # No cycle found for the current node

    def is_cyclic(self):
        # Method to check if the graph contains any cycles
        visited = [False] * self.vertices  # Initialize visited array for all vertices
        for node in range(self.vertices):  # Iterate through all nodes in the graph
            if not visited[node] and self.is_cyclic_util(node, visited, -1):  # If the node is not visited and contains a cycle
                return True  # Return True indicating the presence of a cycle
        return False  # No cycle found in the graph

# Example usage:
graph = Graph(4)  # Create a graph with 4 vertices
graph.add_edge(0, 1)  # Add edges to the graph
graph.add_edge(1, 2)
graph.add_edge(1, 3)

print(graph.is_cyclic())  # Check and print whether the graph contains a cycle
