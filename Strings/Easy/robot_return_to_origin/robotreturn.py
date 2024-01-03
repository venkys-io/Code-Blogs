def robot_return_to_origin(input):
    # Initialize the coordinates to (0, 0)
    x = y = 0

    # Iterate through each character in the input string
    for i in input:
        # Update coordinates based on the current direction
        if i == "U": #U denotes "UP" and it moves towards top from the origin(y-axis)
            y += 1
        elif i == "D": #D denotes "DOWN" and it moves bottom from the origin(y-axis)
            y -= 1
        elif i == "R": #R denotes "RIGHT" and it moves right hand side from the origin(x-axis)
            x += 1
        elif i == "L": #L denotes "LEFT" and it moves left hand side from the origin(x-axis)
            x -= 1
        else:
            # Handle invalid input characters other than "R,U,L,D"
            print("Wrong input")

    # Check if the final coordinates are at the origin (0, 0)
    return x == 0 and y == 0

# Get user input for directions (case-insensitive)
z = input("Enter the directions: ")
z = z.upper()  # Convert input to uppercase for case-insensitivity

# Call the function and print the result
print(robot_return_to_origin(z))
#returns True if the robot returns to the origin else returns False

#Test case 1
#Enter the directions: ruld
#true

#Test case 2
#Enter the directions: rrdludl
#false

#Test case 3
#Enter the directions: rulde
#Wrong input
#false
