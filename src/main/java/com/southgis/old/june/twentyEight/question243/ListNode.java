package com.southgis.old.june.twentyEight.question243;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author 王军
 * @description
 * @date 2021/6/24 21:24
 */
@Accessors(chain = true)
@Data
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