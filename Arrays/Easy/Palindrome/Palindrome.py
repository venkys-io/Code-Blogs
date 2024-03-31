# Copyrights to venkys.io
# For more programs visit venkys.io 
# Python program for Palindrome

# Time complexity:O(n)
# Space complexity:O(1)


# function return wether the input string is palindrome or not
# It takes a string as a parameter
def string_palindrome(string):
    cleared_string=''.join(char.lower() for char in string if char.isalnum())
    # length variable stores the length of string  
    length=len(cleared_string)
    # loop iterates half of the length of string 
    for i in range(len(cleared_string)//2):
        # Check if the character at index i is not equal to its corresponding character from the end
        if cleared_string[i]!=cleared_string[length-(i+1)]:
            print("False")
            break
    else:
        # If the loop completes without breaking, it's a palindrome
        print("True")

#test drive code:
string = input()
string_palindrome(string)
