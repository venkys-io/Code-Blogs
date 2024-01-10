

public class PalindromeTest{
  public boolean test(String input,boolean output){
    Palindrome obj = new Palindrome();
    return obj.isPalindrome(input) == output;
  }
}