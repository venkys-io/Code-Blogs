
def longest_common_prefix(strings):
    if not strings:
        return ""

    # Sort the list to get the lexicographically smallest and largest strings
    strings.sort()

    # Compare the first and last strings in the sorted list
    prefix = ""
    for char1, char2 in zip(strings[0], strings[-1]):
        if char1 == char2:
            prefix += char1
        else:
            break

    return prefix

if __name__ == "__main__":
    # Taking user input for a list of strings
    num_strings = int(input("Enter the number of strings: "))
    input_strings = [input(f"Enter string {i + 1}: ") for i in range(num_strings)]

    result = longest_common_prefix(input_strings)

    if result:
        print("Longest common prefix:", result)
    else:
        print("No common prefix.")
