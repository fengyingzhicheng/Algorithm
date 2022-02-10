package leetcode.editor.cn;

//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
//
//
//
// 示例 :
//给定二叉树
//
//           1
//         / \
//        2   3
//       / \
//      4   5
//
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
//
//
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。
// Related Topics 树 深度优先搜索 二叉树 👍 902 👎 0

class 二叉树的最大直径2 {
	public static void main(String[] args) {
		Solution solution = new 二叉树的最大直径2().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)

  //Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
class Solution {
	// 记录最大直径的长度
	int maxDiameter = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		maxDepth(root);
		return maxDiameter;
	}

	int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftMax = maxDepth(root.left);
		int rightMax = maxDepth(root.right);
		// 后序位置顺便计算最大直径
		int myDiameter = leftMax + rightMax;
		maxDiameter = Math.max(maxDiameter, myDiameter);

		return 1 + Math.max(leftMax, rightMax);
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
