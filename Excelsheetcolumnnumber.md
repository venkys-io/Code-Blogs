# Excel Sheet Column Number

## Introduction:

In Excel, columns are identified by letters, starting with the letter "A" for the first column. The column labels progress alphabetically, and when you reach the letter "Z," the next column is labeled "AA." This pattern continues with subsequent columns receiving labels like "AB," "AC," and so forth.

To convert these column labels to numeric values (column numbers), you can think of each letter as representing a digit in a base-26 number system. In the base-26 system used by Excel column labels, the letters A-Z correspond to the decimal values 1-26. When you have two letters, the first letter represents the higher-order digit, and the second letter represents the lower-order digit.

For example:

- Column A corresponds to the number 1.
- Column B corresponds to the number 2.
- ...
- Column Z corresponds to the number 26.
- Column AA corresponds to the number 27 (A=1, B=2, so AA=1*26 + 1 = 27).
- Column AB corresponds to the number 28 (A=1, B=2, so AB=1*26 + 2 = 28).
- Column BA corresponds to the number 53 (B=2, A=1, so BA=2*26 + 1 = 53).

When working with Excel column numbers programmatically, you may need to convert between numeric values and column labels. The conversion algorithms often involve manipulating the characters in the column label to obtain the corresponding numeric value and vice versa, as demonstrated in the C++ programs provided earlier.

1. **Single Letter Columns:**
    - The first 26 columns are labeled with single letters from 'A' to 'Z'.
    - 'A' corresponds to the column number 1, 'B' to 2, and so on, up to 'Z' which corresponds to 26.
2. **Double Letter Columns:**
    - Once 'Z' is reached, Excel starts using double letters for column labels.
    - The first double-letter column is 'AA', which corresponds to 27 (1 * 26 + 1).
    - 'AB' corresponds to 28 (1 * 26 + 2), 'AC' to 29, and so forth.
3. **Triple Letter Columns and Beyond:**
    - The pattern continues with triple letter columns like 'AAA', 'AAB', and so on.
    - Each additional letter adds another factor of 26 to the calculation.
4. **Conversion from Column Name to Number:**
    - To convert a column name (e.g., 'AB') to a column number (e.g., 28), you can think of it as a base-26 to base-10 conversion.
    - Each letter represents a digit, and you multiply its numeric value by 26 raised to the power of its position from the right.
5. **Conversion from Column Number to Name:**
    - To convert a column number to a column name, you essentially perform the reverse process.
    - You divide the number by 26, take the remainder, and map it back to the corresponding letter. Repeat this process until the number is zero.
6. **Practical Use Cases:**
    - Understanding Excel column numbering is essential when working with Excel formulas and functions that involve column references.
    - In programming, when interacting with Excel files or performing tasks related to column manipulation, you might need to convert between column names and numbers.

## Algorithm:

```
1. Initialize result to 0.
2. For each character c in the column name, from left to right:
   a. Multiply the current result by 26.
   b. Add the numeric value of c to the result.
      - The numeric value of c can be calculated as ord(c) - ord('A') + 1.
3. The final result is the column number.

```

- **Initialization:**
    - Start with the result set to 0, as you'll be adding to it as you process each character.
- **Loop through Characters:**
    - For each character in the column name, perform the following steps:
        - **Multiply by 26:**
            - Multiply the current result by 26. This is because each position in the column name represents a power of 26 in the base-26 system used by Excel.
        - **Add Numeric Value of the Character:**
            - Calculate the numeric value of the current character `c` using the expression `ord(c) - ord('A') + 1`.
            - Add this numeric value to the result.
            - The subtraction of `ord('A')` ensures that 'A' maps to 1, 'B' to 2, and so on.
- **Final Result:**
    - After processing all characters, the result is the column number corresponding to the input column name.

## Program in `c++`:

- **Below Program is from Column Name to Column Number -**

```cpp
#include <iostream>
#include <string>

using namespace std;

int excelColumnToNumber(const string& column) {
    int result = 0;
    for (char c : column) {
        result = result * 26 + (c - 'A' + 1);
    }
    return result;
}

int main() {
    string columnName;

    // Input the column name from the user
    // cout << "Enter Excel column name: ";
    cin >> columnName;

    // Convert the column name to a column number
    int columnNumber = excelColumnToNumber(columnName);

    // Output the result
    cout << columnNumber << endl;

    return 0;
}
```

- **Below Program is from Column Number to Column Name -**

