package com.kangmin.algo.csce.heap;

/**
 * Array Heap (min version) Program for sheep heap
 * Methods()contains:
 * insert/addSheep;
 * bubbleUp/climbUp;
 * remove/removeSheep;
 * bubbleDown/climbDown;
 * printBreadthOrder/sheepRollCall;
 * heapSort/sheepHeapSort;
 */

public class ArrayHeapMin<T extends Comparable> implements HeapInterface<T>  {
    private T[] heap;            //instance variable, array
    private int tailIndex;        //instance variable, index for to be added
    private static final int DEF_SIZE = 128;

    //default constructor
    public ArrayHeapMin() {
        heap = (T[]) (new Comparable[DEF_SIZE]);
        tailIndex = 0;
    }

    //parameterized constructor
    public ArrayHeapMin(int aSize) {
        if (aSize <= 0) return;
        heap = (T[]) (new Comparable[aSize]);
        tailIndex = 0;
    }

    @Override
    public void insert(T data) {
        this.addSheep(data);
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public T peek() {
        if (tailIndex <= 0) {
            return null;
        }
        return heap[tailIndex - 1];
    }

    //method "insert", or addSheep
    //insert a new element to heap from tailIndex
    public void addSheep(T data) {
        if (tailIndex >= heap.length) {
            System.out.println("Our heap is full now");
            return;
        }
        heap[tailIndex] = data;
        this.climbUp();
        tailIndex++;
    }

    //support for method addSheep
    //if the new element is bigger than its parent, swap, and compare until the it is larger than adjusted parement
    private void climbUp() {
        int tempIndex = this.tailIndex;
        while (tempIndex > 0 && heap[(tempIndex - 1) / 2].compareTo(heap[tempIndex]) > 0) {
            T temp = heap[(tempIndex - 1) / 2];
            heap[(tempIndex - 1) / 2] = heap[tempIndex];
            heap[tempIndex] = temp;

            tempIndex = (tempIndex - 1) / 2;
        }
    }

    //method removeSheep
    //delete the heap[0], destroy
    private T removeSheep() {
        T retVal = heap[0];
        heap[0] = heap[tailIndex - 1];
        heap[tailIndex - 1] = null;
        tailIndex--;
        this.climbDown();
        return retVal;
    }

    private void climbDown() {
        int tempIndex = 0;
        while (tempIndex * 2 + 1 < tailIndex) {
            //find the child
            int smallIndex = tempIndex * 2 + 1;
            //assume the left child is smaller initially
            if (tempIndex * 2 + 2 < tailIndex &&
                    heap[tempIndex * 2 + 1].compareTo(heap[tempIndex * 2 + 2]) > 0)
                smallIndex = tempIndex * 2 + 2;
            if (heap[tempIndex].compareTo(heap[smallIndex]) > 0) {
                T temp = heap[tempIndex];
                heap[tempIndex] = heap[smallIndex];
                heap[smallIndex] = temp;
            } else {
                break;
            }
            tempIndex = smallIndex;
        }
    }

    //method showBreadth() or sheepRollCall
    //show the breadth order traversal
    public void sheepRollCall() {
        if (tailIndex == 0) {
            System.out.println("Heap is Empty, nothing to showBreadth");
            return;
        }
        for (int i = 0; i < tailIndex; i++) {
        	//Array[0] to Array[tailIndex-1]
            System.out.println(heap[i]);
        }
    }

    //method heapSort()or sheepHeapSort()
    //will damage the previous heap since the Array[0] will be removed
    public void heapSort() {
        if (tailIndex == 0) {
            System.out.println("Empty heap no need to do heapSort");
            return;
        }
        for (int i = tailIndex; i > 0; i--) {
            System.out.println(this.removeSheep());
        }
    }

    @Override
    public void print() {
        this.heapSort();
    }
}
