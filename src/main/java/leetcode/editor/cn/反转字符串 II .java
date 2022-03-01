package leetcode.editor.cn;

//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文组成 
// 1 <= k <= 10⁴ 
// 
// Related Topics 双指针 字符串 👍 254 👎 0

class 反转字符串II {
    public static void main(String[] args) {
        Solution solution = new 反转字符串II().new Solution();
        solution.reverseStr("abcd", 4);
        solution.reverseStr("abcdefg", 8);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            int fast = 0;
            char[] chars = s.toCharArray();
            int length = chars.length;
            while (fast < length) {
                int slow = fast;
                int last = slow;
                while (slow < length && slow - last < k) {
                    fast += 2;
                    slow++;
                }
                if (slow - last == k || slow == length) {
                    int left = last;
                    int right = slow - 1;
                    while (left < right) {
                        char temp = chars[left];
                        chars[left] = chars[right];
                        chars[right] = temp;
                        left++;
                        right--;
                    }

                }

            }
            return String.copyValueOf(chars);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
