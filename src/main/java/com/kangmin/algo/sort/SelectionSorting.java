package com.kangmin.algo.sort;

public class SelectionSorting {

    public static int[] selectionSortInt(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int smallestIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[smallestIndex]) {
                    smallestIndex = j;
                }
            }
            if (smallestIndex != i) {
                final int temp = a[i];
                a[i] = a[smallestIndex];
                a[smallestIndex] = temp;
            }
        }
        return a;
    }

    private static void printout(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(final String[] args) {
        final int[] testArray = {5, 4, 3, 2, 1};
        final int[] sorted = selectionSortInt(testArray);
        printout(sorted);
    }
}
