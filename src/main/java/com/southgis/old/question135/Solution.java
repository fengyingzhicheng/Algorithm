package com.southgis.old.question135;

import sun.security.util.Length;

/**
 * @className: Sloution
 * @package: com.southgis.question135
 * @author: 王军
 * @description: 分配糖果
 * @date: 2020/12/17 14:51
 */
class Solution {
    public static int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            candies[i] = 1;
        }
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i + 1] > ratings[i])
                candies[i + 1]=candies[i]+1;
        }
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]&&candies[i-1]<=candies[i])
                candies[i - 1]=candies[i]+1;
        }
        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += candies[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] ratings = {1,3,4,5,2};
        candy(ratings);
    }
}