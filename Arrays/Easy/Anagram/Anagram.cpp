// Copyrights to venkys.io
// For more programs visit venkys.io 
// CPP program for Anagrams


// Time Complexity:
// space Complexity:

#include<iostream>
#include<map>
using namespace std;

int main(){

  string s1, s2;

  // Get input for the first string
  // cout << "Enter the first string: ";
  cin >> s1;

  // Get input for the second string
  // cout << "Enter the second string: ";
  cin >> s2;

  // Check if the lengths of both strings are different
  if(s1.size()!=s2.size()){
    // If different, print "Not Anagram"
    court<<"False";
  }
  else{
    // Create a hash map to store the frequency of characters
    map<char,int> map;
    // Iterate through the characters of the first string
    for(int i=0;i<s1.size();i++){
      //Increment the frequency of each character in the map
      map[s1[i]]++;
    }
    // Iterate through the characters of the second string
    for(int j=0;j<s2.size();j++){
      // Check if the character is present in the hash map
      if(map.find(s2[j])!=map.end()){
        //If present, decrement the frequency in the map
        map[s2[j]]--;
      }
      else{
        // If character not found, print "Not Anagrams" and exit
        court<<"False";
        return false;
      }
    }
    // Iterate through the map
    for(auto items:map){
      // Check if any frequency is not zero
      if(items.second!=0){
        // If not zero, print "Not Anagrams" and exit
         cout<<s1<<"False";
      }
    }
    // If all characters match, print "Anagrams"
    cout<<"True";
    return true;
  }
   
  return 0;
}
