package com.kangmin.algo.twopointer;

public class SquaresOfSortedArray {
    // A is sorted, e.g. -3, -1, 0, 2
    public int[] sortedSquares(int[] A) {
        int N = A.length;
        int[] result = new int[N];
        int i = 0;
        int j = N - 1;
        for (int p = N - 1; p >= 0; p--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[p] = A[i] * A[i];
                i++;
            } else {
                result[p] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }
}
