package com.southgis.old.day03.huiwen;

import com.southgis.old.day03.ListNode;

/**
 * @className: Solution
 * @package: com.southgis.code03
 * @author: 王军
 * @description: 判断单链表的字符串是否为回文 正读反着读一样
 * @date: 2020/11/18 14:32
 */
public class Solution {
    public static void main(String[] args) {

    }
    /**
     * 基本思想：
     * 快指针每次移动两格 慢指针每次移动一格 最终慢指针位置就是中间位置
     * 移动满指针过程 逆序前面的链表 设置了一个prev指针 这个就是前链表
     * 指针的开始位置 后链表的开始位置可以根据快指针位置确定总链表奇数
     * 还是偶数进而判断后链表与慢指针位置关系 遍历前后链表即可判断
     * <p>
     * 为了防止逆序前面的链表 使用过程可以使用栈记录前面遍历的数据
     * 然后弹栈与后面的链表比较
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) { //log2^N
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        if (fast != null) {//原来链表为偶数个
            slow = slow.next;
        }
        while (slow != null) {
            if (slow.value != prev.value) return false;
            slow = slow.next;
            prev = prev.next;
        }
        return true;
    }
}