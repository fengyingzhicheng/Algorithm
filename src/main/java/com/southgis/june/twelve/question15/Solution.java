package com.southgis.june.twelve.question15;

import java.util.*;

/**
 * @author 王军
 * @description 给你一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有满足条件且不重复的三元组。注意：答案中不可以包含重复的三元组。
 *
 * map:{-1,0}=>c=0=>map.fori
 * {-1,0}=>map2中找有无-c-(-1)->有无key 1 =>没有=>map2{-1,0}
 * =>map.put=> map:{-1,0},{0,1}
 * map:{-1,0},{0,1}=>c=1=>map.fori
 * {-1,0}=>map2中找有无-c-(-1)->有无key 0 =>没有=>map2{-1,0}
 * {0,1}=>map2中找有无-c-(0)->有无key -1 =>有
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * @date 2021/6/12 20:16
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }

        List<List<Integer>> listList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < 2) {
                continue;
            }
            int c = nums[i];
            //map存储遍历过的值 在map中找到a+b=-c
            Map<Integer, Integer> map2 = new HashMap<>();
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < i; j++) {
                Integer index = map2.get(-c - nums[j]);
                if (index == null || index.equals(j)) {
                    map2.put(nums[j], j);
                } else {
                    list.add(nums[index]);
                    list.add(nums[j]);
                    list.add(nums[i]);
                    if (!list.isEmpty()) {
                        if (!isContain(listList, list)) {
                            listList.add(list);
                        }
                        list = new ArrayList<>();
                    }
                }
            }

        }
        return listList;
    }

    private boolean isContain(List<List<Integer>> listList, List<Integer> list) {
        for (List<Integer> data : listList) {
            if (data.containsAll(list) && list.containsAll(data)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums));

        int[] test2 = {0, 0, 0, 0, 0, 0};
        System.out.println(solution.threeSum(test2));
    }

}