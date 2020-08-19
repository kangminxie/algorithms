package com.kangmin.algo.csce.tree;

/**
 * Driver Program for Linked Binary Search Tree(BST)
 * Test the as-constructed methods in the Driver program;
 * Step-1: test insert method by inserting 10 numbers, and show the pre-order traversal, test printPreorder as well;
 * Step-2: test remove method by deleting 1 number of the 10 numbers, then show the pre-order traversal;
 * Step-3: test getDepth method, get the expected integer depth
 */

public class LinkedBSTreeDriver {

    public static void main(String[] args) {

        //create an integer type linked binary search tree, default root=null
        LinkedBSTree<Integer> myTestTree = new LinkedBSTree<>();

        //Welcome message
        System.out.println("Testing the tree");

        //Test insert method by inserting 10 numbers
        System.out.println("Insterting 10 numbers");
        myTestTree.insert(8);
        myTestTree.insert(13);
        myTestTree.insert(3);
        myTestTree.insert(4);
        myTestTree.insert(18);
        myTestTree.insert(19);
        myTestTree.insert(10);
        myTestTree.insert(1);
        myTestTree.insert(9);
        myTestTree.insert(2);
        myTestTree.insert(-1);

        //Test printPreorder() method
        System.out.println("Printing pre-order traversal");
        myTestTree.printPreorder();

        //Test printInorder() method
        System.out.println("Printing in-order traversal");
        myTestTree.printInorder();

        //Test printPostorder() method
        System.out.println("Printing post-order traversal");
        myTestTree.printPostorder();


        //Test remove() method
        myTestTree.delete(4);
        myTestTree.printPreorder();


        //Test getDepth() method for all raw elements
        //In expected tree level order, depth from 0 to 3
        int depth8;
        depth8 = myTestTree.getDepth(8);
        System.out.println("The Depth of " + 8 + " is " + depth8);

        int depth3;
        depth3 = myTestTree.getDepth(3);
        System.out.println("The Depth of " + 3 + " is " + depth3);

        int depth13;
        depth13 = myTestTree.getDepth(13);
        System.out.println("The Depth of " + 13 + " is " + depth13);

        int depth1;
        depth1 = myTestTree.getDepth(1);
        System.out.println("The Depth of " + 1 + " is " + depth1);

        int depth4;
        depth4 = myTestTree.getDepth(4);
        System.out.println("The Depth of " + 4 + " is " + depth4);

        int depth10;
        depth10 = myTestTree.getDepth(10);
        System.out.println("The Depth of " + 10 + " is " + depth10);

        int depth18;
        depth18 = myTestTree.getDepth(18);
        System.out.println("The Depth of " + 18 + " is " + depth18);

        int depth2;
        depth2 = myTestTree.getDepth(2);
        System.out.println("The Depth of " + 2 + " is " + depth2);


        int depth9;
        depth9 = myTestTree.getDepth(9);
        System.out.println("The Depth of " + 9 + " is " + depth9);

        int depth19;
        depth19 = myTestTree.getDepth(19);
        System.out.println("The Depth of " + 19 + " is " + depth19);

        //The end
        System.out.println("Done!");
    }
}
