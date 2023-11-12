# Exploring Graph Algorithms :                   Dijkstra Algorithm

Today, we dive into the fascinating world of Graph algorithms and uncover their most captivating mysteries — Dijkstra Algorithm . Get ready to embark that will  challenge your minds and you will come to know about the power of Graphs.

## Introduction to Graph Algorithms

Graph algorithms are a powerful tool for solving a wide variety of problems . These are used to solve problems on graphs , such as finding the shortest path between two nodes , finding the maximum flow in a network or detecting communities in a  social network.

Graph algorithms are used wide variety of applications such as 

1. **Transportation** :  for finding the shortest route between two points
2. **Social Networks** : detecting spam users , identifying influential users
3. **Computer Science** : compiling programs , optimizing network performance and malware detection

There are few basic types of algorithms such as “Breadth-first search(BFS)” , “depth-first search(DFS)”, Dijkstra algorithm ,Bellman-Ford algorithm etc. and also we have few advanced type of algorithms such as “Matching algorithm” , “Clustering algorithm”, and Maximum flow algorithm etc. It also works on both directed(edges are present for a graph) and undirected graph(there will be no edges for a graph) .

Graph algorithm can be implemented in different programming languages and software Libraries . Some popular graph libraries include 

1. **NetworkX** : A python library for graph implementation and graph manipulation
2. **GraphLab** : A distributed graph computing framework 
3. **Neo4j** : A graph database management system

One of the fundamental tasks in graph theory is Dijkstra Algorithm.

## Overview of Dijkstra’s  Algorithm

Dijkstra’s algorithm is a graph algorithm that finds you the shortest path between a single source node and all other nodes in a graph . It is a greedy algorithm , that it makes the locally optimal choice at each step in order to reach the globally optimal solution.

Code : 

import sys

class Graph()

def __init__(self, vertices):
	self.V = vertices
	self.graph = [[0 for column in range(vertices)]
				for row in range(vertices)]

def printSolution(self, dist):
	print("Vertex \\tDistance from Source")
	for node in range(self.V):
		print(node, "\\t", dist[node])

# A utility function to find the vertex with
# minimum distance value, from the set of vertices
# not yet included in shortest path tree
def minDistance(self, dist, sptSet):

	# Initialize minimum distance for next node
	min = sys.maxsize

	# Search not nearest vertex not in the
	# shortest path tree
	for u in range(self.V):
		if dist[u] < min and sptSet[u] == False:
			min = dist[u]
			min_index = u

	return min_index

# Function that implements Dijkstra's single source
# shortest path algorithm for a graph represented
# using adjacency matrix representation
def dijkstra(self, src):

	dist = [sys.maxsize] * self.V
	dist[src] = 0
	sptSet = [False] * self.V

	for cout in range(self.V):

		# Pick the minimum distance vertex from
		# the set of vertices not yet processed.
		# x is always equal to src in first iteration
		x = self.minDistance(dist, sptSet)

		# Put the minimum distance vertex in the
		# shortest path tree
		sptSet[x] = True

		# Update dist value of the adjacent vertices
		# of the picked vertex only if the current
		# distance is greater than new distance and
		# the vertex in not in the shortest path tree
		for y in range(self.V):
			if self.graph[x][y] > 0 and sptSet[y] == False and \\
					dist[y] > dist[x] + self.graph[x][y]:
				dist[y] = dist[x] + self.graph[x][y]

	self.printSolution(dist)
if **name** == "**main**":
g = Graph(9)
g.graph = [[0, 4, 0, 0, 0, 0, 0, 8, 0],
[4, 0, 8, 0, 0, 0, 0, 11, 0],
[0, 8, 0, 7, 0, 4, 0, 0, 2],
[0, 0, 7, 0, 9, 14, 0, 0, 0],
[0, 0, 0, 9, 0, 10, 0, 0, 0],
[0, 0, 4, 14, 10, 0, 2, 0, 0],
[0, 0, 0, 0, 0, 2, 0, 1, 6],
[8, 11, 0, 0, 0, 0, 1, 0, 7],
[0, 0, 2, 0, 0, 0, 6, 7, 0]
]g.dijkstra(0)

Code Explanation :

1. Initialize a set of  visited nodes and a set of unvisited nodes . The visited set is initially empty, and the unvisited set  contains all the nodes in the graph .

2. select the source node and add it into the visited set . 

3. For each neighbor of the source node, calculate the shortest distance from the source node to the neighbor. If the calculated distance is shortest than the current distance  sorted for  the neighbor , update the neighbor’s distance and add it into the priority queue.


4. Once all nodes have been visited, the distance of each node is the shortest distance from the source node to that node


5. Here the algorithm terminates, when all of the nodes in the graph have been visited. At this point , the tentative distance of each node is equal to the shortest distance from the source to that node. 

**Time Complexity and space complexity :**

O(E * logV), Where E is the number of edges and V is the number of vertices.

The time complexity of the given code/algorithm looks O(V^2) as there are two nested while loops. If we take a closer look, we can observe that the statements in inner loop are executed O(V+E) times (similar to BFS). The inner loop has decreaseKey() operation which takes O(LogV) time. So overall time complexity is O(E+V)*O(LogV) which is O((E+V)*LogV) = O(ELogV) Note that the above code uses Binary Heap for Priority Queue implementation. Time complexity can be reduced to O(E + VLogV) using Fibonacci Heap. The reason is, Fibonacci Heap takes O(1) time for decrease-key operation while Binary Heap takes O(Logn) time.

 space complexity is  O(V).