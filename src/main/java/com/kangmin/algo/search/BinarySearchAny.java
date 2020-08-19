package com.kangmin.algo.search;

public class BinarySearch<T extends Comparable<T>> {

    // pre-condition: array is sorted
	public int binarySearch(T[] arr, T target) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		
		int startIndex = 0;
		int endIndex = arr.length - 1;
        while (startIndex <= endIndex) {  
            // until startIndex > endIndex
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if (arr[midIndex].compareTo(target) == 0) {
                return midIndex;
            } else if (arr[midIndex].compareTo(target) > 0) {
                endIndex = midIndex - 1;
            } else {
                //a[midIndex] < target or arr[midIndex].compareTo(target) < 0
                startIndex = midIndex + 1;
            }
        }
		return -1;
	}
	
    // pre-condition: array is sorted
    public int binarySearch(int[] a, int startIndex, int endIndex, int target) {
        if (startIndex > endIndex) {
            return -1;
        }
        while (startIndex <= endIndex) {  
            // until startIndex > endIndex
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if (a[midIndex] == target) {
                return midIndex;
            } else if (a[midIndex] > target) {
                endIndex = midIndex - 1;
            } else {
                //a[midIndex] < target
                startIndex = midIndex + 1;
            }
        }
        return -1;
    }

    // pre-condition: array is sorted
    public int binarySearchRecursive(int[] a, int startIndex, int endIndex, int target) {
        if (startIndex > endIndex) {
            return -1;
        }
        int midIndex = startIndex + (endIndex - startIndex) / 2;
        if (a[midIndex] == target) {
            return midIndex;
        } else if (a[midIndex] > target) {
            return binarySearchRecursive(a, startIndex, midIndex - 1, target);
        } else {
            //a[midIndex] < target
            return binarySearchRecursive(a, startIndex + 1, endIndex, target);
        }
    }


    // pre-condition: array is sorted
    public int binarySearchImproved(int[] a, int startIndex, int endIndex, int target) {
        if (startIndex > endIndex) {
            return -1;
        }
        while (startIndex + 1 < endIndex) {  
            // until startIndex + 1 = endIndex
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            if (a[midIndex] == target) {
                return midIndex;
            } else if (a[midIndex] > target) {
                endIndex = midIndex - 1;
            } else {
                //a[midIndex] < target
                startIndex = midIndex + 1;
            }
        }
        
        if (a[startIndex] == target) {
        	return startIndex;
        }
        if (a[endIndex] == target) {
        	return startIndex;
        }
        return -1;
    }
}
