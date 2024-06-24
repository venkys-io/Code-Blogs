class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

def create_list(llist):
    head = None
    temp = None
    for i in llist:
        if not temp:
            temp = Node(i)
            head = temp
        else:
            temp.next = Node(i)
            temp = temp.next
    return head

def check_palindrome(head):
    temp = head
    stack = []

    # Push elements of the first half onto the stack
    while head:
        stack.append(head.data)
        head = head.next

    # Compare the second half with the elements popped from the stack
    while temp:
        if temp.data != stack.pop():
            return False
        temp = temp.next

    return True

if __name__ == "__main__":
    # Take user input for the linked list
    user_input = input("Enter elements of the linked list separated by spaces: ")
    llist = list(map(int, user_input.split()))

    # Create the linked list
    head = create_list(llist)

    # Check if the linked list is a palindrome
    result = check_palindrome(head)

    # Print the result
    if result:
        print("The linked list is a palindrome.")
    else:
        print("The linked list is not a palindrome.")
