package main.java.com.kangmin.algo.sort;

public class QuickSorting {

    public static void quickSortInt(int[] a, int left, int right) {
        //get partitioning index from partition method, use midIndex's value as pivot
        int index = partition(a, left, right);

        if (left < index - 1) {
            //still more items to sort in the left
            quickSortInt(a, left, index - 1);
        }

        if (index < right) {
            //still more items to sort in the right
            quickSortInt(a, index, right);
        }
    }

    private static int partition(int[] a, int left, int right) {
        int i = left;   // start from the first element for i
        int j = right;  // start from the last element for j
        int pivot = a[(left + right) / 2];  //mid-value for pivot

        while (i <= j) {
            while (a[i] < pivot && i <= j) {
                i++;            // until there is a[i]>=pivot
            }
            while (a[j] > pivot) {
                j--;            //until there is a[j]<=pivot
            }

            //double make sure no cross operation
            if (i <= j) {
                //swap a[i] and a[j]
                swap(a, i, j);
                i++;    //post-operation, move i one right
                j--;    //post-operation, move j one left
            }
        }
        return i;    //this is the position for partition
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void quickSortIntV1(int[] arr) {
        quickSortIntV1(arr, 0, arr.length - 1);
    }

    private static void quickSortIntV1(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int index = partitionV1(arr, left, right);
        quickSortIntV1(arr, left, index - 1);
        quickSortIntV1(arr, index + 1, right);
    }

    private static int partitionV1(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left + 1;
        int j = right;

        while (true) {
            while (arr[i] < pivot && i < right) {
                i++;
            }
            while (arr[j] > pivot && j > left) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(arr, i, j);
        }

        swap(arr, left, j);
        return j;
    }

    public static void quickSortString(String[] a, int left, int right) {
        //get partitioning index from partition method, use midIndex's value as pivot
        int index = partitionString(a, left, right);

        if (left < index - 1) {
            //still more items to sort in the left\
            quickSortString(a, left, index - 1);
        }

        if (index < right) {
            //still more items to sort in the right
            quickSortString(a, index, right);
        }

        // quickSortString(a, index+1, right); wu fa bao zheng a[i]
    }


    private static int partitionString(String[] a, int left, int right) {
        int i = left;    //start from the first element for i
        int j = right;    //start from the last element for j
        String pivot = a[(left + right) / 2];    //mid-value for pivot

        while (i <= j) {
            while (a[i].compareTo(pivot) < 0) {
                i++;            //until there is a[i]>=pivot
            }
            while (a[j].compareTo(pivot) > 0) {
                j--;            //until there is a[j]<=pivot
            }

            //double make sure no cross operation
            if (i <= j) {    //swap a[i] and a[j]
                String temp = a[i];
                a[i] = a[j];
                a[j] = temp;

                i++;    //post-operation, move i one right
                j--;    //post-operation, move j one left
            }
        }
        return i;    //this is the position for partition
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
        quickSortInt(testArray, 0, testArray.length - 1);
        printout(testArray);

        int[] testArray1 = {5, 11, 4, 8, 3, 10, 6, 2, 12, 7, 13, 9, 1};
        quickSortIntV1(testArray1, 0, testArray1.length - 1);
        printout(testArray1);

        String test = "dcbae";
        String[] a = test.split("");
        quickSortString(a, 0, a.length - 1);
        printout(a);

        System.out.println("ahaha");
        String test3 = "a";
        String[] b = test3.split("");
        printout(b);
        System.out.println(b.length);
    }
}
