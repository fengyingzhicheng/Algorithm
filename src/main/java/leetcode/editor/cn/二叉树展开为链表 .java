package leetcode.editor.cn;

//给你二叉树的根结点 root ，请你将它展开为一个单链表： 
//
// 
// 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。 
// 展开后的单链表应该与二叉树 先序遍历 顺序相同。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,5,3,4,null,6]
//输出：[1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 2000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？ 
// Related Topics 栈 树 深度优先搜索 链表 二叉树 👍 1056 👎 0

class 二叉树展开为链表 {
    public static void main(String[] args) {
        Solution solution = new 二叉树展开为链表().new Solution();
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2, new TreeNode(3, null, null), new TreeNode(4, null, null)),
                new TreeNode(5, null, new TreeNode(6, null, null)));
        solution.flatten(treeNode);
        printTreeNodeRight(treeNode);

    }

    private static void printTreeNodeRight(TreeNode treeNode) {
        while (treeNode != null) {
            System.out.println(treeNode.val);
            treeNode = treeNode.right;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)

    //Definition for a binary tree node.
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
        public void flatten(TreeNode root) {
            if (root == null) {
                return;
            }

            //拉平左侧
            flatten(root.left);
            //拉平右侧
            flatten(root.right);

            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            //root.right遍历到最下面 连接temp
            TreeNode p = root;
            while (p.right != null) {
                p = p.right;
            }
            p.right = temp;
        }


    }

//leetcode submit region end(Prohibit modification and deletion)

}
