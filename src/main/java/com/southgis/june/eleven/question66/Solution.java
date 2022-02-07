package com.southgis.june.eleven.question66;

/**
 * @author 王军
 * @description 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 倒着遍历，如果++为10 对应数组设为0 否则为+1的值（即对10取余数）
 * 如果对应的数字变成了0表示要进位继续遍历 否则应该计算完成了直接返回
 * 对于整个数组遍历完了都没有return表示为[9],[9,9]这种情况 直接新建数组高位为1返回
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 *
 * 输入: [4,3,9,9]
 * 输出: [4,4,0,0]
 * 解释: 输入数组表示数字 4399。
 * @date 2021/6/11 11:16
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        // 针对第三种情况单独讨论
        digits = new int[length + 1];
        digits[0] = 1;
        return digits;
    }
}