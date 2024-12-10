package com.southgis.old.question120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> triangle= new ArrayList<>();
        triangle.add(Arrays.asList(-10));
        System.out.println(new Solution().minimumTotal(triangle));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + list.get(j);
                }else if(i==j){
                    dp[i][j] = dp[i - 1][j - 1]+ list.get(j);
                }
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1])+ list.get(j);
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for (int i = 0; i <triangle.size(); i++) {
            min=Math.min(min,dp[triangle.size()-1][i]);
        }
        return min;
    }
}
