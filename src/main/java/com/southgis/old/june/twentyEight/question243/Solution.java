package com.southgis.old.june.twentyEight.question243;

import edu.princeton.cs.algs4.Stack;

/**
 * @author 王军
 * 请判断一个链表是否为回文链表。
 * TODO 解法进阶
 *
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * @description
 * @date 2021/6/28 10:22
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = buildStack(head);
        ListNode p=head;
        while (!stack.isEmpty() && p != null) {
            ListNode end=stack.pop();
            if (end.val != p.val) {
                return false;
            }
            p=p.next;
        }
        return true;
    }

    private Stack<ListNode> buildStack(ListNode l) {
        Stack<ListNode> stack = new Stack<>();
        while (l != null) {
            stack.push(l);
            l = l.next;
        }
        return stack;
    }
}