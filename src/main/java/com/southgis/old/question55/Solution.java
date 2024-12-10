package com.southgis.old.question55;

public class Solution {
    public static void main(String[] args) {
        int[] prices = {2,3,1,1,4};
        System.out.println(new Solution().canJump(prices));
    }
    public boolean canJump(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        return true;
    }

}
