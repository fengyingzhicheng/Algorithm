package com.southgis.old.question300;

public class Solution {
    public static void main(String[] args) {
        int[] prices = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new Solution().lengthOfLIS(prices));
    }

    public int lengthOfLIS(int[] nums) {
        //dp[i] 表示以nums[i]结尾的最长上升子序列的长度
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLength=1;
        for (int i = 1; i < nums.length; i++) {
            //如果nums[i]小于前面所有 的元素 dp[i]=1
            int max=Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    max=Math.max(max,dp[j]);
                }
            }
            if(max==Integer.MIN_VALUE){
                dp[i]=1;
            }else{
                dp[i]=max+1;
            }
            maxLength=Math.max(maxLength,dp[i]);
        }
        return maxLength;
    }

}
