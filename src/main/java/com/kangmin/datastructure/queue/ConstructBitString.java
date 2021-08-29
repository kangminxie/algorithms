package main.java.com.kangmin.datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructBitString {

    //1.Start with Enqueuing 1.
    //2.Dequeue a number from queue and append 0 to it and enqueue it back to queue.
    //3.Perform step 2 but with appending 1 to the original number and enqueue back to queue.
    //Size of Queue should be 1 more than number because for a single number we're enqueuing two
    public static String[] findBin(int number) {
        String[] result = new String[number];
        Queue<String> queue = new LinkedList<>();

        queue.offer("1");

        for (int i = 0; i < number; i++) {
            result[i] = queue.poll();
            String s1 = result[i] + "0";
            String s2 = result[i] + "1";
            queue.offer(s1);
            queue.offer(s2);
        }

        return result; //For number = 3 , result = {"1","10","11"};
    }

    public static void main(String[] args) {

        String[] output = findBin(10);
        for (String s : output) {
            System.out.print(s + " ");
        }
    }
}
