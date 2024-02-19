package main.java.com.kangmin.datastructure.array;

public class MergeTwoSortedArr {

    public int[] mergeArrays(int[] arr1, int[] arr2) {
        int M = arr1.length;
        int N = arr2.length;

        int[] result = new int[M + N];
        int i = 0, j = 0, k = 0;

        while (i < M && j < N) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < M) {
            result[k++] = arr1[i++];
        }

        while (j < N) {
            result[k++] = arr2[j++];
        }

        return result;
    }
}
