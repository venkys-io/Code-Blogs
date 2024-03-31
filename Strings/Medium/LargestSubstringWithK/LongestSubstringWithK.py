# Copyrights to venkys.io
# For more information, visit https://venkys.io */

# Space complexity: O(n)
# Time complexity: O(n^2)

from collections import Counter, defaultdict

def longestSubstring(string, k):
    # Check if the input string is not empty
    if not string:
        return 0

    # Count the occurrences of each character in the string
    char_count = Counter(string)
    # Determine the maximum number of unique characters
    max_unique_chars = len(char_count)
    n = len(string)
    ans = 0

    # Iterate over the possible number of unique characters (1 to max_unique_chars)
    for num in range(1, max_unique_chars + 1):
        # Counter to keep track of characters in the current window
        counter = defaultdict(int)
        left = 0

        # Iterate over the string with a sliding window
        for right in range(n):
            counter[string[right]] += 1

            # Shrink the window if the number of unique characters exceeds the target (num)
            while len(counter) > num:
                counter[string[left]] -= 1
                if counter[string[left]] == 0:
                    del counter[string[left]]
                left += 1

            # Check if all characters in the current window appear at least k times
            if all(count >= k for key, count in counter.items()):
                ans = max(ans, right - left + 1)

    return ans
  
# Take input from the user
input_str = input()
k_value = int(input())
# Call the function and print the result
result = longestSubstring(input_str, k_value)
print(result)
