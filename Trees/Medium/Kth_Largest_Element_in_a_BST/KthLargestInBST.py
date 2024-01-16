""" Copyrights to venkys.io
For more information, visit https://venkys.io

Space complexity: O(H)
Time complexity: O(H + K) """
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

class KthLargestInBST:
    def __init__(self):
        self.count = 0
        self.result = None

    def kth_largest(self, root, k):
        self.count = k
        self.inorder_traversal(root)
        return self.result

    def inorder_traversal(self, node):
        if not node or self.count == 0:
            return

        self.inorder_traversal(node.right)

        self.count -= 1
        if self.count == 0:
            self.result = node.val
            return

        self.inorder_traversal(node.left)

def build_tree_from_input(nodes, index):
    if index < len(nodes) and nodes[index] is not None:
        root = TreeNode(nodes[index])
        root.left = build_tree_from_input(nodes, 2 * index + 1)
        root.right = build_tree_from_input(nodes, 2 * index + 2)
        return root
    return None

if __name__ == "__main__":
    # Input the values for the tree nodes (e.g., "5 3 7 2 null 6 8")
    nodes_input = input("Enter the values for the tree nodes: ")
    nodes = [int(val) if val != "null" else None for val in nodes_input.split()]

    root = build_tree_from_input(nodes, 0)

    if root is None:
        print("The BST is empty.")
    else:
        kth_largest_obj = KthLargestInBST()

        # Input the value of k
        k = int(input("Enter the value of k: "))

        result = kth_largest_obj.kth_largest(root, k)
        print(f"The {k}th largest element in the BST is: {result}")
