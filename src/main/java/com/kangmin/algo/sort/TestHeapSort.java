package main.java.com.kangmin.algo.sort;

public class TestHeapSort {

    public static void main(String[] args) {
        ArrayHeap<Integer> theHeap = new ArrayHeap<>();

        int[] a = {4, 6, 8, 9, 10};
        // insert all elements of a[] to the heap
        for (int value : a) {
            theHeap.insert(value);
        }

        // now call heap.remove() method for the heap sort
        // since we removed the maximum first, we will do the assignment from index
        // length-1 to 0
        for (int i = a.length - 1; i >= 0; i--) {
            a[i] = theHeap.remove();
        }
        for (int value : a) {
            System.out.println(value);
        }
    }
}
