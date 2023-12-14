import java.util.Scanner;

public class shufflestring {

    public static String shuffleString(String str, int[] indices) {
        int n = str.length();
        char[] result = new char[n];
        for (int index = 0; index < n; ++index) {
            result[indices[index]] = str.charAt(index);
        }
        return new String(result);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Custom Example
            System.out.print("Enter the string: ");
            String customString = scanner.nextLine();

            System.out.print("Enter the indices separated by space: ");
            String[] indicesInput = scanner.nextLine().split(" ");
            int[] customIndices = new int[indicesInput.length];
            for (int i = 0; i < indicesInput.length; i++) {
                customIndices[i] = Integer.parseInt(indicesInput[i]);
            }

            System.out.print("Enter the expected output: ");
            String expectedOutput = scanner.nextLine();

            String customOutput = shuffleString(customString, customIndices);
            System.out.println("Custom Example Result: " + customOutput);

            if (customOutput.equals(expectedOutput)) {
                System.out.println("Test case passed.");
            } else {
                System.out.println("Test case failed.");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
