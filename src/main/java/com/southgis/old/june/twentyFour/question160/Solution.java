package com.southgis.old.june.twentyFour.question160;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 王军
 * @description
 * @date 2021/6/24 21:25
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set=new HashSet<>();
        ListNode h1=headA;
        while (h1 != null) {
            set.add(h1);
            h1=h1.next;
        }
        ListNode h2=headB;
        while (h2 != null) {
            if (set.contains(h2)) {
                return h2;
            }
            h2=h2.next;
        }
        return null;
    }
}