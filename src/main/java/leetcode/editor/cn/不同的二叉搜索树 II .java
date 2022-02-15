package leetcode.editor.cn;

//给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// 
// 
// Related Topics 树 二叉搜索树 动态规划 回溯 二叉树 👍 1121 👎 0

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class 不同的二叉搜索树II {
    public static void main(String[] args) {
        Solution solution = new 不同的二叉搜索树II().new Solution();

    }
//leetcode submit region begin(Prohibit modification and deletion)

    //  Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {


        public List<TreeNode> generateTrees(int n) {
            return generateTrees(1, n);
        }

        /**
         * 生成树
         * @param left
         * @param right
         * @return
         */
        public List<TreeNode> generateTrees(int left, int right) {
            List<TreeNode> res = new LinkedList<>();
            // base case
            if (left > right) {
                res.add(null);
                return res;
            }

            // 1、穷举 root 节点的所有可能。
            for (int i = left; i <= right; i++) {
                // 2、递归构造出左右子树的所有合法 BST。
                List<TreeNode> leftTrees = generateTrees(left, i - 1);
                List<TreeNode> rightTrees = generateTrees(i + 1, right);
                // 3、给 root 节点穷举所有左右子树的组合。
                for (TreeNode leftTree : leftTrees) {
                    for (TreeNode rightTree : rightTrees) {
                        // i 作为根节点 root 的值
                        TreeNode root = new TreeNode(i);
                        root.left = leftTree;
                        root.right = rightTree;
                        res.add(root);
                    }
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
