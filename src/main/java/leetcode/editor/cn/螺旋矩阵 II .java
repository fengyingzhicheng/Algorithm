package leetcode.editor.cn;

//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟 👍 597 👎 0

import java.util.Arrays;

class 螺旋矩阵II {
    public static void main(String[] args) {
        Solution solution = new 螺旋矩阵II().new Solution();
        int[][] ints = solution.generateMatrix(5);

        System.out.println(Arrays.deepToString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][n];
            int xLeft = 0;
            int yLeft = 0;

            int xRight = n - 1;
            int yRight = n - 1;

            cycle(matrix, xLeft, yLeft, xRight, yRight, 1);
            return matrix;
        }

        private void cycle(int[][] matrix, int xLeft, int yLeft, int xRight, int yRight, int index) {
            if (xLeft > xRight || yLeft > yRight) {
                return;
            }
            if (yLeft == yRight) {
                //同一列
                for (int i = xLeft; i <= xRight; i++) {
                    matrix[i][yLeft]=index;
                    index++;
                }
                return;
            }
            if (xLeft == xRight) {
                //同一行
                for (int i = yLeft; i <= yRight; i++) {
                    matrix[xLeft][i]=index;
                    index++;
                }
                return;
            }
            //向右
            for (int i = yLeft; i < yRight; i++) {
                matrix[xLeft][i]=index;
                index++;
            }
            //向下
            for (int i = xLeft; i < xRight; i++) {
                matrix[i][yRight]=index;
                index++;
            }
            //向左
            for (int i = yRight; i > yLeft; i--) {
                matrix[xRight][i]=index;
                index++;
            }
            //向上
            for (int i = xRight; i > xLeft; i--) {
                matrix[i][yLeft]=index;
                index++;
            }

            cycle(matrix, xLeft + 1, yLeft + 1, xRight - 1, yRight - 1, index);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
