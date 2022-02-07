package com.southgis.june.twentyTwo.question283;

import java.util.Arrays;

/**
 * @author 王军
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * @description
 * @date 2021/6/22 20:39
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int index=0;
        for (int num : nums) {
            if (num != 0) {
                nums[index++]=num;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i]=0;
        }
    }

    public static void main(String[] args) {
        int[] nums={0,1,0,3,12};
        Solution solution=new Solution();
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}