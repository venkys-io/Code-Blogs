# Exploring Tries : TriesAutoCompleteStrings

Today, we dive into the fascinating world of Tries and uncover one of their most captivating mysteries . Get ready to embark on an adventure that will challenge your mind and leave you with newfound insights into Tries!

## Introduction of Tries

Trie, also known as a prefix tree or digital tree, is a tree-like data structure used to store and manage a dynamic set of strings. The word "Trie" comes from the word "retrieval," reflecting its main application in efficiently retrieving a set of strings with common prefixes. Tries are particularly useful in tasks involving dictionaries, spell-checking, IP routing tables, and auto-completion systems.

- A Trie is a tree-like data structure where each node represents a single character of a string.
- The root node represents the empty string, and each edge from a node to its children corresponds to one character.

## Tries Auto Complete String

Trie-based string auto-completion is a powerful technique used to efficiently suggest and complete words or phrases based on a partial input. This concept is particularly useful in applications like search engines, text editors, and predictive text systems on mobile devices.

- Auto-completion involves predicting and suggesting possible completions for a partial input string.
- Trie-based auto-completion leverages the Trie's ability to represent the structure of words and their common prefixes.
- During Trie construction, words are inserted into the structure by adding nodes for each character in the word.
- Common prefixes are shared among words, resulting in a compact representation of the vocabulary.
- To perform auto-completion, the Trie is traversed based on the characters in the partial input.
- The traversal continues until the Trie reaches a node representing the last character of the partial input.

## Overview of Tries

Nodes in a Trie contain links to their children, typically organized as an array or a map based on the characters.

- Paths from the root to the leaves of the Trie represent complete words or strings.
- Traversing a path from the root to a node forms a string by concatenating the characters along the edges.
- Tries efficiently handle prefixes, as common prefixes share nodes in the tree, reducing redundancy and improving space efficiency.
- Inserting a string into a Trie involves traversing the tree from the root, creating nodes as needed for each character in the string.
- Searching for a string in a Trie involves traversing the tree along the characters of the string.
- If the search reaches a node representing the last character of a string and that node is marked as the end of a word, the search is successful.

## Code

```python
class VSDTrieNode:
    def __init__(self):
        self.tnodes = [None] * 26
        self.character = '\0'
        self.end_of_word = False

def vsd_insert_node(root_node, string_list, i, j):
    index = ord(string_list[i][j]) - ord('a')

    if root_node.tnodes[index] is None:
        root_node.tnodes[index] = VSDTrieNode()
        root_node.tnodes[index].character = string_list[i][j]

        if j + 1 < len(string_list[i]):
            root_node = root_node.tnodes[index]
            vsd_insert_node(root_node, string_list, i, j + 1)

        if j + 1 == len(string_list[i]):
            root_node.tnodes[index].end_of_word = True
    else:
        if j + 1 < len(string_list[i]):
            root_node = root_node.tnodes[index]
            vsd_insert_node(root_node, string_list, i, j + 1)

        if j + 1 == len(string_list[i]):
            root_node.tnodes[index].end_of_word = True

def vsd_match_string(root_node, s, i):
    if i >= len(s):
        vsd_auto_complete(root_node, s)
    else:
        c = s[i]
        index = ord(c) - ord('a')
        if root_node.tnodes[index] is None:
            print("no strings matched")
        elif root_node.tnodes[index].character == c:
            vsd_match_string(root_node.tnodes[index], s, i + 1)

def vsd_auto_complete(node, s):
    for i in range(25):
        if i != 0 and node.tnodes[i - 1] is not None:
            temp = ""
            for k in range(len(s) - 1):
                temp += s[k]
            s = temp

        if node.tnodes[i] is not None:
            s += node.tnodes[i].character
            if node.tnodes[i].end_of_word:
                print(s)
            vsd_auto_complete(node.tnodes[i], s)

def main():
    string_list = ["search", "seek", "seaked", "soak", "settle", "sea", "setting"]
    root_node = VSDTrieNode()

    for i in range(len(string_list)):
        vsd_insert_node(root_node, string_list, i, 0)

    vsd_match_string(root_node, "ab", 0)

if __name__ == "__main__":
    main()
```

## Explanation

****1. VSDTrieNode Class:****