```cpp
#include <iostream>
#include <string>

using namespace std;

string excelNumberToColumn(int columnNumber) {
    string result = "";

    while (columnNumber > 0) {
        int remainder = (columnNumber - 1) % 26;
        char charValue = 'A' + remainder;
        result = charValue + result;
        columnNumber = (columnNumber - 1) / 26;
    }

    return result;
}

int main() {
    int columnNumber;

    // Input the column number from the user
    // cout << "Enter Excel column number: ";
    cin >> columnNumber;

    // Convert the column number to a column name
    string columnName = excelNumberToColumn(columnNumber);

    // Output the result
    cout << columnName << endl;

    return 0;
}
```

## Step-By-Step Explanation:

### **Program 1: Converting Excel Column Name to Column Number**

1. **Header Files:**
    - Include necessary header files (`iostream` for input/output and `string` for string operations).
2. **Namespace:**
    - Use the `std` namespace to simplify the use of standard library components.
3. **Function for Conversion:**
    - Define a function `excelColumnToNumber` that takes a reference to a `const string&` (constant reference to a string) representing the Excel column name and returns an integer representing the corresponding column number.
    - Inside the function, iterate through each character of the column name.
    - Update the result using the formula: `result = result * 26 + (c - 'A' + 1)`.
        - This formula treats each character as a digit in a base-26 system, where 'A' is 1, 'B' is 2, and so on.
4. **Main Function:**
    - Declare a string variable `columnName` to store the user input.
    - Prompt the user to enter an Excel column name and read the input using `cin`.
    - Call the `excelColumnToNumber` function to convert the column name to a column number.
    - Output the result.

---

### Program 2: Converting Excel Column Number to Column Name

1. **Header Files and Namespace:**
    - Similar to the first program, include necessary header files and use the `std` namespace.
2. **Function for Conversion:**
    - Define a function `excelNumberToColumn` that takes an integer `columnNumber` and returns a string representing the corresponding Excel column name.
    - Inside the function, use a loop to convert the number to a column name.
    - In each iteration:
        - Calculate the remainder using `(columnNumber - 1) % 26`.
        - Map the remainder to the corresponding character ('A' + remainder).
        - Prepend the character to the result string.
        - Update `columnNumber` for the next iteration using `(columnNumber - 1) / 26`.
3. **Main Function:**
    - Declare an integer variable `columnNumber` to store the user input.
    - Prompt the user to enter an Excel column number and read the input using `cin`.
    - Call the `excelNumberToColumn` function to convert the column number to a column name.
    - Output the result.

### Program in `python`:

- **Below Program is from Column Name to Column Number -**

```python
def excel_column_to_number(column):
    result = 0
    for char in column:
        result = result * 26 + (ord(char) - ord('A') + 1)
    return result

# Main Program
column_name = input()
column_number = excel_column_to_number(column_name)
print(column_number)
```

- **Below Program is from Column Number to Column Name-**

```python
def excel_number_to_column(column_number):
    result = ""
    while column_number > 0:
        remainder = (column_number - 1) % 26
        char_value = chr(ord('A') + remainder)
        result = char_value + result
        column_number = (column_number - 1) // 26

    return result

# Main Program
column_number = int(input())
column_name = excel_number_to_column(column_number)
print(column_name)
```

## Step-By-Step Explanation:

### **Program 1: Converting Excel Column Name to Column Number**

1. **Function Definition:**
    - Define a function **`excel_column_to_number`** that takes a string **`column`** (representing an Excel column name) and returns an integer (representing the corresponding column number).
    - Initialize **`result`** to 0.
    - Iterate through each character in the column name:
        - Update **`result`** using the formula **`result = result * 26 + (ord(char) - ord('A') + 1)`**.
2. **Main Program:**
    - Prompt the user to enter an Excel column name using **`input`**.
    - Call the **`excel_column_to_number`** function to convert the column name to a column number.
    - Print the result.

### Program 2: Converting Excel Column Number to Column Name

1. **Function Definition:**
    - Define a function **`excel_number_to_column`** that takes an integer **`column_number`** (representing an Excel column number) and returns a string (representing the corresponding column name).
    - Initialize an empty string **`result`**.
    - Use a **`while`** loop to convert the number to a column name:
        - Calculate the remainder using **`(column_number - 1) % 26`**.
        - Map the remainder to the corresponding character using **`char_value = chr(ord('A') + remainder)`**.
        - Prepend the character to the result.
        - Update **`column_number`** for the next iteration using **`column_number = (column_number - 1) // 26`**.
2. **Main Program:**
    - Prompt the user to enter an Excel column number using **`input`** and convert it to an integer using **`int`**.
    - Call the **`excel_number_to_column`** function to convert the column number to a column name.
    - Print the result.

## Program in `java`:

- **Below Program is from Column Name to Column Number -**

