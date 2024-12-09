package com.southgis.old.question189;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        Solution solution = new Solution();
        solution.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        rotate(nums, 0, k % length, length);
    }

    public void rotate(int[] nums, int start, int k, int n) {
        int i = start;
        for (; i < start + k; i++) {
            //交换
            int temp = nums[i];
            nums[i] = nums[n - start + i - k];
            nums[n  - start +  i - k] = temp;
        }
        if (i < n) {
            rotate(nums, i, k, n);
        }
    }


}
