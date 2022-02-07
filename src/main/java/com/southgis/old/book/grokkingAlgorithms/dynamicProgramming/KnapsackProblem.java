package com.southgis.book.grokkingAlgorithms.dynamicProgramming;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author 王军
 * @description 动态规划 背包问题，使用动态规划，即分解子问题，通过局部最大值，逐渐得到全局最大值
 * @date 2021/6/22 13:48
 */
@RunWith(JUnit4.class)
public class KnapsackProblem {
    private static int[] weights = {10, 20, 40};
    private static int[] dollars = {60, 100, 120};
    private static int capacity = 50;
    private static int count = 3;
    private static int[][] packageValue;

    static {
        //找到权重们与capacity的最大公约数
        int greatestCommonDivisor = 10;
        for (int i = 0; i < weights.length; i++) {
            weights[i] = weights[i] / greatestCommonDivisor;
        }
        capacity = capacity / greatestCommonDivisor;
        packageValue = new int[count + 1][capacity + 1];
    }

    /***
     *
     * 辗转相减法
     * @param a 大的
     * @param b 小的
     * @return int
     */
    public static int nGCD(int a, int b) {
        if (a == b) {
            return a;
        }
        return a - b > b ? nGCD(a - b, b) : nGCD(b, a - b);
    }


    @Test
    public void DpAlgorithm() {
        for (int i = 1; i < packageValue.length; i++) {
            for (int j = 1; j <packageValue[i].length; j++) {
                if (weights[i - 1] <= j) {
                    //上一次的最大值 当前商品值与剩余空间最大值 取最大
                    packageValue[i][j] = Math.max(packageValue[i - 1][j], dollars[i - 1] + packageValue[i - 1][j - weights[i - 1]]);
                } else {
                    packageValue[i][j] = packageValue[i - 1][j];
                }
            }
        }
        System.out.println("动态规划后最大的价值是：" + packageValue[count][capacity]);
    }
}