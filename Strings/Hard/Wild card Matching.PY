def is_match(input_str, pattern, i, j, memo):
    if i == len(input_str) and j == len(pattern):
        return True
    
    if memo[i][j] != -1:
        return memo[i][j] == 1
    
    if j < len(pattern) and pattern[j] == '*':
        remember_wildcard_position = j
        remember_input_position = i
        
        while i < len(input_str):
            if is_match(input_str, pattern, i, j + 1, memo):
                memo[remember_input_position][remember_wildcard_position] = 1
                return True
            i += 1
        
        j = remember_wildcard_position
        i = remember_input_position
    
    if i < len(input_str) and j < len(pattern) and (input_str[i] == pattern[j] or pattern[j] == '*'):
        result = is_match(input_str, pattern, i + 1, j + 1, memo)
        memo[i][j] = 1 if result else 0
        return result
    
    memo[i][j] = 0
    return False

def wildcard_match(input_str, pattern):
    memo = [[-1 for _ in range(len(pattern) + 1)] for _ in range(len(input_str) + 1)]
    return is_match(input_str, pattern, 0, 0, memo)

if __name__ == "__main__":
    # User input
    input_str = input("Enter the input string: ")
    pattern = input("Enter the pattern: ")

    # Perform wildcard matching
    if wildcard_match(input_str, pattern):
        print(f'The string "{input_str}" matches the pattern "{pattern}".')
    else:
        print(f'No match found for the string "{input_str}" and pattern "{pattern}".')
