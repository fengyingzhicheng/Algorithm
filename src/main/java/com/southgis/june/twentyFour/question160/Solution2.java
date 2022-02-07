package com.southgis.june.twentyFour.question160;

/**
 * @author 王军
 * 解：设 A 的长度为 a + c，B 的长度为 b + c，其中 c 为尾部公共部分长度，可知 a + c + b = b + c + a。
 * 如果c等于0 同时为null此时跳出循环返回任意一个null
 *
 * 当访问 A 链表的指针访问到链表尾部时，令它从链表 B 的头部开始访问链表 B；
 * 同样地，当访问 B 链表的指针访问到链表尾部时，令它从链表 A 的头部开始访问链表 A。
 * 这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。
 *
 *
 * 如果只是判断是否存在交点。有两种解法: 把第一个链表的结尾连接到第二个链表的开头，看第二个链表是否存在环；
 * 或者直接比较两个链表的最后一个节点是否相同。
 * @description
 * @date 2021/6/24 21:25
 */
public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }
}