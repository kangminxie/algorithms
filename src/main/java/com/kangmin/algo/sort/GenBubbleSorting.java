package com.kangmin.algo.sort;

public class GenBubbleSorting {

    public static <T extends Comparable<T>> T[] bubbleSortGen(T[] a) {
        int size = a.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    T temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

    public static void printout(Integer[] dummyIntArray) {
        for (Integer integer : dummyIntArray) {
            System.out.print(integer + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Integer[] testArray1 = {5, 4, 3, 2, 7, 9, 1};
        bubbleSortGen(testArray1);
        printout(testArray1);
    }
}
