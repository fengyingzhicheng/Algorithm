package com.southgis.old.june.twentyThree.question485;

/**
 * @author 王军
 * <p>
 * 给定一个二进制数组， 计算其中最大连续 1 的个数。
 * eg:
 * 输入：[1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * @description
 * @date 2021/6/23 9:10
 */
public class Solution2 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, cur = 0;
        for (int x : nums) {
            cur = x == 0 ? 0 : cur + 1;
            max = Math.max(max, cur);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(solution.findMaxConsecutiveOnes(nums));
        int[] data = {1, 1, 1, 1, 0};
        System.out.println(solution.findMaxConsecutiveOnes(data));
    }
}