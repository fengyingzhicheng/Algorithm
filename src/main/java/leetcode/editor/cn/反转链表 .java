package leetcode.editor.cn;

//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 递归 链表 👍 2260 👎 0

class 反转链表 {
    public static void main(String[] args) {
        Solution solution = new 反转链表().new Solution();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        ListNode listNode1 = solution.reverseN2(listNode, 3);
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)

    //  Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode listNode = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return listNode;
        }

        public ListNode reverseN(ListNode head, int n) {
            if (head == null || head.next == null || n == 1 || n == 0) return head;
            ListNode returnNode = head;
            for (int i = 0; i < n - 1; i++) {
                returnNode = returnNode.next;
            }
            ListNode listNode = reverseN(head, n - 1);
            head.next = returnNode.next;
            returnNode.next = listNode;
            return returnNode;
        }

        public ListNode reverseN2(ListNode head, int n) {
            if (head == null || head.next == null || n == 1 || n == 0) return head;

            // 以 head.next 为起点，需要反转前 n - 1 个节点
            ListNode last = reverseN2(head, n - 1);
            ListNode temp = head.next.next;
            head.next.next = last;
            // 让反转之后的 head 节点和后面的节点连起来
            ListNode returnNode = head.next;
            head.next = temp;
            return returnNode;
        }

        ListNode successor = null; // 后驱节点

        // 反转以 head 为起点的 n 个节点，返回新的头结点
        ListNode reverseN3(ListNode head, int n) {
            if (n == 1) {
                // 记录第 n + 1 个节点
                successor = head.next;
                return head;
            }
            // 以 head.next 为起点，需要反转前 n - 1 个节点
            ListNode last = reverseN3(head.next, n - 1);

            head.next.next = head;
            // 让反转之后的 head 节点和后面的节点连起来
            head.next = successor;
            return last;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
