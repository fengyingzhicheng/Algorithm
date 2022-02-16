package leetcode.editor.cn;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2364 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class 括号生成 {
    public static void main(String[] args) {
        Solution solution = new 括号生成().new Solution();
        solution.generateParenthesis(3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        public List<String> generateParenthesis(int n) {
            StringBuilder sb = new StringBuilder();
            char[] candidateList = new char[]{'(', ')'};
            backtrack(2 * n, sb, candidateList);
            System.out.println(result);
            return result;
        }

        public void backtrack(int n, StringBuilder stringBuilder, char[] candidateList) {
            if (stringBuilder.length() == n) {
                if (map.get('(').equals(map.get(')'))) {
                    result.add(stringBuilder.toString());
                }
                return;
            }

            for (char candidate : candidateList) {
                if (!isValid(candidate)) {
                    //不合法跳过
                    continue;
                }
                //做选择
                stringBuilder.append(candidate);
                map.put(candidate, map.getOrDefault(candidate, 0) + 1);
                //进入下一层
                backtrack(n, stringBuilder, candidateList);
                //撤销选择
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                map.put(candidate, map.getOrDefault(candidate, 0) - 1);
            }
        }

        /**
         * 检测当前字符( 或者)对 stringBuilder是否合法
         *
         * @param candidate     候选字符
         * @return
         */
        private boolean isValid(char candidate) {
            Integer left = map.getOrDefault('(',0);
            Integer right = map.getOrDefault(')',0);

            if (candidate == '(') {
                left++;
            } else {
                right++;
            }
            return left >= right;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
