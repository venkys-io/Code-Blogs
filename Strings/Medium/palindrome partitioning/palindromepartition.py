def partition(string):
  if string is None or not string.strip():
      return [[]]

  # Initialize dynamic programming array
  dp = [[] for _ in range(len(string) + 1)]

  # Initialize the first state with an empty partition
  dp[0] = [[]]

  # Iterate over each character of the string
  for j in range(1, len(string) + 1):
      # Iterate through each previous character
      for i in range(j):
          # Check if the substring is a palindrome
          if string[i:j] == string[i:j][::-1]:
              # If so, extend the partitions ending at i with the palindrome substring
              for each in dp[i]:
                  dp[j].append(each + [string[i:j]])
  # Return the final state, which contains all valid partitions
  return dp[-1]

def main():
  # Read input from standard input
  string = input("Enter a string: ")

  # Check for None or empty string
  if string is None or not string.strip():
      print("Empty or None input. Exiting.")
      return

  # Call the partition function and get the result
  result = partition(string)

  # Print the result
  print("Partitions:")
  for partition_set in result:
      print(partition_set)

  # Print the count of partitions
  print(f"\nNumber of Partitions: {len(result)}")

if __name__ == "__main__":
  main()
