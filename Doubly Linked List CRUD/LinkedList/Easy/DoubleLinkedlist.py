class Node:
    def __init__(self, val):
        self.prev = None
        self.data = val
        self.next = None

class DLL:
    def __init__(self):
        self.head = None

    # Create Operation: Insert at the Beginning
    def insert_begin(self, val):
        new_node = Node(val)
        if self.head:
            self.head.prev = new_node
            new_node.next = self.head
            self.head = new_node
        else:
            self.head = new_node

    # Create Operation: Insert at the End
    def insert_end(self, val):
        new_node = Node(val)
        if self.head is None:
            self.head = new_node
        else:
            temp = self.head
            while temp.next:
                temp = temp.next
            new_node.prev = temp
            temp.next = new_node

    # Create Operation: Insert at a Specific Position
    def insert_pos(self, val, pos):
        count = 0
        temp = self.head
        while temp:
            count += 1
            if count == pos:
                break
            else:
                temp = temp.next
        new_node = Node(val)
        new_node.prev = temp.prev
        new_node.next = temp
        temp.prev.next = new_node

    # Delete Operation: Delete from the Beginning
    def delete_begin(self):
        if self.head is None:
            print("List is empty.")
        else:
            self.head = self.head.next
            if self.head:
                self.head.prev = None

    # Delete Operation: Delete from the End
    def delete_end(self):
        if self.head is None:
            print("List is empty.")
        elif self.head.next is None:
            self.head = None
        else:
            temp = self.head
            while temp.next:
                temp = temp.next
            temp.prev.next = None

    # Delete Operation: Delete from a Specific Position
    def delete_pos(self, pos):
        count = 0
        temp = self.head
        while temp:
            count += 1
            if count == pos:
                break
            else:
                temp = temp.next
        if temp.next:
            temp.next.prev = temp.prev
            temp.prev.next = temp.next
        else:
            temp.prev.next = None

    # Update Operation: Update Node Value
    def update(self, pval, nval):
        if self.head:
            temp = self.head
            while temp:
                if temp.data == pval:
                    temp.data = nval
                    break
                temp = temp.next

    # Remove Operation: Remove Node with a Specific Value
    def remove(self, val):
        if self.head and self.head.data == val:
            self.head = self.head.next
            if self.head:
                self.head.prev = None
        else:
            temp = self.head
            while temp and temp.next:
                if temp.data == val:
                    temp.next.prev = temp.prev
                    temp.prev.next = temp.next
                    break
                temp = temp.next

    # Display Operation: Display the Doubly Linked List
    def display(self):
        temp = self.head
        while temp:
            print(temp.data, end="<->")
            temp = temp.next
        print("None")


# Example Usage
dll = DLL()

while True:
    print("\n1. Insert at the Beginning")
    print("2. Insert at the End")
    print("3. Insert at a Specific Position")
    print("4. Delete from the Beginning")
    print("5. Delete from the End")
    print("6. Delete from a Specific Position")
    print("7. Update Node Value")
    print("8. Remove Node with a Specific Value")
    print("9. Display")
    print("0. Exit")

    choice = int(input("Enter your choice: "))

    if choice == 1:
        val = int(input("Enter value to insert at the beginning: "))
        dll.insert_begin(val)
    elif choice == 2:
        val = int(input("Enter value to insert at the end: "))
        dll.insert_end(val)
    elif choice == 3:
        val = int(input("Enter value to insert: "))
        pos = int(input("Enter position to insert at: "))
        dll.insert_pos(val, pos)
    elif choice == 4:
        dll.delete_begin()
    elif choice == 5:
        dll.delete_end()
    elif choice == 6:
        pos = int(input("Enter position to delete: "))
        dll.delete_pos(pos)
    elif choice == 7:
        pval = int(input("Enter old value to update: "))
        nval = int(input("Enter new value: "))
        dll.update(pval, nval)
    elif choice == 8:
        val = int(input("Enter value to remove: "))
        dll.remove(val)
    elif choice == 9:
        dll.display()
    elif choice == 0:
        print("Exiting...")
        break
    else:
        print("Invalid choice. Please try again.")