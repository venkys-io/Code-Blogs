# Building Tries

## Problem Statement

Tries, also known as prefix trees, are a powerful data structure used in various applications such as autocomplete systems, spell checkers, and IP routers. In this blog, we have solved a realtime problem of storing and retrieving Aadhar Numbers 

## Introduction

Tries are tree-like structures that represent a dynamic set of strings, where the keys usually consist of characters. Each node in a trie represents a single character, and the path from the root to a node spells out a word. In this blog, we'll explore the step-by-step process of building a trie for storing and finding aadhar numbers and implement the solution in Java, Python, and C++.

## Overview

To build a trie, we need to perform the following key operations:

1. `Initialization`: Create a trie data structure.

2. `Insertion`: Insert a word into the trie.

3. `Search`: Check if a given word exists in the trie.

4. `Deletion`: Remove a word from the trie.

## Code

### Java Implementation

```java
/* Copyrights to vsdevelopers.io 
   For more programs visit vsdevelopers.io
   Java program for implementing Tries 

   Space Complexity : O(L), L is the length of the word
   Time Complexity : O(N * L),N is the number of words,
   L is the average length of the words */

import java.util.Arrays;

public class VSDBuildingTries {
    // Class to hold the structure of a trie node
    public static class VSDTrieNode {
        VSDTrieNode[] tnodes; // Array of tries nodes
        int DIGITS = 10;
        private long aadharNum; // Actual Aadhaar number

        // Default constructor
        VSDTrieNode() {
            this.tnodes = new VSDTrieNode[DIGITS];
            this.aadharNum = -1;
            // Initially making the nodes of trie node empty
            for (int i = 0; i < DIGITS; i++)
                tnodes[i] = null;
        }
    }

    // Standard length of the Aadhaar number
    public static int AADHAARLENGTH = 12;
    public static int TOTALAADHAARNUMBERS = 6;
    // To access root node of the Trie
    public static VSDTrieNode rootNode;
    // Convert the long Aadhaar numbers to two-dimensional array for indexing
    public static long[][] twodarray = new long[6][12];
    // An array of input Aadhaar numbers
    public static long[] aadhaarList = { 550512345678L, 123456789012L, 123467890123L, 678901234567L, 689012345678L,
            901234567890L };

    // Method to convert given long array of Aadhar numbers to two-dimensional array
    public static void VSDlongto2d(long aadhar[], int n) {
        long[] local = Arrays.copyOf(aadhar, aadhar.length);
        for (int i = 0; i < n; i++) {
            for (int j = 11; j >= 0; j--) {
                long d = local[i] % 10;
                twodarray[i][j] = d;
                local[i] = local[i] / 10;
            }
        }
    }

    // Method to convert given long array of Aadhar to long
    public static long VSDconvertlongArray2long(long[] larray) {
        long converted2long = 0L;
        for (int i = 0; i < 12; i++) {
            converted2long = larray[i] * 10 + converted2long;
        }
        return converted2long;
    }

    // Method to convert given long Aadhar to long array of digits
    public static long[] VSDconvertlong2longarray(long longint) {
        long converted2Array[] = new long[12];
        for (int i = 11; i >= 0; i--) {
            converted2Array[i] = longint % 10;
            longint = longint / 10;
        }
        return converted2Array;
    }

    // Method to insert Aadhar number into trie
    public static void VSDInsertNode(VSDTrieNode rootNode, int rowindex, int colindex) {
        long index = twodarray[rowindex][colindex];
        // If the root node of required index is null insert the number
        if (rootNode.tnodes[(int) index] == null) {
            rootNode.tnodes[(int) index] = new VSDTrieNode();
            rootNode.tnodes[(int) index].aadharNum = aadhaarList[rowindex];
        } else {
            // There is an Aadhaar number already at the index, create a new node and
            // reassign the Aadhaar
            long existingaadhaar = rootNode.tnodes[(int) index].aadharNum;
            rootNode.tnodes[(int) index].aadharNum = -1;

            rootNode = rootNode.tnodes[(int) index];
            long[] existingaadhaarArray = VSDconvertlong2longarray(existingaadhaar);
            index = existingaadhaarArray[colindex];
            rootNode.tnodes[(int) index] = new VSDTrieNode();

            rootNode.tnodes[(int) index].aadharNum = existingaadhaar;

            VSDInsertNode(rootNode, rowindex, colindex + 1);
        }
    }

    // Method to recursively search for an element in the trie
    public static boolean VSDSearchTrieRecursive(VSDTrieNode node, long[] searchKey, int i) {
        int index = (int) searchKey[i];
        if (node.tnodes[index] == null) {
            return false;
        } else if (node.tnodes[index].aadharNum == -1) {
            return VSDSearchTrieRecursive(node.tnodes[index], searchKey, i + 1);
        } else {
            System.out.println("Key found " + node.tnodes[index].aadharNum);
            return true;
        }
    }

    // Method to Print Trie recursively
    public static void VSDPrintTrieRecursive(VSDTrieNode rootNode) {
        for (int i = 0; i < 10; i++) {
            if (rootNode.tnodes[i] != null) {
                if (rootNode.tnodes[i].aadharNum != -1) {
                    System.out.println(rootNode.tnodes[i].aadharNum);
                }
                VSDPrintTrieRecursive(rootNode.tnodes[i]);
            }
        }
    }

    public static void main(String args[]) {
        rootNode = new VSDTrieNode();
        // Store the long Aadhaar numbers into a 2-D array
        VSDlongto2d(aadhaarList, TOTALAADHAARNUMBERS);
        // Insert the Aadhaar numbers into Trie here
        for (int i = 0; i < TOTALAADHAARNUMBERS; i++) {
            VSDInsertNode(rootNode, i, 0);
        }
        // Print Trie after insertion
        VSDPrintTrieRecursive(rootNode);

        // Search for a key
        long[] searchKey = VSDconvertlong2longarray(aadhaarList[1]);
        if (!VSDSearchTrieRecursive(rootNode, searchKey, 0)) {
            System.out.println("Key not found");
        }
    }
}
```

