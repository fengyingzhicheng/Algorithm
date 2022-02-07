package com.southgis.june.thirteen.question6;

import java.util.Arrays;

/**
 * @author 王军
 * @description 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * 使用numRows个字符串数组 遍历char数组，找到对应的char字符在字符串中的位置，然后合并字符串数组得到结果
 * 这里寻找轨迹（字符对应位置）为向下为字符串数组索引变为++，斜向上为--
 * <p>
 * 猜想：一个倒三角为 2n-1长，不考虑中间，下一个位置为2(n-1)=>eg2:L->0 D:6,E->1 E->7
 * <p>
 * 输入：s="LEETCODEISHIRING"，numRows=3=>length=16
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * =>LCIRETOESIIGEDHN
 * <p>
 * 输入：s = "LEETCODEISHIRING", numRows = 4=>length=16 16%4==0
 * L     D     R    ->3
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * 输入：s = "LEETCODEISHIRING", numRows = 5=>length=16->2*5=3
 * L       I         ->2
 * E     E S    G
 * E   D   H   N
 * T O     I I
 * C       R
 * =>LDREOEIIECIHNTSG
 * @date 2021/6/13 10:55
 */
public class Solution2 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        String[] arr = new String[numRows];
        Arrays.fill(arr, "");
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            arr[i] += c;

            //往下i++;往斜侧方i--
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (String ch : arr) {
            res.append(ch);
        }
        return res.toString();
}

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String s="LEETCODEISHIRING";
        System.out.println(solution.convert(s,4));
        System.out.println(solution.convert(s,5));
    }
}