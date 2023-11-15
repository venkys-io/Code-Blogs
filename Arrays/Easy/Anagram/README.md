# Exploring Array Algorithms: Anagram Finder Using Hash Table

Today, let's explore the world of array algorithms specifically focusing on finding anagrams using a hash table. This can be a captivating and practical problem, and it can provide insights into data structures and algorithmic thinking.

## Introduction to Array Algorithm

Array algorithms are fundamental tools, serving as the building blocks for solving a wide range of problems involving ordered data structures. An array is a simple data structure consisting of elements, each identified by an index, making it easy to access and manipulate individual items.

Some of the most commonly used array algorithms are searching, sorting, manipulation, and various operations on the array data structure. Array algorithms have wide applications across various fields, including data processing, numerical analysis, and computational biology. They enable us to efficiently process and extract insights from structured data.

One of the pivotal operations in array manipulation is the identification of anagrams. An anagram is a rearrangement of the letters of a word or phrase to form a different word or phrase. In this blog, we identify anagram using a hash table.

## Hash Table

Hash tables offer a powerful solution for efficiently solving the anagram problem. It efficiently stores and retrieves data using a technique called hashing, It consists of an array of buckets, where each bucket is associated with a unique index. The magic of hash tables lies in the hash function. The content of a hash table is composed of key-value pairs.

An anagram is a word or phrase formed by rearranging the letters of another word or phrase, using all the original letters exactly once. It's a form of word play where the letters of a word or phrase are rearranged to create a new one, often with a different meaning or a humorous twist. anagrams follow:

* Letter Rearrangement
* Original Letters Only
* New Meaning or Phrase

**Example:**
**Original Word:**
LISTEN
**Anagram:**
SILENT

The letters in the word "LISTEN" can be rearranged to form the word "SILENT," making it an anagram. The anagram retains all the original letters of the word but presents them in a different order, resulting in a new word with a different meaning.

For an Anagram Finder, this involves creating a hash function that accurately captures the similarities between words, enabling the grouping of anagrams at the same hash index.

## overview of Hash Table

A hash table is a data structure that maps keys to values. It's also known as a hash map. A hash table works by using a hash function to translate each key into a distinct index in an array. The index then functions as a storage location for the matching value.

A hash table is one part of a technique called hashing. The other part is a hash function, which is an algorithm that produces an index of where a value can be found or stored in the hash table.
Hash tables are used to insert, look up, and remove key-value pairs quickly. The index value behaves as a key for the data value, which enables very fast data access. Hash tables are also known as associative arrays or dictionaries.

The hash function takes input (in this case, words) and produces a fixed-size numerical representation or hash code. This code is used as an index to store or retrieve the associated data. Due to the finite size of the array, collisions can occur when multiple keys hash to the same index. collision resolution strategies, such as chaining (using linked lists at each array index) or open addressing (finding the next available slot), are used to maintain the integrity and speed of the Hash Table.

## Python Code

```python

#  Copyrights to venkys.io
#  For more programs visit venkys.io 
#  Python program for Anagrams

# Time complexity:O(n)constant time complexity
# Space complexity:O(n)


def is_anagram(s1,s2):
    # We use hashtables to solve this problem
    # Check for the length of the String
    if len(s1) != len(s2):
        #If lengths are different, strings can't be anagrams
        return False
    else:
        # Create a hashtable to store character counts
        ht=dict()
        # Iterate over characters in s1 
        for i in s1:
            if i in ht. keys(): #If character i is already in the hashtable
                # Update count for characters in s1
                ht[i]+=1
            else:
                # Otherwise, initialize its count to 1 
                ht[i]=1
        # Iterate over characters in s2
        for j in s2:
            # If character j is not in the hashtable
            if j not in ht. keys():
                # Strings can't be anagrams
                return False
            # Decrement the count of character j in the hashtable
            ht[j]-=1
        # Check if all counts in the hashtable are zero
        for key, value in ht. items():
            if value!=0:
                # If any count is not zero, strings are not anagrams
                return False 
        # If all counts are zero, strings are anagrams
        return True

                
# test drive code
if __name__ == "__main__":
    # Input two strings from the user
    s1=input("Enter the string: ")
    s2=input("Enter another String: ")
    # Check if the strings are anagrams and print the result
    if(is_anagram(s1,s2)):
        print(f"{s1} and {s2} are Anagrams")
    else:
        print(f"{s1} and {s2} are Not Anagrams")


```

Let us see the step-by-step process of solving the anagram finder using the Hash Table in (**PYTHON**)

**1. Create Function:**
   The first step is to define a function is_anagram taking two strings as parameters.

