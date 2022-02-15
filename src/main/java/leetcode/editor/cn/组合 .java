package leetcode.editor.cn;

//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。 
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 数组 回溯 👍 861 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class 组合 {
    public static void main(String[] args) {
        Solution solution = new 组合().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            LinkedList<Integer> track = new LinkedList<>();
            backtrack(n, 1, track, k);
            return result;
        }

        private void backtrack(int n, int index, LinkedList<Integer> track, int k) {
            if (track.size() == k) {
                result.add(new ArrayList<>(track));
            }

            for (int i = index; i <= n; i++) {
                //做选择
                track.add(i);
                backtrack(n, i + 1, track, k);
                track.removeLast();
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
