def ispalindrome(string):
    rev = ""
    for char in string:
        if char.isalpha():
            rev += char.lower()

    low, high = 0, len(rev) - 1
    while low < high:
        if rev[low] != rev[high]:
            return "Not A Palindrome"
        low += 1
        high -= 1
    return "Palindrome"

s = input()
a = ispalindrome(s)
print(a)
