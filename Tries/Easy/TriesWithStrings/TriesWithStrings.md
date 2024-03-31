# Tries With Strings

## Problem Statement

Strings are fundamental in programming, and optimizing operations on them is crucial. One powerful data structure for string-related problems is the `Trie`, a tree-like structure that excels in storing and searching for strings efficiently. In this blog, we'll delve into the implementation of Tries for string problems using Java, Python, and C++.

## Introduction

Trie, short for re**trie**val tree or digital tree, is a tree-like data structure that is used to store a dynamic set or associative array where keys are strings. Tries are particularly useful for string-related problems, providing efficient solutions for tasks like searching for a word in a dictionary, autocomplete suggestions, and more.

## Overview

Tries consist of nodes, where each node represents a character in a string. The path from the root to a particular node forms the string represented by that node. Each node may have multiple children, each associated with a unique character. Tries excel in string-related problems due to their ability to provide fast lookups and insertions.

## Code

Let's dive into the implementation of Tries in Java, Python, and C++.

### Java Implementation

```java
/* Copyrights to venkys.io
For more information, visit https://venkys.io */

//Space complexity: O(total characters * average length of words)
//Time complexity
// Insertion: O(n); n is the length of the word.
// Search: O(n)
import java.util.Scanner;
public class VSDTriesWithStrings{

public static class VSDTrieNode{
	VSDTrieNode []tnodes;//Array of tries node
	int DIGITS = 26;
	char character;//Actual character

	//Default constructor
	VSDTrieNode(){
		this.tnodes=new VSDTrieNode[DIGITS];
		this.character='\0';
		for(int i=0;i<DIGITS;i++)
			tnodes[i] = null;
	}
}

//List of strings to be inserted into trie
public static String[] stringList;

//Root node of trie
public static VSDTrieNode rootNode=new VSDTrieNode();

//String variable to store search string 
public static String searchstring="";

//Method to insert strings into the trie
public static void VSDInsertNode(VSDTrieNode rootNode, int i,int j){
    //getting index to store the character 
	int index = stringList[i].charAt(j)-'a';

	//Checking for the appropriate position to inserrt character
	if(rootNode.tnodes[index] == null) {
		rootNode.tnodes[(int) index] = new VSDTrieNode();
		rootNode.tnodes[(int) index].character = stringList[i].charAt(j);
		if(j+1<stringList[i].length()) {
			rootNode = rootNode.tnodes[(int)index];
			VSDInsertNode(rootNode,i,j+1);
		}
	}

	//For characters already present, traversing the trie until mismatch of character is found
	else {
		if(j+1<stringList[i].length()) {
			rootNode = rootNode.tnodes[(int)index];
			VSDInsertNode(rootNode,i,j+1);
		}
		
	}
}

//Method to find wheather a string is present in trie
public static String VSDSearchTrieRecursive(VSDTrieNode node, String s, int j){

	int index = s.charAt(j)-'a';
		if(node.tnodes[index]==null)
		{	
			return searchstring;
		}
		else if(node.tnodes[index].character!='\0')
		{
			searchstring+= node.tnodes[index].character;
			if(j+1<s.length()) {
			VSDSearchTrieRecursive(node.tnodes[index],s, j+1);	
			}
			
		}
		return searchstring;
}

public static void main(String args[]) {
	Scanner scanner = new Scanner(System.in);

        // Input the number of strings in the list
        // System.out.print("Enter the number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Create an array to store the strings
        String[] stringList = new String[n];

        // Input each string from the user
        for (int i = 0; i < n; i++) {
            stringList[i] = scanner.nextLine();
	//Inserting strings into the trie
	for(int i = 0;i<stringList.length;i++)
		 VSDInsertNode(rootNode,i,0);
	String searchkey = scanner.nextLine();
	searchstring="";
	String searchres=VSDSearchTrieRecursive(rootNode,searchkey,0);
	if(searchkey.contentEquals(searchres))
		System.out.println("Key found");
	else
		System.out.println("Key not found");
}
}
```

### Python Implementation

