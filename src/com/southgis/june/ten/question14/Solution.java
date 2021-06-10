package com.southgis.june.ten.question14;

/**
 * @author 王军
 * @description 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，则返回""
 * 遍历第一个字符串的每次去前缀检查所有数组中字符串是不是以此开始
 * 每次遍历全匹配的更新返回值，不匹配的跳出循环
 *
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
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String returnStr = "";

        int length = strs[0].length();
        for (int i = 0; i < length; i++) {
            String prefix = strs[0].substring(0, i + 1);
            int count = 0;
            for (String str : strs) {
                if (!str.startsWith(prefix)) {
                    break;
                }
                count++;
            }
            if (count == strs.length) {
                returnStr = prefix;
            } else {
                break;
            }
        }

        return returnStr;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        Solution solution = new Solution();

        System.out.println(solution.longestCommonPrefix(strs));
    }
}