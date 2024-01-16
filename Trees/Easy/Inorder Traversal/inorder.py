# Definition for a binary tree node
class Node:
    def __init__(self, data):
        self.data = data
        self.left = self.right = None

# Recursive Inorder Traversal.
def inorder(root):
    # Check if the root exists
    if root:
        # Perform an inorder traversal on the left subtree
        inorder(root.left)
        # Print the value of the current node
        print(root.data, end=" ")
        # Perform an inorder traversal on the right subtree
        inorder(root.right)

if __name__ == "__main__":
    try:
        # Prompt the user to enter values for the binary tree
        root_data = int(input("Enter the value for the root node: "))
        root = Node(root_data)

        left_data = int(input("Enter the value for the left child of the root node: "))
        root.left = Node(left_data)

        right_data = int(input("Enter the value for the right child of the root node: "))
        root.right = Node(right_data)

        left_left_data = int(input("Enter the value for the left child of the left child: "))
        root.left.left = Node(left_left_data)

        left_right_data = int(input("Enter the value for the right child of the left child: "))
        root.left.right = Node(left_right_data)

        right_left_data = int(input("Enter the value for the left child of the right child: "))
        root.right.left = Node(right_left_data)

        right_right_data = int(input("Enter the value for the right child of the right child: "))
        root.right.right = Node(right_right_data)

        # Perform Inorder Traversal
        print("Inorder Traversal:")
        inorder(root)
    
    except ValueError:
        print("Error: Please enter valid integer values for the nodes.")
    except Exception as e:
        print(f"Error: {e}")
