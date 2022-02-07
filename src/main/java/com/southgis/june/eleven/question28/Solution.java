package com.southgis.june.eleven.question28;

import java.util.Arrays;

/**
 * @author 王军
 * @description 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 解：使用计数符记录查到相等的数组数量，遍历数组相等的话，后面的数组值（前移）覆盖前面，增加计数
 * 如果不相等外围循环指针后移，最终的数组长度为真实长度减去计数相等的
 * <p>
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：nums=[2,2],length=2
 * @date 2021/6/11 9:42
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length - count; ) {
            if (nums[i] == val) {
                for (int j = i + 1; j < nums.length - count; j++) {
                    nums[j - 1] = nums[j];
                }
                count++;
            } else {
                i++;
            }
        }
        return nums.length-count;
    }

    public static void main(String[] args) {
        int nums[] = {3, 2, 2, 3};
        Solution solution = new Solution();
        System.out.println(solution.removeElement(nums, 2));
        System.out.println(Arrays.toString(nums));
    }
}