package com.southgis.june.twentySeven.question445;

import org.junit.Test;

/**
 * @author 王军
 * 解：带反转链表的解法 反转两个链表 顺序遍历相加找出最长的链表 从头遍历 大于10进1 最后一位小于十
 * 然后反转 大于十新建一个1的节点指向反转后的链表
 *
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
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode h1 = l1;
        ListNode h2 = l2;

        while (h1.next != null && h2.next != null) {
            int val = h1.val + h2.val;
            h1.val = val;
            h2.val = val;
            h1 = h1.next;
            h2 = h2.next;
        }
        ListNode maxNode;
        if (h1.next == null) {
            h2.val = h1.val + h2.val;
            maxNode = l2;
        } else {
            h1.val = h1.val + h2.val;
            maxNode = l1;
        }

        ListNode p = maxNode;
        boolean flag = false;
        while (p != null) {
            if (flag) {
                flag = (p.val + 1) >= 10;
                p.val = (p.val + 1) % 10;
            } else {
                flag = p.val >= 10;
                p.val = p.val % 10;
            }
            p = p.next;
        }
        if (flag) {
            return new ListNode(1, reverseList(maxNode));
        }

        return reverseList(maxNode);
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    @Test
    public void testAddNumber() {
        Solution solution = new Solution();
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

    @Test
    public void testAddNumber_bug() {
        Solution solution = new Solution();
        ListNode l1 = new ListNode().setVal(2).setNext(
                new ListNode().setVal(4).setNext(
                        new ListNode().setVal(3).setNext(null)
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