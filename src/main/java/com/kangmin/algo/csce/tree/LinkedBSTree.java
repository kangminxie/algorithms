package com.kangmin.algo.csce.tree;

/**
 * Linked Binary Search Tree(BST) Program
 * Support for FruitTree.java
 * Methods()contains:
 * insert:						insert();
 * delete:						delete();
 * search:						search();
 * print pre-order traversal	printPreorder();
 * print in-order traversal	printInorder();
 * print post-order traversal	printPostorder();
 * get depth:					getDepth();
 *
 */

public class LinkedBSTree<T extends Comparable> {
    //internal class Node
    private class Node {
        private T data;
        private Node leftChild;
        private Node rightChild;

        //default constructor for Node
        Node(T aData) {
            data = aData;
            leftChild = rightChild = null;
        }
    }//end of internal class Node


    private Node root;    //instance variable, Node type

    //default constructor for LinkedBSTree
    LinkedBSTree() {
        root = null;
    }

    //method insert(data), return void
    public void insert(T data) {
        if (root == null)
            root = new Node(data);
        else
            insert(root, data);
//			System.out.println("Inserting "+data);
    }

    //method insert(Node, data), return Node
    private Node insert(Node aNode, T data) {
        if (aNode == null)//stopping condition for recursively
            aNode = new Node(data);
        else if (data.compareTo(aNode.data) < 0)    //data is less than Node's, go left
            aNode.leftChild = insert(aNode.leftChild, data);
        else if (data.compareTo(aNode.data) >= 0)
            aNode.rightChild = insert(aNode.rightChild, data);
        return aNode;
    }

    //method search(data), return void
    public boolean search(T data) {    //if(root == null) return false
        return search(root, data);
    }

    //method search(Node data), return Node
    private boolean search(Node aNode, T data) {
        if (aNode == null)    //ending condition one, not find
            return false;

        if (data.compareTo(aNode.data) == 0)    //ending condition two, find
            return true;
        else if (data.compareTo(aNode.data) < 0)
            return search(aNode.leftChild, data);        //recursive call to leftChild
        else // if(data.compareTo(aNode.data)>0)
            return search(aNode.rightChild, data);        //recursive call to rightChild
    }

    //method delete(data), return void
    public void delete(T data) {
        root = delete(root, data);
//		System.out.println("Removing the number "+data);
    }

    //method delete(Node data), return Node
    private Node delete(Node aNode, T data) {
        if (aNode == null)
            return null;

        if (data.compareTo(aNode.data) < 0)//go to left
            aNode.leftChild = delete(aNode.leftChild, data);        //recursive call to leftChild
        else if (data.compareTo(aNode.data) > 0)
            aNode.rightChild = delete(aNode.rightChild, data);        //recursive call to rightChild

        else // if (data.compareTo(aNode.data)==0); find it, delete it the next
        {
            if (aNode.rightChild == null)//including both null
                return aNode.leftChild;
            else if (aNode.leftChild == null)//now rightChild is not null
                return aNode.rightChild;
            else//it has twoo children
            {
                Node temp = aNode;

                //find min in right tree
                aNode = findMinInTree(aNode.rightChild);

                //delete this min from right tree
                aNode.rightChild = deleteMinFromTree(temp.rightChild);

                //make sure left is still left
                aNode.leftChild = temp.leftChild;
            }
        }
        return aNode;
    }//end of method delete(Node, data)


    //method findMin(), return Node
    private Node findMinInTree(Node aNode) {
        if (aNode == null) return null;
        if (aNode.leftChild == null)
            return aNode;
        else
            return findMinInTree(aNode.leftChild);
    }

    //method deleteMin(), return Node
    private Node deleteMinFromTree(Node aNode) {
        if (aNode == null) {
            return null;
        }
        if (aNode.leftChild == null)
            return aNode.rightChild;

        //else
        aNode.leftChild = deleteMinFromTree(aNode.leftChild);
        return aNode;
    }

    //Pre-order printing, return void
    public void printPreorder() {
        if (root == null)
            System.out.println("Tree is empty");
        else {
            //	System.out.println("Printing pre-order traversal");
            printPreorder(root);
        }
    }

    private void printPreorder(Node aNode) {
        if (aNode == null)
            return;
        else {
            System.out.println(aNode.data);
            if (aNode.leftChild != null) printPreorder(aNode.leftChild);
            if (aNode.rightChild != null) printPreorder(aNode.rightChild);
        }
    }

    //In-order printing, return void
    public void printInorder() {
        if (root == null)
            System.out.println("Tree is empty");
        else {
            //	System.out.println("Printing pre-order traversal");
            printInorder(root);
        }
    }

    private void printInorder(Node aNode) {
        if (aNode == null)
            return;
        else {
            if (aNode.leftChild != null) printInorder(aNode.leftChild);
            System.out.println(aNode.data);
            if (aNode.rightChild != null) printInorder(aNode.rightChild);
        }
    }

    //Post-order printing, return void
    public void printPostorder() {
        if (root == null)
            System.out.println("Tree is empty");
        else {
            //	System.out.println("Printing post-order traversal");
            printPostorder(root);
        }
    }

    private void printPostorder(Node aNode) {
        if (aNode == null)
            return;
        else {
            if (aNode.leftChild != null) printPostorder(aNode.leftChild);
            if (aNode.rightChild != null) printPostorder(aNode.rightChild);
            System.out.println(aNode.data);
        }
    }


    //getDepth method, return int
    public int getDepth(T data) {
        if (search(data)) {
            return getDepth(root, data);
        } else {
            System.out.println("The data " + "\"" + data + "\"" + " is not found, no Depth");
            return -1;
        }
    }

    private int getDepth(Node aNode, T data) {
        if (aNode == null) return -1;
        else {
            if (data.compareTo(aNode.data) == 0) {
                return 0;
            }
            if (data.compareTo(aNode.data) < 0) {
                return getDepth(aNode.leftChild, data) + 1;
            }
            if (data.compareTo(aNode.data) > 0) {
                return getDepth(aNode.rightChild, data) + 1;
            }
            return -1;
        }
    }
}
