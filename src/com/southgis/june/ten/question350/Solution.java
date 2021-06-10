package com.southgis.june.ten.question350;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 王军
 * @description 给定两个数组，编写一个函数来计算它们的交集。两个数组中均重复出现取最少
 * 1、返回的数组长度不会超过最短的
 * 2、记录最短的数组中每个值相同的元素出现次数，记录Map<值,次数>
 * 3、遍历较长的数组对Map<值,次数>获取次数，次数大于0的表示另一个数组中出现过 需要放到返回数组中
 * 4、更新遍历的值的记录Map为 当前count-1 这样同一个值遍历次数会减少不会记录错误
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * @date 2021/6/10 15:18
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            //保证nums1数组最短
            return intersect(nums2, nums1);
        }

        //统计数组1中每个值出现的次数
        Map<Integer, Integer> map = countKey(nums1);

        int[] intersection = new int[nums1.length];
        int k = 0;
        for (int data : nums2) {
            int count = map.getOrDefault(data, 0);
            if (count > 0) {
                intersection[k++] = data;
                map.put(data, count - 1);
            }
        }
        return Arrays.copyOf(intersection, k);
    }

    private Map<Integer, Integer> countKey(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int data : array) {
            int count = map.getOrDefault(data, 0) + 1;
            map.put(data, count);
        }
        return map;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2, 2};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.intersect(nums1, nums2)));
    }
}