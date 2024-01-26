import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    // Class to represent the structure of the edge along with weights
    public static class VSDEdge {
        int source;
        int destination;
        int weight;

        public VSDEdge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Class to represent the structure of the graph
    public static class VSDGraph {
        int v; // No.of vertices
        LinkedList<VSDEdge> adList[]; // Adjacency list to mark the edges

        // Initializing vertices using constructor
        VSDGraph(int size) {
            v = size;
            adList = new LinkedList[v];
            for (int i = 0; i < v; i++)
                adList[i] = new LinkedList<VSDEdge>();
        }

        // Function to add edge to the graph
        public void VSDaddEgde(int source, int destination, int weight) {
            VSDEdge edge = new VSDEdge(source, destination, weight);
            adList[source].addLast(edge); // adding new edge to the list
        }

        // Function to implement prim's algorithm
        public void VSDPrimsMst(VSDGraph g) {
            int edgecount = 0;
            boolean[] visited = new boolean[g.v];// Array to mark the vertices already present in MST
            for (int i = 0; i < g.v; i++) {
                visited[i] = false;
            }
            int weight = 0;// To calculate the weight of MST.
            visited[0] = true;
            System.out.println("The Prim's MST is:");
            while (edgecount < g.v - 1) {

                int min = 999999;
                int x = 0; // source vertex
                int y = 0; // destination vertex

                for (int i = 0; i < g.v; i++) {
                    if (visited[i] == true) {
                        LinkedList<VSDEdge> list = adList[i];
                        for (int j = 0; j < list.size(); j++) {
                            if (!visited[list.get(j).destination] && min > list.get(j).weight) {
                                min = list.get(j).weight;
                                x = i;
                                y = list.get(j).destination;
                            }
                        }
                    }
                }
                System.out.println(x + " - " + y);
                weight += min;
                visited[y] = true;
                edgecount++;

            }
            System.out.println("The total cost of Prim's MST is " + weight);
        }
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        VSDGraph g = new VSDGraph(vertices);

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter edges (format: source destination weight):");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            int weight = scanner.nextInt();
            g.VSDaddEgde(source, destination, weight);
        }

        g.VSDPrimsMst(g);

        scanner.close();
    }
}