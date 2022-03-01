package leetcode.editor.cn;

//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 👍 1658 👎 0

import java.util.HashMap;
import java.util.Map;

class 最小覆盖子串 {
    public static void main(String[] args) {
        Solution solution = new 最小覆盖子串().new Solution();
        solution.minWindow("a", "a");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //TODO 优化 targetMap中
        public String minWindow(String s, String t) {
            String min = "";
            Map<Character, Integer> targetMap = new HashMap<>();
            for (char charData : t.toCharArray()) {
                targetMap.put(charData, targetMap.getOrDefault(charData, 0) + 1);
            }

            Map<Character, Integer> sourceMap = new HashMap<>();
            int left = 0;
            char[] sourceArr = s.toCharArray();
            for (int right = 0; right < sourceArr.length; right++) {
                sourceMap.put(sourceArr[right], sourceMap.getOrDefault(sourceArr[right], 0) + 1);
                while (sourceMap.size() >= targetMap.size() && isValid(sourceMap, targetMap)) {
                    if ("".equals(min) || min.length() > right - left + 1) {
                        min = s.substring(left, right + 1);
                    }

                    Integer defaultData = sourceMap.getOrDefault(sourceArr[left], 0);
                    if (defaultData == 1) {
                        sourceMap.remove(sourceArr[left]);
                    } else {
                        sourceMap.put(sourceArr[left], defaultData - 1);
                    }
                    left++;
                }
            }
            return min;
        }

        private boolean isValid(Map<Character, Integer> sourceMap, Map<Character, Integer> targetMap) {
            for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
                if (sourceMap.get(entry.getKey()) == null) {
                    return false;
                }
                if (sourceMap.get(entry.getKey()) < entry.getValue()) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
