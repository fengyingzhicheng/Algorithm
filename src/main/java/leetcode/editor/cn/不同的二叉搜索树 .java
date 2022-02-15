package leetcode.editor.cn;

//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 1539 👎 0

class 不同的二叉搜索树 {
    public static void main(String[] args) {
        Solution solution = new 不同的二叉搜索树().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 备忘录
        int[][] memo;
        public int numTrees(int n) {
            // 备忘录的值初始化为 0
            memo = new int[n + 1][n + 1];
            return count(1, n);
        }

        /**
         * 计算从左到右有几种BST组合
         *
         * @param left
         * @param right
         * @return
         */
        int count(int left, int right) {
            //base case
            if (left > right) {
                return 1;
            }
            // 查备忘录
            if (memo[left][right] != 0) {
                return memo[left][right];
            }

            int sum = 0;
            for (int i = left; i <= right; i++) {
                int leftCount = count(left, i - 1);
                int rightCount = count(i + 1, right);
                sum += leftCount * rightCount;
            }
            memo[left][right]=sum;
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
