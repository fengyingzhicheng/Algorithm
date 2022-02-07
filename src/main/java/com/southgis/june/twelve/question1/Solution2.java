package com.southgis.june.twelve.question1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 王军
 * @description 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 解：遍历=>使用map存储key和数组索引，{2，0}{7，1}{11，2}{15，3}：
 * 每次循环内检查是否map有对应的target-当前值如果有返回数组
 * 没有放进map中
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @date 2021/6/12 19:42
 */
public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return null;
        }

        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index == null) {
                map.put(nums[i], i);
            } else {
                return new int[]{index,i};
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] nums={2, 7, 7, 15};
        int target=14;
        Solution2 solution=new Solution2();
        System.out.println(Arrays.toString(solution.twoSum(nums,target)));
    }
}