package com.southgis.old.question14;

/**
 * @author 王军
 * @description 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，则返回""
 * 当字符串数组长度为 0 时则公共前缀为空，直接返回
 * 令最长公共前缀 ans 的值为第一个字符串，进行初始化
 * 遍历后面的字符串，依次将其与 ans 进行比较，更新公共前缀，最终结果即为最长公共前缀
 * 如果查找过程中出现了 ans 为空的情况，则公共前缀不存在直接返回
 * 时间复杂度：O(s)O(s)，s 为所有字符串的长度之和
 * <p>
 * <p>
 * 说明：
 * 所有输入只包含小写字母 a-z
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * @date 2021/6/10 16:40
 */
public class Solution2 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;

            //截取得公共前缀 指针指两个链表不等跳出
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            //根据指针位置拿前缀
            ans = ans.substring(0, j);


            if ("".equals(ans)) {
                return ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        Solution2 solution = new Solution2();

        System.out.println(solution.longestCommonPrefix(strs));
    }
}