### Python Implementation

```python
""" Copyrights to vsdevelopers.io 
For more programs visit vsdevelopers.io
Java program for implementing Tries 

Space Complexity : O(L), L is the length of the word
Time Complexity : O(N * L),
N is the number of words,
L is the average length of the words """

import numpy as np

class VSDTrieNode:
    def __init__(self):
        self.tnodes = [None] * 10
        self.aadharNum = -1

def VSDlongto2d(aadhar, n):
    twodarray = np.zeros((n, 12), dtype=int)
    for i in range(n):
        local = aadhar[i]
        for j in range(11, -1, -1):
            d = local % 10
            twodarray[i][j] = d
            local //= 10
    return twodarray

def VSDconvertlongArray2long(larray):
    converted2long = 0
    for i in range(12):
        converted2long = larray[i] * 10 + converted2long
    return converted2long

def VSDconvertlong2longarray(longint):
    converted2Array = [0] * 12
    for i in range(11, -1, -1):
        converted2Array[i] = longint % 10
        longint //= 10
    return converted2Array

def VSDInsertNode(rootNode, rowindex, colindex):
    index = twodarray[rowindex][colindex]
    if rootNode.tnodes[index] is None:
        rootNode.tnodes[index] = VSDTrieNode()
        rootNode.tnodes[index].aadharNum = aadhaarList[rowindex]
    else:
        existingaadhaar = rootNode.tnodes[index].aadharNum
        rootNode.tnodes[index].aadharNum = -1

        rootNode = rootNode.tnodes[index]
        existingaadhaarArray = VSDconvertlong2longarray(existingaadhaar)
        index = existingaadhaarArray[colindex]
        rootNode.tnodes[index] = VSDTrieNode()
        rootNode.tnodes[index].aadharNum = existingaadhaar

        VSDInsertNode(rootNode, rowindex, colindex + 1)

def VSDSearchTrieRecursive(node, searchKey, i):
    index = searchKey[i]
    if node.tnodes[index] is None:
        return False
    elif node.tnodes[index].aadharNum == -1:
        return VSDSearchTrieRecursive(node.tnodes[index], searchKey, i + 1)
    else:
        print("Key found", node.tnodes[index].aadharNum)
        return True

def VSDPrintTrieRecursive(rootNode):
    for i in range(10):
        if rootNode.tnodes[i] is not None:
            if rootNode.tnodes[i].aadharNum != -1:
                print(rootNode.tnodes[i].aadharNum)
            VSDPrintTrieRecursive(rootNode.tnodes[i])

AADHAARLENGTH = 12
TOTALAADHAARNUMBERS = 6
rootNode = VSDTrieNode()
aadhaarList = [550512345678, 123456789012, 123467890123, 678901234567, 689012345678, 901234567890]
twodarray = VSDlongto2d(aadhaarList, TOTALAADHAARNUMBERS)

for i in range(TOTALAADHAARNUMBERS):
    VSDInsertNode(rootNode, i, 0)

VSDPrintTrieRecursive(rootNode)

# Search for a key
searchKey = VSDconvertlong2longarray(aadhaarList[1])
if not VSDSearchTrieRecursive(rootNode, searchKey, 0):
    print("Key not found")
```

### C++ Implementation

