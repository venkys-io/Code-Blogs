function isMatch(input, pattern, i, j):
        if i == length(input) and j == length(pattern):
            return true
    
        if j < length(pattern) and pattern[j] == '*':
            rememberWildcardPosition = j
            rememberInputPosition = i
            while i < length(input):
                if isMatch(input, pattern, i, j + 1):
                    return true
                i++
            j = rememberWildcardPosition
            i = rememberInputPosition
    
        if i < length(input) and j < length(pattern) and (input[i] == pattern[j] or pattern[j] == '*'):
            return isMatch(input, pattern, i + 1, j + 1)
    
        return false
    
