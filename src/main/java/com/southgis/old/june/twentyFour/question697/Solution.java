package com.southgis.old.june.twentyFour.question697;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author 王军
 * 给定一个非空且只包含非负数的整数数组nums，数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是在 nums 中找到与nums拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 * eg:
 * 输入：[1, 2, 2, 3, 1]
 * 输出：2
 * 解释：
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 * <p>
 * 输入：[1,2,2,3,1,4,2]
 * 输出：6
 * @description
 * @date 2021/6/24 10:56
 * TODO 回头参考
 * https://leetcode-cn.com/problems/degree-of-an-array/solution/shu-zu-ji-shu-ha-xi-biao-ji-shu-jie-fa-y-a0mg/
 */
public class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //度
        int degree = map.values().stream().max(Integer::compareTo).orElse(1);
        //最大度对应的数字
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            Integer count = map.get(num);
            if (count == degree) {
                set.add(num);
            }
        }
        if (degree == 1) {
            return 1;
        }

        Map<Integer, Integer> lengthMap = new HashMap<>();

        for (Integer data : set) {
            for (int i = 0, count = degree; i < nums.length; i++) {
                if (nums[i] == data) {
                    Integer lastIndex = lengthMap.putIfAbsent(nums[i], i);
                    if (count == 1 && lastIndex != null) {
                        lengthMap.put(nums[i], i - lastIndex + 1);
                    }
                    count--;
                }
            }
        }


        return lengthMap.values().stream().min(Integer::compareTo).orElse(0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] nums = {1, 2, 2, 3, 1};
        //System.out.println(solution.findShortestSubArray(nums));
        int[] data = {1, 2, 2, 3, 1, 4, 2};
        System.out.println(solution.findShortestSubArray(data));
    }
}