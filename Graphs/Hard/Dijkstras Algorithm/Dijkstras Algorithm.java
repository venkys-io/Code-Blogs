import java.util.*;

public class DijkstraAlgorithm {

    static class Edge {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void dijkstra(Map<Integer, List<Edge>> graph, int start, Map<Integer, Integer> distances, Map<Integer, Integer> predecessors) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        priorityQueue.offer(new Edge(start, 0));

        distances.put(start, 0);

        while (!priorityQueue.isEmpty()) {
            Edge currentEdge = priorityQueue.poll();
            int currentVertex = currentEdge.destination;

            if (currentEdge.weight > distances.get(currentVertex)) {
                continue;
            }

            for (Edge neighbor : graph.getOrDefault(currentVertex, new ArrayList<>())) {
                int newDistance = distances.get(currentVertex) + neighbor.weight;

                if (newDistance < distances.get(neighbor.destination)) {
                    distances.put(neighbor.destination, newDistance);
                    predecessors.put(neighbor.destination, currentVertex);
                    priorityQueue.offer(new Edge(neighbor.destination, newDistance));
                }
            }
        }
    }

    public static void printPath(Map<Integer, Integer> predecessors, int target) {
        List<Integer> path = new ArrayList<>();
        int current = target;

        while (current != -1) {
            path.add(current);
            current = predecessors.get(current);
        }

        Collections.reverse(path);
        System.out.print("Shortest path: ");
        for (int vertex : path) {
            System.out.print(vertex + " -> ");
        }
        System.out.println("\b\b  ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, List<Edge>> graph = new HashMap<>();

        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        System.out.println("Enter the edges (source destination weight): ");
        for (int i = 0; i < numEdges; ++i) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            int weight = scanner.nextInt();

            graph.computeIfAbsent(source, k -> new ArrayList<>()).add(new Edge(destination, weight));
            // Assuming an undirected graph
            graph.computeIfAbsent(destination, k -> new ArrayList<>()).add(new Edge(source, weight));
        }

        System.out.print("Enter the start node: ");
        int startNode = scanner.nextInt();
        System.out.print("Enter the end node: ");
        int endNode = scanner.nextInt();

        Map<Integer, Integer> distances = new HashMap<>();
        Map<Integer, Integer> predecessors = new HashMap<>();

        // Initialize distances and predecessors
        for (int vertex : graph.keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
            predecessors.put(vertex, -1); // -1 represents no predecessor
        }

        dijkstra(graph, startNode, distances, predecessors);

        if (distances.get(endNode) != Integer.MAX_VALUE) {
            System.out.println("Shortest distance from " + startNode + " to " + endNode + ": " + distances.get(endNode));
            printPath(predecessors, endNode);
        } else {
            System.out.println("There is no path from " + startNode + " to " + endNode + ".");
        }
    }
}
