package com.southgis.old.question122;

public class Solution {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new Solution().maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int n = prices.length;
        int[][] dp = new int[n][2];

        // 初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 状态转移
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        // 最后一天不持有股票的利润就是我们要找的最大利润
        return dp[n - 1][0];
    }


}
