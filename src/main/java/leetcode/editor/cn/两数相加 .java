package leetcode.editor.cn;

//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
// Related Topics 递归 链表 数学 👍 7436 👎 0

class 两数相加 {
    public static void main(String[] args) {
        Solution solution = new 两数相加().new Solution();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(9)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9))));
        solution.addTwoNumbers(l1, l2);
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            //保证 l1最长
            ListNode p = l1;
            ListNode q = l2;

            while (p != null && q != null) {
                p = p.next;
                q = q.next;
            }
            if (p == null) {
                ListNode temp = l1;
                l1 = l2;
                l2 = temp;
            }
            //l2的值累加到l1上

            p = l1;
            q = l2;

            int data = 0;
            while (p != null && q != null) {
                //余数
                int temp = p.val;
                p.val = (p.val + q.val + data) % 10;
                data = (temp + q.val + data) / 10;
                p = p.next;
                q = q.next;
            }

            while (p != null) {
                int temp = p.val;
                p.val = (p.val + data) % 10;
                data = (temp + data) / 10;
                p = p.next;
            }

            if (data != 0) {
                p = l1;
                while (p.next != null) {
                    p = p.next;
                }
                ListNode addNode = new ListNode();
                addNode.val = data;
                p.next = addNode;
            }

            //最后返回 l1
            return l1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
