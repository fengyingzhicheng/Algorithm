package com.southgis.june.twentyFive.question83;

/**
 * @author 王军
 * 两个指针 h1在后面 h2在前面 相等的话h2前进 不相等的时候 判断两个相不相邻 相邻两个同时前进 不相邻h1接到h2前面
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * @description
 * @date 2021/6/25 16:46
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode h1 = head;
        ListNode h2 = head.next;

        while (h2 != null) {
            if (h1.val == h2.val) {
                h2 = h2.next;
            } else {
                if (h1.next != h2) {
                    h1.next = h2;
                } else {
                    h1 = h1.next;
                    h2 = h2.next;
                }

            }
        }
        if (h1.val == h1.next.val) {
            h1.next=null;
        }

        return head;
    }
}