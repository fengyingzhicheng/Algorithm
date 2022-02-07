package com.southgis.old.june.twentyFour.question565;

/**
 * @author 王军
 * 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }
 * 且遵守以下的规则。
 * 假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
 * <p>
 * eg:
 * 输入: A = [5,4,0,3,1,6,2]
 * 输出: 4
 * 解释:
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 * <p>
 * 其中一种最长的 S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 * @description
 * @date 2021/6/24 14:53
 */
public class Solution {
    public int arrayNesting(int[] nums) {
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            int length = 0;
            //初始放入的值
            for (int putData = i; nums[putData] != -1; ) {
                length++;
                int temp=putData;
                putData = nums[putData];
                nums[temp]=-1;
            }
            if (maxLength < length) {
                maxLength = length;
            }

        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5, 4, 0, 3, 1, 6, 2};
        System.out.println(solution.arrayNesting(nums));
    }

}