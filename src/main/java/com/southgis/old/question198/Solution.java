package com.southgis.old.question198;

public class Solution {
    public static void main(String[] args) {
    }

    public int rob(int[] nums) {
        int[] dp=new int[nums.length];

        dp[0]=nums[0];
        if(nums.length>1){
            dp[1]=Math.max(nums[0],nums[1]);
            for (int i = 2; i < nums.length; i++) {
                dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
            }
        }

        return dp[nums.length-1];
    }
}
