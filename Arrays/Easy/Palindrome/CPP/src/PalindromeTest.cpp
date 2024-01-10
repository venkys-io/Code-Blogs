#include "../include/Palindrome.hpp"
#include "../include/PalindromeTest.hpp"


bool PalindromeTest::test(std::string input,bool output){
  Palindrome obj;
  bool result = obj.is_palindrome(input);
  return result == output;

}