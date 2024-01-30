def generate_parentheses(n):
    def backtrack(s, left, right):
        if len(s) == 2 * n:
            result.append(s)
            return
        if left < n:
            backtrack(s + '(', left + 1, right)
        if right < left:
            backtrack(s + ')', left, right + 1)

    result = []
    backtrack('', 0, 0)
    return result

if __name__ == "__main__":
    n = int(input("Enter the number of pairs of parentheses: "))
    parentheses_combinations = generate_parentheses(n)

    print("Valid parentheses combinations:")
    for combination in parentheses_combinations:
        print(combination)
