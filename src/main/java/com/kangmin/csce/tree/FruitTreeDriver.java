package main.java.com.kangmin.csce.tree;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class Fruit was created in the Fruit.java, with String name and Double weight as instance variables;
 * Also, in the Fruit class toString(),equals() and compareTo() was either defined override;
 * The LinkedBSTree.java implemented the Binary Search Tree already, has all with needed methods listed
 * This Main Program will do following steps in the main() method as show below.
 */

public class FruitTreeDriver {
    /**
     * main() method to test the Generic LinkedBSTree, element Fruit
     * Step-1, read the information from "fruitFile.txt", readFromFile(), returned an String ArrayList;
     * Step-2, for each fruit(name, weight) in the line of ArrayList, insert it to the LinkedBSTree;
     * Step-3, test printPreorder(), printInorder() and printPostorder() and show list
     * Step-4, get the target item and test delete() and printInorder() show updated list
     */
    private static final String delim = "\t";    //the name and weight was separated by "\t"

    public static void main(String[] args) {

        //Welcome information
        System.out.println("Welcome to the fruit tree!");
        System.out.println("Populating tree file file");

        //Read Fruit name and weight information from certain file, return to ArrayList<String>
        String myFileName = "fruitFile.txt";
        ArrayList<String> wholeFruitList = readFromFile(myFileName);

        //create the Linked Binary Search TSeree
        //For each line get the information to new Fruit type and insert to Treee
        LinkedBSTree<Fruit> myFruitTree = new LinkedBSTree<>();
        assert wholeFruitList != null;
        for (String currentLine : wholeFruitList)    //traverse all list
        {
            String[] splitLines = currentLine.split(delim);    //split the obtained String with "\t"
            String theName = splitLines[0];                        //name is the 1st element
            double theWeight = Double.parseDouble(splitLines[1]);//weight is the 2nd element
            Fruit aNewFruit = new Fruit(theName, theWeight);    //new fruit created
//			System.out.println(currentLine);					//debug purpose
            myFruitTree.insert(aNewFruit);                        //insert the as-created fruit to BSTree
        }

        System.out.println("Printing the in-order traversal");    //In-order printing now
        myFruitTree.printInorder();

        System.out.println("\nPrinting the pre-order traversal");//Pre-order printing now
        myFruitTree.printPreorder();

        System.out.println("\nPrinting the post-order traversal");//Post-order printing now
        myFruitTree.printPostorder();

        System.out.println("\nDeleting Apple 0.4859853412170728");//test delete now
        Fruit theTargetFruit = new Fruit("Apple", 0.4859853412170728);//target item
        myFruitTree.delete(theTargetFruit);    //delete the target item

        System.out.println("Printing the in-order traversal");
        myFruitTree.printInorder();                                    //check whether it is removed or not

    }


    /**
     * Method to read from a file and return an Array list
     *
     * @param aFileName String such as "fruitFile.txt"
     * @return ArrayList<String>
     */
    private static ArrayList<String> readFromFile(String aFileName) {
        try {
            Scanner fileScanner = new Scanner(new File(aFileName));
            ArrayList<String> theList = new ArrayList<>();    //create a empty ArrayList<String>
            while (fileScanner.hasNext())                        //if there is information in the next line
            {
                String currentLine = fileScanner.nextLine();    //current line scan to String currentLine
                theList.add(currentLine);                        //add String currentLine to our ExpressionList
            }
            return theList;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
}
