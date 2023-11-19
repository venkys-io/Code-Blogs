#include<bits/stdc++.h>

class Node{
    public:
        int data;
        Node *left=NULL;
        Node *right=NULL;

        // Node constructor initializes data
        Node(int val){
            data=val;
        }
};
void inorder(Node* root){
    // call inorder for left subtree
    if(root!=NULL){
        inorder(root->left);
        // Print root node data
        std::cout<<root->data<<" ";
        // call inorder for right subtree
        inorder(root->right);
    }
}

int main(){
    // Creating the binary tree
    Node* root=new Node(10);
    root->left=new Node(20);
    root->right=new Node(30);
    root->left->left=new Node(40);
    root->left->right=new Node(50);
    root->right->left=new Node(60);
    root->right->right=new Node(70);
    // Displaying the binary tree in inorder traversal
    inorder(root);
    // Inorder traversal of the tree
    return 0;
}