- This class represents a node in the Trie.
- tnodes : An array of 26 elements, representing child nodes for each lowercase letter of the English alphabet.
- character : The character associated with the current node.
- end_of_word : A boolean flag indicating whether the current node represents the end of a word.

****2. vsd_insert_node Function:****

- This function inserts a string into the Trie.
- It takes the root node of the Trie, the list of strings (string_list), and indices i and j as parameters.
- It calculates the index of the current character in the Trie using ASCII values.
- If the corresponding child node is None, a new node is created, and the character is set.
- The function recursively continues insertion for the next character until the end of the string is reached.

****3. vsd_match_string Function:****

- This function searches for a string in the Trie based on a partial input.
- It takes the root node of the Trie, the input string (s), and index i as parameters.
- If the end of the input string is reached, it calls vsd_auto_complete to perform auto-completion.
- Otherwise, it recursively searches for the next character in the Trie.

****4. vsd_auto_complete Function:****

- This function performs auto-completion, printing all possible completions for the given partial input.
- It takes a node in the Trie (node) and the current string ( s ) as parameters.
- It uses a loop to iterate through the child nodes of the current node.
- It recursively performs auto-completion for each child node, updating the current string accordingly.

****5. main Function:****

     The **`main`** function initializes a list of strings (**`string_list`**) and the root node of the Trie.

- It inserts each string into the Trie using the **`vsd_insert_node`** function.
- Finally, it calls the **`vsd_match_string`** function to search for and perform auto-completion on the input string "ab".

```java
public class VSDTriesAutoCompleteStrings {
	//Class to store the structure of trie
	public static class VSDTrieNode{
		VSDTrieNode []tnodes;//Array of tries node
		int DIGITS = 26;
		char character;//Actual character
		boolean endofWord;//Boolean flag to mark the end of word
		//Default constructor
		VSDTrieNode(){
			this.tnodes=new VSDTrieNode[DIGITS];
			this.character='\0';
			this.endofWord=false;
			for(int i=0;i<DIGITS;i++)
				tnodes[i] = null;
		}
	}
	//List of strings to be inserted into trie
	public static String[] stringList;
	//Root node of trie
	public static VSDTrieNode rootNode=new VSDTrieNode(); 
	
	//Method to insert strings into the trie
	public static void VSDInsertNode(VSDTrieNode rootNode, int i,int j)

	{	//getting index to store the character 
		int index = stringList[i].charAt(j)-'a';
		//Checking for the appropriate position to inserrt character
		if(rootNode.tnodes[index] == null) {
			rootNode.tnodes[(int) index] = new VSDTrieNode();
			rootNode.tnodes[(int) index].character = stringList[i].charAt(j);
			if(j+1<stringList[i].length()) {
				rootNode = rootNode.tnodes[(int)index];
				VSDInsertNode(rootNode,i,j+1);
			}
			//When the end of string is reached, marking the node with end of word
			if(j+1==stringList[i].length()) {
				rootNode.tnodes[(int)index].endofWord=true;
			}
		}
		//For characters already present, traversing the trie until mismatch of character is found
		else {
			if(j+1<stringList[i].length()) {
				rootNode = rootNode.tnodes[(int)index];
				VSDInsertNode(rootNode,i,j+1);
			}
			//When the end of string is reached, marking the node with end of word
			if(j+1==stringList[i].length()) {
				rootNode.tnodes[(int)index].endofWord=true;
			}
			
		}
	}
//Method to check whether the given character string pattern is present in the trie	
public static void VSDMatchString(VSDTrieNode rootNode,String s, int i) {
	if(i>=s.length()) {
		VSDAutoComplete(rootNode,s);
	}
	else {
	char c= s.charAt(i);
	int index=c-'a';
	if(rootNode.tnodes[index]==null) 
	System.out.println("no strings matched");
	else if(rootNode.tnodes[index].character==c) 
		VSDMatchString(rootNode.tnodes[index],s,i+1);
	}
}
//Method to find strings presnt in the trie that completes given string
public static void VSDAutoComplete(VSDTrieNode node,String s) {
	for(int i=0;i<25;i++) {
		if(i!=0 &&node.tnodes[i-1]!=null) {
			String temp="";
			for(int k=0;k<s.length()-1;k++) {
				temp+=s.charAt(k);
			}
			s=temp;
		}
		if(node.tnodes[i]!=null) {
			s+=node.tnodes[i].character;
			if(node.tnodes[i].endofWord==true)System.out.println(s);
			VSDAutoComplete(node.tnodes[i],s);
		}
	}
}

public static void main(String args[]) {
		stringList=new String[] {"search","seek","seaked","soak","settle","sea","setting"};
		//Inserting strings into the trie
		for(int i = 0;i<stringList.length;i++)
			 VSDInsertNode(rootNode,i,0);
		VSDMatchString(rootNode,"ab",0);
	}
}
```

