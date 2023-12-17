'''Copyrights to venkys.io
For more information, visite https://venkys.io"/

Python program to sort a given array in order using radix sort algorithm.'''

# Stable : Yes
# Inplace : Yes
# Adaptive : No

# Space complexity: O(n+k) where
  # n = number of elements in the input array
  # k = range of input values (number of unique digits)

#Time Complexity: O(d*(n+k)) /O(n+k) in simplified version
  # n=no. of elements 
  # k= range of input values
  # d= no. of digits in maximum value
  

def counting_sort(arr, exp):
    n = len(arr)
    output = [0] * n
    count = [0] * 10

    for i in range(n):
        index = arr[i] // exp
        count[index % 10] += 1

    for i in range(1, 10):
        count[i] += count[i - 1]

    i = n - 1
    while i >= 0:
        index = arr[i] // exp
        output[count[index % 10] - 1] = arr[i]
        count[index % 10] -= 1
        i -= 1

    for i in range(n):
        arr[i] = output[i]

def radix_sort(arr):
    max_num = max(arr)
    exp = 1
    while max_num // exp > 0:
        counting_sort(arr, exp)
        exp *= 10
    return arr

arr = list(map(int, input().split()))
print('The given array is',arr)
print('The sorted order is:',radix_sort(arr))
