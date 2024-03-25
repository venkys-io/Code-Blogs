# Basic Calculator Program

def add(x, y):
    """Addition function"""
    return x + y

def subtract(x, y):
    """Subtraction function"""
    return x - y

def multiply(x, y):
    """Multiplication function"""
    return x * y

def divide(x, y):
    """Division function"""
    if y != 0:
        return x / y
    else:
        return "Cannot divide by zero!"

# Main program loop
while True:
    # User input
    # Enter first number
    num1 = float(input())
    # Enter operator (+, -, *, /)
    operator = input()
    # Enter second number
    num2 = float(input()

    # Perform calculation based on the operator
    if operator == '+':
        result = add(num1, num2)
    elif operator == '-':
        result = subtract(num1, num2)
    elif operator == '*':
        result = multiply(num1, num2)
    elif operator == '/':
        result = divide(num1, num2)
    else:
        result = "Invalid operator"

    # Display the result
    print(result)

    # Ask if the user wants to perform another calculation
    another_calculation = input("Do you want to perform another calculation? (yes/no): ").lower()
    if another_calculation != 'yes':
        break

print("Calculator program terminated.")
