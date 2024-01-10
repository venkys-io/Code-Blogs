
public class Palindrome {
  public boolean isPalindrome(String s){
    if (s.isEmpty()) {
      return true;
    } 

    int start = 0;
    int last = s.length() - 1;
    
    while(start <= last) {
      char firstChar = s.charAt(start);
      char lastChar = s.charAt(last);
      if (!Character.isLetterOrDigit(firstChar )) {
        start++;
      } else if(!Character.isLetterOrDigit(lastChar)) {
        last--;
      } else {
        if (Character.toLowerCase(firstChar) != Character.toLowerCase(lastChar)) {
          return false;
        }
        start++;
        last--;
      }
    }
    return true;
  }
}