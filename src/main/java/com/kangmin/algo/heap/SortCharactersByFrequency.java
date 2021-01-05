package com.kangmin.algo.heap;

import java.util.*;

public class SortCharactersByFrequency {

    public String frequencySortByPriorityQueue(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (entryA, entryB) -> entryB.getValue() - entryA.getValue());
        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry e = pq.poll();
            for (int i = 0; i < (int) e.getValue(); i++)
                sb.append(e.getKey());
        }
        return sb.toString();
    }
}
