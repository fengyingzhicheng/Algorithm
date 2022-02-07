package com.southgis.june.twentyThree.question287;

/**
 * @author 王军
 * <p>
 * 给定一个包含n + 1 个整数的数组nums ，其数字都在 1 到 n之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 不一定是只缺一个数字 [2,2,2,2]
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 * 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
 * <p>
 * <p>
 * eg:
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：nums = [1,1]
 * 输出：1
 * 示例 4：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：1
 * @description
 * @date 2021/6/23 17:26
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }

            // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个，此时重复元素一定出现在 [1..4] 区间里
            if (cnt > mid) {
                // 重复元素位于区间 [left..mid]
                right = mid;
            } else {
                // if 分析正确了以后，else 搜索的区间就是 if 的反面区间 [mid + 1..right]
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(solution.findDuplicate(nums));

    }
}