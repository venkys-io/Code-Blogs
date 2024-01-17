# Exploring Linked Lists:Finding median from two sorrted linked lists

A linked list is a data structure that consists of a sequence of elements, where each element points to the next one in the sequence. Unlike arrays, linked lists do not have a fixed size, and elements can be easily inserted or removed without the need to shift other elements.

# Introduction to linked lists

A linked list is a linear data structure consisting of a sequence of elements, where each element points to the next one in the sequence. Unlike arrays, linked lists do not have a fixed size in memory and can dynamically grow or shrink. This makes linked lists a flexible and efficient choice for certain operations, such as inserting or deleting elements, as compared to arrays.

The basic building block of a linked list is a node. Each node contains two fields: a data element (or payload) and a reference (or link) to the next node in the sequence. The last node in the list typically has a null reference, indicating the end of the list.

There are various types of linked lists, with the two most common types being:

1. Singly linked list
2. Doubly linked list

# Finding median from two sorted linked lists:

Finding the median from two sorted linked lists involves merging the lists and then determining the median based on the combined elements. The process typically begins with the creation of a dummy node to simplify the merging algorithm. The merge_lists function iterates through both input linked lists (l1 and l2), comparing the values of corresponding nodes and linking the smaller value to the merged list. This continues until one of the input lists is fully processed. The remaining elements from the non-empty list are then appended to the merged list.

After merging the two sorted linked lists, the find_median function uses the two-pointer approach to locate the median node. It employs both a slow and a fast pointer, with the slow pointer advancing one node at a time and the fast pointer advancing two nodes at a time. If the fast pointer reaches the end of the list, the number of elements is even, and the median is calculated as the average of the values of the two middle elements. If the fast pointer is not at the end, indicating an odd number of elements, the median is the value of the middle element.

The find_median_from_sorted_lists function combines the merging and median-finding processes. It takes two sorted linked lists (l1 and l1), merges them using the merge_lists function, and then calculates the median using the find_median function. The final median value is returned.

In the provided example, two sorted linked lists (list1 and list2) are created, representing sorted sequences of values. The  function is then applied to find find_median_from_sorted_lists and print the median of the combined elements from both lists. This approach is particularly useful for efficiently determining the median of large datasets without the need to fully concatenate the lists.

# Code

## Python code:

```python
# Copyrights to venkys.io for more information, visit https://venkys.io
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

def merge_lists(l1, l2):
    dummy = ListNode()
    current = dummy

    while l1 and l2:
        if l1.val < l2.val:
            current.next = l1
            l1 = l1.next
        else:
            current.next = l2
            l2 = l2.next
        current = current.next

    if l1:
        current.next = l1
    elif l2:
        current.next = l2

    return dummy.next

def find_median(head):
    slow = head
    fast = head
    prev = None

    while fast and fast.next:
        prev = slow
        slow = slow.next
        fast = fast.next.next

    if fast is None:
        # Even number of elements
        return (prev.val + slow.val) / 2
    else:
        # Odd number of elements
        return slow.val

def find_median_from_sorted_lists(l1, l2):
    merged_list = merge_lists(l1, l2)
    return find_median(merged_list)

# Example usage:
# Create sorted linked lists
list1 = ListNode(1, ListNode(3, ListNode(5)))
list2 = ListNode(2, ListNode(4, ListNode(6)))

# Find the median
median = find_median_from_sorted_lists(list1, list2)

print("Median:", median)
```

## Step-by-step explantion:

### **ListNode Class:**

- The find_median_from_sorted_lists list node class represents a node in a linked list. Each node has a value (val) and a reference to the next node (next).

### **merge_lists Function:**

- The merge_lists function takes two sorted linked lists l1 and l1 and merges them into a single sorted linked list.
- It uses the two-pointer approach to iterate through both lists and compares the values of the current nodes, linking the smaller one to the result.
- The function returns the merged sorted linked list.

### **find_median Function:**

- The find_median function takes a linked list head and finds its median.
- It uses the two-pointer approach, where the slow pointer advances one step at a time, and the fast pointer advances two steps at a time.
- If the number of elements is even, the median is the average of the two middle elements. If it's odd, the median is the value of the middle element.
- The function returns the median value.

### **find_median_from_sorted_lists Function:**

- The  function takes two sorted linked lists l1 and l2, merges them using merge_lists, and then finds the median using find_median.
- It returns the calculated median value.

### **Example Usage:**

- This section demonstrates the usage of the functions by creating two sorted linked lists (l1 and l2) and finding their median using the find_median_from_sorted_lists function.
- The calculated median is then printed.

## Java code:

