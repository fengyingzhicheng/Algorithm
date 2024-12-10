package com.southgis.old.dpstudy;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.camp(3);
        System.out.println(result);
    }

    public int camp(int n) {
        if(n==0) return 0;
        int[] dp =new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <= n; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
