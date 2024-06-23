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