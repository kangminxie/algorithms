package main.java.com.kangmin.algo.sort;

public class BubbleSorting {

    public static void bubbleSortIntV0(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            // move max to the right
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    public static void bubbleSortIntV1(int[] a) {
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    swap(a, i, i + 1);
                    swapped = true;
                }
            }
        }
    }

    public static void bubbleSortIntV1e(int[] a) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    swap(a, i, i + 1);
                    isSorted = false;
                }
            }
        }
    }

    public static void bubbleSortIntV2(int[] a) {
        boolean isSorted = false;
        for (int i = 0; i < a.length - 1 && !isSorted; i++) {
            isSorted = true;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    isSorted = false;
                    swap(a, j, j + 1);
                }
            }
        }
    }

    public static void bubbleSortIntV2e(int[] a) {
        boolean isSorted = false;
        for (int i = a.length - 1; i > 0 && !isSorted; i--) {
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    isSorted = false;
                    swap(a, j, j + 1);
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

        int[] testArray0 = {5, 4, 8, 3, 6, 2, 7, 9, 1};
        bubbleSortIntV0(testArray0);
        printout(testArray0);

        int[] testArray1 = {5, 4, 8, 3, 6, 2, 7, 9, 1};
        bubbleSortIntV1(testArray1);
        printout(testArray1);

        int[] testArray1e = {5, 4, 8, 3, 6, 2, 7, 9, 1};
        bubbleSortIntV1e(testArray1e);
        printout(testArray1e);

        int[] testArray2 = {5, 4, 8, 3, 6, 2, 7, 9, 1};
        bubbleSortIntV2(testArray2);
        printout(testArray2);

        int[] testArray2e = {5, 4, 8, 3, 6, 2, 7, 9, 1};
        bubbleSortIntV2e(testArray2e);
        printout(testArray2e);

        String test = "bshiflsjdhcda";
        String[] a = test.split("");
        System.out.println(test);
        bubbleSortString(a);
        printout(a);
    }
}
