# ****Reverse String****

In programming, reversing a string means changing the order of its characters. For instance, "olleH" would be the result of reversing the string "Hello". In many programming languages, reversing a string is a common task that can be applied to a variety of problems.

## **Introduction to Reverse String**

Reversing a string can be done in a variety of ways, from basic iterative processes to advanced methods. The programming language being used and the demands of the particular challenge may influence the solution that is selected.

One of the main concepts in programming that may help in the development of problem-solving abilities is the ability to reverse a string.

Reversing a string can be done easily by iterating through the characters and appending them to a new string in the opposite order. Depending on the programming language, either a loop or an integrated string manipulation method can be used to do this. Recursion is an alternative strategy in which the function calls itself to reverse the original string's substrings. Both approaches are capable of producing the intended outcome and are implementable in accordance with the particular needs of the current problem.

## **Overview of Reverse String**

Reversing a string involves changing the order of its characters. It is a common task in programming and can be useful in solving various problems. There are multiple approaches to reverse a string, including iterative methods and recursion. The chosen method depends on the programming language and the specific problem requirements. Reversing a string is a fundamental concept in programming and helps in developing problem-solving skills.

## **Code**
### PYTHON
```python
# Copyrights to venkys.io

#  For more information, visit https://venkys.io

# Write a function that reverses a string. The input string is given as an array of characters s.

# You must do this by modifying the input array in-place with O(1) extra memory.

 

# Example 1:

# Input: s = ["h","e","l","l","o"]
# Output: ["o","l","l","e","h"]
# Example 2:

# Input: s = ["H","a","n","n","a","h"]
# Output: ["h","a","n","n","a","H"]
 

# Constraints:

# 1 <= s.length <= 105
# s[i] is a printable ascii character.

def reverseString(arr:list[str])->None:

    i,j=0,len(arr)-1
    while(i<j):
        arr[i],arr[j]=arr[j],arr[i]
        i+=1
        j-=1
    
    return arr

if "__name__"=="__main__":
    input=["h","e","l","l","o"]
    print(reverseString(input))
```

## Step-by-Step Explanation

1. Inside the function, two pointers i and j are initialized. i points to the first element of the array (arr[0])  and j points to the last element (arr[len(arr) - 1]).
2. A while loop is used to iterate until i becomes greater than or equal to j. This ensures that the loop only runs until the middle of the array is reached.
3. Inside the loop, the values at arr[i] and arr[j] are swapped using a temporary variable. This effectively reverses the order of the characters at positions ***i***   and ***j***.
4. After the swap,i is incremented by 1 and j is decremented by 1, moving towards the middle of the array.
5. Once the loop finishes, the function returns the modified array arr.
5. Once the loop finishes, the function returns the modified array .
6. Outside the function, the code checks if the module's name is equal to "__main__". This ensures that the code is only executed if the script is run directly and not imported as a module.
7. Inside the conditional block, an example input array ***input*** is defined as ***["h","e","l","l","o"]***.
## CODE
### JAVA

```python
# Copyrights to venkys.io

#  For more information, visit https://venkys.io

# Write a function that reverses a string. The input string is given as an array of characters s.

# You must do this by modifying the input array in-place with O(1) extra memory.

 

# Example 1:

# Input: s = ["h","e","l","l","o"]
# Output: ["o","l","l","e","h"]
# Example 2:

# Input: s = ["H","a","n","n","a","h"]
# Output: ["h","a","n","n","a","H"]

#//Write a function that reverses a string. The input string is given as an array of characters s.
#//You must do this by modifying the input array in-place with O(1) extra memory.


public class Main{
		#Reverse the characters in the array

    static void reverseString(String[] s){
        int i=0,j=s.length-1;
        while(i<j) swap(s,i++,j--);

    }
	  #Swap characters at start and end indices
      
    static void swap(String[] s,int i,int j){
        String temp=s[i];
        s[i]=s[j];
        s[j]=temp;
    }
    public static void main(String[] args) {
        String[] s={"h","e","l","l","o"};
        reverseString(s);
        for(String a:s)System.out.print(a+" ");

    }
}
```

## Step-by-Step Explanation

The given code is a Java program that demonstrates how to reverse a string by modifying the input array in-place with O(1) extra memory. Here is a step-by-step explanation of the code:

