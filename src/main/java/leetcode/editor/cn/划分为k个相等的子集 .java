package leetcode.editor.cn;

//给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。 
//
// 示例 1： 
//
// 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//输出： True
//说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= len(nums) <= 16 
// 0 < nums[i] < 10000 
// 
// Related Topics 位运算 记忆化搜索 数组 动态规划 回溯 状态压缩 👍 496 👎 0

import java.util.Arrays;

/**
 * 每个数字去选择桶
 */
class 划分为k个相等的子集数字视角 {
    public static void main(String[] args) {
        Solution solution = new 划分为k个相等的子集数字视角().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            // 排除一些基本情况
            if (k > nums.length) return false;

            int sum = 0;
            for (int v : nums) sum += v;
            if (sum % k != 0) return false;
            // 理论上每个桶（集合）中数字的和
            int target = sum / k;

            int[] buckets = new int[k];

            /* 降序排序 nums 数组 */
            Arrays.sort(nums);
            for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
                // 交换 nums[i] 和 nums[j]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            /*******************/
            return backtrack(nums, buckets, 0, target);
        }

        boolean backtrack(int[] nums, int[] buckets, int index, int target) {
            if (index == nums.length) {
                //指向最后一个
                // 检查所有桶的数字之和是否都是 target
                for (int bucket : buckets) {
                    if (bucket != target) {
                        return false;
                    }
                }
                // nums 成功平分成 k 个子集
                return true;
            }

            //穷举选择列表 要选择的是很多桶中的一个
            for (int i = 0; i < buckets.length; i++) {
                // 剪枝
                if (nums[index] > target) {
                    break;
                }
                // 剪枝，桶装装满了
                if (buckets[i] + nums[index] > target) {
                    continue;
                }

                //做选择
                buckets[i] += nums[index];
                //进入下一层
                if (backtrack(nums, buckets, index + 1, target)) {
                    return true;
                }
                //撤销选择
                buckets[i] -= nums[index];
                // 剪枝
                if (buckets[i] == 0) break;
            }
            //剪枝
            // nums[index] 装入哪个桶都不行
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}

class 划分为k个相等的子集桶视角 {
    public static void main(String[] args) {
        Solution solution = new 划分为k个相等的子集桶视角().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            // 排除一些基本情况
            if (k > nums.length) return false;

            int sum = 0;
            for (int v : nums) sum += v;
            if (sum % k != 0) return false;
            // 理论上每个桶（集合）中数字的和
            int target = sum / k;


            /* 降序排序 nums 数组 */
            Arrays.sort(nums);
            for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
                // 交换 nums[i] 和 nums[j]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            /*******************/
            int bucket = 0;
            return backtrack(nums, bucket, 0, target);
        }

        private boolean backtrack(int[] nums, int bucket, int index, int target) {

            //TODO
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
