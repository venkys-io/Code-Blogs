# Definition for a binary tree node
class Node:
    def __init__(self,data):
        self.data=data 
        self.left=self.right=None 
# Recursive Inorder Traversal.
def inorder(root):
    # Check if the root exists
    if root:
        # Perform an inorder traversal on the left subtree
        inorder(root.left)
        # Print the value of the current node
        print(root.data,end=" ")
        # Perform an inorder traversal on the right subtree
        inorder(root.right)
    # Driver code to test above function 
# The values of nodes are given below :
if __name__=="__main__":
    root=Node(80)
    root.left=Node(20)
    root.right=Node(30)
    root.left.left=Node(40)
    root.left.right=Node(350)
    root.right.left=Node(460)
    root.right.right=Node(70)
    inorder(root)
