package leetcode.editor.cn;

//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// Related Topics 字符串 👍 221 👎 0

class 替换空格{
	public static void main(String[] args) {
		Solution solution = new 替换空格().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
		if (s == null) {
			return null;
		}
		//选用 StringBuilder 单线程使用，比较快，选不选都行
		StringBuilder sb = new StringBuilder();
		//使用 sb 逐个复制 s ，碰到空格则替换，否则直接复制
		for (int i = 0; i < s.length(); i++) {
			//s.charAt(i) 为 char 类型，为了比较需要将其转为和 " " 相同的字符串类型
			//if (" ".equals(String.valueOf(s.charAt(i)))){
			if (s.charAt(i) == ' ') {
				sb.append("%20");
			} else {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