1. The ***reverseString*** method is defined, which takes an array of strings (***String[] s***) as input.
2. Inside the ***reverseString*** method, two pointers i and j are initialized to the start and end indices of the input array, respectively.
3. The swap method is defined, which takes the input array ***(String[] s)*** and two indices (i and j) as input. It swaps the elements at the given indices.
4. Using a while loop, the ***reverseString*** method iterates until i becomes greater than or equal to j.
5. Inside the while loop, the ***swap*** method is called to swap the characters at indices i  and j in the input array. After each swap, i is incremented and j is decremented.
6. Once the while loop completes, the input array s contains the reversed string.
7. The ***main*** method is defined, where a sample input array s is declared with the characters ***"h", "e", "l", "l", "o"***.
8. The ***reverseString***  method is called, passing the input array s as an argument.
9. Finally, a loop is used to print each character in the reversed string.


## CODE
### C++
```c++
/* Copyrights to venkys.io
For more information, visit https://venkys.io 

# Example 1:

# Input: s = ["h","e","l","l","o"]
# Output: ["o","l","l","e","h"]
# Example 2:

# Input: s = ["H","a","n","n","a","h"]
# Output: ["h","a","n","n","a","H"]

*/

#include<bits/stdc++.h>
using namespace std;

void swap(string s[],int i,int j){
    string temp=s[i];
    s[i]=s[j];
    s[j]=temp;
}

void reverseString(string s[],int n){
    int i=0,j=n-1;
    while(i<j)swap(s,i++,j--);
}


int main(){
    string s[]={"h","e","l","l","o"};
    int n=sizeof(s)/sizeof(s[0]);
    reverseString(s,n);
    for(string x:s)cout<<x<<" ";
    cout<<endl;
    return 0;
}

}
```
## **Step-by-Step Explanation**
The above code is a C++ program that demonstrates how to reverse a string.

Here is a step-by-step explanation of the code:

1. We include the necessary header file `bits/stdc++.h` which includes all the standard library headers.
2. We define a function `swap` that takes an array of strings `s[]` and two indices `i` and `j`. This function swaps the strings at indices `i` and `j` in the array.
3. We define another function `reverseString` that takes an array of strings `s[]` and the size of the array `n`. This function reverses the order of strings in the array by using the `swap` function.
4. In the `main` function, we declare an array of strings `s` initialized with the values "h", "e", "l", "l", "o".
5. We calculate the size of the array `n` using the `sizeof` operator.
6. We call the `reverseString` function passing the array `s` and size `n` as arguments to reverse the order of strings.
7. Finally, we use a range-based for loop to iterate over each string `x` in the array `s` and print it followed by a space.
8. We print a newline character to end the line.
9. The program returns 0 to indicate successful execution.

This code reverses the order of the strings in the array `s` and prints them in reverse order, resulting in the output "o l l e h".
## **Time Complexity Analysis**

The time complexity of the reverseString  function is O(n/2), where n is the length of the input array. This is because the function iterates through half of the array, swapping the characters at opposite ends. The constant factor of 1/2 is ignored in Big O notation.

## **Space Complexity Analysis**

The space complexity of the reverseString function is O(1) because it uses only a constant amount of extra memory. The input array is modified in-place, without requiring any additional data structures.

Overall, the time complexity and space complexity of the code are both considered to be optimal.

## **Real-World Applications of Reverse String**

The ability to reverse a string has various real-world applications in programming. Here are some examples:

1. **Text Manipulation**: Reversing a string can be useful for tasks like text encryption, where reversing the characters can provide a form of obfuscation or scrambling.
2. **Palindrome Detection**: Palindromes are words, phrases, or numbers that read the same backward as forward. Reversing a string and comparing it to the original string can help identify palindromes.
3. **String Processing**: In certain scenarios, reversing a string can help in processing and analyzing textual data. For example, in natural language processing, reversing the order of words in a sentence can be used as a technique for data augmentation or language modeling.
4. **User Interface**: Reversing a string can also be utilized in user interface elements, such as displaying text in a mirror or flipped orientation.
5. **String Parsing**: In some cases, reversing a string can assist in parsing and extracting specific information. For instance, reversing a URL can help identify its top-level domain or extract meaningful components from a complex string.
