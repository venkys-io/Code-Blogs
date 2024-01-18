#  Copyrights to venkys.io
#  For more information, visit https://venkys.io

class Node:
    def __init__(self, data):
        # Constructor for the Node class
        self.data = data
        self.left = self.right = None

def insertBST(root, data):
    # Function to insert a node into the Binary Search Tree (BST)
    if root is None:
        # If the tree is empty, create a new node
        return Node(data)
    if root.data == data:
        # If the data is already present, return the current root
        return root
    elif data < root.data:
        # If the data is smaller, go to the left subtree
        root.left = insertBST(root.left, data)
    else:
        # If the data is larger, go to the right subtree
        root.right = insertBST(root.right, data)
    return root

def inorder(root):
    # Function to perform inorder traversal of the BST
    if root:
        inorder(root.left)
        print(root.data, end=" ")
        inorder(root.right)

if __name__ == "__main__":
    root = None
    
    # Taking user input for the BST elements
    user_input = input("Enter elements for the BST (separated by spaces): ")
    arr = list(map(int, user_input.split()))

    # Building the BST using user-provided elements
    for i in arr:
        root = insertBST(root, i)

    # Displaying the inorder traversal of the BST
    print("Inorder traversal of the BST:")
    inorder(root)
