package leetcode.editor.cn;

//给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,2,1]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围[1, 10⁵] 内 
// 0 <= Node.val <= 9 
// 
//
// 
//
// 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 👍 1252 👎 0

class 回文链表{
	public static void main(String[] args) {
		Solution solution = new 回文链表().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)

//  Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
	// 左侧指针
	ListNode left;

    public boolean isPalindrome(ListNode head) {
		left = head;
		return traverse(head);
    }

	/**
	 * 链表的后序遍历相当于压栈 回退后执行后序遍历代码 right一直移动到 null 然后回退打印左侧
	 * @param right
	 * @return
	 */
	boolean traverse(ListNode right) {
		if (right == null) return true;
		boolean res = traverse(right.next);
		// 后序遍历代码
		res = res && (right.val == left.val);
		left = left.next;
		return res;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