```java
import java.util.Scanner;

public class ExcelColumnToNumber {
    public static int excelColumnToNumber(String column) {
        int result = 0;
        for (char c : column.toCharArray()) {
            result = result * 26 + (c - 'A' + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the column name from the user
        // System.out.print("Enter Excel column name: ");
        String columnName = scanner.next();

        // Convert the column name to a column number
        int columnNumber = excelColumnToNumber(columnName);

        // Output the result
        System.out.println(columnNumber);
    }
}
```

- **Below Program is from Column Number to Column Name-**

```java
import java.util.Scanner;

public class ExcelNumberToColumn {
    public static String excelNumberToColumn(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while (columnNumber > 0) {
            int remainder = (columnNumber - 1) % 26;
            char charValue = (char) ('A' + remainder);
            result.insert(0, charValue);
            columnNumber = (columnNumber - 1) / 26;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the column number from the user
        // System.out.print("Enter Excel column number: ");
        int columnNumber = scanner.nextInt();

        // Convert the column number to a column name
        String columnName = excelNumberToColumn(columnNumber);

        // Output the result
        System.out.println(columnName);
    }
}
```

## Step-By-Step Explanation:

### **Program 1: Converting Excel Column Name to Column Number**

1. **Import Statements:**
    - Import the **`java.util.Scanner`** class to handle user input.
2. **Class Definition:**
    - Define a class named **`ExcelColumnToNumber`**.
3. **Method for Conversion:**
    - Define a static method **`excelColumnToNumber`** that takes a **`String`** parameter (**`column`**) and returns an **`int`**.
    - Initialize **`result`** to 0.
    - Iterate through each character in the column name:
        - Update **`result`** using the formula **`result = result * 26 + (c - 'A' + 1)`**.
4. **Main Method:**
    - Inside the **`main`** method:
        - Create a **`Scanner`** object to read user input.
        - Prompt the user to enter an Excel column name and read the input using **`scanner.next()`**.
        - Call the **`excelColumnToNumber`** method to convert the column name to a column number.
        - Print the result.

### Program 2: Converting Excel Column Number to Column Name

1. **Import Statements:**
    - Import the **`java.util.Scanner`** class to handle user input.
2. **Class Definition:**
    - Define a class named **`ExcelNumberToColumn`**.
3. **Method for Conversion:**
    - Define a static method **`excelNumberToColumn`** that takes an **`int`** parameter (**`columnNumber`**) and returns a **`String`**.
    - Initialize a **`StringBuilder`** named **`result`**.
    - Use a **`while`** loop to convert the number to a column name:
        - Calculate the remainder using **`(columnNumber - 1) % 26`**.
        - Map the remainder to the corresponding character using **`(char) ('A' + remainder)`**.
        - Prepend the character to the **`result`** using **`result.insert(0, charValue)`**.
        - Update **`columnNumber`** for the next iteration using **`(columnNumber - 1) / 26`**.
4. **Main Method:**
    - Inside the **`main`** method:
        - Create a **`Scanner`** object to read user input.
        - Prompt the user to enter an Excel column number and read the input using **`scanner.nextInt()`**.
        - Call the **`excelNumberToColumn`** method to convert the column number to a column name.
        - Print the result.

## Time and Space Complexities:

### Time Complexity:

### **Convert Excel Column Name to Column Number:**

- **Python:**
    - Time Complexity: O(n), where n is the length of the input column name.
        - The `excel_column_to_number` function iterates through each character in the column name once.
- **C++:**
    - Time Complexity: O(n), where n is the length of the input column name.
        - The `excelColumnToNumber` function iterates through each character in the column name once.
- **Java:**
    - Time Complexity: O(n), where n is the length of the input column name.
        - The `excelColumnToNumber` method iterates through each character in the column name once.

### Convert Excel Column Number to Column Name:

- **Python:**
    - Time Complexity: O(log(columnNumber)), where columnNumber is the input column number.
        - The `excel_number_to_column` function divides the column number by 26 in each iteration of the loop.
- **C++:**
    - Time Complexity: O(log(columnNumber)), where columnNumber is the input column number.
        - The `excelNumberToColumn` function divides the column number by 26 in each iteration of the loop.
- **Java:**
    - Time Complexity: O(log(columnNumber)), where columnNumber is the input column number.
        - The `excelNumberToColumn` method divides the column number by 26 in each iteration of the loop.

### Space Complexity:

### Convert Excel Column Name to Column Number:

- **Python:**
    - Space Complexity: O(1)
        - The `excel_column_to_number` function uses a constant amount of space.
- **C++:**
    - Space Complexity: O(1)
        - The `excelColumnToNumber` function uses a constant amount of space.
- **Java:**
    - Space Complexity: O(1)
        - The `excelColumnToNumber` method uses a constant amount of space.

### Convert Excel Column Number to Column Name:

- **Python:**
    - Space Complexity: O(log(columnNumber)), where columnNumber is the input column number.
        - The `excel_number_to_column` function uses a StringBuilder to store the result.
