# Palindrome



Write a function `is_palindrome` to determine whether a given string is a palindrome. A palindrome is a sequence of characters that reads the same forward and backward, ignoring spaces, punctuation, and capitalization.

### Input

- A string `s` where 1 <= len(s) <= 2 * 10^5.
- The string may consist of alphabetic characters, spaces, and/or punctuation.

### Output

- Return `True` if the given string is a palindrome, `False` otherwise.



### Example 1

```
Input: "racecar"
output: true
```

### Example 2

```
Input: ""A man, a plan, a canal, Panama""
output: true
```
### Example 3

```
Input: "hello"
output: false
```



### Hints
- Remove spaces and convert the string to lowercase before checking for palindrome.
- Use two pointers to iterate from the start and end of the string simultaneously.
- While iterating, compare characters at the pointers and move towards each other until they meet or cross.
- If at any point the characters don't match, the string is not a palindrome.