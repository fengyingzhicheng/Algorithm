package leetcode.editor.cn;

//给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。 
//
// 二叉搜索树的定义如下： 
//
// 
// 任意节点的左子树中的键值都 小于 此节点的键值。 
// 任意节点的右子树中的键值都 大于 此节点的键值。 
// 任意节点的左子树和右子树都是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
//输出：20
//解释：键值为 3 的子树是和最大的二叉搜索树。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [4,3,null,1,2]
//输出：2
//解释：键值为 2 的单节点子树是和最大的二叉搜索树。
// 
//
// 示例 3： 
//
// 
//输入：root = [-4,-2,-5]
//输出：0
//解释：所有节点键值都为负数，和最大的二叉搜索树为空。
// 
//
// 示例 4： 
//
// 
//输入：root = [2,1,3]
//输出：6
// 
//
// 示例 5： 
//
// 
//输入：root = [5,4,8,3,null,6,3]
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// 每棵树有 1 到 40000 个节点。 
// 每个节点的键值在 [-4  10^4 , 4  10^4] 之间。 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 动态规划 二叉树 👍 79 👎 0

class 二叉搜索子树的最大键值和 {
    public static void main(String[] args) {
        Solution solution = new 二叉搜索子树的最大键值和().new Solution();

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
        int max;

        public int maxSumBST(TreeNode root) {
            traverseAndCalculate(root);
            //遍历这个树 在遍历中更新max
            return max;
        }


        private Result traverseAndCalculate(TreeNode root) {
            if (root == null) {
                return new Result(true, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
            }

            Result left = traverseAndCalculate(root.left);
            Result right = traverseAndCalculate(root.right);

            Result local = new Result();
            if (left.isBst && right.isBst) {
                if (root.val > left.max && root.val < right.min) {
                    local.setBst(true);
                    local.setMin(Math.min(root.val,left.min));
                    local.setMax(Math.max(root.val,right.max));
                    local.setSum(left.sum + right.sum + root.val);
                    max = Math.max(max, local.getSum());
                } else {
                    local.setBst(false);
                }
            } else {
                //标记当前结点为树根节点不是BST
                local.setBst(false);
            }
            return local;
        }
    }

    class Result {

        public Result(boolean isBst, int max, int min, int sum) {
            this.isBst = isBst;
            this.max = max;
            this.min = min;
            this.sum = sum;
        }

        public Result() {
        }

        public boolean isBst() {
            return isBst;
        }

        public void setBst(boolean bst) {
            isBst = bst;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getSum() {
            return sum;
        }

        public void setSum(int sum) {
            this.sum = sum;
        }

        /**
         * 是否是二叉搜索树
         */
        boolean isBst;

        /**
         * 二叉搜索树中的最大值
         */
        int max;
        /**
         * 二叉搜索树中的最小值
         */
        int min;
        /**
         * 当前结点二叉搜索树的和
         */
        int sum;

    }
//leetcode submit region end(Prohibit modification and deletion)

}
