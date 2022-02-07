package com.southgis.june.twentyFive.question83;

/**
 * @author 王军
 * 我们从指针 {cur}cur 指向链表的头节点，随后开始对链表进行遍历。
 * 如果当前 {cur}cur 与 {cur.next}cur.next 对应的元素相同，
 * 那么我们就将 {cur.next}cur.next 从链表中移除；
 * 否则说明链表中已经不存在其它与 {cur}cur 对应的元素相同的节点，
 * 因此可以将 {cur}cur 指向 {cur.next}cur.next。

 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * @description
 * @date 2021/6/25 16:46
 */
public class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}