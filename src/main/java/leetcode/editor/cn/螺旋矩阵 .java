package leetcode.editor.cn;

//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 👍 986 👎 0

import java.util.ArrayList;
import java.util.List;

class 螺旋矩阵 {
    public static void main(String[] args) {
        Solution solution = new 螺旋矩阵().new Solution();
        List<Integer> list = solution.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        list.forEach(System.out::print);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            int xLeft = 0;
            int yLeft = 0;
            int yRight = matrix.length - 1;
            int xRight = matrix[matrix.length - 1].length - 1;
            List<Integer> list = new ArrayList<>();

            cycle(matrix,xLeft,yLeft,xRight,yRight,list);
            return list;
        }

        private void cycle(int[][] matrix,int xLeft, int yLeft, int xRight, int yRight, List<Integer> list) {
            if (xLeft > xRight || yLeft > yRight) {
                return;
            }

            if (xLeft == xRight) {
                for (int i = yLeft; i <=yRight ; i++) {
                    list.add(matrix[i][xLeft]);
                }
                return ;
            }

            if (yLeft == yRight) {
                for (int i = xLeft; i <=xRight ; i++) {
                    list.add(matrix[yLeft][i]);
                }
                return ;
            }

            for (int i = xLeft; i < xRight; i++) {
                list.add(matrix[yLeft][i]);
            }

            for (int i = yLeft; i < yRight; i++) {
                list.add(matrix[i][xRight]);
            }

            for (int i = xRight; i > xLeft; i--) {
                list.add(matrix[yRight][i]);
            }

            for (int i = yRight; i >yLeft ; i--) {
                list.add(matrix[i][xLeft]);
            }
            cycle(matrix,xLeft+1,yLeft+1,xRight-1,yRight-1,list);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
