package com.southgis.old.june.twentyThree.question645;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 王军
 * <p>
 * 集合 s 包含从 1 到n的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，
 * 导致集合 丢失了一个数字 并且 有一个数字重复 。
 * <p>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 * eg：
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * <p>
 * 输入：nums = [1,1]
 * 输出：[1,2]
 * @description
 * @date 2021/6/23 16:51
 */
public class Solution {
    public int[] findErrorNums(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] miss = new int[2];
        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            count++;
            map.put(num, count);
        }
        for (int i = 1; i <= nums.length; i++) {
            Integer count = map.getOrDefault(i, 0);
            if (count == 2) {
                miss[0]=i;
            }
            if (count == 0) {
                miss[1]=i;
            }
        }
        return miss;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums={1,2,2,4};
        System.out.println(Arrays.toString(solution.findErrorNums(nums)));

    }
}