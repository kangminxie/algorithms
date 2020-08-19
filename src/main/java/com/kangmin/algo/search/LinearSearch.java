package com.kangmin.algo.search;

public class LinearSearch<T> {

    public int linearSearch(T[] arr, T target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(target)) {
                return i;
            }
        }

        return -1;
    }

    public int linearSearchV2(T[] arr, T target) {
        return linearSearch(arr, target, 0, arr.length - 1);
    }

    public int linearSearch(T[] arr, T target, int startIndex, int endIndex) {
        if (arr == null || arr.length == 0 || arr.length < endIndex || startIndex < 0) {
            return -1;
        }

        for (int i = startIndex; i < endIndex; i++) {
            if (arr[i].equals(target)) {
                return i;
            }
        }

        return -1;
    }
}
