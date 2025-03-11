package com.southgis.old;

public class MinPathSum {
    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 4, 7},
                {7, 1, 2, 2},
                {8, 0, 5, 1},
                {7, 6, 0, 0}
        };
        int result = minPathSum(A);
        System.out.println("最小路径和为：" + result);
    }
    public static int minPathSum(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = A[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0&&j==0){
                    continue;
                }
                if(j == 0){
                    dp[i][j]=dp[i-1][j]+A[i][j];
                    continue;
                }
                if(i == 0){
                    dp[i][j]=dp[i][j-1]+A[i][j];
                    continue;
                }

                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+A[i][j];
            }
        }
        return dp[m-1][n-1];
    }
}
