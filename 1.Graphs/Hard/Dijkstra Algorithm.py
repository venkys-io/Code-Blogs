import heapq

def dijkstra(graph, start):
    priority_queue = [(0, start)]
    distances = {node: float('infinity') for node in graph}
    distances[start] = 0
    
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

def get_graph_from_user():
    graph = {}
    nodes = int(input("Enter the number of nodes: "))
    
    for _ in range(nodes):
        node = input("Enter node: ")
        edges = {}
        neighbors = int(input(f"Enter the number of neighbors for node {node}: "))
        
        for _ in range(neighbors):
            neighbor, weight = input("Enter neighbor and weight (space-separated): ").split()
            edges[neighbor] = int(weight)
            
        graph[node] = edges
    
    return graph

if __name__ == "__main__":
    graph = get_graph_from_user()
    
    start_node = input("Enter the starting node: ")
    shortest_distances = dijkstra(graph, start_node)
    
    print("Shortest distances from node", start_node + ":")
    for node, distance in shortest_distances.items():
        print(f"To {node}: {distance}")
