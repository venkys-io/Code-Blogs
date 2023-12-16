def toLowerCase(s: str) -> str:
    # Initialize an empty string to store the converted characters
    lowercase = ""

    # Loop through each character in the input string
    for char in s:
        # Check if the character is uppercase
        if 'A' <= char <= 'Z':
            # Convert the uppercase character to lowercase using ASCII manipulation
            lowercase += chr(ord(char) + 32)
        else:
            # If the character is not uppercase, keep it unchanged
            lowercase += char 

    # Return the converted string with lowercase characters
    return lowercase

# Test the function
string = "UpperCase"
print(toLowerCase(string))