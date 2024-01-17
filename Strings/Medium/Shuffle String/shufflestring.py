# Define a function named shuffle_string that takes a string and a list of indices as input
def shuffle_string(string, indices):
    # Get the length of the input string
    n = len(string)
    
    # Create a list of n empty spaces
    result = [" "] * n
    
    # Iterate through the indices and assign characters from the input string to the corresponding positions
    for index in range(n):
        result[indices[index]] = string[index]
    
    # Convert the list of characters back to a string and return the result
    return "".join(result)

# Check if the script is being run as the main program
if __name__ == "__main__":
    # Prompt the user to enter a custom string
    custom_string = input("Enter the string: ")
    
    # Prompt the user to enter a list of indices separated by space, convert them to integers, and store in a list
    custom_indices = list(map(int, input("Enter the indices separated by space: ").split()))
    
    # Prompt the user to enter the expected output after shuffling the string
    expected_output = input("Enter the expected output: ")

    # Call the shuffle_string function with the custom string and indices
    custom_output = shuffle_string(custom_string, custom_indices)
    
    # Print the result of the custom example
    print("Custom Example Result:", custom_output)

    # Check if the custom output matches the expected output and provide feedback
    if custom_output == expected_output:
        print("Test case passed.")
    else:
        print("Test case failed.")
        
        
# Enter the string: hello
# Enter the indices separated by space: 4 1 3 2 0
# Enter the expected output: oellh
# Custom Example Result: oellh
# Test case passed.