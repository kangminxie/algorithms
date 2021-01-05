package com.kangmin.algo.dp;

public class MaximumSubarray {

    public int maxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];
        dp[0] = A[0];
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = A[i] + (Math.max(dp[i - 1], 0));
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
