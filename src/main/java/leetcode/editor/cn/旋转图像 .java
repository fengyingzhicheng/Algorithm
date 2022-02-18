package leetcode.editor.cn;

//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
//
// 
// Related Topics 数组 数学 矩阵 👍 1170 👎 0

class 旋转图像 {
    public static void main(String[] args) {
        Solution solution = new 旋转图像().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            //先对称对调
            for (int i = 0; i < matrix.length; i++) {
                for (int left = 0, right = matrix.length - 1; left < right; left++,right--) {
                    int temp = matrix[i][left];
                    matrix[i][left] = matrix[i][right];
                    matrix[i][right] = temp;
                }
            }

            //再对角线对调
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length - i; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[matrix.length - 1 - j][matrix.length - 1 - i];
                    matrix[matrix.length - 1 - j][matrix.length - 1 - i] = temp;
                }
            }
        }

        private void sout(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
