#include "../include/Palindrome.hpp"
#include<cctype>

bool Palindrome::is_palindrome(std::string s){
  int n = s.size();
  int l = 0;
  int r = n - 1;
  while (l < r) {
      while (l < r && !isalnum(s[l])) {
          l++;
      }
      while (l < r && !isalnum(s[r])) {
          r--;
      }
      if (tolower(s[l++]) != tolower(s[r--])) {
          return false;
      }
  }
  return true;
}