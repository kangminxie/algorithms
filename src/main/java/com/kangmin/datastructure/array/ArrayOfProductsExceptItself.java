package main.java.com.kangmin.datastructure.array;

public class ArrayOfProductsExceptItself {

    // time = O(n）
    // space = O(n)
    // assistant-space = O(1)
    public static int[] findProduct(int[] arr) {
        int N = arr.length;
        int[] result = new int[N];

        int temp = 1;
        for (int i = 0; i < N; i++) {
            result[i] = temp;
            temp *= arr[i];
        }
        // result[0] = 1
        // result[1] = a[0]
        // result[2] = a[0] * a[1]
        // k >= 1
        // result[K] = a[0] * ... * a[K - 1]

        temp = 1;
        for (int i = N - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= arr[i];
        }
        // result[N - 1] = (a[0] * ...... * a[N - 2]) * 1
        // result[N - 2] = (a[0] * ... * a[N - 3]) * 1 * a[N - 1];
        return result;
    }

    public int[] productExceptSelf(int[] nums) {
        int N = nums.length;

        int[] left = new int[N];
        int[] right = new int[N];
        int[] result = new int[N];

        left[0] = 1;
        for (int i = 1; i < N; i++) {
            left[i] = left[i - 1] * nums[i -1];
        }

        right[N - 1] = 1;
        for (int j = N - 2; j >= 0; j--) {
            right[j] = right[j + 1] * nums [j + 1];
        }

        for (int k = 0; k < N; k++) {
            result[k] = left[k] * right[k];
        }

        return result;
    }
}
