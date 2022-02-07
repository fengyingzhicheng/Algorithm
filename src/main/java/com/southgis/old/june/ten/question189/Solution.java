package com.southgis.old.june.ten.question189;

import java.util.Arrays;

/**
 * @author 王军
 * @description 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 解：反转，先整个数组反转，然后前K个反转，后length-k个反转
 * [1,2,3,4,5,6,7]->[7,6,5,4,3,2,1]
 * =>[5,6,7]+[1,2,3,4]
 * <p>
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * @date 2021/6/10 17:53
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k % nums.length - 1);
        reverse(nums, k % nums.length, nums.length - 1);
    }

    public void reverse(int[] array, int start, int end) {
        int temp;
        while (start < end) {
            temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(nums));
        Solution solution = new Solution();
        solution.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));

        int data[] = {-1, 2};
        System.out.println(Arrays.toString(data));
        solution.rotate(data, 3);
        System.out.println(Arrays.toString(data));
    }
}