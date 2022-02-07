package com.southgis.old.june.twentySeven.question19;

/**
 * @author 王军
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * 一趟遍历
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @description
 * @date 2021/6/27 19:51
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null) {
            return null;
        }
        ListNode pre=head;
        ListNode end=pre;
        while (n != 0) {
            end=end.next;
            n--;
        }
        if (end == null) {
            return head.next;
        }

        while (end.next != null) {
            pre=pre.next;end=end.next;
        }
        pre.next=pre.next.next;
        return head;
    }
}