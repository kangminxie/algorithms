package com.kangmin.algo.csce.tree;

/**
 * Driver Program for Array-based Binary Search Tree(BST)
 * Test the as-constructed methods in this Driver program;
 * Step-1: test insert method by inserting 10 numbers in a desired order;
 * Step-2: show the In-order traversal, and test printBreadth first traversal as well;
 * Step-3: test getDepth method, get the expected integer depth
 */

public class IntBSTreeDriver {
    public static void main(String[] args) {
        //Welcome message
        System.out.println("Int BST Tester!");

        //Create an instance of IntBSTree use the ArrayBSTree class
        System.out.println("Creating tree");
        IntBSTree myIntTree = new IntBSTree();

        //Now add integer numbers to the tree in good order
        //Test insert() method
        System.out.println("Populating Tree with values");

        //root
        myIntTree.insert(10);
        myIntTree.insert(9);
        myIntTree.insert(1);
        myIntTree.insert(5);
        myIntTree.insert(16);
        myIntTree.insert(32);

        myIntTree.printPostOrder();


	/*
		//root
		myIntTree.insert(4);
		//fist layer
		myIntTree.insert(8);
		myIntTree.insert(2);
		//second layer
		myIntTree.insert(10);
		myIntTree.insert(1);
		myIntTree.insert(3);
		myIntTree.insert(7);
		//third layer
		myIntTree.insert(5);
		//forth layer
		myIntTree.insert(6);
		//another third layer
		myIntTree.insert(9);
		myIntTree.insert(1);
		myIntTree.insert(-4);

		//Print out In-order
		//Test printInOrder() method
		System.out.println("Testing insertion by in-order traversal");
		myIntTree.printInOrder();

		//Print out Breadth first traversal
		//Test printBreadthOrder() method
		System.out.println("Testing breadth order traversal");
		myIntTree.printBreadthOrder();

		//Test getDepth() if the element is there
		System.out.println("Getting depth of 6");
		int depth6 = myIntTree.getDepth(6);
		System.out.println(depth6);

		//Test getDepth() if the element is not there
		System.out.println("Getting depth of 14");
		int depth14 = myIntTree.getDepth(14);
		System.out.println(depth14);

*/


    }//end of main() method

}
