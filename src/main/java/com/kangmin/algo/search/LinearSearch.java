package main.java.com.kangmin.algo.search;

public class LinearSearch<T> {

    // iterative approach
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

    // recursive call
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

    public static void main(String[] args) {
        LinearSearch<Integer> instance = new LinearSearch<>();
        Integer[] arr = new Integer[] {4, 3, 5, 2, 6, 1, 8, 7};

        int findPositionOf6 = instance.linearSearch(arr, 6);
        System.out.println(findPositionOf6 == 4);

        int findPositionOf8 = instance.linearSearchV2(arr, 8);
        System.out.println(findPositionOf8 == 6);
    }
}
