package main.java.com.kangmin.csce.tree;

/**
 * Driver Program for Array Binary Search Tree(BST)
 * Test the as-constructed methods in this Driver program;
 * Step-1: test insert method by inserting 10 numbers, and show the pre-order traversal, test printPreorder as well;
 * Step-2: test remove method by deleting 1 number of the 10 numbers, then show the pre-order traversal;
 * Step-3: test getDepth method, get the expected integer depth
 *
 */
public class ArrayBSTreeDriver {
    public static void main(String[] args) {
        //Welcome message
        System.out.println("Int BST Tester!");

        //Create an instance of IntBSTree use the ArrayBSTree class
        System.out.println("Creating tree");
        ArrayBSTree<Integer> myIntTree = new ArrayBSTree<>();

        //Now add integer numbers to the tree in good order
        //Test insert() method
        System.out.println("Populating Tree with values");
        myIntTree.insert(4);
        myIntTree.insert(2);
        myIntTree.insert(8);
        myIntTree.insert(1);
        myIntTree.insert(3);
        myIntTree.insert(7);
        myIntTree.insert(10);
        myIntTree.insert(5);
        myIntTree.insert(6);
        myIntTree.insert(9);

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
    }
}
