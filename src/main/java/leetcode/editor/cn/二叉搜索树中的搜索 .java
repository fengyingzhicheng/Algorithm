package leetcode.editor.cn;

//给定二叉搜索树（BST）的根节点 root 和一个整数值 val。 
//
// 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：root = [4,2,7,1,3], val = 2
//输出：[2,1,3]
// 
//
// Example 2: 
//
// 
//输入：root = [4,2,7,1,3], val = 5
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 数中节点数在 [1, 5000] 范围内 
// 1 <= Node.val <= 10⁷ 
// root 是二叉搜索树 
// 1 <= val <= 10⁷ 
// 
// Related Topics 树 二叉搜索树 二叉树 👍 237 👎 0

/**
 * 二叉搜索树(BST)的搜索 新增 删除
 */
class 二叉搜索树中的搜索 {
    public static void main(String[] args) {
        Solution solution = new 二叉搜索树中的搜索().new Solution();

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
        public TreeNode searchBST(TreeNode root, int val) {
            if (root == null) {
                return null;
            }
            if (root.val == val) {
                return root;
            }

            if (root.val > val) {
                return searchBST(root.left, val);
            } else {
                return searchBST(root.right, val);
            }
        }

        TreeNode searchBST2(TreeNode root, int target) {
            if (root == null) {
                return null;
            }
            // 去左子树搜索
            if (root.val > target) {
                return searchBST2(root.left, target);
            }
            // 去右子树搜索
            if (root.val < target) {
                return searchBST2(root.right, target);
            }
            return root;
        }

        /**
         * 二叉树的插入
         *
         * @param root
         * @param val
         * @return
         */
        TreeNode insertIntoBST(TreeNode root, int val) {
            // 找到空位置插入新节点
            if (root == null) return new TreeNode(val);
            // if (root.val == val)
            //     BST 中一般不会插入已存在元素
            if (root.val < val)
                root.right = insertIntoBST(root.right, val);
            if (root.val > val)
                root.left = insertIntoBST(root.left, val);
            return root;
        }

        TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return null;
            if (root.val == key) {
                //要删除当前结点 且当前结点为叶子
                if (root.left == null && root.right == null) {
                    return null;
                }
                //要删除当前结点 且当前结点只有左或者右
                if (root.left == null || root.right == null) {
                    return root;
                }
                //要删除当前结点 且当前结点左右都有
                //遍历右结点找到 最小值 交换 然后删除 最小值所在结点
                // 处理情况 3
                // 获得右子树最小的节点
                TreeNode minNode = getMin(root.right);
                // 删除右子树最小的节点
                root.right = deleteNode(root.right, minNode.val);
                // 用右子树最小的节点替换 root 节点
                minNode.left = root.left;
                minNode.right = root.right;
                root = minNode;

                // 找到啦，进行删除
            } else if (root.val > key) {
                // 去左子树找
                root.left = deleteNode(root.left, key);
            } else {
                // 去右子树找
                root.right = deleteNode(root.right, key);
            }
            return root;
        }

        TreeNode getMin(TreeNode node) {
            // BST 最左边的就是最小的
            while (node.left != null) node = node.left;
            return node;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
