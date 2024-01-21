import heapq

def dijkstra(graph, start):
    # Initialize distances and visited nodes
    distances = {node: float('infinity') for node in graph}
    distances[start] = 0
    priority_queue = [(0, start)]

    while priority_queue:
        current_distance, current_node = heapq.heappop(priority_queue)

        if current_distance > distances[current_node]:
            continue

        for neighbor, weight in graph[current_node].items():
            distance = current_distance + weight

            if distance < distances[neighbor]:
                distances[neighbor] = distance
                heapq.heappush(priority_queue, (distance, neighbor))

    return distances

# Predefined graph
graph = {
    'A': {'B': 1, 'C': 4},
    'B': {'A': 1, 'C': 2, 'D': 5},
    'C': {'A': 4, 'B': 2, 'D': 1},
    'D': {'B': 5, 'C': 1}
}

# Predefined starting node
start_node = 'A'

# Check if the starting node is in the graph
if start_node not in graph:
    print("Invalid starting node.")
else:
    result = dijkstra(graph, start_node)
    print("Shortest distances from node {}:".format(start_node))
    for node, distance in result.items():
        print("To {}: {}".format(node, distance))
