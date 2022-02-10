package leetcode.editor.cn;

//给定一棵二叉树 root，返回所有重复的子树。 
//
// 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。 
//
// 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,null,2,4,null,null,4]
//输出：[[2,4],[4]] 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,1]
//输出：[[1]] 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [2,2,2,3,null,3,null]
//输出：[[2,3],[3]] 
//
// 
//
// 提示： 
//
// 
// 树中的结点数在[1,10^4]范围内。 
// -200 <= Node.val <= 200 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 366 👎 0

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class 寻找重复的子树{
	public static void main(String[] args) {
		Solution solution = new 寻找重复的子树().new Solution();
		
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
	// 记录所有子树以及出现的次数
	HashMap<String, Integer> memo = new HashMap<>();
	// 记录重复的子树根节点
	LinkedList<TreeNode> res = new LinkedList<>();

	/* 主函数 */
	List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		traverse(root);
		return res;
	}

	/* 辅助函数 */
	String traverse(TreeNode root) {
		if (root == null) {
			return "#";
		}

		String left = traverse(root.left);
		String right = traverse(root.right);

		//后序遍历
		//不同二叉树的唯一序列化
		String subTree = left + "," + right+ "," + root.val;

		int freq = memo.getOrDefault(subTree, 0);
		// 多次重复也只会被加入结果集一次
		if (freq == 1) {
			res.add(root);
		}
		// 给子树对应的出现次数加一
		memo.put(subTree, freq + 1);
		return subTree;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
