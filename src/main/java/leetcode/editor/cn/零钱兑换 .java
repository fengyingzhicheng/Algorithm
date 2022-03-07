package leetcode.editor.cn;

//给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。 
//
// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
// Related Topics 广度优先搜索 数组 动态规划 👍 1757 👎 0

import java.util.Arrays;

class 零钱兑换 {
    public static void main(String[] args) {
        Solution solution = new 零钱兑换().new Solution();
//        solution.coinChange(new int[]{1,2,5},11);
        solution.coinChange(new int[]{2}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            // 数组大小为 amount + 1，初始值也为 amount + 1
            Arrays.fill(dp, amount + 1);

            // base case
            dp[0] = 0;
            // 外层 for 循环在遍历所有状态的所有取值
            for (int i = 0; i < dp.length; i++) {
                // 内层 for 循环在求所有选择的最小值
                for (int coin : coins) {
                    // 子问题无解，跳过
                    if (i - coin < 0) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
            return (dp[amount] == amount + 1) ? -1 : dp[amount];

//            return dpMyself(coins, amount);
//            return byRecursion(coins, amount);
        }

        private int dpMyself(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            dp[0] = 0;
            for (int i = 1; i < dp.length; i++) {
                int MIN_VALUE = Integer.MAX_VALUE;
                for (int coin : coins) {
                    if (i - coin < 0) {
                        continue;
                    }
                    //子问题
                    if (i == coin || dp[i - coin] > 0) {
                        MIN_VALUE = Math.min(dp[i - coin] + 1, MIN_VALUE);
                    }
                }
                dp[i] = MIN_VALUE == Integer.MAX_VALUE ? -1 : MIN_VALUE;
            }
            return dp[amount];
        }

        private int byRecursion(int[] coins, int amount) {
            int[] memo = new int[amount + 1];
            // dp 数组全都初始化为特殊值
            Arrays.fill(memo, -666);
            // 题目要求的最终结果是 dp(amount)
            return dp(coins, memo, amount);
        }

        int dp(int[] coins, int[] memo, int amount) {
            // base case
            if (amount == 0) return 0;
            if (amount < 0) return -1;

            // 查备忘录，防止重复计算
            if (memo[amount] != -666)
                return memo[amount];

            int res = Integer.MAX_VALUE;
            for (int coin : coins) {
                // 计算子问题的结果
                int subProblem = dp(coins, memo, amount - coin);
                // 子问题无解则跳过
                if (subProblem == -1) continue;
                // 在子问题中选择最优解，然后加一
                res = Math.min(res, subProblem + 1);
            }
            // 把计算结果存入备忘录
            memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
            return memo[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
