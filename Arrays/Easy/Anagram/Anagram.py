#  Copyrights to venkys.io
#  For more programs visit venkys.io 
#  Python program for Anagrams

# Time complexity:O(n)constant time complexity
# Space complexity:O(n)


def is_anagram(s1,s2):
    # We use hashtables to solve this problem
    # Check for the length of the String
    if len(s1) != len(s2):
        #If lengths are different, strings can't be anagrams
        return False
    else:
        # Create a hashtable to store character counts
        hashtable=dict()
        # Iterate over characters in s1 
        for i in s1:
            if i in hashtable. keys(): #If character i is already in the hashtable
                # Update count for characters in s1
                hashtable[i]+=1
            else:
                # Otherwise, initialize its count to 1 
                hashtable[i]=1
        # Iterate over characters in s2
        for j in s2:
            # If character j is not in the hashtable
            if j not in hashtable. keys():
                # Strings can't be anagrams
                return False
            # Decrement the count of character j in the hashtable
            hashtable[j]-=1
        # Check if all counts in the hashtable are zero
        for key, value in hashtable. items():
            if value!=0:
                # If any count is not zero, strings are not anagrams
                return False 
        # If all counts are zero, strings are anagrams
        return True

                
# test drive code
if __name__ == "__main__":
    # Input two strings from the user
    s1=input()
    s2=input()
    # Check if the strings are anagrams and print the result
    if(is_anagram(s1,s2)):
        print("True")
    else:
        print("False")
