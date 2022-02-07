package com.southgis.old.june.twentyFive.question83;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author 王军
 * @description
 * @date 2021/6/24 21:24
 */
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}