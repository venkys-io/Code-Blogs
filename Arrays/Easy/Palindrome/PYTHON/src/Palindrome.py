class Palindrome:

  def is_palindrome(self,s:str) -> bool:
    temp = ""
    for ch in s:
      if ch.isalnum():
        temp+=ch.lower()
    return temp==temp[::-1]
  
