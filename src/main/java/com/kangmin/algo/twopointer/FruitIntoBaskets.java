package main.java.com.kangmin.algo.twopointer;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

    public int totalFruit(int[] tree) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int i = 0;
        int j;
        for (j = 0; j < tree.length; ++j) {
            countMap.put(tree[j], countMap.getOrDefault(tree[j], 0) + 1);
            if (countMap.size() > 2) {
                countMap.put(tree[i], countMap.get(tree[i]) - 1);
                countMap.remove(tree[i++], 0);
            }
        }
        return j - i;
    }

    public int totalFruit2(int[] tree) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int result = 0;
        int i = 0;
        for (int j = 0; j < tree.length; ++j) {
            countMap.put(tree[j], countMap.getOrDefault(tree[j], 0) + 1);
            while (countMap.size() > 2) {
                countMap.put(tree[i], countMap.get(tree[i]) - 1);
                if (countMap.get(tree[i]) == 0) countMap.remove(tree[i]);
                i++;
            }
            result = Math.max(result, j - i + 1);
        }
        return result;
    }
}
