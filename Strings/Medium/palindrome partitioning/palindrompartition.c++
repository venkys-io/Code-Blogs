#include<bits/stdc++.h>
bool isPalindrome(std::string s, int i, int j) {
    // While loop checks the string symmetrically.
    while (i <= j) {
        // If characters at different ends don't match, it's not a palindrome.
        if (s[i++] != s[j--]) return false;
    }
    // If loop finished, the string is a palindrome.
    return true;
}
void util(int i,std::string s,std::vector<std::vector<std::string>>& res,std::vector<std::string>& path){
    // base case: when string s is fully processed
    if(i==s.size()){
        res.push_back(path);
        return ;
    }

    // iteratively checking each substring
    for(int j=i;j<s.size();++j){
        // checking if the substring is a palindrome
        if(isPalindrome(s,i,j)) {
            // if it is, adding the substring to the path
            path.push_back(s.substr(i,j-i+1));
            // recursively calling util to process the rest of the string
            util(j+1,s,res,path);
            // removing the added substring from the path
            path.pop_back();
        }
    }
}
std::vector<std::vector<std::string>> partition (std::string s){
    // Output list of all palindrome partitions
    std::vector<std::vector<std::string>> res;
    // List to keep track of the current path
    std::vector<std::string> path;
    // Utility function to find all palindrome partitions
    util(0,s,res,path);
    return res;
}
int main(){
    // initial string to be partitioned
    std::string s = "aaab";
    // function call to get all partitions
    std::vector<std::vector<std::string>> ans=partition(s);
    // loop to print all partitions
    for(auto& a:ans){
        for(auto& b:a){
            std::cout<<b<<" ";
        }
        std::cout<<std::endl;
    }
    return 0;
}