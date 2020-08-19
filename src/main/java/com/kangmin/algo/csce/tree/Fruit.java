package com.kangmin.algo.csce.tree;

/**
 * Program of Fruit Class
 * instance variable name, Type String
 * instance variable weight, Type double
 * Method toString()was override;
 * Method equals()defined;
 * compareTo()defined, especially for "implements Comparable<Fruit>" to make it available for T data
 */
public class Fruit implements Comparable<Fruit> {
    //two instance variables
    private String name;
    private double weight;

    //default constructor
    public Fruit() {
        this.name = "no name yet";
        this.weight = 0.0;
    }

    //parameterized constructor
    public Fruit(String aName, double aWeight) {
        this.setName(aName);
        this.setWeight(aWeight);
    }

    //Method getName
	private String getName() {
        return name;
    }

    //Method setName
	private void setName(String aName) {
        this.name = aName;
    }

    //Method getWeight
	private double getWeight() {
        return weight;
    }

    //Method setWeight
	private void setWeight(double aWeight) {
        this.weight = aWeight;
    }

    //Method toString for printing
    public String toString() {
        return this.getName() + "\t" + this.getWeight();
    }

    //Method equals
    public boolean equals(Fruit aFruit) {
        return this.name.equals(aFruit.getName()) &&
                (Math.abs(this.weight - aFruit.getWeight()) < 0.00000000001);
    }

    //Method compareTo so as it belongs Comparable group "implements Comparable<Fruit>"
    public int compareTo(Fruit aFruit) {
        if (Math.abs(this.weight - aFruit.getWeight()) < 0.00000000001) return 0;
        else if (this.weight > aFruit.getWeight()) return 1;
        else return -1;
    }
}
