package com.southgis.old.june.twentyTwo.question70;

import org.junit.Test;

/**
 * @author 王军
 * @description 爬楼梯 动态规划
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ **注意：**给定 n 是一个正整数。
 *
 * eg:
 * 输入： 2   输出： 2  解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 输入： 3   输出： 3  解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * @date 2021/6/22 16:21
 */
public class Solution {
    public int climbStairs(int n) {
        int[] array=new int[n];
        for (int i = 1; i <= n; i++) {
            if (i <= 2) {
                array[i - 1] = i;
            } else {
                array[i-1]=array[i-2]+array[i-3];
            }
        }
        return array[n-1];
    }

    @Test
    public void testClimbStairs() {
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(10));
    }
}