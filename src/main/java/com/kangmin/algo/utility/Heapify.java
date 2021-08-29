package main.java.com.kangmin.algo.utility;

import java.util.Arrays;

public class Heapify {

	// method to heapify an array
	// a[0] space is reserved
	public static int[] heapify(int[] a) {
		if (a == null) {
			return null;
		}

		// deep copy to protect the raw array
		int size = a.length;
		int halfSize = size / 2;
		int[] result = Arrays.copyOf(a, size);

		for (int i = halfSize; i > 0; i--) {
			int fatherIndex = i;
			int childIndex = 2 * i;
			if (childIndex + 1 < size && result[childIndex] < result[childIndex + 1]) {
				childIndex += 1;
			}
			boolean needBottomUp = true;
			while (needBottomUp && childIndex < size) {
				if (childIndex + 1 < size && result[childIndex] < result[childIndex + 1]) {
					childIndex += 1;
				}
				if (result[fatherIndex] < result[childIndex]) {
					swap(result, fatherIndex, childIndex);
					fatherIndex = childIndex;
					childIndex = 2 * childIndex;
				} else {
					needBottomUp = false;
				}
			}
		}
		result[0] = 100;
		return result;
	}

	// check it the array is heapified or not
	public static boolean isHeapified(int[] a) {
		int size = a.length;
		int halfSize = size / 2;
		for (int i = 1; i <= halfSize; i++) {
			if (a[i] < a[2 * i]) {
				return false;
			}
			if (2 * i + 1 < size && a[i] < a[2 * i + 1]) {
				return false;
			}
		}
		return true;
	}

	// helper method
	public static void swap(int[] a, int index1, int index2) {
		int temp = a[index1];
		a[index1] = a[index2];
		a[index2] = temp;
	}

	public static void main(String[] args) {
		int[] a = {0, 1, 3, 2, 5, 4, 6, 7, 9, 8, 10};
		System.out.println(Arrays.toString(a));
		System.out.println(isHeapified(a));
		int[] result = heapify(a);
		System.out.println(Arrays.toString(result));
		System.out.println(isHeapified(result));
	}
}