- **C++:**
    - Space Complexity: O(log(columnNumber)), where columnNumber is the input column number.
        - The `excelNumberToColumn` function uses a StringBuilder to store the result.
- **Java:**
    - Space Complexity: O(log(columnNumber)), where columnNumber is the input column number.
        - The `excelNumberToColumn` method uses a StringBuilder to store the result.

In both programs, the space complexity is primarily determined by the length of the result string, which grows logarithmically with the input column number. The time complexity is dominated by the number of iterations needed to perform the conversion.

## Real Time Applications:

Excel column name and number conversions, as demonstrated in the provided programs, might seem like a simple concept, but they can be quite useful in various real-time applications, especially when dealing with data manipulation, data analysis, and spreadsheet-related tasks. Here are some scenarios where such conversions are relevant:

1. **Excel File Processing:**
    - When working with Excel files programmatically, these conversions are useful for translating between column names and numerical indices. This is crucial when extracting, updating, or manipulating data in Excel sheets using programming languages.
2. **Data Analysis and Visualization:**
    - In data analysis tasks, you might encounter situations where column names or indices need to be dynamically referenced based on user input or specific conditions. These conversions are handy in creating flexible and dynamic data analysis tools.
3. **Database Integration:**
    - When integrating with databases, especially those that store tabular data similar to Excel sheets, these conversions can help map between column names used in the application and their corresponding database columns.
4. **Web Development:**
    - In web development, these conversions can be relevant when handling data tables. For instance, a web application may allow users to interact with data using Excel-like column references, and these conversions help bridge the gap between user input and backend processing.
5. **Data Science and Machine Learning:**
    - In data science workflows, where datasets are often loaded and processed programmatically, these conversions can be essential for feature selection, referencing specific columns, or reshaping data for machine learning models.
6. **Automation Scripts:**
    - Automation scripts that involve Excel, such as automating repetitive tasks or generating reports, may need to convert between column names and numbers. This is common in scenarios where specific columns need to be selected or manipulated.
7. **Spreadsheet Software Extensions:**
    - If you're developing extensions or plugins for spreadsheet software, having the ability to convert between column names and numbers is fundamental. This is applicable to platforms beyond Excel, such as Google Sheets or other spreadsheet tools.
8. **User Interface Design:**
    - In applications with user interfaces that involve tables or grid-like structures, these conversions are useful for handling user input related to columns. For example, a user might refer to columns by name, and the application needs to translate this into a numerical representation.
9. **Custom Reporting Systems:**
    - Custom reporting systems often involve specifying columns for data extraction or analysis. These conversions can be part of the mechanism to allow users to define and customize their reports.

In essence, these conversions play a role in enhancing the flexibility, user-friendliness, and automation capabilities of applications dealing with tabular data, especially in contexts where Excel-like column references are used.

## Test Cases
- For Column Name to Column Number
  Input: "AB"
  Output: 28
  
  - The program converts the Excel column name "AB" to its corresponding numeric value.
  - In the function excel_column_to_number:
    - Each character contributes to the final result by its position in the alphabet.
    - 'A' contributes 1, 'B' contributes 2, and so on.
  - For the input "AB", the calculation is (1 * 26 + 2) = 28.
  Therefore, the output is 28.

  For Column Number to Column Name
  Input: 28
  Output: "AB"

  - The program converts the Excel column number "28" to its corresponding column name.
  - In the function excel_number_to_column:
    - Characters are calculated from right to left.
    - Each character is determined by the remainder of the column number divided by 26 (minus 1), representing its position in the alphabet.
    - The character is prepended to the result string.
    - The column number is updated by integer division by 26 (minus 1).
  - For the input "28", the characters are calculated as follows: 'A' (1), 'B' (2).
  Therefore, the output is "AB".

- For Column Name to Column Number
  Input: "ZY"
  Output: 701

  - The program converts the Excel column name "ZY" to its corresponding numeric value.
  - In the function excel_column_to_number:
    - Each character contributes to the final result by its position in the alphabet.
    - 'Z' contributes 26, 'Y' contributes 25.
  - For the input "ZY", the calculation is (26 * 26 + 25) = 701.
  Therefore, the output is 701.

  For Column Number to Column Name
  Input: 701
  Output: "ZY"

  - The program converts the Excel column number "701" to its corresponding column name.
  - In the function excel_number_to_column:
    - Characters are calculated from right to left.
    - Each character is determined by the remainder of the column number divided by 26 (minus 1), representing its position in the alphabet.
    - The character is prepended to the result string.
    - The column number is updated by integer division by 26 (minus 1).
  - For the input "701", the characters are calculated as follows: 'Z' (25), 'Y' (24).
  Therefore, the output is "ZY".
  
