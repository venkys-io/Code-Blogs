def robot_return_to_origin(input):# Function to check if the robot returns to the origin
    x = y = 0
    for i in input:# Update the position based on the current character
        if i == "U":
            y += 1
        elif i == "D":
            y -= 1
        elif i == "R":
            x += 1
        elif i == "L":
            x -= 1
        else:
            print("wrong input")
    return x == 0 and y == 0

z = input("Enter the directions: ")# Get user input for robot directions
z=z.upper()
if robot_return_to_origin(z):# Check if the robot returns to the origin
    print("Got the Robot")
else:
    print("lost your robot")



