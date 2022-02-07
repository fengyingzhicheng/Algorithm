package com.southgis.june.twentyFour.question160;

import lombok.EqualsAndHashCode;

/**
 * @author 王军
 * @description
 * @date 2021/6/24 21:24
 */
@EqualsAndHashCode
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}