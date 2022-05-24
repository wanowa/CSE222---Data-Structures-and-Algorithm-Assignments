import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Objects;

public class BinaryTree<E extends Comparable<E>>  {
    protected Node<E> root;
    protected int index;

    // A constructor that initializes the root of the tree to null and the index to 0.
    public BinaryTree(){
        this.root = null;
        this.index = 0;
    }


    // Creating a new node with the data that is passed in.
    public  BinaryTree(E data){
        this.root = new Node<>(data);
    }


    // A constructor that takes a node as a parameter and sets the root of the tree to that node.
    protected BinaryTree(Node<E> root){
        this.root = root;
    }

    /**
     * Returns the root node of the tree.
     *
     * @return The root node of the tree.
     */
    public Node<E> getNode(){
        return this.root;
    }

    /**
     * Return the data of the root node.
     *
     * @return The data of the root node.
     */

    public E getData(){
        return this.root.data;
    }

    /**
     * Return a new BinaryTree object that has the same root as the current object, but with the left subtree of the
     * current object as its root.
     *
     * @return A BinaryTree object with the root of the left subtree.
     */
    public BinaryTree<E> getLeftSubtree(){
        BinaryTree<E> temp = this;
        temp.root = temp.root.left;
        return temp;
    }

    /**
     * Return a new BinaryTree object that has the same root as the current object, but with the right subtree of the
     * current object as its root.
     *
     * @return A reference to the root of the right subtree.
     */
    public BinaryTree<E> getRightSubtree(){
        BinaryTree<E> temp = this;
        temp.root = temp.root.right;
        return temp;
    }

    /**
     * It creates a binary tree of size N.
     *
     * @param val The value of the node.
     */
    public void createNSizeBinaryTree(E val){
        Node<E> temp;
        root = new Node<>(val);
        temp = this.root;
        temp.left = new Node<E>(val);
        temp.right = new Node<E>(val);
        temp.left.left = new Node<E>(val);
        temp.left.right = new Node<E>(val);
        temp.right.left = new Node<E>(val);
        temp.right.right = new Node<E>(val);
        temp.left.left.right = new Node<E>(val);
        temp.left.right.left = new Node<E>(val);
        temp.left.right.right = new Node<E>(val);
        temp.right.right.left = new Node<E>(val);
        temp.right.right.right = new Node<E>(val);
    }


    /**
     * We traverse the Binary Tree in inorder traverse make it Binary Search Tree
     *
     * @param node The node of the tree that we are currently at.
     * @param arr The array that contains the elements of the BST.
     */
    public void binaryTreeToBST(Node<E> node, E[] arr){
        if(index >= arr.length){
            this.index = 0;
            return;
        }

        else if(node == null){
            return;
        }

        else{
            binaryTreeToBST(node.left, arr);
            node.data = arr[index];
            index++;
            binaryTreeToBST(node.right, arr);
        }
    }

    /**
     * If the node is null, append "null" to the string builder. Otherwise, append the node's data to the string builder,
     * then recursively call the function on the left and right children
     *
     * @param node the node to start at
     * @param depth the depth of the current node
     * @param sb a StringBuilder object that will be used to build the string that represents the tree.
     */
    public void preOrderTraverse(Node<E> node, int depth, StringBuilder sb){
        for(int i = 1; i < depth; i++){
            sb.append("  ");
        }
        if(node == null){
            sb.append("null\n");
        } else {
            sb.append(node.data.toString());
            sb.append("\n");
            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }

    public  static class Node<E> implements Serializable {
        protected  E data;
        public   Node<E> left;
        public  Node<E> right;
        public  Node(E data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

}
