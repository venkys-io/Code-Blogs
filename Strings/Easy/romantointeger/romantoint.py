def roman_to_int(s):
    # Define a dictionary mapping Roman numerals to their integer values
    roman_dict = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
    result = 0# Initialize the result variable to store the total integer value

    # Loop through the Roman numeral string from left to right
    for i in range(len(s)):
        # If the current numeral is smaller than the next numeral, subtract its value
        if i < len(s) - 1 and roman_dict[s[i]] < roman_dict[s[i + 1]]:
            result -= roman_dict[s[i]]
        else:
            result += roman_dict[s[i]]

    return result

# Test the function
roman_numeral = input("Enter a Roman numeral: ")
integer_value = roman_to_int(roman_numeral.upper())
print(f"The integer value of {roman_numeral} is: {integer_value}")
