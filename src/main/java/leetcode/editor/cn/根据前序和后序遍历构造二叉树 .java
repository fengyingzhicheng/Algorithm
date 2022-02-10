package leetcode.editor.cn;

//返回与给定的前序和后序遍历匹配的任何二叉树。 
//
// pre 和 post 遍历中的值是不同的正整数。 
//
// 
//
// 示例： 
//
// 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
//输出：[1,2,3,4,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pre.length == post.length <= 30 
// pre[] 和 post[] 都是 1, 2, ..., pre.length 的排列 
// 每个输入保证至少有一个答案。如果有多个答案，可以返回其中一个。 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 220 👎 0

class 根据前序和后序遍历构造二叉树 {
    public static void main(String[] args) {
        Solution solution = new 根据前序和后序遍历构造二叉树().new Solution();

    }
//leetcode submit region begin(Prohibit modification and deletion)

    //Definition for a binary tree node.
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
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            return build(preorder, 0, preorder.length - 1,
                    postorder, 0, postorder.length - 1);
        }

        // 定义：根据 preorder[preStart..preEnd] 和 postorder[postStart..postEnd]
        // 构建二叉树，并返回根节点。
        TreeNode build(int[] preorder, int preStart, int preEnd,
                       int[] postorder, int postStart, int postEnd) {
            //base case
            if (preStart > preEnd) {
                return null;
            }
            if (preStart == preEnd) {
                return new TreeNode(preorder[preStart]);
            }
            //下面逻辑 数组应该是大于2的 所以双指针相等要判断 base case

            // root 节点对应的值就是前序遍历数组的第一个元素
            int rootVal = preorder[preStart];
            // root.left 的值是前序遍历第二个元素
            // 通过前序和后序遍历构造二叉树的关键在于通过左子树的根节点
            // 确定 preorder 和 postorder 中左右子树的元素区间
            int leftRootVal = preorder[preStart + 1];
            // leftRootVal 在后序遍历数组中的索引
            int index = 0;
            for (int i = postStart; i < postEnd; i++) {
                if (postorder[i] == leftRootVal) {
                    index = i;
                    break;
                }
            }
            // 左子树的元素个数
            int leftSize = index - postStart + 1;

            // 先构造出当前根节点
            TreeNode root = new TreeNode(rootVal);
            // 递归构造左右子树
            // 根据左子树的根节点索引和元素个数推导左右子树的索引边界
            root.left = build(preorder, preStart + 1, preStart + leftSize,
                    postorder, postStart, index);
            root.right = build(preorder, preStart + leftSize + 1, preEnd,
                    postorder, index + 1, postEnd - 1);

            return root;
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}
