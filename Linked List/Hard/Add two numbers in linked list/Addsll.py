'''Copyrights to venkys.io
For more information, visit https://venkys.io"/

Python program to add two numbers in a linked list'''

# Stable : Yes
# Inplace : Yes
# Adaptive : Yes

# Space complexity: O(max(N,M)), where N and M are the lengths of input linked lists.

#Time Complexity: O(max(N,M)), where N and M are the lengths of input linked lists.

# Constructor method for the Node class
class Node:
    def __init__(self,data):
        self.data=data # Store the provided data in the 'data' attribute of the node
        self.next=None  # Initialize the 'next' attribute to None, as this node is not yet connected to another node.

def printLLReverse(head):
    #Function to print linked list in reverse order
    stack=[]
    # Traverse the linked list and push each node's data onto the stack
    while head:
        stack.append(head.data)
        head=head.next
    # Pop each element from the stack and print it in reverse order
    while stack:
        print(stack.pop(),end="")
    # Print a newline to separate the reversed data from the rest of the output
    print()

'''def printLL(head):
#Function to print the linked list
    while head:
        print(head.data,end="-->")
        head=head.next
    print()'''

def buildLL(arr):
    #Function to build a linked list from an array
    temp=Node(0)
    head=temp
    for i in arr:
        # Create a new node with the current array element
        temp.next=Node(i)
        # Move the temporary pointer to the newly created node
        temp=temp.next
    return head.next

def addTwoNumbers(l1,l2):
#Function to add two numbers represented as linked lists
    temp=Node(0)
    head=temp
    c=0
    # loop until there are elements in either l1,;2 or there is carry.
    while l1 or l2 or c:
        # add corresponding digits from l1,l2 along with carry
        if l1:
            c+=l1.data
            l1=l1.next
        if l2:
            c+=l2.data
            l2=l2.next
        #Create a new node with sum%10 and update carry
        temp.next=Node(c%10)
        c=c//10
        temp=temp.next
    return head.next


def main():
    # Prompt the user to enter the first number
    print("Enter first number:", end=" ")
    num1 = input()
    l1 = buildLL([int(x) for x in num1.split()])
    
     # Prompt the user to enter the second number
    print("Enter Second number:", end=" ")
    num2 = input()
    l2 = buildLL([int(x) for x in num2.split()])
    
    # Print the reverse of the linked list representing the sum (result)
    print("Sum of two numbers: ", end=" ")
    ans = addTwoNumbers(l1, l2)
    printLLReverse(ans)

if __name__ == "__main__":
    main()
