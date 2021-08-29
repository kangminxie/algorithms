package main.java.com.kangmin.algo.greedy;

import java.util.PriorityQueue;

public class LastStoneWeight {

    // start from heaviest
    public int lastStoneWeight(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        if (A.length == 1) {
            return A[0];
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int a : A) {
            pq.offer(a);
        }
        for (int i = 0; i < A.length - 1; ++i) {
            pq.offer(pq.poll() - pq.poll());
        }
        return pq.poll();
    }
}
