package leetcode.editor.cn;

//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 👍 1480 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class 子集 {
    public static void main(String[] args) {
        Solution solution = new 子集().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            LinkedList<Integer> tracks = new LinkedList<>();
            backtrack(nums, 0, tracks);
            return result;
        }

        /**
         *
         * @param nums 遍历的数据源
         * @param index 本次遍历开始的位置
         * @param tracks 当前集合
         */
        private void backtrack(int[] nums, int index, LinkedList<Integer> tracks) {
            result.add(new ArrayList<>(tracks));
            for (int i = index; i < nums.length; i++) {
                tracks.add(nums[i]);
                //做选择
                backtrack(nums, i + 1, tracks);
                //撤销选择
                tracks.removeLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
