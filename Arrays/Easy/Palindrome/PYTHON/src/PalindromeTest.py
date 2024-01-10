
from Palindrome import Palindrome

class Test:
  def test(self,input:str,output:bool) -> bool:
    obj = Palindrome()
    return obj.is_palindrome(input)==output
