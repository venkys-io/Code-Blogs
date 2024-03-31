// Copyrights to venkys.io
// For more programs visit venkys.io
// JAVA program for Anagrams

// Time Complexity
// Space Complexity


import java. util.HashMap;
import java. util.Map;
import java.util.Scanner;

public class Main {
    // Method to check if two strings are anagrams.
    static boolean isAnagram(String s1,String s2){

        // Check if the lengths of the two strings are not equal, they cannot be anagrams
        if(s1.length()!=s2.length()) return false;

        // Create a HashMap to store character frequencies.

        Map<Character,Integer> map = new HashMap<>();

        // Iterate through each character in the first string
        for(char ch:s1.toCharArray()){
            // Update the map with the frequency of character
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        // Iterate through each character in the second string
        for(char ch:s2.toCharArray()){
            // Get the frequency of the character from the map
            int value = map.getOrDefault(ch, 0);
            // If the frequency is 0, the strings are not anagrams
            if(value==0)
                return false ;
            // Update the map by decreasing the frequency of the character
            map.put(ch,value-1);
        }
        // If all characters have been matched, the strings are anagrams
        return true;
    }
    // The main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the first string 
        // System.out.print("Enter the first string: ");
        String s1 = scanner.nextLine();

        // Input the second string 
        // System.out.print("Enter the second string: ");
        String s2 = scanner.nextLine();

        // Checking if the strings are anagrams and printing the result
        if(isAnagram(s1,s2)){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}
