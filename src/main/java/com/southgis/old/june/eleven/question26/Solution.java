package com.southgis.old.june.eleven.question26;

/**
 * @author 王军
 * @description 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次。
 * 解：题目为已经排序的，双指针一个用于循环另一个用于记录有效位置索引 不等的时候索引位置加一个为不等的值
 * <p>
 * 说明：返回移除后数组的新长度。不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * nums = [1,1,2]
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * @date 2021/6/11 10:47
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        //j表示有效的最后一个位置
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}