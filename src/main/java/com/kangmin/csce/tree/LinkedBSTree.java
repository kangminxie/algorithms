package main.java.com.kangmin.csce.tree;

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
 */

public class LinkedBSTree<T extends Comparable<T>> {

    // internal class Node
    private class Node {

        private final T data;
        private Node leftChild;
        private Node rightChild;

        Node(T aData) {
            data = aData;
            leftChild = null;
            rightChild = null;
        }
    }

    private Node root;

    LinkedBSTree() {
        root = null;
    }

    public void insert(T data) {
        insert(root, data);
    }

    private Node insert(Node aNode, T data) {
        if (aNode == null) {
            aNode = new Node(data);
        } else if (data.compareTo(aNode.data) < 0) {
            aNode.leftChild = insert(aNode.leftChild, data);
        } else if (data.compareTo(aNode.data) >= 0) {
            aNode.rightChild = insert(aNode.rightChild, data);
        }

        return aNode;
    }

    public boolean search(T data) {
        return search(root, data);
    }

    private boolean search(Node aNode, T data) {
        if (aNode == null) {
            return false;
        }

        if (data.compareTo(aNode.data) == 0) {
            return true;
        } else if (data.compareTo(aNode.data) < 0) {
            return search(aNode.leftChild, data);
        } else {
            return search(aNode.rightChild, data);
        }
    }

    public void delete(T data) {
        root = delete(root, data);
    }

    private Node delete(Node aNode, T data) {
        if (aNode == null) {
            return null;
        }

        if (data.compareTo(aNode.data) < 0) {
            aNode.leftChild = delete(aNode.leftChild, data);
        } else if (data.compareTo(aNode.data) > 0) {
            aNode.rightChild = delete(aNode.rightChild, data);
        } else {
            if (aNode.rightChild == null) {
                return aNode.leftChild;
            } else if (aNode.leftChild == null) {
                return aNode.rightChild;
            } else {
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
    }


    // helper method findMin(), return Node
    private Node findMinInTree(Node aNode) {
        if (aNode == null) {
            return null;
        }

        if (aNode.leftChild == null) {
            return aNode;
        } else {
            return findMinInTree(aNode.leftChild);
        }
    }

    // helper method deleteMin(), return Node
    private Node deleteMinFromTree(Node aNode) {
        if (aNode == null) {
            return null;
        }
        if (aNode.leftChild == null) {
            return aNode.rightChild;
        }

        aNode.leftChild = deleteMinFromTree(aNode.leftChild);
        return aNode;
    }

    public void printPreorder() {
        if (root == null) {
            System.out.println("Tree is empty");
        } else {
            printPreorder(root);
        }
    }

    private void printPreorder(Node aNode) {
        if (aNode != null) {
            System.out.println(aNode.data);
            if (aNode.leftChild != null) {
                printPreorder(aNode.leftChild);
            }
            if (aNode.rightChild != null) {
                printPreorder(aNode.rightChild);
            }
        }
    }

    public void printInorder() {
        if (root == null) {
            System.out.println("Tree is empty");
        } else {
            //	System.out.println("Printing pre-order traversal");
            printInorder(root);
        }
    }

    private void printInorder(Node aNode) {
        if (aNode != null) {
            if (aNode.leftChild != null) {
                printInorder(aNode.leftChild);
            }
            System.out.println(aNode.data);
            if (aNode.rightChild != null) {
                printInorder(aNode.rightChild);
            }
        }
    }

    public void printPostorder() {
        if (root == null) {
            System.out.println("Tree is empty");
        } else {
            //	System.out.println("Printing post-order traversal");
            printPostorder(root);
        }
    }

    private void printPostorder(Node aNode) {
        if (aNode != null) {
            if (aNode.leftChild != null) {
                printPostorder(aNode.leftChild);
            }
            if (aNode.rightChild != null) {
                printPostorder(aNode.rightChild);
            }
            System.out.println(aNode.data);
        }
    }

    public int getDepth(T data) {
        if (search(data)) {
            return getDepth(root, data);
        } else {
            System.out.println("The data " + "\"" + data + "\"" + " is not found, no Depth");
            return -1;
        }
    }

    private int getDepth(Node aNode, T data) {
        if (aNode == null) {
            return -1;
        }

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
