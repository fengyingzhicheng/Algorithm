package com.southgis.june.twentyFour.question667;

import java.util.Arrays;

/**
 * @author 王军
 * <p>
 * 解：顺序数组或者逆序数组：[1, 2, 3, ..., n] ，呈等差数列形式，此时公差为 1，即 k = 1；
 * 最大值和最小值交错出现： [1, n, 2, n-1, 3, n-2, ....]，此时相邻的两个数的差的绝对值不会出现重复，
 * k 达到最大，k = n - 1。
 * <p>
 * 给你两个整数 n 和 k ，请你构造一个答案列表 answer ，该列表应当包含从 1 到 n 的 n 个不同正整数，并同时满足下述条件：
 * <p>
 * 假设该列表是 answer =[a1, a2, a3, ... , an] ，那么列表 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 中应该有且仅有 k 个不同整数。
 * 返回列表 answer 。如果存在多种答案，只需返回其中 任意一种 。
 * <p>
 * eg：
 * 输入：n = 3, k = 1
 * 输出：[1, 2, 3]
 * 解释：[1, 2, 3] 包含 3 个范围在 1-3 的不同整数，并且 [1, 1] 中有且仅有 1 个不同整数：1
 * 示例 2：
 * <p>
 * 输入：n = 3, k = 2
 * 输出：[1, 3, 2]
 * 解释：[1, 3, 2] 包含 3 个范围在 1-3 的不同整数，并且 [2, 1] 中有且仅有 2 个不同整数：1 和 2
 * @description
 * @date 2021/6/24 9:14
 */
//TODO
public class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        //1、构造1差值的长度为n-k-1的数组
        for (int i = 0; i < n - k - 1; i++) {
            res[i] = i + 1;
        }
        //2、构造k个差值的长度为k+1数组
        boolean flag = true;
        int j = 1;
        int m=k+1;
        for (int i = n - k - 1; i < n; i++) {
            if (m == j) {
                res[i]=j+n-k-1;
                break;
            }
            if (flag) {
                res[i]=j+n-k-1;
                j++;
            } else {
                res[i]=m+n-k-1;
                m--;
            }
            flag = !flag;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.constructArray(5, 3)));
    }
}