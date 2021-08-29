package main.java.com.kangmin.datastructure.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {

    public String frequencySortByPriorityQueue(String s) {
        Map<Character, Integer> map = new HashMap<>();

        char[] arr = s.toCharArray();
        for (char ch : arr) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (entryA, entryB) -> entryB.getValue() - entryA.getValue()
        );

        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> e = pq.poll();
            // sb.append(String.valueOf(e.getKey()).repeat(Math.max(0, e.getValue())));
            for (int i = 0; i < e.getValue(); i++)
                sb.append(e.getKey());
        }
        return sb.toString();
    }
}
