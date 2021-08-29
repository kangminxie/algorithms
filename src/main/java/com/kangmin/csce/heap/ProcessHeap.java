package main.java.com.kangmin.csce.heap;

/**
 * Program of ProcessHeap Class
 * A Heap was created, based on the priority value of each Process
 * instance variable heap, Type Array[Process]
 * instance variable size, Type int
 * Methods()contains:
 * insert(); bubbleUp();
 * peek();
 * remove(); bubbleDown();
 * printHeap()
 * isEmpty()
 */

public class ProcessHeap {
    private Process[] heap;    //instance variable, array<Process>
    private int size;                    //instance variable, index for to be added
    private static final int DEF_SIZE = 64;

    //Default constructor
    public ProcessHeap() {
        heap = new Process[DEF_SIZE];
        size = 0;
    }

    //parameterized constructor
    public ProcessHeap(int aSize) {
        if (aSize <= 0) return;
        heap = new Process[aSize];
        size = 0;
    }

    //method insert
    public void insert(Process data) {
        if (size >= heap.length) {
            System.out.println("heap is full now");
            return;
        }
        heap[size] = data;
        this.bubbleUp();
        size++;
    }

    private void bubbleUp() {
        int tempIndex = this.size;
        while (tempIndex > 0 && heap[(tempIndex - 1) / 2].compareTo(heap[tempIndex]) < 0) {
            Process temp = heap[(tempIndex - 1) / 2];
            heap[(tempIndex - 1) / 2] = heap[tempIndex];
            heap[tempIndex] = temp;

            tempIndex = (tempIndex - 1) / 2;
        }
    }


    //method peek
    public Process peek() {
        if (this.size > 0)
            return heap[0];
        return null;
    }


    //method remove
    //delete the heap[0], destroy
    public Process remove() {
        Process retVal = heap[0];
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;
        this.bubbleDown();
        return retVal;
    }

    private void bubbleDown() {
        int tempIndex = 0;
        while (tempIndex * 2 + 1 < size) {
            //find the child
            int bigIndex = tempIndex * 2 + 1;
            //assume teh left child is bigger initially
            if (tempIndex * 2 + 2 < size &&
                    heap[tempIndex * 2 + 1].compareTo(heap[tempIndex * 2 + 2]) < 0)
                bigIndex = tempIndex * 2 + 2;
            if (heap[tempIndex].compareTo(heap[bigIndex]) < 0) {
                Process temp = heap[tempIndex];
                heap[tempIndex] = heap[bigIndex];
                heap[bigIndex] = temp;
            } else {
                break;
            }
            tempIndex = bigIndex;
        }
    }


    //method pringtHeap
    public void printHeap() {
        if (this.size == 0) {
            System.out.println("Heap is Empty, nothing to print");
            return;
        }
        for (int i = 0; i < this.size; i++) {
            //Array[0] to Array[tailIndex-1]
            System.out.println(heap[i]);
        }
    }

    //method isEmpty
    public boolean isEmpty() {
        return this.size == 0;
    }

}//end of ProcessHeap Class
