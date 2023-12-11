import java.util.ArrayList;
import java.util.List;

public class MultiStringSearch {

    // Function to perform multi-string search
    // Returns a list containing patterns found in the text
    public static List<String> multiStringSearch(String text, List<String> patterns) {
        List<String> result = new ArrayList<>();

        // Iterate through each pattern
        for (String pattern : patterns) {
            // Use String.contains to check if the pattern is present in the text
            if (text.contains(pattern)) {
                result.add(pattern);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Sample text and patterns
        String text = "This is a sample text for multi-string search.";
        List<String> patterns = List.of("sample", "search", "notfound");

        // Perform multi-string search
        List<String> result = multiStringSearch(text, patterns);

        // Print the found patterns
        System.out.print("Found patterns:");
        for (String pattern : result) {
            System.out.print(" " + pattern);
        }
        System.out.println();
    }
}
