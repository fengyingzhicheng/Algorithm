package com.southgis.old.question169;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int majorityElement(int[] nums) {
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            Integer integer = map.get(num);
            if(integer==null){
                map.put(num,1);
            }else {
                map.put(num,integer+1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if(value>n/2){
                return entry.getKey();
            }
        }
        throw new RuntimeException("不存在多数元素");
    }

    public int majorityElement2(int[] nums) {
        //O(logn)
        Arrays.sort(nums);
        int countA=0;
        int maxA=nums[0];
        int countB=0;

        for (int num : nums) {
            if (num == maxA) {
                countA++;
            } else {
                countB++;
            }
            if (countB > countA) {
                maxA = num;
                countA = countB;
                countB = 0;
            }
        }
        return maxA;

    }

    public int majorityElement3(int[] nums) {
        int count=0;
        int major=nums[0];
        for (int num : nums) {
            if(num==major){
                count++;
            }else {
                if(count==0){
                    major=num;
                    count++;
                }else {
                    count--;
                }
            }
        }
        return major;
    }
}
