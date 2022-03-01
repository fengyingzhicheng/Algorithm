package leetcode.editor.cn;

//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 10⁹ 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
// Related Topics 数组 二分查找 前缀和 滑动窗口 👍 956 👎 0

import java.util.Arrays;

class 长度最小的子数组 {
    public static void main(String[] args) {
        Solution solution = new 长度最小的子数组().new Solution();
        solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minSubArrayLen(int target, int[] nums) {
            return violenceSolution(target, nums);

        }

        /**
         * 暴力解法
         *
         * @param target 目标值
         * @param nums   数组
         * @return
         */
        private int violenceSolution(int target, int[] nums) {
            int min = 0;
            for (int slow = 0; slow < nums.length; slow++) {
                int sum = 0;
                int fast = slow;
                while (fast < nums.length) {
                    sum += nums[fast];
                    fast++;
                    if (sum >= target) {
                        break;
                    }
                }
                if (sum >= target) {
                    //当前的长度
                    if (min == 0) {
                        min = fast - slow;
                    } else {
                        min = Math.min(min, fast - slow);
                    }
                }
            }
            return min;
        }

        /**
         * 前缀数组
         *
         * @param s 目标值
         * @param nums   数组
         * @return
         */
        private int arrayOfPrefixesSolution(int s, int[] nums) {
            int length = nums.length;
            int min = Integer.MAX_VALUE;
            int[] preSum = getPreSum(nums, length);
            for (int i = 0; i < preSum.length; i++) {
                int target = s + preSum[i];
                int left = 0;
                int right = preSum.length ;


            }
            return min == Integer.MAX_VALUE ? 0 : min;
        }

        /**
         * 获取前缀数组 O(n)
         * @param nums
         * @param length
         * @return
         */
        private int[] getPreSum(int[] nums, int length) {
            int[] preSum = new int[length + 1];
            preSum[0] = 0;
            for (int i = 1; i < preSum.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
            return preSum;
        }

        /**
         * 滑动窗口
         *
         * @param s 目标值
         * @param nums   数组
         * @return
         */
        private int slidingWindowSolution(int s, int[] nums) {
            int min = Integer.MAX_VALUE;
            int sum = 0;
            int left = 0;
            for (int right = 0; right < nums.length; right++) {
                sum += nums[right];
                while (sum >= s) {
                    min = Math.min(min, right - left + 1);
                    sum -= nums[left++];
                }
            }
            return min == Integer.MAX_VALUE ? 0 : min;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
