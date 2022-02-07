package com.southgis.old.june.twentyNine.question128;

import java.util.Arrays;

/**
 * @author 王军
 * TODO 不重复可以
 * 解：排序 O(nlogn)然后遍历数组O(n)
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 进阶：你可以设计并实现时间复杂度为O(n) 的解决方案吗？
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * @description
 * @date 2021/6/29 9:03
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 1 || nums.length == 0) {
            return nums.length;
        }
        Arrays.sort(nums);
        int length = 1;
        int start = 0;
        int interval = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[start] != interval) {
                start = i;
                interval = 1;
            } else {
                interval++;
                length = Math.max(length, i - start + 1);
            }
        }
        return length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(solution.longestConsecutive(nums));

        int[] data = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(solution.longestConsecutive(data));

        int[] ints = {1,2,0,1};
        //0 1 1 2 =>0 1 2
        System.out.println(solution.longestConsecutive(ints));
    }
}