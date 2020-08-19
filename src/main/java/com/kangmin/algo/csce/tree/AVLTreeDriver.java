package com.kangmin.algo.csce.tree;

/**
 * AVL tree's test Program
 * Methods()contains:
 * insert:						insert();
 * delete:						delete();
 * search:						search();
 * print pre-order traversal	printPreorder();
 * print in-order traversal	printInorder();
 * print post-order traversal	printPostorder();
 * get depth:					getDepth();
 * get Height:					Height();
 */

public class AVLTreeDriver {

    public static void main(String[] args) {

        //create an integer type linked binary search tree, default root=null
        AVLTree<Integer> myTestTree = new AVLTree<>();

        //Welcome message
        System.out.println("Testing the AVL tree");

        //Test insert method by inserting 20 numbers
        //debug step by step
        System.out.println("Inserting 20 numbers now");
        for (int i = 1; i <= 20; i++) {
            myTestTree.insert(i);
        }

//		myTestTree.insert(1);
//		myTestTree.insert(2);
//		myTestTree.insert(3);
//		myTestTree.insert(4);
//		myTestTree.insert(5);
//		myTestTree.insert(6);
//		myTestTree.insert(7);

        //Test printPreorder() method
        System.out.println("Printing pre-order traversal");
        myTestTree.printPreorder();

        //Test printInorder() method
        System.out.println("Printing in-order traversal");
        myTestTree.printInorder();

        //Test printPostorder() method
        System.out.println("Printing post-order traversal");
        myTestTree.printPostorder();

        System.out.println("Show depth now");
        for (int i = 1; i <= 20; i++) {
            System.out.println("The Depth of " + i + " is " + myTestTree.getDepth(i));
        }

        //Test getDepth() method for all elements
        //In expected tree level order
//		System.out.println("The Depth of "+1+" is "+myTestTree.getDepth(1));
//		System.out.println("The Depth of "+2+" is "+myTestTree.getDepth(2));
//		System.out.println("The Depth of "+3+" is "+myTestTree.getDepth(3));
//		System.out.println("The Depth of "+4+" is "+myTestTree.getDepth(4));
//		System.out.println("The Depth of "+5+" is "+myTestTree.getDepth(5));
//		System.out.println("The Depth of "+6+" is "+myTestTree.getDepth(6));
//		System.out.println("The Depth of "+7+" is "+myTestTree.getDepth(7));


        System.out.println("Show Height now");
        for (int i = 1; i <= 20; i++) {
            System.out.println("The Height of " + i + " is " + myTestTree.getHeight(i));
        }

        //Test getHeight() method for all elements
//		System.out.println("\nThe Height of "+1+" is "+myTestTree.getHeight(1));
//		System.out.println("The Height of "+2+" is "+myTestTree.getHeight(2));
//		System.out.println("The Height of "+3+" is "+myTestTree.getHeight(3));
//		System.out.println("The Height of "+4+" is "+myTestTree.getHeight(4));
//		System.out.println("The Height of "+5+" is "+myTestTree.getHeight(5));
//		System.out.println("The Height of "+6+" is "+myTestTree.getHeight(6));
//		System.out.println("The Height of "+7+" is "+myTestTree.getHeight(7));

        System.out.println("All-Done!");
    }
}