```java

// Copyrights to venkys.io for more information, visit https://venkys.io
class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

public class MedianOfSortedLinkedLists {

    public double findMedianSortedLists(ListNode l1, ListNode l2) {
        ListNode mergedList = mergeLists(l1, l2);
        return findMedian(mergedList);
    }

    private ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }

        return dummy.next;
    }

    private double findMedian(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast == null) {
            // Even number of elements
            return (prev.val + slow.val) / 2.0;
        } else {
            // Odd number of elements
            return slow.val;
        }
    }

    public static void main(String[] args) {
        MedianOfSortedLinkedLists solution = new MedianOfSortedLinkedLists();

        // Create sorted linked lists
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        // Find the median
        double median = solution.findMedianSortedLists(list1, list2);

        System.out.println("Median: " + median);
    }
}
```

## Step-by-step explantion:

### listnode **Class:**

- The listnode class is a simple class representing a node in a linked list. Each node has an integer value (val) and a reference to the next node in the list (next).

`MedianOfSortedLinkedLists` **Class:**

### Findmediansortedlists **Method:**

- The findmediansortedlists **** method takes two sorted linked lists (l1 and l2), merges them using the mergelists method, and then calculates the median using the findmedian method.

### mergelists **Method:**

- The mergelists method takes two sorted linked lists (l1 and l2) and merges them into a single sorted linked list.
- It uses a dummy node to simplify the merging process and iterates through both lists, comparing values and linking the smaller value to the merged list.
- The method returns the merged sorted linked list.

### findmedian **Method:**

- The findmedianmethod takes a linked list (head) and finds its median using the two-pointer approach.
- It uses two pointers (slow and fast) to traverse the list, with fast moving twice as fast as alow.
- If the number of elements is even, it returns the average of the values of the two middle elements. If it's odd, it returns the value of the middle element.

### Main **Method (Example Usage):**

- The main method demonstrates the usage of the  Findmediansortedlists class
- It creates two sorted linked lists (l1 and l2), finds their median using the Findmediansortedlists method, and prints the result.

## C++ code:

```cpp
// Copyrights to venkys.io for more information, visit https://venkys.io
#include <iostream>

using namespace std;

// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode* next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    double findMedianSortedLists(ListNode* l1, ListNode* l2) {
        ListNode* mergedList = mergeLists(l1, l2);
        return findMedian(mergedList);
    }

private:
    ListNode* mergeLists(ListNode* l1, ListNode* l2) {
        ListNode* dummy = new ListNode(0);
        ListNode* current = dummy;

        while (l1 != nullptr && l2 != nullptr) {
            if (l1->val < l2->val) {
                current->next = l1;
                l1 = l1->next;
            } else {
                current->next = l2;
                l2 = l2->next;
            }
            current = current->next;
        }

        if (l1 != nullptr) {
            current->next = l1;
        } else if (l2 != nullptr) {
            current->next = l2;
        }

        return dummy->next;
    }

    double findMedian(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;
        ListNode* prev = nullptr;

        while (fast != nullptr && fast->next != nullptr) {
            prev = slow;
            slow = slow->next;
            fast = fast->next->next;
        }

        if (fast == nullptr) {
            // Even number of elements
            return (prev->val + slow->val) / 2.0;
        } else {
            // Odd number of elements
            return slow->val;
        }
    }
};

int main() {
    Solution solution;

    // Create sorted linked lists
    ListNode* list1 = new ListNode(1);
    list1->next = new ListNode(3);
    list1->next->next = new ListNode(5);

    ListNode* list2 = new ListNode(2);
    list2->next = new ListNode(4);
    list2->next->next = new ListNode(6);

    // Find the median
    double median = solution.findMedianSortedLists(list1, list2);

    cout << "Median: " << median << endl;

    return 0;
}
```

## Stwp-by-step explanation:

1. **ListNode Structure:**
    - A simple structure is defined to represent a node in a singly-linked list. Each node contains an integer value (val) and a pointer to the next node (next).
2. **Solution Class:**
    - The solution class encapsulates the solution logic.
3. **findMedianSortedLists Method:**
    - This method takes two sorted linked lists (l1 and l1), merges them using the mergelists method, and calculates the median using the findmedian method.
4. **mergeLists Method:**
    - The mergelists method takes two sorted linked lists (l1 and l2) and merges them into a single sorted linked list.
    - It uses a dummy node to simplify the merging process and iterates through both lists, comparing values and linking the smaller value to the merged list.
5. **findMedian Method:**
    - The findmedian method takes a linked list (haed) and finds its median using the two-pointer approach.
    - Two pointers (slow and fast) are used to traverse the list, with fast moving twice as fast as slow.
    - If the number of elements is even, it returns the average of the values of the two middle elements. If it's odd, it returns the value of the middle element.
