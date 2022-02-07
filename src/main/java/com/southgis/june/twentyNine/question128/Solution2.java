package com.southgis.june.twentyNine.question128;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 王军
 * 解：暴力的方法是 O(n) 遍历数组去看是否存在这个数，
 * 但其实更高效的方法是用一个哈希表存储数组中的数，这样查看一个数是否存在即能优化至 O(1) 的时间复杂度。
 *
 * 仅仅是这样我们的算法时间复杂度最坏情况下还是会达到 O(n^2)
 * （即外层需要枚举 O(n) 个数，内层需要暴力匹配O(n) 次），
 * 无法满足题目的要求。但仔细分析这个过程，我们会发现其中执行了很多不必要的枚举，
 * 如果已知有一个 x, x+1, x+2, ⋯,x+y 的连续序列，
 * 而我们却重新从 x+1，x+2 或者是 x+y 处开始尝试匹配，
 * 那么得到的结果肯定不会优于枚举 x为起点的答案，因此我们在外层循环的时候碰到这种情况跳过即可。
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 进阶：你可以设计并实现时间复杂度为O(n) 的解决方案吗？
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * <p>
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * @description
 * @date 2021/6/29 9:03
 */
public class Solution2 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 1;
        for (Integer data : set) {
            if (!set.contains(data - 1)) {
                int i = 1;
                while (set.contains(data + i)) {
                    max = Math.max(max, i + 1);
                    i++;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(solution.longestConsecutive(nums));

        int[] data = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(solution.longestConsecutive(data));

        int[] ints = {1, 2, 0, 1};
        //0 1 1 2 =>0 1 2
        System.out.println(solution.longestConsecutive(ints));
    }
}