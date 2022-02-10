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

class 回文链表 {
    public static void main(String[] args) {
        Solution solution = new 回文链表().new Solution();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1, null))));
         printNode(listNode);
        System.out.println("\n");
        System.out.print("测试回文后");
        solution.isPalindrome2(listNode);
        printNode(listNode);
        System.out.println("\n");

    }

    private static ListNode printNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
        return listNode;
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
        // 左侧指针
        ListNode left;

        public boolean isPalindrome(ListNode head) {
            left = head;
            return traverse(head);
        }

        /**
         * 链表的后序遍历相当于压栈 回退后执行后序遍历代码 right一直移动到 null 然后回退打印左侧
         *
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

        //快慢指针 找到终点 然后反转后面的链表 再双指针前进 判断是否相等
        public boolean isPalindrome2(ListNode head) {
            if (head == null) {
                return true;
            }

            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            //奇数的话 fast!=null slow在中点 偶数的话fast==null slow在中间靠右
            if (fast != null) {
                //奇数 slow右移动一下
                slow = slow.next;
            }

            //然后反转slow为头的链表
            ListNode rightListNode = reverse(slow);

            ListNode left = head;
            ListNode successor = left;
            ListNode right = rightListNode;
            while (right != null) {
                if (left.val != right.val) {
                    return false;
                }
                successor = left;
                left = left.next;
                right = right.next;
            }
            //恢复链表
            rightListNode=reverse(rightListNode);
            successor.next = rightListNode;
            return true;
        }

        private ListNode reverse(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode reverse = reverse(head.next);
            head.next.next=head;
            head.next=null;
            return reverse;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
