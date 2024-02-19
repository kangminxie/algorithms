package main.java.com.kangmin.levitin;

import java.util.ArrayList;
import java.util.List;

public class PrimesSieve {

    public static List<Integer> getPrimesNoMoreThan(int n) {
        final List<Integer> result = new ArrayList<>();
        final int[] arr = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            arr[i] = i;
        }
        int limit = (int) Math.sqrt(n);
        for (int p = 2; p <= limit; p++) {
            if (arr[p] != 0) {
                int j = p * p;
                while (j <= n) {
                    arr[j] = 0;
                    j += p;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (arr[i] != 0) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        final List<Integer> result = getPrimesNoMoreThan(100);
        // [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97]
        System.out.println(result);
    }
}