## Explanation

### **1. VSDTrieNode Class:**

- This class represents a node in the Trie.
- It contains an array of 26 elements, tnodes , representing child nodes for each lowercase letter of the English alphabet.
- character stores the character associated with the current node.
- endofWord is a boolean flag indicating whether the current node represents the end of a word.

### **2. VSDInsertNode Method:**

- This method inserts a string into the Trie.
- It takes the root node of the Trie ( rootNode ), and indices i and j.
- It calculates the index of the current character in the Trie.
- If the corresponding child node is null , a new node is created, and the character is set.
- The method recursively continues insertion for the next character until the end of the string is reached.

### **3. VSDMatchString Method:**

- This method searches for a string in the Trie based on a partial input.
- It takes the root node of the Trie ( rootNode ), the input string ( s ), and index i.
- If the end of the input string is reached, it calls VSDAutoComplete to perform auto-completion.
- Otherwise, it recursively searches for the next character in the Trie.

### **4. VSDAutoComplete Method:**

- This method performs auto-completion, printing all possible completions for the given partial input.
- It takes a node in the Trie ( node ) and the current string (s).
- It uses a loop to iterate through the child nodes of the current node.
- It recursively performs auto-completion for each child node, updating the current string accordingly.

### **5. main Method:**

- The main method initializes a list of strings ( stringList ) and the root node of the Trie.
- It inserts each string into the Trie using the VSDInsertCode method.
- Finally, it calls the VSDMatchString method to search for and perform auto-completion on the input string "ab".

## Time and Space Complexities

### **Time Complexity:**

1. **Insertion (vsd_insert_node):**
    - In the worst case, each character of each string needs to be inserted into the Trie.
    - For each character insertion, the code traverses the Trie and creates a new node if necessary.
    - The time complexity for inserting a single string is O(m), where m is the length of the string.
    - For n strings, the overall time complexity of insertion is O(n * m).
2. **Search (vsd_match_string):**
    - The search function traverses the Trie based on the input string.
    - In the worst case, it might traverse the entire Trie for each character of the input string.
    - The time complexity for the search operation is O(m), where m is the length of the input string.
3. **Auto-Complete (vsd_auto_complete):**
    - The auto-complete function performs a depth-first traversal of the Trie, visiting each node.
    - The time complexity is proportional to the number of nodes in the Trie.
    - In the worst case, it is O(N), where N is the total number of nodes in the Trie.

### **Space Complexity:**

1. **Trie Structure (VSDTrieNode):**
    - The space complexity of the Trie structure is O(N), where N is the total number of nodes in the Trie.
    - Each node in the Trie requires constant space, and the total number of nodes is determined by the total number of characters in all inserted strings.
2. **Input Strings (string_list):**
    - The space complexity to store the input strings is O(m * n), where m is the average length of the strings, and n is the number of strings.

## Real World Applications

1. **Spell Checking:**
    - Tries are commonly used in spell-checking algorithms to efficiently suggest corrections for misspelled words. The Trie allows for quick lookups and suggestions based on common prefixes.
2. **Auto-Completion:**
    - Tries are extensively employed in auto-complete systems, such as those found in search engines, text editors, and mobile keyboards. They provide quick and relevant suggestions by efficiently navigating the Trie based on partial inputs.
3. **Dictionary Implementation:**
    - Tries are used to implement dictionaries and word lists. Searching for words in a dictionary or verifying the existence of a word becomes efficient with Trie structures.
4. **IP Routing Tables:**
    - Tries are employed in networking for the efficient storage and retrieval of IP addresses in routing tables. This ensures fast lookup of routes based on IP prefixes.
5. **Network Routing Protocols:**
    - Trie structures are used in network protocols like OSPF (Open Shortest Path First) and BGP (Border Gateway Protocol) for efficient route information storage and retrieval.
