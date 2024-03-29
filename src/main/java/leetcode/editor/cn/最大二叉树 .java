package leetcode.editor.cn;

//给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建: 
//
// 
// 创建一个根节点，其值为 nums 中的最大值。 
// 递归地在最大值 左边 的 子数组前缀上 构建左子树。 
// 递归地在最大值 右边 的 子数组后缀上 构建右子树。 
// 
//
// 返回 nums 构建的 最大二叉树 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,1,6,0,5]
//输出：[6,3,5,null,2,0,null,null,1]
//解释：递归调用如下所示：
//- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
//    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
//        - 空数组，无子节点。
//        - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
//            - 空数组，无子节点。
//            - 只有一个元素，所以子节点是一个值为 1 的节点。
//    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
//        - 只有一个元素，所以子节点是一个值为 0 的节点。
//        - 空数组，无子节点。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[3,null,2,null,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// nums 中的所有整数 互不相同 
// 
// Related Topics 栈 树 数组 分治 二叉树 单调栈 👍 367 👎 0

class 最大二叉树 {
    public static void main(String[] args) {
        Solution solution = new 最大二叉树().new Solution();
        solution.traverse(new int[]{3, 2, 1, 6, 0, 5}, 4, 5);
    }
//leetcode submit region begin(Prohibit modification and deletion)

    //  Definition for a binary tree node.
    public static class TreeNode {
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

        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return traverse(nums, 0, nums.length - 1);
        }


        public TreeNode traverse(int[] nums, int left, int right) {
            if (left < 0 || right > nums.length - 1 || left > right) {
                return null;
            }
            TreeNode root = new TreeNode();
            if (right == left) {
                root.val = nums[left];
                return root;

            }

            int maxIndex = left;
            int maxData = nums[left];

            //找到maxIndex
            for (int i = left; i <= right; i++) {
                if (maxData < nums[i]) {
                    maxData = nums[i];
                    maxIndex = i;
                }
            }
            root.val = maxData;
            root.left = traverse(nums, left, maxIndex - 1);
            root.right = traverse(nums, maxIndex + 1, right);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