6. **Main Method:**
    - The main function demonstrates the usage of the solution class.
    - It creates two sorted linked lists (l1 and l2), finds their median using the findmediansortedlists method, and prints the result.

## Time and Space complexity analysis:

### **Time Complexity:**

1. **Merging Linked Lists (mergelists method):**
    - The merging process involves iterating through both linked lists once.
    - The time complexity is O(m + n), where m and n are the lengths of the two linked lists.
2. **Finding Median (findmedian method):**
    - The finding median process involves traversing the linked list with two pointers.
    - The time complexity is O(m + n), where m and n are the lengths of the merged linked list.
3. **Overall Time Complexity:**
    - The overall time complexity is dominated by the merging process, resulting in O(m + n).

### **Space Complexity:**

1. **Merging Linked Lists (mergelists method):**
    - The merging process creates a new linked list (merged list) but does not use any additional space.
    - The space complexity is O(1) since the merged list is constructed in place.
2. **Finding Median (findmedian method):**
    - The finding median process uses three pointers (slow, fast, and prev), which requires O(1) extra space.
3. **Overall Space Complexity:**
    - The overall space complexity is O(1) as it doesn't depend on the size of the input linked lists.
      
#Test cases to the above codes:
# Test Case 1: Successful Merge and Median Calculation
list1 = ListNode(1, ListNode(3, ListNode(5)))
list2 = ListNode(2, ListNode(4, ListNode(6)))
# Merged List: 1 -> 2 -> 3 -> 4 -> 5 -> 6
# Median: (3 + 4) / 2 = 3.5
# Expected output: Median: 3.5
print("Test Case 1:", find_median_from_sorted_lists(list1, list2))

# Test Case 2: Successful Merge and Median Calculation (Odd Number of Elements)
list1 = ListNode(1, ListNode(3, ListNode(5)))
list2 = ListNode(2, ListNode(4, ListNode(6, ListNode(8))))
# Merged List: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 8
# Median: 4
# Expected output: Median: 4
print("Test Case 2:", find_median_from_sorted_lists(list1, list2))

# Test Case 3: Unsuccessful Merge (One of the lists is empty)
list1 = ListNode(1, ListNode(3, ListNode(5)))
list2 = None
# Merged List: 1 -> 3 -> 5
# Expected output: Median: 3
print("Test Case 3:", find_median_from_sorted_lists(list1, list2))

# Test Case 4: Unsuccessful Merge (Both lists are empty)
list1 = None
list2 = None
# Merged List: None
# Expected output: Median: None
print("Test Case 4:", find_median_from_sorted_lists(list1, list2))

# Test Case 5: Hard Test Case (Lists with negative values and duplicates)
list1 = ListNode(-5, ListNode(-3, ListNode(-1)))
list2 = ListNode(-4, ListNode(-2, ListNode(0, ListNode(2))))
# Merged List: -5 -> -4 -> -3 -> -2 -> -1 -> 0 -> 2
# Median: -3
# Expected output: Median: -3
print("Test Case 5:", find_median_from_sorted_lists(list1, list2))


# Real world applications :

1. **Database Management Systems:**
    - In database systems, data is often stored and retrieved in a sorted manner. The code could be adapted to find the median value of a result set from a database query, providing insights into the central tendency of the data.
2. **Financial Analysis:**
    - Financial data, such as stock prices or economic indicators, is frequently sorted in time series. The code could be used to find the median value of financial metrics, helping analysts identify trends and make informed decisions.
3. **Healthcare Data Analysis:**
    - Medical datasets, such as patient vital signs or laboratory results, may be sorted. The code could assist in finding the median values of health-related parameters, aiding healthcare professionals in assessing patient health and making clinical decisions.
4. **Merge Sort Implementation:**
    - The code performs a basic form of merging two sorted lists, which is a fundamental step in algorithms like Merge Sort. Understanding and implementing such merging logic is crucial in various sorting algorithms used in computer science and software development.
5. **Statistical Analysis and Machine Learning:**
    - In statistical analysis and machine learning, algorithms often work with sorted data. The code could be adapted to find the median of feature values or predicted outcomes, contributing to the interpretation and evaluation of models.
6. **Data Preprocessing in Data Science:**
    - When working with large datasets, sorting is a common preprocessing step. The code could be part of a data preprocessing pipeline, helping to compute summary statistics like the median before further analysis.
7. **Time Series Analysis:**
    - Time series data, such as climate records or stock prices, is frequently sorted by timestamp. The code could be used to find the median value of time series data, providing insights into central trends over time.
8. **Log Analysis:**
    - In log files generated by applications or systems, events are often timestamped and sorted. The code could be employed to find the median timestamp, assisting in diagnosing issues or analyzing the system's behavior.
