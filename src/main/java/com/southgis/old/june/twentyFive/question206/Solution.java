package com.southgis.old.june.twentyFive.question206;

/**
 * @author 王军
 * 把头节点拿出来然后头插法 后续的节点
 *
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * @description
 * @date 2021/6/25 9:26
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode h = head.next;
        if (h == null) {
            return head;
        }
        head.next = null;
        while (h != null) {
            ListNode h2 = h.next;
            h.next = head;
            head = h;
            h = h2;
        }
        return head;
    }
}