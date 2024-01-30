def remove_vowels(input_string):
    return ''.join(char for char in input_string if char.lower() not in 'aeiou')

def count_vowels(input_string):
    return sum(1 for char in input_string if char.lower() in 'aeiou')

if __name__ == "__main__":
    input_string = input("Enter a string: ")
    
    result_removed_vowels = remove_vowels(input_string)
    count_original_vowels = count_vowels(input_string)

    print("String after removing vowels:", result_removed_vowels)
    print("Number of vowels in the original string:", count_original_vowels)
