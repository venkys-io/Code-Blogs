import java.util.Scanner;

public class robotreturn {
    public static void main(String[] args) {
        try (// Get user input for directions (case-insensitive)
                Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the directions: ");
            String z = scanner.nextLine().toUpperCase(); // Convert input to uppercase for case-insensitivity

            // Call the function and print the result
            System.out.println(robotReturnToOrigin(z)); // returns True if the robot returns to the origin else returns False
                                                        

        }
    }

    static boolean robotReturnToOrigin(String input) {
        // Initialize the coordinates to (0, 0)
        int x = 0, y = 0;

        // Iterate through each character in the input string
        for (char i : input.toCharArray()) {
            // Update coordinates based on the current direction
            if (i == 'U') { // U denotes "UP" and it moves towards top from the origin(y-axis)
                y += 1;
            } else if (i == 'D') { // D denotes "DOWN" and it moves bottom from the origin(y-axis)
                y -= 1;
            } else if (i == 'R') { // R denotes "RIGHT" and it moves right hand side from the origin(x-axis)
                x += 1;
            } else if (i == 'L') { // L denotes "LEFT" and it moves left hand side from the origin(x-axis)
                x -= 1;
            } else {
                // Handle invalid input characters other than "R,U,L,D"
                System.out.println("Wrong input");
            }
        }

        // Check if the final coordinates are at the origin (0, 0)
        return x == 0 && y == 0;
    }
}


//Test case 1
//Enter the directions: ruld
//true

//Test case 2
//Enter the directions: rrdludl
//false

//Test case 3
//Enter the directions: rulde
//Wrong input
//false
