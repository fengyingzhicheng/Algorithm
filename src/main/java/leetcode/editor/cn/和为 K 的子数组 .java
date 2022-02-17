package leetcode.editor.cn;

//给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
// Related Topics 数组 哈希表 前缀和 👍 1316 👎 0

import java.util.HashMap;
import java.util.Map;

class 和为K的子数组 {
    public static void main(String[] args) {
        Solution solution = new 和为K的子数组().new Solution();
        solution.subarraySum(new int[]{1,-1,0},0);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //前缀和主要适用的场景是原始数组不会被修改的情况下，频繁查询某个区间的累加和。
        public int subarraySum(int[] nums, int k) {
            int[] preSum = new int[nums.length + 1];
            preSum[0] = 0;
            for (int i = 0; i < nums.length; i++) {
                preSum[i + 1] = preSum[i] + nums[i];
            }
            //前缀和一定是升序
            Map<Integer, Integer> map = new HashMap<>();
            int count = 0;
            for (int data : preSum) {
                if (map.get(data - k) != null) {
                    count+=map.get(data - k);
                }
                map.put(data, map.getOrDefault(data, 0) + 1);
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
