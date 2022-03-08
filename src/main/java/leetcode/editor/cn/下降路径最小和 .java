package leetcode.editor.cn;

//给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。 
//
// 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第
//一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1
//, col + 1) 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
//输出：13
//解释：如图所示，为和最小的两条下降路径
// 
//
// 示例 2： 
//
// 
//
// 
//输入：matrix = [[-19,57],[-40,-5]]
//输出：-59
//解释：如图所示，为和最小的下降路径
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 100 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 动态规划 矩阵 👍 148 👎 0

class 下降路径最小和{
	public static void main(String[] args) {
		Solution solution = new 下降路径最小和().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minFallingPathSum(int[][] matrix) {
		int n = matrix.length;
		int res = Integer.MAX_VALUE;
		// 终点可能在 matrix[n-1] 的任意一列
		for (int j = 0; j < n; j++) {
			res = Math.min(res, recursion(matrix, n - 1, j));
		}
		return res;
    }


	/**
	 * 递归矩阵到达i j的最短路径
	 * @param matrix
	 * @param i
	 * @param j
	 * @return
	 */
	int recursion(int[][] matrix, int i, int j) {
		// 非法索引检查
		if (i < 0 || j < 0 ||
				i >= matrix.length ||
				j >= matrix[0].length) {
			// 返回一个特殊值
			return 99999;
		}
		// base case
		if (i == 0) {
			return matrix[i][j];
		}
		// 状态转移
		return matrix[i][j] + min(
				recursion(matrix, i - 1, j),
				recursion(matrix, i - 1, j - 1),
				recursion(matrix, i - 1, j + 1)
		);
	}

	int min(int a, int b, int c) {
		return Math.min(a, Math.min(b, c));
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}
