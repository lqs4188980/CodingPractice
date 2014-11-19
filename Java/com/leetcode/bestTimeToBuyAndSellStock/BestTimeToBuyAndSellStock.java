package com.leetcode.bestTimeToBuyAndSellStock;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        // If only permitted to complete at most one transaction, we must find an ascending range that the min on the left and max on the right, and also has largest difference.
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int diff = Integer.MIN_VALUE;
        
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] < min) {
                min = prices[i];
            }
            if (prices[i] - min > diff) {
                diff = prices[i] - min;
            }
        }
        
        return diff;
    }
}
