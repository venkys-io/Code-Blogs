#include <iostream>



using namespace std;

// Function to add two numbers
double add(double x, double y) {
return x + y;
}

// Function to subtract two numbers
double subtract(double x, double y) {
return x - y;
}

// Function to multiply two numbers
double multiply(double x, double y) {
return x * y;
}

// Function to divide two numbers
double divide(double x, double y) {
if (y != 0) {
return x / y;
} else {
cout << "Error: Cannot divide by zero!" << endl;
return 0;  // You can customize the return value for division by zero
}
}

int main() {
char operation;
double num1, num2, result;

// Enter operator (+, -, *, /): "
cin >> operation;

// Enter first number
cin >> num1;

// Enter second number: 
cin >> num2;

switch (operation) {
    case '+':
        result = add(num1, num2);
        break;
    case '-':
        result = subtract(num1, num2);
        break;
    case '*':
        result = multiply(num1, num2);
        break;
    case '/':
        result = divide(num1, num2);
        break;
    default:
        cout << "Error: Invalid operator" << endl;
        return 1;  // Exit program with an error code
}

cout << result << endl;

return 0;

}
