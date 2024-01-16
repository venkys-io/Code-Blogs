def compute_prefix_function(p):
    # Function to compute the prefix function (π) for the pattern 'p'
    m = len(p)
    π = [0] * m  # Initialize an array to store the prefix function values
    k = 0  # Initialize a variable for matching characters

    # Iterate through the pattern to compute the prefix function
    for q in range(1, m):
        # Update the matching character index while it's not zero and characters mismatch
        while k > 0 and p[k] != p[q]:
            k = π[k - 1]
        # If characters match, increment the matching character index
        if p[k] == p[q]:
            k += 1
        # Store the current matching character index in the prefix function array
        π[q] = k

    return π

def kmp_matcher(t, p):
    # Function to perform pattern matching using the Knuth-Morris-Pratt (KMP) algorithm
    n = len(t)  # Length of the text
    m = len(p)  # Length of the pattern
    π = compute_prefix_function(p)  # Compute the prefix function for the pattern
    q = 0  # Initialize a variable for matching characters

    # Iterate through the text to find occurrences of the pattern
    for i in range(n):
        # Update the matching character index while it's not zero and characters mismatch
        while q > 0 and p[q] != t[i]:
            q = π[q - 1]
        # If characters match, increment the matching character index
        if p[q] == t[i]:
            q += 1
        # If the entire pattern is matched, print the occurrence
        if q == m:
            print(f"Pattern occurs with shift {i - m + 1}")
            q = π[q - 1]  # Look for the next match

# Get user input with null safety
text = input("Enter the text: ")
pattern = input("Enter the pattern: ")

# Check if input is not empty and contains only alphabetical characters
if text and pattern and text.isalpha() and pattern.isalpha():
    kmp_matcher(text, pattern)
else:
    print("Please enter valid text and pattern.")
