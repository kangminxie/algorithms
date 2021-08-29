package main.java.com.kangmin.csce.tree;

/**
 * AVL tree Program
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

public class AVLTree<T extends Comparable> {
    //internal class Node
    private class Node {
        //instance variable for Node
        private T data;
        private Node leftChild;
        private Node rightChild;

        //default constructor for Node
        Node(T aData) {
            data = aData;
            leftChild = rightChild = null;
        }
    }//end of internal class Node

    //instance variable for AVLTree, Node type
    private Node root;

    //default constructor for LinkedBSTree
	AVLTree() {
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


    //method insert(Node, data), return Node type, and self-balanced structure
    private Node insert(Node aNode, T data) {
        if (aNode == null)//stopping condition for recursively
            aNode = new Node(data);

        else if (data.compareTo(aNode.data) < 0)    //data is less than Node's, go left
        {
            aNode.leftChild = insert(aNode.leftChild, data);
            //insert the new data from the left, if unbalanced, the left-part should be larger
            if (Height(aNode.leftChild) - Height(aNode.rightChild) == 2) {
                if (data.compareTo(aNode.leftChild.data) < 0)    //Right rotation only
                    aNode = doRightRotationWithLeftChild(aNode);    //do Right Rotation With LeftChild
                else
                    aNode = doLeftAndRightRotateWithLeftChild(aNode);  //L-R double rotation
            }
        } else if (data.compareTo(aNode.data) >= 0)    //data is bigger than Node's, go right
        {
            aNode.rightChild = insert(aNode.rightChild, data);
            //insert the new data from the right, if unbalanced, the right-part should be larger
            if (Height(aNode.leftChild) - Height(aNode.rightChild) == -2) {
                if (data.compareTo(aNode.rightChild.data) > 0)    //Left rotation only
                    aNode = doLeftRotationWithRightChild(aNode);    //do Left Rotation With RightChild
                else
                    aNode = doRightAndLeftRotateWithRightChild(aNode);    //R-L double rotation
            }
        }

        return aNode;
    }

    //For Right rotation
    private Node doRightRotationWithLeftChild(Node aNode) {
        Node rtNode = aNode.leftChild;
        aNode.leftChild = rtNode.rightChild;
        rtNode.rightChild = aNode;

        if (aNode == root) //if previous Node is the root, update the root now
            root = rtNode;

        return rtNode;
    }

    //For Left rotation
    private Node doLeftRotationWithRightChild(Node aNode) {
        Node rtNode = aNode.rightChild;
        aNode.rightChild = rtNode.leftChild;
        rtNode.leftChild = aNode;

        if (aNode == root)  //if previous Node is the root, update the root now
            root = rtNode;

        return rtNode;
    }

    //For L-R double rotation
    private Node doLeftAndRightRotateWithLeftChild(Node aNode) {
        aNode.leftChild = doLeftRotationWithRightChild(aNode.leftChild);
        if (aNode == root)
            root = aNode.leftChild;
        return doRightRotationWithLeftChild(aNode);
    }

    //For R-L double rotation
    private Node doRightAndLeftRotateWithRightChild(Node aNode) {
        aNode.rightChild = doRightRotationWithLeftChild(aNode.rightChild);
        if (aNode == root)
            root = aNode.rightChild;
        return doLeftRotationWithRightChild(aNode);
    }


    //method search(data), return void
    public boolean search(T data) {
        //if(root == null) return false
        return search(root, data);//start from root
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
        if (aNode == null) return null;    //stopping condition

        if (aNode.leftChild == null)
            return aNode.rightChild;
        //else
        aNode.leftChild = deleteMinFromTree(aNode.leftChild);
        return aNode;
    }

    //Pre-order printing, return void
	void printPreorder() {
        if (root == null)
            System.out.println("Tree is empty");
        else {
            //	System.out.println("Printing pre-order traversal");
            printPreorder(root);
        }
    }

    private void printPreorder(Node aNode) {
        if (aNode == null) return;
        else {
            System.out.println(aNode.data);
            if (aNode.leftChild != null) printPreorder(aNode.leftChild);
            if (aNode.rightChild != null) printPreorder(aNode.rightChild);
        }
    }

    //In-order printing, return void
	void printInorder() {
        if (root == null)
            System.out.println("Tree is empty");
        else {
            //	System.out.println("Printing pre-order traversal");
            printInorder(root);
        }
    }

    private void printInorder(Node aNode) {
        if (aNode == null) return;
        else {
            if (aNode.leftChild != null) printInorder(aNode.leftChild);
            System.out.println(aNode.data);
            if (aNode.rightChild != null) printInorder(aNode.rightChild);
        }
    }

    //Post-order printing, return void
	void printPostorder() {
        if (root == null)
            System.out.println("Tree is empty");
        else {
            //	System.out.println("Printing post-order traversal");
            printPostorder(root);
        }
    }

    private void printPostorder(Node aNode) {
        if (aNode == null) return;
        else {
            if (aNode.leftChild != null) printPostorder(aNode.leftChild);
            if (aNode.rightChild != null) printPostorder(aNode.rightChild);
            System.out.println(aNode.data);
        }
    }


    //getDepth method, return int
	int getDepth(T data) {
        if (search(data)) {    //if we could find the data
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


    //Get the heigh of a Node, return integer
	int getHeight(T data) {
        if (search(data)) {    //if we can find it
            Node theNode = findNode(root, data);    //call the findNode() method to locate the Node
            return Height(theNode);                    //call the Height() method
        } else {
            System.out.println("The data " + "\"" + data + "\"" + " is not found, no Depth");
            return -1;
        }
    }

    //help method to locate the Node position of a particular data
    private Node findNode(Node aNode, T data) {
        if (aNode == null)    //ending condition one, not find
            return null;

        if (data.compareTo(aNode.data) == 0)    //ending condition two, find
            return aNode;

        else if (data.compareTo(aNode.data) < 0)
            return findNode(aNode.leftChild, data);        //recursive call to leftChild

        else // if(data.compareTo(aNode.data)>0)
            return findNode(aNode.rightChild, data);        //recursive call to rightChild
    }

    //get the Height of a particular Node, recursively
	private int Height(Node aNode) {
        if (aNode == null) return -1;

        if (aNode.leftChild == null && aNode.rightChild == null)
            return 0;

        if (aNode.leftChild != null && aNode.rightChild == null)
            return Height(aNode.leftChild) + 1;

        if (aNode.leftChild == null && aNode.rightChild != null)
            return Height(aNode.rightChild) + 1;

        else {
			//if (aNode.leftChild != null && aNode.rightChild != null)
            return max(Height(aNode.leftChild), Height(aNode.rightChild)) + 1;
        }
    }


    //small assistant method
    private int max(int X, int Y) {
		return Math.max(X, Y);
    }
}
