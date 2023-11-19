public class Main {

    // Function to convert a string to lowercase
    // Returns the lowercase version of the input string
    public static String toLowerCase(String s) {
        StringBuilder result = new StringBuilder();

        // Iterate through each character in the input string
        for (char c : s.toCharArray()) {
            // Check if the character is an uppercase letter
            if (c >= 'A' && c <= 'Z') {
                // Convert uppercase to lowercase using ASCII values
                result.append((char) (c + 32));
            } else {
                // Keep non-uppercase characters unchanged
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Example string
        String inputString = "UpperCase";

        // Convert the string to lowercase and print the result
        System.out.println("Original: " + inputString);
        System.out.println("Lowercase: " + toLowerCase(inputString));
    }
}