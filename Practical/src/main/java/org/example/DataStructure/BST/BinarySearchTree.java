package org.example.DataStructure.BST;

class Node{
    int data;
    Node left;
    Node right;

    Node() { }

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    public int getData() { return this.data; }

    public void setLeft(Node l) {
        this.left = l;
    }

    public void setRight(Node r) {
        this.right = r;
    }

    public Node getLeft() { return this.left; }

    public Node getRight() { return this.right; }
}

public class BinarySearchTree {
    public void insert(Node root, int data) {
        Node node = root;

        if (root == null) { 
            System.out.println("We are inside the null");
            root = new Node(data);
            if (root == null) {
                System.out.println("we are null");
            } else {
                System.out.println("We are not null");
            }
            return;
        }

        while (node != null) {
        
            if (node.getData() >= data) {
                // left
                if (node.getLeft() == null) {
                    node.setLeft(new Node(data));

                    // System.out.println("Data: "+root.getData());
                    // System.out.println("Left: "+root.getLeft().getData());
                    return;
                } else {
                    node = node.getLeft();
                }
            } else {
                // right
                if (node.getRight() == null) {
                    node.setRight(new Node(data));
                    return;
                } else {
                    node = node.getRight();
                }
                
            }
        }

        // System.out.println("Data: "+root.getData());
        // System.out.println("Left: "+root.getLeft().getData());
    }

    public void inorderTraversal(Node root) {
        if (root == null) return;

        inorderTraversal(root.getLeft());

        System.out.print(root.getData()+" ");
        inorderTraversal(root.getRight());
    }

    public void preorderTraversal(Node root) {
        if (root == null) return;

        System.out.print(root.getData()+" ");
        preorderTraversal(root.getLeft());
        preorderTraversal(root.getRight());
    }

    public void postorderTraversal(Node root) {
        if (root == null) return;

        postorderTraversal(root.getLeft());
        postorderTraversal(root.getRight());  
        System.out.print(root.getData()+" ");      
    }

    public Node search(Node root, int key) {
        if (root == null) return null;

        if (root.getData() == key) return root;

        if (root.getData() > key) return search(root.getLeft(), key);

        return search(root.getRight(), key);
    }
    
    public static void main(String[] args) {
        Node root = new Node(50);
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(root, 20);
        bst.insert(root, 70);
        bst.insert(root, 35);
        bst.insert(root, 80);

        System.out.println("Inorder Traversal: ");
        Node node = root;
        bst.inorderTraversal(node);  

        System.out.println("Preorder Traversal: ");
        node = root;
        bst.preorderTraversal(node);  

        System.out.println("Postorder Traversal: ");
        node = root;
        bst.postorderTraversal(node);   

        if (bst.search(root, 35) != null) {
            System.out.println("Key found");
        } else {
            System.out.println("Key not found");
        }
    }
}