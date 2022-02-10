package leetcode.editor.cn;

/**
 * @author 王军
 * @description $%$ 通过增加函数参数可以讲 约束传递给遍历的子树
 * @date 2022/2/10 15:30
 */
public class 判断BST的合法性 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode =
                new TreeNode(10,
                        new TreeNode(5, null, null),
                        new TreeNode(15,
                                new TreeNode(11, null, null),
                                new TreeNode(20, null, null)));
        System.out.println(solution.isValidBST(treeNode));
    }


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


    static class Solution {
        boolean isValidBST(TreeNode root) {
            return isValidBST(root, null, null);
        }

        /**
         * 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val
         */
        boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
            // base case
            if (root == null) {
                return true;
            }
            // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
            if (min != null && root.val <= min.val) {
                return false;
            }
            if (max != null && root.val >= max.val) {
                return false;
            }
            // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
            return isValidBST(root.left, min, root)
                    && isValidBST(root.right, root, max);
        }
    }
}