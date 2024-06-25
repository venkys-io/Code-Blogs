def convertStringToInteger(s):
    # Define constants for the 32-bit signed integer range
    INT_MIN, INT_MAX = -2**31, 2**31 - 1
    
    # Initialize variables for the result, sign, and position in the string
    answer, sign, i = 0, 1, 0

    # Skip leading whitespaces
    while i < len(s) and s[i] == " ":
        i += 1

    # Check for empty string or non-numeric input
    if i == len(s) or (s[i] not in ["+", "-"] and not s[i].isdigit()):
        print("Error: Invalid input. Please enter a valid numeric string.")
        return None

    # Handle sign
    if s[i] in ["+", "-"]:
        # Set the sign based on the presence of a positive or negative sign
        sign = -1 if s[i] == "-" else 1
        i += 1

    # Process digits
    while i < len(s) and s[i].isdigit():
        digit = int(s[i])
        # Check for overflow
        if (INT_MAX - digit) // 10 < answer:
            return INT_MAX if sign == 1 else INT_MIN
        # Update the result by multiplying by 10 and adding the current digit
        answer = answer * 10 + digit
        i += 1

    # Return the final result multiplied by the sign
    return sign * answer

if __name__ == "__main__":
    # Example usage
    input_string = input("Enter a string: ")
    result = convertStringToInteger(input_string)

    # Check for None to handle cases of invalid input
    if result is not None:
        print("Converted integer:", result)
