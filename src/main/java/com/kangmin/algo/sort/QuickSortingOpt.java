package main.java.com.kangmin.algo.sort;

import java.util.Arrays;

public class QuickSortingOpt {

    public static void quickSort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
//        if (left + 1 == right) {
//            if (a[left] > a[right]) {
//                swap(a, left, right);
//            }
//        }
        System.out.println("Now sorting >>>> " + Arrays.toString(a) + " with left = " + left + " and right = " + right);
        int partitionedIndex = partition(a, left, right);
        System.out.println("partitionedIndex is " + partitionedIndex);
        quickSort(a, left, partitionedIndex - 1);
        quickSort(a, partitionedIndex + 1, right);
    }

    private static int partition(int[] a, int left, int right) {
        int pivot = a[left];
        System.out.println("pivot = " + pivot);
        int i = left;
        int j = right;
        while (i <= j) {
            while (i <= j && a[i] <= pivot) {
                i++;
            }

            while (i <= j && a[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }
        swap(a, left, j);
        System.out.println("j = " + j + " and a[j] = " + a[j]);
        System.out.println(Arrays.toString(a));
        return j;
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

    private static void printout(String[] strArr) {
        for (String s : strArr) {
            System.out.print(s + "");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        int[] testArray = {5, 11, 4, 8, 3, 10, 6, 2, 12, 7, 13, 9, 1};
        quickSort(testArray);
        printout(testArray);
    }
}
