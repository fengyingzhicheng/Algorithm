package com.southgis.june.twelve.question15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 王军
 * @description 给你一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有满足条件且不重复的三元组。注意：答案中不可以包含重复的三元组。
 * 解：首先对数组进行排序，排序后固定一个数 nums[i]nums[i]，
 * 再使用左右指针指向 nums[i]nums[i]后面的两端，数字分别为 nums[L]nums[L] 和 nums[R]nums[R]，
 * 计算三个数的和 sum 判断是否满足为 0，满足则添加进结果集
 *
 *
 * [-1, 0, 1, 2, -1, -4,-1]=>sorted=>[-4,-1,-1,-1, 0, 1, 2]
 * [0,0,0,0,0]=>sorted=>[0,0,0,0,0]
 * [-3,-3,0,1,0,2,3,3]
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * @date 2021/6/12 20:16
 */
public class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return listList;
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0) {
                    List<Integer> data = new ArrayList<>();
                    data.add(nums[i]);
                    data.add(nums[left]);
                    data.add(nums[right]);
                    listList.add(data);

                    //没想出来
                    // 去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // 去重
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    //相等前后各移动1
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return listList;
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums));
        int[] test1 = {-1, 0, 1, 2, -1, -4, -1};
        System.out.println(solution.threeSum(test1));

        int[] test2 = {0, 0, 0, 0, 0, 0};
        System.out.println(solution.threeSum(test2));
    }

}