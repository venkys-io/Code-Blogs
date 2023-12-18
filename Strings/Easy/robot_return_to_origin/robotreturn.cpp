#include <iostream>
#include <string>
using namespace std;

bool robot_return_to_origin(const string &input) // Function to check if the robot returns to the origin
{
    int x = 0, y = 0;
    for (char i : input) // Iterate through each character in the input string
    {
        if (i == 'U') // Update the position based on the current character
        {
            y += 1;
        }
        else if (i == 'D')
        {
            y -= 1;
        }
        else if (i == 'R')
        {
            x += 1;
        }
        else if (i == 'L')
        {
            x -= 1;
        }
        else
        {
            cout << "wrong input" << endl; // Handle invalid input
            return false;
        }
    }
    return x == 0 && y == 0; // Check if the final position is the origin (0, 0)
}

int main()
{
    string directions;
    cout << "Enter the directions: ";
    cin >> directions; // Read user input
    for (char &c : directions)
    {
        c = toupper(c); // Convert the input string to uppercase for case-insensitive comparison
    }

    if (robot_return_to_origin(directions)) // Convert the input string to uppercase for case-insensitive comparison
    {
        cout << "Robot gotcha" << endl;
    }
    else
    {
        cout << "Lost your robot" << endl;
    }

    return 0;
}
