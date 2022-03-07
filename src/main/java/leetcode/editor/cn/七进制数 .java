package leetcode.editor.cn;

//给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。 
//
// 
//
// 示例 1: 
//
// 
//输入: num = 100
//输出: "202"
// 
//
// 示例 2: 
//
// 
//输入: num = -7
//输出: "-10"
// 
//
// 
//
// 提示： 
//
// 
// -10⁷ <= num <= 10⁷ 
// 
// Related Topics 数学 👍 124 👎 0

class 七进制数 {
    public static void main(String[] args) {
        Solution solution = new 七进制数().new Solution();
        solution.convertToBase7(-7);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String convertToBase7(int num) {
            if(num==0) return String.valueOf(0);

            StringBuilder sb = new StringBuilder();
            boolean flag=true;
            if (num < 0) {
                num=-num;
                flag=false;
            }

            while (num > 0) {
                int i = num % 7;
                sb.insert(0, i);
                num = num / 7;
            }
            if (!flag) {
                sb.insert(0,'-');
            }

            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
