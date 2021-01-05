package com.kangmin.algo.dp;

public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        int[] result = new int[n + 1];
        result[1] = 1;
        result[2] = 2;
        for (int i = 3; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }
}
