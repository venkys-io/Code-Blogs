def VSDprims(G, n):
    inf = 999999
    visited = [0] * n
    edge_count = 0
    visited[0] = True
    cost = 0
    
    while edge_count < n - 1:
        minimum = inf
        x = 0
        y = 0
        for i in range(n):
            if visited[i]:
                for j in range(n):
                    if (not visited[j]) and G[i][j]:
                        if minimum > G[i][j]:
                            minimum = G[i][j]
                            x = i
                            y = j
                            
        print("Edge pair is", (x, y), "with weight", G[x][y])
        cost += G[x][y]
        visited[y] = True
        edge_count += 1
    
    print("The total cost of Prim's MST is", cost)

if __name__ == "__main__":
    n = int(input("Enter the number of vertices: "))
    
    # Taking input for the adjacency matrix
    g = []
    print("Enter the adjacency matrix (row-wise):")
    for i in range(n):
        row = list(map(int, input().split()))
        g.append(row)

    VSDprims(g, n)