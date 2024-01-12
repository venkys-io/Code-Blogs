class Node:
    def __init__(self, val):
        self.data = val
        self.next = None

class SLL:
    def __init__(self):
        self.head = None

    def insert_begin(self, val):
        # Insert a new node at the beginning of the linked list
        new_node = Node(val)
        new_node.next = self.head
        self.head = new_node

    def insert_end(self, val):
        # Insert a new node at the end of the linked list
        new_node = Node(val)
        if self.head is None:
            self.head = new_node
        else:
            temp = self.head
            while temp.next:
                temp = temp.next
            temp.next = new_node

    def insert_pos(self, val, pos):
        # Insert a new node at a specified position in the linked list
        if pos < 1:
            print("Invalid position for insertion.")
            return

        count = 0
        temp = self.head
        while temp:
            count += 1
            if count == pos - 1:
                break
            temp = temp.next

        if temp is None:
            print("Invalid position for insertion.")
            return

        new_node = Node(val)
        new_node.next = temp.next
        temp.next = new_node

    def create_loop(self, position, by_value=True):
        # Create a loop in the linked list either by value or position
        count = 0
        temp = self.head
        while temp.next:
            count += 1
            if (by_value and count == position) or (not by_value and count == position - 1):
                loop_node = temp.next
                break
            temp = temp.next

        temp.next = loop_node

    def detect_loop(self):
        # Detect a loop in the linked list using Floyd's Tortoise and Hare algorithm
        slow = self.head
        fast = self.head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                print("Loop detected in the linked list.")
                return slow  # Return the node where the loop starts

        print("No loop found in the linked list.")
        return None

    def remove_loop(self):
        # Remove the loop in the linked list using Floyd's Tortoise and Hare algorithm
        loop_start = self.detect_loop()
        if loop_start:
            slow = self.head
            fast = loop_start

            while slow.next != fast.next:
                slow = slow.next
                fast = fast.next

            fast.next = None

    def display(self):
        # Display the elements of the linked list
        temp = self.head
        while temp:
            print(temp.data, end=" -> ")
            temp = temp.next
        print("None")


# Test drive code with user input:
sll = SLL()

print("------------INSERTION OPERATIONS-------------")
n = int(input("Enter the number of elements to insert at the beginning: "))
for _ in range(n):
    val = int(input("Enter the value to insert at the beginning: "))
    sll.insert_begin(val)
sll.display()

n = int(input("Enter the number of elements to insert at the end: "))
for _ in range(n):
    val = int(input("Enter the value to insert at the end: "))
    sll.insert_end(val)
sll.display()

val = int(input("Enter the value to insert: "))
pos = int(input("Enter the position to insert at: "))
sll.insert_pos(val, pos)
sll.display()

print("------------LOOP CREATION-------------")
pos = int(input("Enter the position for loop creation: "))
sll.create_loop(pos)
sll.display()

print("------------LOOP DETECTION-------------")
sll.detect_loop()

print("------------LOOP REMOVAL-------------")
sll.remove_loop()
sll.display()