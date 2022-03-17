package leetcode.editor.cn;

//给定一个表示数据的整数数组 data ，返回它是否为有效的 UTF-8 编码。 
//
// UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则： 
//
// 
// 对于 1 字节 的字符，字节的第一位设为 0 ，后面 7 位为这个符号的 unicode 码。 
// 对于 n 字节 的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为 0 ，后面字节的前两位一律设为 10 。剩下的没有提及的二进制
//位，全部为这个符号的 unicode 码。 
// 
//
// 这是 UTF-8 编码的工作方式： 
//
// 
//   Char. number range  |        UTF-8 octet sequence
//      (hexadecimal)    |              (binary)
//   --------------------+---------------------------------------------
//   0000 0000-0000 007F | 0xxxxxxx
//   0000 0080-0000 07FF | 110xxxxx 10xxxxxx
//   0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
//   0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
// 
//
// 注意：输入是整数数组。只有每个整数的 最低 8 个有效位 用来存储数据。这意味着每个整数只表示 1 字节的数据。 
//
// 
//
// 示例 1： 
//
// 
//输入：data = [197,130,1]
//输出：true
//解释：数据表示字节序列:11000101 10000010 00000001。
//这是有效的 utf-8 编码，为一个 2 字节字符，跟着一个 1 字节字符。
// 
//
// 示例 2： 
//
// 
//输入：data = [235,140,4]
//输出：false
//解释：数据表示 8 位的序列: 11101011 10001100 00000100.
//前 3 位都是 1 ，第 4 位为 0 表示它是一个 3 字节字符。
//下一个字节是开头为 10 的延续字节，这是正确的。
//但第二个延续字节不以 10 开头，所以是不符合规则的。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= data.length <= 2 * 10⁴ 
// 0 <= data[i] <= 255 
// 
// Related Topics 位运算 数组 👍 108 👎 0

import java.math.BigInteger;

class UTF8编码验证 {
    public static void main(String[] args) {
        Solution solution = new UTF8编码验证().new Solution();
        solution.validUtf8(new int[]{197, 130, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validUtf8(int[] data) {
            int n = data.length;
            for (int i = 0; i < n; ) {
                //当前的二进制值 每次位移的数
                int t = data[i], j = 7;
                //位移7查看从右往左第八个是否为1=>位移6查看从右往左第7个是否为1
                while (j >= 0 && (((t >> j) & 1) == 1)) j--;
                // 11000101=>j=5
                int cnt = 7 - j;//前面有两个1
                //有一个1或者大于4错误
                if (cnt == 1 || cnt > 4) return false;
                //如果位置 i 后面不足 cnt - 1 也返回 False；
                if (i + cnt - 1 >= n) return false;

                //（看成为一个字符的）检查
                for (int k = i + 1; k < i + cnt; k++) {
                    //检查他们的第八位为1 第七位为0
                    if ((((data[k] >> 7) & 1) == 1) && (((data[k] >> 6) & 1) == 0)) continue;
                    return false;
                }
                //如果是单字节字符 检查下一个 否则跳过cnt个 到下一个字符
                if (cnt == 0) i++;
                else i += cnt;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
