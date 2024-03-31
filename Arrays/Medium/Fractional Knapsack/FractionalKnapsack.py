# Copyrights to venkys.io
# For more programs visit venkys.io
# Python program for Fractional Knapsack

# Function to calculate P/W ratio
def VSDcalculatepwratio(n, p, w):
    # Create a 2D array to store profit, weight, and profit-to-weight ratio
    ratioarray = [[0 for i in range(3)] for i in range(n)]

    # Calculate and populate the array
    for i in range(n):
        # Profit
        ratioarray[i][0] = p[i]
        # Weight
        ratioarray[i][1] = w[i]
        # Profit-to-Weight ratio
        ratioarray[i][2] = p[i] / w[i]

    # Return the array sorted in descending order based on profit-to-weight ratio
    return sorted(ratioarray, reverse=True, key=lambda x: x[2])


# Function to find maximum profit possible
def VSDknapsack(sortedarray, n, m):
    i = result = 0

    # Iterate until the knapsack is full
    while m > 0 and i < n:
        if m - sortedarray[i][1] >= 0:
            # Add the entire item to the knapsack
            result += sortedarray[i][0]
            # Reduce knapsack capacity
            m = m - sortedarray[i][1]
        else:
            # Add a fraction of the item to fill the remaining capacity
            result += sortedarray[i][2] * m
            # Knapsack is full
            m = 0
        i += 1
    # Return the maximum profit as a formatted string
    return "{:.2f}".format(result)


# Function to print array
def VSDprint(sortedarray, n):
    print("\nProfits:")
    for i in range(n):
        # Print profit of each item
        print(sortedarray[i][0], end="  ")
    print("\nweights:")
    for i in range(n):
        # Print weight of each item
        print(sortedarray[i][1], end="  ")
    print("\nP/W ratio:")
    for i in range(n):
        # Print profit-to-weight ratio of each item
        print(sortedarray[i][2], end="  ")
    print("\n")


# Main Function
if __name__ == "__main__":
    n = int(input())
    profits = []
    weights = []

    for i in range(n):
        profit = int(input())
        weight = int(input())
        profits.append(profit)
        weights.append(weight)

    capacity = int(input())

    # Calculate and sort the array based on profit-to-weight ratio
    arr = VSDcalculatepwratio(n, profits, weights)

    # Find and print the maximum profit
    result = VSDknapsack(arr, n, capacity)
    VSDprint(arr, n)
    print(result)
