package com.southgis.june.ten.question350;

import java.util.Arrays;

/**
 * @author 王军
 * @description 给定两个数组，编写一个函数来计算它们的交集。两个数组中均重复出现取最少。两数组已经排序
 * <p>
 * 假如两个数组都是有序的，分别为：arr1 = [1,2,3,4,4,13]，arr2 = [1,2,3,9,10]
 * @date 2021/6/10 15:18
 */
public class Solution2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            //保证nums1数组最短
            return intersect(nums2, nums1);
        }
        int[] intersection = new int[nums1.length];
        int k = 0;

        int point1 = 0;
        int point2 = 0;


        while (point1 < nums1.length && point2 < nums2.length) {
            if (nums1[point1] == nums2[point2]) {
                intersection[k++] = nums1[point1];
                point1++;
                point2++;
            } else if (nums1[point1] < nums2[point2]) {
                point1++;
            } else {
                point2++;
            }
        }
        return Arrays.copyOf(intersection, k);
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Solution2 solution = new Solution2();
        System.out.println(Arrays.toString(solution.intersect(nums1, nums2)));
    }
}