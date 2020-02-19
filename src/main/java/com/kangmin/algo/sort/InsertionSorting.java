package com.kangmin.algo.sort;

public class InsertionSorting {

    public static int[] insertionSortInt(int[] a) {
        if (a == null || a.length <= 1) {
            return a;
        }
        for (int i = 1; i < a.length; i++) {
            int j = i - 1;
            int temp = a[i];
            while (j >= 0 && a[j] > temp) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = temp;
        }
        return a;
    }

    public static int[] insertionSortIntB(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] < a[j + 1])
                    break;
                else {
                    swap(a, j, j + 1);
                }
            }
        }
        return a;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void printout(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] testArray1 = {5, 4, 3, 2, 9, 8, 1};
        printout(insertionSortInt(testArray1));
        int[] testArray2 = {5, 4, 3, 2, 9, 8, 1};
        printout(insertionSortIntB(testArray2));
    }
}
