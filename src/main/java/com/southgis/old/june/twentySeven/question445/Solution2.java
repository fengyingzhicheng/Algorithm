package com.southgis.old.june.twentySeven.question445;

import edu.princeton.cs.algs4.Stack;
import org.junit.Test;

/**
 * @author 王军
 * 解：逆序处理首先想到要用栈处理
 * <p>
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。
 * 它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 进阶：
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 * @description
 * @date 2021/6/27 20:25
 */
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = buildStack(l1);
        Stack<Integer> l2Stack = buildStack(l2);
        ListNode head = new ListNode(-1);
        int carry = 0;
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry != 0) {
            int x = l1Stack.isEmpty() ? 0 : l1Stack.pop();
            int y = l2Stack.isEmpty() ? 0 : l2Stack.pop();
            int sum = x + y + carry;
            ListNode node = new ListNode(sum % 10);
            node.next = head.next;
            head.next = node;
            carry = sum / 10;
        }
        return head.next;
    }

    private Stack<Integer> buildStack(ListNode l) {
        Stack<Integer> stack = new Stack<>();
        while (l != null) {
            stack.push(l.val);
            l = l.next;
        }
        return stack;
    }


    @Test
    public void testAddNumber() {
        Solution2 solution = new Solution2();
        ListNode l1 = new ListNode().setVal(7).setNext(
                new ListNode().setVal(2).setNext(
                        new ListNode().setVal(4).setNext(
                                new ListNode().setVal(3).setNext(null)
                        )
                )
        );

        ListNode l2 = new ListNode().setVal(5).setNext(
                new ListNode().setVal(6).setNext(
                        new ListNode().setVal(4).setNext(null)
                )
        );

        solution.addTwoNumbers(l1, l2);
    }

}