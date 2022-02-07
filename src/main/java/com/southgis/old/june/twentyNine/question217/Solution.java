package com.southgis.old.june.twentyNine.question217;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 王军
 * 判断数组是否含有重复元素
 * @description
 * @date 2021/6/29 8:59
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() < nums.length;
    }
}