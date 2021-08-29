package main.java.com.kangmin.datastructure.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public List<Integer> topKFrequentElementByPriorityQueue(int[] nums, int K) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (entryA, entryB) -> (entryB.getValue() - entryA.getValue())
        );

        pq.addAll(map.entrySet());

        List<Integer> result = new ArrayList<>();
        while (result.size() < K) {
            Map.Entry<Integer, Integer> entry = pq.poll();
            assert entry != null;
            result.add(entry.getKey());
        }
        return result;
    }
}
