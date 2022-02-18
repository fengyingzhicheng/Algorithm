package leetcode.editor.cn;

//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 数组 👍 2249 👎 0

class 只出现一次的数字{
	public static void main(String[] args) {
		Solution solution = new 只出现一次的数字().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//		一个数和它本身做异或运算结果为 0，即 a ^ a = 0；
//		一个数和 0 做异或运算的结果为它本身，即 a ^ 0 = a。
    public int singleNumber(int[] nums) {
		int res = 0;
		for (int n : nums) {
			res ^= n;
		}
		return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
