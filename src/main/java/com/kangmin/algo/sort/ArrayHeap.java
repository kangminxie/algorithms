package com.kangmin.algo.sort;

/**
 * Array Heap (max version) Program
 * The default size of the heap is 10001
 * Methods()contains:
 * insert;
 * bubbleUp();
 * remove();
 * bubbleDown();
 */

public class ArrayHeap<T extends Comparable> {
    private T[] heap;        //instance variable, array
    private int tailIndex;    //instance variable, index for to be added
    private static final int DEF_SIZE = 10001;

    //default constructor
    public ArrayHeap() {
        heap = (T[]) (new Comparable[DEF_SIZE]);
        tailIndex = 0;
    }

    //parameterized constructor
    public ArrayHeap(int aSize) {
        if (aSize <= 0) return;
        heap = (T[]) (new Comparable[aSize]);
        tailIndex = 0;
    }

    //method insert
    //insert a new element to heap from tailIndex
    public void insert(T data) {
        if (tailIndex >= heap.length) {
            System.out.println("heap is full now");
            return;
        }
        heap[tailIndex] = data;
        this.bubbleUp();
        tailIndex++;
    }

    //support for method insert
    //if the new element is bigger than its parent, swap, and compare until the it is larger than adjusted parement
    private void bubbleUp() {
        int tempIndex = this.tailIndex;
        while (tempIndex > 0 && heap[(tempIndex - 1) / 2].compareTo(heap[tempIndex]) < 0) {
            T temp = heap[(tempIndex - 1) / 2];
            heap[(tempIndex - 1) / 2] = heap[tempIndex];
            heap[tempIndex] = temp;
            tempIndex = (tempIndex - 1) / 2;
        }
    }

    //method remove
    //delete the heap[0], destroy
    public T remove() {
        T retVal = heap[0];
        heap[0] = heap[tailIndex - 1];
        heap[tailIndex - 1] = null;
        tailIndex--;
        this.bubbleDown();
        return retVal;
    }

    private void bubbleDown() {
        int tempIndex = 0;
        while (tempIndex * 2 + 1 < tailIndex) {
            //find the child
            int bigIndex = tempIndex * 2 + 1;
            //assume teh left child is bigger initially
            if (tempIndex * 2 + 2 < tailIndex &&
                    heap[tempIndex * 2 + 1].compareTo(heap[tempIndex * 2 + 2]) < 0)
                bigIndex = tempIndex * 2 + 2;
            if (heap[tempIndex].compareTo(heap[bigIndex]) < 0) {
                T temp = heap[tempIndex];
                heap[tempIndex] = heap[bigIndex];
                heap[bigIndex] = temp;
            } else {
                break;
            }
            tempIndex = bigIndex;
        }
    }

    //method showBreadth()
    //show the breadth order traversal
    public void showBreadth() {
        if (tailIndex == 0) {
            System.out.println("Heap is Empty, nothing to showBreadth");
            return;
        }
        for (int i = 0; i < tailIndex; i++) {   //Array[0] to Array[tailIndex-1]
            System.out.println(heap[i]);
        }
    }

    //method heapSort()
    //will damage the previous heap since the Array[0] will be removed
    public void heapSort() {
        if (tailIndex == 0) {
            System.out.println("Empty heap no need to do heapSort");
            return;
        }
        for (int i = tailIndex; i > 0; i--) {
            System.out.println(this.remove());
        }
    }
}
