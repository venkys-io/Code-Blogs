def multi_string_search(text, patterns):
    result = []

    for pattern in patterns:
        # Use the built-in find method to check if the pattern is present in the text
        if text.find(pattern) != -1:
            result.append(pattern)

    return result


if __name__ == "__main__":
    # Sample text and patterns
    text = "This is a sample text for multi-string search."
    patterns = ["sample", "search", "notfound"]

    # Perform multi-string search
    result = multi_string_search(text, patterns)

    # Print the found patterns
    print("Found patterns:", *result)
