package leetcode.editor.cn;

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 4366 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class 三数之和 {
    public static void main(String[] args) {
        Solution solution = new 三数之和().new Solution();
        solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //[-1,0,1,2,-1,-4]
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null || nums.length < 3) return result;
            Arrays.sort(nums);
            int length = nums.length;
            for (int i = 0; i < length; i++) {
                if (nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
                if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重

                int left = i + 1;
                int right = length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right] + nums[i];
                    if (sum < 0) {
                        left++;
                    } else if (sum > 0) {
                        right--;
                    } else {
                        result.add(Arrays.asList(nums[left], nums[right], nums[i]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
