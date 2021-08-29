package main.java.com.kangmin.csce.tree;

import java.util.Arrays;

/**
 * Array-based Binary Search Tree(BST) Program
 * Support for DriverForArrayTree.java
 * Methods()contains:
 * insert:						insert();
 * search:						search();
 * print pre-order traversal	printPreOrder();
 * print in-order traversal	printInOrder();
 * print post-order traversal	printPostOrder();
 * print Breadth traversal		printBreadthOrder();
 * get depth:					getDepth();
 *
 */

public class IntBSTree {
    //instance variables
    private int[] tree;
    private static final int DEF_SIZE = 1024;

    //default constructor
    public IntBSTree() {
        tree = new int[DEF_SIZE];

        //initialize all elements to -9
        Arrays.fill(tree, -9);
    }

    //parameterized constructor
    public IntBSTree(int size) {
        if (size > 0)
            tree = new int[size];

        //initialize all elements to -9
        Arrays.fill(tree, -9);
    }

    //method insert(data), return void
    public void insert(int data) {
        if (data > 0) {
            if (tree[0] == -9)//if the tree is empty
                tree[0] = data;
            else
                insert(0, data);//start from the root
        } else
            System.out.println("Please insert a positive number");
    }

    //method insert(index, data), return void
    private void insert(int index, int data) {
        if (tree[index] == -9) {                        //insert here
            tree[index] = data;
        } else if (data - (tree[index]) < 0) {
            if (index * 2 + 1 < tree.length)//make sure within the array
                insert(index * 2 + 1, data);
        } else if (data - (tree[index]) >= 0) {
            if (index * 2 + 2 < tree.length)//also make sure within the array
                insert(index * 2 + 2, data);
        }
    }

    //method printPreOrder(), return void
    public void printPreOrder() {
        printPreOrder(0);
    }

    //method printPreOrder(index), return void
    private void printPreOrder(int index) {
        if (tree[index] == -9)
            return;
        System.out.println(tree[index]);//process
        if ((index * 2 + 1) < tree.length)//can I go left?
            printPreOrder(index * 2 + 1);//go left
        if ((index * 2 + 2) < tree.length)//can I go right?
            printPreOrder(index * 2 + 2);//go right
    }


    //method printInOrder(), return void
    public void printInOrder() {
        printInOrder(0);
    }

    //method printInOrder(index), return void
    private void printInOrder(int index) {
        if (tree[index] == -9)
            return;
        if ((index * 2 + 1) < tree.length)//can I go left?
            printInOrder(index * 2 + 1);//go left
        System.out.println(tree[index]);//process
        if ((index * 2 + 2) < tree.length)//can I go right?
            printInOrder(index * 2 + 2);//go right
    }


    //method printPostOrder(), return void
    public void printPostOrder() {
        printPostOrder(0);
    }

    //method printPostOrder(index), return void
    private void printPostOrder(int index) {
        if (tree[index] == -9)
            return;
        if ((index * 2 + 1) < tree.length)//can I go left?
            printPostOrder(index * 2 + 1);//go left
        if ((index * 2 + 2) < tree.length)//can I go right?
            printPostOrder(index * 2 + 2);//go right
        System.out.println(tree[index]);//process
    }


    //method printPostOrder(), return void
    public void printBreadthOrder() {
        for (int val : tree) {
            if (val != -9)
                System.out.println(val);
        }
    }


    //method search(data)
    public boolean search(int data) {
        if (data > 0)
            return search(0, data);
        else
            return false;
    }

    //method search(index, data), return true or false
    private boolean search(int index, int data) {
        if (index > tree.length || tree[index] == -9)    //ending condition one, not find
            return false;                            //keep the index is safe until end

        if (data - tree[index] == 0)    //ending condition two, find
            return true;
        else if (data - (tree[index]) < 0)
            return search(index * 2 + 1, data);        //recursive call to leftChild
        else // if(data.compareTo(aNode.data)>0)
            return search(index * 2 + 2, data);        //recursive call to rightChild
    }


    //getDepth method, return int
    public int getDepth(int data) {
        if (search(data)) {
            return getDepth(0, data);
        } else {
//	        System.out.println("The data "+"\""+data+"\""+" is not found, no Depth");
            return -1;
        }
    }

    //getDepth method with initial index, return int
    private int getDepth(int index, int data) {
        if (tree[index] == -9)
            return -1;    //data is not find at the end
        else {
            //find data at current index
            if (data - (tree[index]) == 0) {
                return 0;
            }
            if (data - (tree[index]) < 0) { //go left
                return getDepth(index * 2 + 1, data) + 1;
            }
            if (data - (tree[index]) > 0) { //go right
                return getDepth(index * 2 + 2, data) + 1;
            }
            return -1;
        }
    }
}