```python
""" Copyrights to venkys.io
For more information, visit https://venkys.io """

# Space complexity: O(total characters * average length of words)
# Time complexity
# Insertion: O(n); n is the length of the word.
# Search: O(n)

class VSDTrieNode:
    def __init__(self):
        self.tnodes = [None] * 26
        self.character = '\0'

def VSDInsertNode(rootNode, i, j):
    index = ord(stringList[i][j]) - ord('a')
    
    if rootNode.tnodes[index] is None:
        rootNode.tnodes[index] = VSDTrieNode()
        rootNode.tnodes[index].character = stringList[i][j]
        
        if j + 1 < len(stringList[i]):
            rootNode = rootNode.tnodes[index]
            VSDInsertNode(rootNode, i, j + 1)
    else:
        if j + 1 < len(stringList[i]):
            rootNode = rootNode.tnodes[index]
            VSDInsertNode(rootNode, i, j + 1)

def VSDSearchTrieRecursive(node, s, j):
    index = ord(s[j]) - ord('a')

    if node.tnodes[index] is None:
        return ""
    elif node.tnodes[index].character != '\0':
        searchstring = node.tnodes[index].character
        if j + 1 < len(s):
            return searchstring + VSDSearchTrieRecursive(node.tnodes[index], s, j + 1)
        else:
            return searchstring
    else:
        return ""

n = int(input())

# Initialize an empty list to store the strings
stringList = []

# Input each string from the user
for i in range(n):
    string = input()
    stringList.append(string)

rootNode = VSDTrieNode()

for i in range(len(stringList)):
    VSDInsertNode(rootNode, i, 0)

searchkey = input()
searchres = VSDSearchTrieRecursive(rootNode, searchkey, 0)

if searchkey == searchres:
    print("Key found")
else:
    print("Key not found")
```

### C++ Implementation

```cpp
/* Copyrights to venkys.io
For more information, visit https://venkys.io */

//Space complexity: O(total characters * average length of words)
//Time complexity
// Insertion: O(n); n is the length of the word.
// Search: O(n)

#include <iostream>
#include <cstring>
#include <vector>

class VSDTrieNode {
public:
    VSDTrieNode* tnodes[26];
    char character;

    VSDTrieNode() : character('\0') {
        std::memset(tnodes, 0, sizeof(tnodes));
    }
};

// Pass the stringList as a parameter
void VSDInsertNode(VSDTrieNode* rootNode, const std::vector<std::string>& stringList, int i, int j) {
    int index = stringList[i][j] - 'a';

    if (rootNode->tnodes[index] == nullptr) {
        rootNode->tnodes[index] = new VSDTrieNode();
        rootNode->tnodes[index]->character = stringList[i][j];

        if (j + 1 < stringList[i].length()) {
            rootNode = rootNode->tnodes[index];
            VSDInsertNode(rootNode, stringList, i, j + 1);
        }
    } else {
        if (j + 1 < stringList[i].length()) {
            rootNode = rootNode->tnodes[index];
            VSDInsertNode(rootNode, stringList, i, j + 1);
        }
    }
}

std::string VSDSearchTrieRecursive(VSDTrieNode* node, const std::string& s, int j) {
    int index = s[j] - 'a';

    if (node->tnodes[index] == nullptr) {
        return ""; // Return an empty string when the node is not found
    } else if (node->tnodes[index]->character != '\0') {
        std::string searchstring = "";
        searchstring += node->tnodes[index]->character;
        if (j + 1 < s.length()) {
            return searchstring + VSDSearchTrieRecursive(node->tnodes[index], s, j + 1);
        } else {
            return searchstring;
        }
    } else {
        return "";
    }
}

int main() {
    // Initialize stringList as a vector of strings
     int n;
    // std::cout << "Enter the number of strings: ";
    std::cin >> n;
    std::cin.ignore(); // Ignore the newline character

    // Initialize an empty vector to store the strings
    std::vector<std::string> stringList;

    // Input each string from the user
    std::string str;
    for (int i = 0; i < n; ++i) {
        // std::cout << "Enter string #" << (i + 1) << ": ";
        std::getline(std::cin, str);
        stringList.push_back(str);
    }
    VSDTrieNode* rootNode = new VSDTrieNode();

    for (int i = 0; i < stringList.size(); i++) {
        VSDInsertNode(rootNode, stringList, i, 0);
    }

    std::string searchkey;
    std::cin >> searchkey;
    std::string searchstring = "";
    std::string searchres = VSDSearchTrieRecursive(rootNode, searchkey, 0);

    if (searchkey == searchres) {
        std::cout << "Key found" << std::endl;
    } else {
        std::cout << "Key not found" << std::endl;
    }

    return 0;
}

```
## Step-by-Step Explanation

