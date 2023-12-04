def partition(string):
    # Initialize dynamic programming array
    dp=[[] for _ in range(len(string)+1)]

    # Initialize the first state with an empty partition
    dp[0]=[[]]

# Iterate over each character of the string
    for j in range(1,len(string)+1):
    # Iterate through each previous character
        for i in range(j):
            # Check if the substring is a palindrome
            if string[i:j]==string[i:j][::-1]:
                # If so, extend the partitions ending at i with the palindrome substring
                for each in dp[i]:
                    dp[j].append(each+[string[i:j]])
    # Return the final state, which contains all valid partitions                
    return dp[-1]

if __name__=="__main__":
    string="ababa"
    print(partition(string))
