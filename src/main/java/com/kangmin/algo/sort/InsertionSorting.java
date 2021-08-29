package main.java.com.kangmin.algo.sort;

public class InsertionSorting {

    // only exchange once
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

    // keep exchanging util done
    public static int[] insertionSortV1(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j = i;
            while (j > 0 && a[j - 1] > a[j]) {
                swap(a, j - 1, j);
                j--;
            }
        }
        return a;
    }

    public static int[] insertionSortIntV2(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] < a[j + 1]) {
                    break;
                } else {
                    swap(a, j, j + 1);
                }
            }
        }
        return a;
    }

    public static int[] insertionSortIntV2e(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && (a[j] < a[j - 1]); j--) {
                swap(a, j, j - 1);
            }
        }
        return a;
    }

    public static int[] shellSortInt(int[] a) {
        int N = a.length;
        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && (a[j] < a[j - 1]); j -= h) {
                    swap(a, j, j - h);
                }
            }
            h = h / 3;
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
        int[] testArray1 = {5, 4, 8, 3, 6, 2, 7, 9, 1};
        printout(insertionSortInt(testArray1));

        int[] testArray2 = {5, 4, 8, 3, 6, 2, 7, 9, 1};
        printout(insertionSortIntV2(testArray2));

        int[] testArray2e = {5, 4, 8, 3, 6, 2, 7, 9, 1};
        printout(insertionSortIntV2e(testArray2e));

        int[] testArrayShell = {5, 11, 4, 8, 3, 10, 6, 2, 12, 7, 13, 9, 1};
        printout(shellSortInt(testArrayShell));
    }
}
