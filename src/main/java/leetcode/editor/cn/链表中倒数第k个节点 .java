package leetcode.editor.cn;

//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。 
//
// 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。 
//
// 
//
// 示例： 
//
// 
//给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针 👍 323 👎 0

class 链表中倒数第k个节点 {
    public static void main(String[] args) {
        Solution solution = new 链表中倒数第k个节点().new Solution();

    }
//leetcode submit region begin(Prohibit modification and deletion)

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
			ListNode p1 = head;
			// p1 先走 k 步
			for (int i = 0; i < k; i++) {
				p1 = p1.next;
			}
			ListNode p2 = head;
			// p1 和 p2 同时走 n - k 步
			while (p1 != null) {
				p2 = p2.next;
				p1 = p1.next;
			}
			// p2 现在指向第 n - k 个节点
			return p2;
		}

		//my solution
		private ListNode getListNode(ListNode head, int k) {
			ListNode p = head;
			ListNode q = null;
			while (p != null) {
				k--;

				if (k == 0) {
					q = head;
				}else if (k < 0) {
					if (q == null) {
						return null;
					}
					q = q.next;
				}
				p = p.next;
			}

			return q;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
