package main.java.com.kangmin.algo.greedy;

public class BestTimeBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int max = 0;
        int historyMin = prices[0];
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] > historyMin) {
                max = Math.max(max, prices[i] - historyMin);
            } else {
                historyMin = prices[i];
            }
        }
        return max;
    }

    // Kadane's Algorithm
    public int maxProfitDp(int[] prices) {
        int currentMax = 0, globalMax = 0;
        for (int i = 1; i < prices.length; i++) {
            currentMax += prices[i] - prices[i - 1];
            currentMax = Math.max(0, currentMax);
            globalMax = Math.max(currentMax, globalMax);
        }
        return globalMax;
    }
}
