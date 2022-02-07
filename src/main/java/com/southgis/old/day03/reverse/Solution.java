package com.southgis.old.day03.reverse;

import com.southgis.old.day03.ListNode;

/**
 * @className: reverseList
 * @package: com.southgis.day03.reverse
 * @author: 王军
 * @description: TODO
 * @date: 2020/11/18 17:23
 */
public class Solution {
    public void reverseList(ListNode head) {
        ListNode pre=null;
        ListNode now=head;
        while (now != null) {
            ListNode next=now.next;
            now.next=pre;
            pre=now;
            now=next;
        }
    }
}