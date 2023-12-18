import java.util.Scanner;

public class robotreturn {

    public static boolean isRobotReturnToOrigin(String input) {
        int x = 0, y = 0;
        for (char i : input.toCharArray()) {
            if (i == 'U') {
                y += 1;
            } else if (i == 'D') {
                y -= 1;
            } else if (i == 'R') {
                x += 1;
            } else if (i == 'L') {
                x -= 1;
            } else {
                System.out.println("Wrong input");
                return false;
            }
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the directions: ");
            String directions = scanner.nextLine().toUpperCase();

            if (isRobotReturnToOrigin(directions)) {
                System.out.println("Robot gotcha");
            } else {
                System.out.println("Lost your robot");
            }
        }
    }
}