```cpp
/* Copyrights to vsdevelopers.io 
   For more programs visit vsdevelopers.io
   Java program for implementing Tries 

   Space Complexity : O(L), L is the length of the word
   Time Complexity : O(N * L),
   N is the number of words,
   L is the average length of the words */

#include <iostream>
#include <vector>
#include <array>

class VSDTrieNode {
public:
    VSDTrieNode* tnodes[10];
    long aadharNum;

    VSDTrieNode() : aadharNum(-1) {
        for (int i = 0; i < 10; i++)
            tnodes[i] = nullptr;
    }
};

const int AADHAARLENGTH = 12;
const int TOTALAADHAARNUMBERS = 6;
VSDTrieNode* rootNode;
std::array<std::array<long, 12>, 6> twodarray;
long aadhaarList[] = { 550512345678, 123456789012, 123467890123, 678901234567, 689012345678, 901234567890 };

void VSDlongto2d(long aadhar[], int n) {
    for (int i = 0; i < n; i++) {
        long local = aadhar[i];
        for (int j = 11; j >= 0; j--) {
            long d = local % 10;
            twodarray[i][j] = d;
            local /= 10;
        }
    }
}


long VSDconvertlongArray2long(long larray[]) {
    long converted2long = 0;
    for (int i = 0; i < 12; i++) {
        converted2long = larray[i] * 10 + converted2long;
    }
    return converted2long;
}

long* VSDconvertlong2longarray(long longint) {
    long* converted2Array = new long[12];
    for (int i = 11; i >= 0; i--) {
        converted2Array[i] = longint % 10;
        longint /= 10;
    }
    return converted2Array;
}

void VSDInsertNode(VSDTrieNode* rootNode, int rowindex, int colindex) {
    long index = twodarray[rowindex][colindex];
    if (rootNode->tnodes[index] == nullptr) {
        rootNode->tnodes[index] = new VSDTrieNode();
        rootNode->tnodes[index]->aadharNum = aadhaarList[rowindex];
    } else {
        long existingaadhaar = rootNode->tnodes[index]->aadharNum;
        rootNode->tnodes[index]->aadharNum = -1;

        rootNode = rootNode->tnodes[index];
        long* existingaadhaarArray = VSDconvertlong2longarray(existingaadhaar);
        index = existingaadhaarArray[colindex];
        rootNode->tnodes[index] = new VSDTrieNode();
        rootNode->tnodes[index]->aadharNum = existingaadhaar;

        VSDInsertNode(rootNode, rowindex, colindex + 1);
    }
}

bool VSDSearchTrieRecursive(VSDTrieNode* node, long searchKey[], int i) {
    int index = searchKey[i];
    if (node->tnodes[index] == nullptr) {
        return false;
    } else if (node->tnodes[index]->aadharNum == -1) {
        return VSDSearchTrieRecursive(node->tnodes[index], searchKey, i + 1);
    } else {
        std::cout << "Key found " << node->tnodes[index]->aadharNum << std::endl;
        return true;
    }
}

void VSDPrintTrieRecursive(VSDTrieNode* rootNode) {
    for (int i = 0; i < 10; i++) {
        if (rootNode->tnodes[i] != nullptr) {
            if (rootNode->tnodes[i]->aadharNum != -1) {
                std::cout << rootNode->tnodes[i]->aadharNum << std::endl;
            }
            VSDPrintTrieRecursive(rootNode->tnodes[i]);
        }
    }
}

int main() {
    rootNode = new VSDTrieNode();
    VSDlongto2d(aadhaarList, TOTALAADHAARNUMBERS);

    for (int i = 0; i < TOTALAADHAARNUMBERS; i++) {
        VSDInsertNode(rootNode, i, 0);
    }

    VSDPrintTrieRecursive(rootNode);

    // Search for a key
    long* searchKey = VSDconvertlong2longarray(aadhaarList[1]);
    if (!VSDSearchTrieRecursive(rootNode, searchKey, 0)) {
        std::cout << "Key not found" << std::endl;
    }

    return 0;
}
```

## Step-by-Step Explanation

1. `Initialization`: We create a trie data structure with a root node.

2. `Insertion`: For each character in the word, we traverse the trie, adding nodes if necessary.

3. `Search`: We navigate the trie to check if a given word is present.

4. `Deletion`: We remove nodes corresponding to the characters in the word, pruning the trie as needed.

## Time and Space Complexity Analysis

- Time complexity for insertion, search, and deletion: **O(L)**, where L is the length of the word.
- Space complexity: **O(N * L)**, where N is the number of words and L is the average length of the words.

## Real-World Applications

Tries are widely used in real-world scenarios, including:

1. `Autocomplete Systems`: Tries efficiently store and retrieve words based on prefixes, making them ideal for autocomplete suggestions.

2. `Spell Checkers`: Tries help quickly identify misspelled words by traversing the structure to check for valid words.

3. `IP Routers`: Tries can be employed in IP routers to efficiently match IP addresses, optimizing routing decisions.

In conclusion, building tries is a fundamental skill in computer science, and mastering their implementation in different programming languages enhances your problem-solving capabilities. Whether you're developing search functionalities or optimizing network routing, understanding and implementing tries can significantly improve the efficiency of your algorithms.