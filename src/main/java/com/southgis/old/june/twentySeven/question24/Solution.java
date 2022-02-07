package com.southgis.old.june.twentySeven.question24;

/**
 * @author 王军
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 输入：head = []
 * 输出：[]
 * 输入：head = [1]
 * 输出：[1]
 * @description
 * @date 2021/6/27 20:12
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head.next;
        head.next = swapPairs(head.next.next);
        p.next = head;
        return p;
    }
}