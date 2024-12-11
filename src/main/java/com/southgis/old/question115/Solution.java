package com.southgis.old.question115;

public class Solution {
    public static void main(String[] args) {
        String s = "rabbbit";
        System.out.println(new Solution().numDistinct(s, "rabbit"));
    }

    public int numDistinct(String s, String t) {
        if (t.length() > s.length()) {
            return 0;
        }
        int[][] dp = new int[s.length()][t.length()];
        int firstCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(0)) {
                firstCount++;
            }
            dp[i][0] = firstCount;
        }
        for (int i = 1; i < t.length(); i++) {
            dp[0][i]=0;
        }
        for (int i = 1; i < s.length(); i++) {
            for (int j = 1; j < t.length(); j++) {
                if (j > i) {
                    dp[i][j] = 0;
                } else if (j == i) {
                    dp[i][j] = s.substring(0, i+1)
                            .equals(t.substring(0, j+1)) ? 1 : 0;
                } else {
                    if (s.charAt(i) != t.charAt(j)) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        //how
                        dp[i][j] = dp[i - 1][j-1] + dp[i-1][j];
                    }
                }
            }
        }
        return dp[s.length() - 1][t.length() - 1];
    }

}
