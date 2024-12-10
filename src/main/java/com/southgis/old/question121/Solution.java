package com.southgis.old.question121;

public class Solution {
    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        System.out.println(new Solution().maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = prices[0];
        int lastMin=prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                lastMin=min;
                min = prices[i];
            }else {
                profit = Math.max(Math.max(profit, prices[i] - min), prices[i] - lastMin);
            }
        }

        return profit;
    }

}
