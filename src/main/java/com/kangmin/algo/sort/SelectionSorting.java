package com.kangmin.algo.sort;

public class SelectionSorting {

    public static int[] selectionSortInt(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                swap(a, i, minIndex);
            }
        }
        return a;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printout(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(final String[] args) {
        final int[] testArray = {5, 4, 8, 3, 6, 2, 7, 9, 1};
        final int[] sorted = selectionSortInt(testArray);
        printout(sorted);
    }
}
