def shuffle_string(string, indices):
    n = len(string)
    result = [" "] * n
    for index in range(n):
        result[indices[index]] = string[index]
    return "".join(result)

if __name__ == "__main__":

    custom_string = input("Enter the string: ")
    custom_indices = list(map(int, input("Enter the indices separated by space: ").split()))

    expected_output = input("Enter the expected output: ")

    custom_output = shuffle_string(custom_string, custom_indices)
    print("Custom Example Result:", custom_output)


    if custom_output == expected_output:
        print("test case passed.")
    else:
        print("test case failed.")








