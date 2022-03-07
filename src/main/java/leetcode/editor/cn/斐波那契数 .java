package leetcode.editor.cn;

//斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是： 
//
// 
//F(0) = 0，F(1) = 1
//F(n) = F(n - 1) + F(n - 2)，其中 n > 1
// 
//
// 给定 n ，请计算 F(n) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：1
//解释：F(2) = F(1) + F(0) = 1 + 0 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：2
//解释：F(3) = F(2) + F(1) = 1 + 1 = 2
// 
//
// 示例 3： 
//
// 
//输入：n = 4
//输出：3
//解释：F(4) = F(3) + F(2) = 2 + 1 = 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 30 
// 
// Related Topics 递归 记忆化搜索 数学 动态规划 👍 409 👎 0

class 斐波那契数{
	public static void main(String[] args) {
		Solution solution = new 斐波那契数().new Solution();
		solution.fib(4);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int fib(int n) {
		return fibByDP(n);
//		return fibByRecursion(n);
	}

	/**
	 * DP方式解题
	 * @param n
	 * @return
	 */
	private int fibByDPLow(int n) {
		if (n == 0 || n == 1) {
			// base case
			return n;
		}
		// 分别代表 dp[i - 1] 和 dp[i - 2]
		int dp_i_1 = 1, dp_i_2 = 0;
		for (int i = 2; i <= n; i++) {
			// dp[i] = dp[i - 1] + dp[i - 2];
			int dp_i = dp_i_1 + dp_i_2;
			// 滚动更新
			dp_i_2 = dp_i_1;
			dp_i_1 = dp_i;
		}
		return dp_i_1;
	}

	/**
	 * DP方式解题
	 * @param n
	 * @return
	 */
	private int fibByDP(int n) {
		if (n == 0) return 0;
		int[] dp = new int[n + 1];
		// base case
		dp[0] = 0;
		dp[1] = 1;
		// 状态转移
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];
	}

	/**
	 * 通过递归方式
	 * @param n
	 * @return
	 */
	private int fibByRecursion(int n) {
		// 备忘录全初始化为 0
		int[] memo = new int[n + 1];
		// 进行带备忘录的递归
		return helper(memo, n);
	}

	int helper(int[] memo, int n) {
		// base case
		if (n == 0 || n == 1) return n;
		// 已经计算过，不用再计算了
		if (memo[n] != 0) return memo[n];
		memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
		return memo[n];
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
