package com.kangmin.algo.sort;

public class BubbleSorting {

    public static void bubbleSortInt(int[] a) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
            }
        }
    }

    public static void bubbleSortInt2(int[] a) {
        int size = a.length;
        for (int i = 0; i < size; i++) {
            // move max to the right
            for (int j = 0; j < size - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void bubbleSortString(String[] a) {
        int size = a.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    String temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

    }

    private static void printout(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    private static void printout(String[] strArr) {
        for (String s : strArr) {
            System.out.print(s + "");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int[] testArray1 = {5, 4, 3, 2, 7, 9, 1};
        bubbleSortInt(testArray1);
        printout(testArray1);

        int[] testArray2 = {5, 4, 2, 3, 7, 9, 1};
        bubbleSortInt2(testArray2);
        printout(testArray2);

        String test = "bshiflsjdh_cda";
        String[] a = test.split("");
        System.out.println(test);
        bubbleSortString(a);
        printout(a);

        Object[] z = new Object[3];
        Comparable[] zz = (Comparable[]) z;
        bubbleSortCom(zz);

    }

    public static void bubbleSortCom(Comparable[] a) {
        int size = a.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {
                    Comparable temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
}
