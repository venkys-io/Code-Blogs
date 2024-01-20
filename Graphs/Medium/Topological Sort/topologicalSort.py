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