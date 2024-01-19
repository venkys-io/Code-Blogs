 # Copyrights to venkys.io
# For more information, visit https://venkys.io
def isValidParanthesis(string: str) -> bool:
    stack = list()

    # Loop through each character in the input string
    for char in string:
        # If the character is an opening parenthesis, add it to the stack
        if char == "(" or char == "{" or char == "[":
            stack.append(char)
        else:
            # If the stack is empty and we encounter a closing parenthesis, return False
            if not stack:
                return False
            # Pop the top element from the stack
            top = stack.pop()
            # Check if the current closing parenthesis matches the corresponding opening parenthesis
            if char == ")" and top != "(":
                return False
            if char == "}" and top != "{":
                return False
            if char == "]" and top != "[":
                return False

    # If the stack is empty at the end, the parentheses are balanced
    return len(stack) == 0

# Get user input for the string
user_input = input("Enter a string with parentheses: ")
result = isValidParanthesis(user_input)

# Display the result
if result:
    print("The parentheses are valid.")
else:
    print("The parentheses are not valid.")
