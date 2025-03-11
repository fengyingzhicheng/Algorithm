package com.southgis.old.question189;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8,9,10};
        Solution solution = new Solution();
        solution.rotate(nums, 4);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        rotate(nums, 0, k % length);
    }

    /**
     * @param nums  数组
     * @param start 开始
     * @param k     k余数 数组长度
     */
    public void rotate(int[] nums, int start, int k) {
        if(k==0){
            return;
        }
        int i = start;
        for (; i < start + k; i++) {
            //交换
            int temp = nums[i];
            nums[i] = nums[nums.length - k + i - start];
            nums[nums.length - k + i - start] = temp;
        }
        if(i<nums.length-1){
            rotate(nums, i, k % (nums.length - i));
        }
    }


}
