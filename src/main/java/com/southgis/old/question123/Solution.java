package com.southgis.old.question123;

public class Solution {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 4, 5};
        System.out.println(new Solution().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int n = prices.length;
        //定义dp为第i天最多交易j次的最大利润 i 为第几天 j为交易次数 0<i<n j<3
        int[][] dp = new int[3][n];

        // 初始化
        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }
        for (int j = 1; j < 3; j++) {
            dp[j][0] = 0;
        }

        //最多交易两次
        for (int i = 1; i < 3; i++) {
            int max=Integer.MIN_VALUE;
            for (int j = 1; j < n; j++) {
                //k为第几天操作 买入的时候的利润 等于前一天
//                j-1
                max=Math.max(max,dp[i-1][j-1]-prices[j-1]);
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + max);
            }
        }
        return dp[2][n - 1];
    }


}
