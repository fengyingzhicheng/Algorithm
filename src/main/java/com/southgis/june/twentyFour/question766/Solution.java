package com.southgis.june.twentyFour.question766;

/**
 * @author 王军
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 * <p>
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 * 输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * 输出：true
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是 True
 * 输入：matrix = [[1,2],[2,2]]
 * 输出：false
 * 解释：
 * 对角线 "[1, 2]" 上的元素不同。
 * @description
 * @date 2021/6/24 13:44
 */
public class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = n - 1;
        int down = 0;
        while (left >= 0 && down < m) {
            int localValue = matrix[down][left];
            for (int i = 1; i + left < n && i + down < m; i++) {
                int compareValue = matrix[down + i][left + i];
                if (compareValue != localValue) {
                    return false;
                }
            }
            if (left > 0) {
                left--;
            } else {
                down++;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[][] matrix = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        //System.out.println(solution.isToeplitzMatrix(matrix));
        int[][] data = {{1, 2}, {2, 2}};
        System.out.println(solution.isToeplitzMatrix(data));
    }
}