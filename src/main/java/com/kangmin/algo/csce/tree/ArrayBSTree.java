package com.kangmin.algo.csce.tree;

/**
 * Array Binary Search Tree(BST) Program
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

public class ArrayBSTree<T extends Comparable> {
    //instance variables
    private T[] tree;
    private static final int DEF_SIZE = 1024;

    //default constructor
    ArrayBSTree() {
        tree = (T[]) new Comparable[DEF_SIZE];
    }

    //parameterized constructor
    public ArrayBSTree(int size) {
        if (size > 0) {
            tree = (T[]) (new Comparable[size]);
        }

    }

    //method insert(data), return void
    public void insert(T data) {
        if (tree[0] == null) {
            tree[0] = data;
        } else {
            insert(0, data);    //start from the root
        }

    }

    //method insert(index, data), return void
    private void insert(int index, T data) {
        if (tree[index] == null) {                        //insert here
            tree[index] = data;
        } else if (data.compareTo(tree[index]) < 0) {
            if (index * 2 + 1 < tree.length) {
                //make sure within the array
                insert(index * 2 + 1, data);
            }
        } else if (data.compareTo(tree[index]) >= 0) {
            if (index * 2 + 2 < tree.length) {
                insert(index * 2 + 2, data);
            }
        }
    }

    //method printPreOrder(), return void
    public void printPreOrder() {
        printPreOrder(0);
    }

    //method printPreOrder(index), return void
    private void printPreOrder(int index) {
        if (tree[index] == null) {
            return;
        }
        System.out.println(tree[index]);    //process
        if ((index * 2 + 1) < tree.length)  //can I go left?
            printPreOrder(index * 2 + 1);   //go left
        if ((index * 2 + 2) < tree.length)  //can I go right?
            printPreOrder(index * 2 + 2);   //go right
    }


    //method printInOrder(), return void
    void printInOrder() {
        printInOrder(0);
    }

    //method printInOrder(index), return void
    private void printInOrder(int index) {
        if (tree[index] == null)
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
        if (tree[index] == null)
            return;
        if ((index * 2 + 1) < tree.length)  //can I go left?
            printPostOrder(index * 2 + 1);  //go left
        if ((index * 2 + 2) < tree.length)  //can I go right?
            printPostOrder(index * 2 + 2);//go right
        System.out.println(tree[index]);    //process
    }


    //method printPostOrder(), return void
    void printBreadthOrder() {
        for (T val : tree) {
            if (val != null)
                System.out.println(val);
//			else
//				System.out.println("null");
        }
    }


    public boolean search(T data) {
        return search(0, data);
    }

    //method search(index, data), return Node
    private boolean search(int index, T data) {
        if (index > tree.length || tree[index] == null)    //ending condition one, not find
            return false;

        if (data.compareTo(tree[index]) == 0)    //ending condition two, find
            return true;
        else if (data.compareTo(tree[index]) < 0)
            return search(index * 2 + 1, data);        //recursive call to leftChild
        else // if(data.compareTo(aNode.data)>0)
            return search(index * 2 + 2, data);        //recursive call to rightChild
    }


    //getDepth method, return int
    int getDepth(T data) {
        if (search(data)) {
            return getDepth(0, data);
        } else {
//	        System.out.println("The data "+"\""+data+"\""+" is not found, no Depth");
            return -1;
        }
    }

    private int getDepth(int index, T data) {
        if (tree[index] == null) {
            return -1;
        }
        if (data.compareTo(tree[index]) == 0) {
            return 0;
        }
        if (data.compareTo(tree[index]) < 0) {
            return getDepth(index * 2 + 1, data) + 1;
        }
        if (data.compareTo(tree[index]) > 0) {
            return getDepth(index * 2 + 2, data) + 1;
        }
        return -1;
    }
}
