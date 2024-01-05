class Solution:
    def countAndSay(self, n: int) -> str:
        # Base case: If n is 1, return the base sequence "1"
        if n == 1:
            return "1"

        # Recursively call countAndSay for (n - 1)
        prev = self.countAndSay(n - 1)
        result = ""  # Initialize the result string
        count = 1  # Initialize count of consecutive digits

        # Loop through the previous sequence to generate the current sequence
        for i in range(1, len(prev)):
            # Compare current digit with the previous one
            if prev[i] == prev[i - 1]:
                # If the current digit is the same as the previous one, increase the count
                count += 1
            else:
                # If it's different, append the count and the digit to the result, then reset the count
                result += str(count) + prev[i - 1]
                count = 1  # Reset count for the new digit

        # Add the count and the last digit after the loop ends
        result += str(count) + prev[-1]

        return result  # Return the generated sequence

# Test cases
solution = Solution()

# Take input from user for n
n = int(input("Enter a value for n: "))

# Generate sequence for input n and print the result
output = solution.countAndSay(n)
print("Result:", output)