**2. Check the length of the strings:**
   The first step after the creation of the function is to check whether the lengths of the strings are equal or not. If the lengths of the strings are not equal then the strings are not anagram. If the lengths of the strings are equal then create a hash table.

**3. Create, Update Frequencies and Check for anagram:**
   We will create a hash table to store the frequency of characters. Iterates through each character of strings(s1,s2) simultaneously, updating frequencies in the hashtable. Check if characters in s2 are present in s1. If not, the function returns false (i.e.Strings are not anagram).

**4. Check Final Frequencies:**
   Check if all characters have zero frequency in the hashtable. If any character has a non-zero frequency, then the strings are not Anagram and the function returns False. If all characters have zero frequency, the function returns True, indicating that the strings are anagrams.

Finally, takes user input for two strings, calls the is_anagram function, and prints whether the strings are anagrams or not.

## Java Code

```java

// Copyrights to venkys.io
// For more programs visit venkys.io
// JAVA program for Anagrams

// Time Complexity
// Space Complexity


import java. util.HashMap;
import java. util.Map;

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
            int value = map.getOrDefault(map, 0);
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
        String s1="hello";
        String s2="olleh";
        // Checking if the strings are anagrams and printing the result
        if(isAnagram(s1,s2)){
            System.out.println(s1+" and "+s2+" are Anagrams");
        }
        else{
            System.out.println(s1+" and "+s2+" are not Anagrams");
        }
    }
}
```

Let us see the step-by-step process of solving the anagram finder using the Hash Table in (**JAVA**)

**1. Define the Main Class and Anagram method:**
    Declare a main class with two methods one is for finding an Anagram(isAnagram) and the other is the main method

**2. Check String Lengths and Create HashMap:**
   Check whether the lengths of the strings are equal or not. If the lengths of the strings are not equal then the strings are not anagram. If the lengths of the strings are equal then create a Hash Map named map to store the frequency of characters in the first string (s1). Iterate through each character in the first string (s1) and update the frequency in the map HashMap.

**3. Iterate through Characters in the Second String and check Frequencies:**
   Iterate through each character in the second string (s2), check and update the frequency in the map HashMap. If the retrieved frequency (value) is equal to 0. If it is, it means the character in s2 is not present in s1 or its frequency has already been exhausted, and the method returns false. This indicates that the strings are not anagrams. If the frequency is not zero, it updates the frequency in the map HashMap by decrementing it.

**4. Main Method and Example String:**
   Define the main method where the program execution begins, define example strings (s1 and s2), and check if they are anagrams using the isAnagram method. Print the result to the console.

## Time and Space Complexity Analysis

To analyze the efficiency of an algorithm, we consider its time and space complexity. Time complexity refers to the time it takes for an algorithm to run, while space complexity refers to the amount of memory or storage space required by an algorithm.

The time complexity of an algorithm is typically expressed using "big O" notation, which gives us an upper bound on the number of operations required by the algorithm as a function of its input size. In this case, the input size is represented by s1(n) and s2(n).

Hashtable Operations in the Loop, iterate over each character of the strings once, and the hashtable operations inside the loop (checking for existence and updating frequency) are constant time on average. The loop contributes O(n) to the time complexity, where n is the length of the strings.

The space complexity is O(n), where n is the length of the input strings s1 and s2. This space complexity is mainly due to the hashtable (ht) used to store the frequency of characters in the strings. all characters of the strings are unique, and the hashtable would have a size proportional to the length of the strings.

Therefore, the overall time complexity is dominated by the linear operations in the loop, resulting in a final time complexity of O(n) and the overall space complexity is O(n) where n is the length of the input strings s1 and s2.

## Real-world Applications

1. **Cryptography:**
Anagrams can be used in the field of cryptography for creating coded messages. By rearranging the letters of words or phrases, a secret message can be hidden.

2. **Memory and Cognitive Training:**
  Anagram-solving is a common exercise in brain training programs. It helps improve memory, cognitive flexibility, and language skills.

3. **Data Encryption:**
 Anagram-based encryption algorithms may use letter rearrangements as part of the encryption process to enhance the security of transmitted data.

4. **Literature and Writing:**
 Authors and poets may use anagrams as a literary device to convey hidden meanings or messages within their works.

5. **Error Detection in DNA Sequencing:**
Anagrams can be applied in bioinformatics for error detection in DNA sequencing. Checking for anagrams can help identify errors or mutations in genetic sequences.

6. **Code Names and Hidden Messages:**
Anagrams are used to create code names or acronyms for various organizations, projects, or initiatives, providing a layer of secrecy or exclusivity.
