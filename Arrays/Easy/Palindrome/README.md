# Palindrome Check

## Problem Statement

Given a string, determine whether it is a palindrome or not. A palindrome is a word, phrase, number, or other sequence of characters that reads the same forward and backward (ignoring spaces, punctuation, and capitalization).

## Intuition

A palindrome reads the same backward as forward. To check if a string is a palindrome, we can compare the characters from the beginning to the end and vice versa.

## Explanation

We need to compare the characters from the start and end of the string. If at any point the characters don't match, the string is not a palindrome. If we reach the middle of the string without finding any mismatch, then the string is a palindrome.

## Algorithm

1. Remove spaces and convert the string to lowercase (optional, depending on requirements).
2. Initialize two pointers, one at the beginning and one at the end of the string.
3. Iterate until the pointers meet or cross each other:
   - Compare the characters at the pointers.
   - If they are not equal, the string is not a palindrome.
   - Move the pointers towards each other.
4. If the pointers meet or cross without finding a mismatch, the string is a palindrome.

## Implementation

Here's a simple implementation in Python:

```python
def is_palindrome(s):
    # Remove spaces and convert to lowercase
    s = s.replace(" ", "").lower()

    # Initialize pointers
    start, end = 0, len(s) - 1

    # Iterate until pointers meet or cross
    while start < end:
        # Compare characters
        if s[start] != s[end]:
            return False
        
        # Move pointers towards each other
        start += 1
        end -= 1

    return True

# Example
input_string = "A man a plan a canal Panama"
result = is_palindrome(input_string)
print(f"The given string is {'a' if result else 'not a'} palindrome.")
