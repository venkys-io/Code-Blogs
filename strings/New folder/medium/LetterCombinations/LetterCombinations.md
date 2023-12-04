# LetterCombinations
In programming, "letter combination" often refers to the process of generating and manipulating combinations of letters, typically within strings. This concept is frequently encountered in various algorithmic problems and challenges.

 #### Here are some common scenarios where letter combinations play a role: 

 - String Manipulation

 - Permutations and Combinations

 - Text Processing

 - Cryptographic Operations
 - String Matching and Searching

 - Data Processing and Transformation
 ## Overview

 Programming is the process of creating a set of instructions that tell a computer how to perform a task. These instructions are typically written in a programming language, and the process involves designing algorithms, troubleshooting issues, and testing the code for functionality.

 ## Code in python
 ```
  # Copyrights to venkys.io
 # For more information, visit https://venkys.io

def letterCombinations(digits):
    
    if len(digits)==0:
        return []
    res=list()
    letters={
        "2":"abc",
        "3":"def",
        "4":"ghi",
        "5":"jkl",
        "6":"mno",
        "7":"pqrs",
        "8":"tuv",
        "9":"wxyz"
        
    }
    def util(index,string):
        if len(string)==len(digits):
            res.append(string)
            return 
        else:
            for char in letters[digits[index]]:
                util(index+1,string+char)
        
    
    util(0,"")
    return res 

if __name__=="__main__":
    digits = "23"
    print(letterCombinations(digits))

 ```
 ## Code in java
 ```
// Copyrights to venkys.io
// For more information, visit https://venkys.io

import java.util.HashMap;
import java.util.ArrayList;


public class Main{
   
    private static HashMap<Character,String> letters ;
    static {
        letters=new HashMap<Character,String>();
        letters.put('2',"abc");
        letters.put('3',"def");
        letters.put('4',"ghi");
        letters.put('5',"jkl");
        letters.put('6',"mno");
        letters.put('7',"pqrs");
        letters.put('8',"tuv");
        letters.put('9',"wxyz");

    }

    
    

    static void util(int index,String string,String digits,ArrayList<String> res){
        if(string.length() == digits.length()){
            res.add(string);
            return;
        }
        else{
            for(char ch:letters.get(digits.charAt(index)).toCharArray()){
                util(index+1,string+ch,digits,res);
            }
        }
    }
    static String letterCombinations(String digits){

        if(digits.length()==0)
            return "[]";
        ArrayList<String> res = new ArrayList<>();
        util(0,"",digits,res);
        return res.toString();

    }
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }
}
 ```
 ## Code in CPP
 ```
 /* Copyrights to venkys.io*/
/* For more information, visit https://venkys.io */
 #include<bits/stdc++.h>


void util(int index,std::string string,std::string digits,std::vector<std::string>& res,std::map<char,std::string> map){
    if(string.length() == digits.length()){
        res.push_back(string);
        return;
    }
    for(char ch:map[digits[index]]){
        util(index+1,string+ch,digits,res,map);
    }
}

std::vector<std::string> letterCombinations(std::string digits){
    std::vector<std::string> ans;
    if(digits.length()==0) return ans;
    std::map<char,std::string> map{{
        {'2',"abc"},
        {'3',"def"},
        {'4',"ghi"},
        {'5',"jkl"},
        {'6',"mno"},
        {'7',"pqrs"},
        {'8',"tuv"},
        {'9',"wxyz"},
    }};
    util(0,"",digits,ans,map);
    return ans;
}

int main(){
    std::string digits = "23";
    std::vector<std::string>ans=letterCombinations(digits);
    for(auto it:ans){
        std::cout<<it<<" ";
    }
    
    return 0;
}
 ```
 ## Code Explanation
 The provided code is  implementation of a function called letterCombinations, which generates all possible combinations of letters corresponding to the digits in a given input string. This is commonly used in the context of phone number letter combinations, where each digit is associated with a set of letters on a phone keypad.
  
  - Function Signature :

    The function takes a string digits as input, representing a sequence of digit.
- Base Case Check :

    If the input digits string is empty, the function returns an empty list because there are no digits to generate combinations for.
- Define Letter Mapping :

    This dictionary letters maps each digit to the corresponding set of letters on a phone keypad.
- Main Function Call :

    The main function call initiates the combination generation process, starting with the first digit (index 0) and an empty string.
## Time Complexity:
### Best Case:
 The time complexity in the best case is O(1) 

### Worst Case:
 In the worst case, the time complexity is O(4^n)

## Space Complexity:
### Best Case:
 The space complexity in the best case is O(1) 

### Worst Case:
the space complexity is O(4^n)
 ## Real time example
  - Phone Number Letter Combinations