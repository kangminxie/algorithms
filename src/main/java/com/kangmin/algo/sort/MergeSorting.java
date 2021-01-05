package com.kangmin.algo.sort;

public class MergeSorting {

    public static void mergeSortInt(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }

        int size = a.length;
        int mid = size / 2;
        int[] left = new int[mid];
        int[] right = new int[size - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = a[i];
        }
        //System.arraycopy(a, 0, left, 0, mid);
        for (int j = mid; j < size; j++) {
            right[j - mid] = a[j];
        }
        mergeSortInt(left);
        mergeSortInt(right);
        merge(left, right, a);
    }

    private static void merge(int[] left, int[] right, int[] a) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                a[k++] = left[i++];
            } else {
                a[k++] = right[j++];
            }
        }

        while (i < left.length) {
            a[k++] = left[i++];
        }
        while (j < right.length) {
            a[k++] = right[j++];
        }
    }


    private static void printout(int[] a) {
        for (int value : a) {
            System.out.print(value + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] testArray = {5, 4, 3, 2, 9, 8, 99, 88, 1};
        mergeSortInt(testArray);
        printout(testArray);

        int[] testArray2 = {-1, -6, 1, 2, 3, 4, 5, 6};
        mergeSortInt(testArray2);
        printout(testArray2);
    }
}
