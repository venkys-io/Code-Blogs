class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class StackLL:
    def __init__(self):
        self.top = None

    def isempty(self):
        #Check if the stack is empty.#
        return not self.top

    def push(self, data):
        #Push a new element onto the stack.
        if not self.top:
            self.top = Node(data)
        else:
            temp = Node(data)
            temp.next = self.top
            self.top = temp

    def pop(self):
        #Pop the top element from the stack and return its value.
        if self.top:
            x = self.top.data
            self.top = self.top.next
            return x
        else:
            print("Stack is empty. Cannot pop.")

    def traverse(self):
        #Traverse and print the elements in the stack.
        head = self.top
        while head:
            print(head.data, end=" ")
            head = head.next
        print()
# Create an instance of StackLL
stack = StackLL()
while True:
    print("\nSelect stack operation:")
    print("1. Push")
    print("2. Pop")
    print("3. Display")
    print("4. Exit")

    choice = input("Enter choice (1/2/3/4): ")

    if choice == '1':
        data = input("Enter data to push onto the stack: ")
        stack.push(data)
        print(f"{data} pushed onto the stack.")
    elif choice == '2':
        popped_element = stack.pop()
        if popped_element is not None:
            print(f"Popped element: {popped_element}")
    elif choice == '3':
        print("Stack elements:")
        stack.traverse()
    elif choice == '4':
        print("Exiting the program.")
        break
    else:
        print("Invalid choice. Please enter a valid option.")
