#include <iostream>
#include <vector>
#include <algorithm>
#include <string> // Add this line to include the necessary header for to_string

std::string largestnumber(std::vector<int> &num)
{
    // Convert each integer to a string and store in a vector
    std::vector<std::string> arr;
    for (auto i : num)
        arr.push_back(std::to_string(i));

    // Sort the strings in descending order based on their concatenated values
    std::sort(begin(arr), end(arr), [](const std::string &s1, const std::string &s2)
              { return s1 + s2 > s2 + s1; });

    // Concatenate the sorted strings to form the largest number
    std::string res;
    for (auto s : arr)
        res += s;

    // Remove leading zeros, except when the result is "0"
    while (res[0] == '0' && res.length() > 1)
        res.erase(0, 1);

    // Return the result as a string
    return res;
}

int main()
{
    // Prompt the user to enter multiple values separated by space
    std::cout << "Enter multiple values separated by space, and press Enter:";

    // Create a vector to store the input numbers
    std::vector<int> arr;
    int num;

    // Read input until a newline character is encountered
    while (std::cin >> num)
    {
        // Add the entered number to the vector
        arr.push_back(num);

        // Check for newline character
        if (std::cin.peek() == '\n')
        {
            break;
        }
    }

    // Find and display the largest number
    std::cout << "The largest number is: " << largestnumber(arr) << std::endl;

    // Return 0 to indicate successful execution
    return 0;
}

// Enter multiple values separated by space, and press Enter:21 23 34 54 9 98 987
// The largest number is: 99898754342321