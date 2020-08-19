package com.kangmin.algo.search;

public class BinarySearchLast {

    // pre-condition: array is sorted
    public static int binarySearchFirst(int[] a, int start, int end, int target) {
        if (start > end) {
            return -1;
        }

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (a[mid] == target) {
                // need move on to find if there is small index can achieve this
                end = mid;
            } else if (a[mid] > target) {
                end = mid - 1;
            } else {
                //a[midIndex] < target
                start = mid + 1;
            }
        }

        if (a[start] == target) {
            return start;
        }
        if (a[end] == target) {
            return start;
        }
        return -1;
    }

    public static void main(final String[] args) {
        int[] a1 = { 4, 5, 6, 6, 9, 12, 13 };
        int result1 = binarySearchFirst(a1, 0, a1.length - 1, 6);
        assert result1 == 2;

        int[] a2 = { 4, 6, 6, 6, 9, 12, 13 };
        int result2 = binarySearchFirst(a2, 0, a2.length - 1, 6);
        assert result2 == 1;
    }
}