Here's a step-by-step explanation that is generally applicable to C++, Java, and Python:

### Trie Node Definition
1. **Class Definition:** The code defines a class named `VSDTrieNode` to represent a node in the Trie.

2. **Member Variables:**
   - `tnodes`: An array of Trie nodes, representing the children of the current node.
   - `DIGITS`: The number of possible characters (assuming lowercase English letters, set to 26).
   - `character`: The actual character stored in the node.

3. **Constructor:** Initializes the Trie node with an array of null children nodes and a null character.

### Trie Implementation
4. **Trie Operations:**
   - **Insertion (`VSDInsertNode`):**
     - For each character in a given string, it calculates the index based on the character's ASCII value.
     - If the node at that index is null, a new node is created, and the character is stored.
     - Recursively continues the insertion process for the next character.
     
   - **Search (`VSDSearchTrieRecursive`):**
     - Searches for a given string in the Trie recursively.
     - Builds the search string character by character as it traverses the Trie.
     - Returns the search string when the search is complete or if the string is not found.

### Trie Initialization and Usage
5. **Initialization:**
   - An array `stringList` contains a list of strings to be inserted into the Trie.
   - The root node of the Trie is initialized as `rootNode`.

6. **Insertion of Strings:**
   - The main method iterates over the `stringList` and inserts each string into the Trie using `VSDInsertNode`.

7. **Search Operation:**
   - The code searches for a specific key (e.g., "apple") in the Trie using `VSDSearchTrieRecursive`.
   - If the key is found, it prints "Key found"; otherwise, it prints "Key not found."

### Note:
- The Trie is built based on the strings provided in `stringList`.
- The search operation uses recursion to traverse the Trie and build the search string.

## Time and Space Complexity Analysis

- **Time Complexity:**
    - Insertion: O(n), where n is the length of the word.
    - Search: O(n), where n is the length of the target word.

- **Space Complexity:**
    - O(total characters * average length of words) for storing the Trie.

## Real-World Applications

Tries find applications in various scenarios:

- **Spell Checkers:** Efficiently check if a given word is correctly spelled.

- **Auto-Complete Systems:** Provide quick suggestions based on the prefix entered by the user.

- **IP Routing:** Tries are used to store IP addresses for efficient routing lookups.

- **Phone Book Search:** Facilitate quick search operations for contact names.

Tries, with their efficient structure for string-related operations, play a vital role in optimizing algorithms and solving real-world problems. Incorporating them into your programming toolkit can greatly enhance your ability to handle string-related challenges effectively.

## Test Cases

- Input:
  5
  apple
  app
  amazon
  laptop
  azure
  applet
  Search Key:
  app
  Output:
  Key Found

  Explanation:
  - We input 5 strings: "apple", "app", "amazon", "laptop", and "azure".
  - The search key is "app".
  - The code constructs a trie from the input strings.
  - Then, it searches for the search key "app" in the trie.
  - Since "app" is a prefix of "apple" and "applet", the search result is "app".
  - Thus, the output is "Key found".

- Input:
  6
  apple
  banana
  orange
  grape
  melon
  mango
  Search Key:
  man
  Output:
  Key not found

  Explanation:
  - We input 6 strings: "apple", "banana", "orange", "grape", "melon", and "mango".
  - The search key is "man".
  - The code constructs a trie from the input strings.
  - Then, it searches for the search key "man" in the trie.
  - Since "man" is not a prefix of any string in the trie, the search result is an empty string.
  - Thus, the output is "Key not found".
