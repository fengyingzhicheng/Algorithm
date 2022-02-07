package com.southgis.old.june.eleven.question28;

import java.util.Arrays;

/**
 * @author 王军
 * @description 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 解：应该把要的（不相等的放前面）相等的放后面，（双指针法）头尾指针，
 * 如果相等交换头尾指针对应的值，头指针不变，尾指针减1，
 * 如果不等头指针加一，直到头尾相遇，然后返回尾指针+1代表最后长度
 * <p>
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 输入：nums = [3,2,2,3], val = 3
 * 输出：nums=[2,2,x,x],length=2
 * @date 2021/6/11 9:42
 */
public class Solution2 {
    public int removeElement(int[] nums, int val) {
        int j = nums.length - 1;
        for (int i = 0; i <= j; i++) {
            if (nums[i] == val) {
                swap(nums, i--, j--);
            }
        }
        return j + 1;
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int nums[] = {3, 2, 2, 3};
        Solution2 solution = new Solution2();
        System.out.println(solution.removeElement(nums, 2));
        System.out.println(Arrays.toString(nums));
    }
}