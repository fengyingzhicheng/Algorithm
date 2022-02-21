package leetcode.editor.cn;

/**
 * @author 王军
 * @description
 * @date 2022/2/18 14:47
 */
class 机器人寻路 {

    public static void main(String[] args) {
        Solution solution = new 机器人寻路().new Solution();
        solution.plan();
    }


    class Solution {
        int route;

        private int plan() {
            //矩阵大小
            int m = 3;
            int n = 3;
            int[][] matrix = new int[m][n];
            //机器人原始位置
            int x = 0;
            int y = 0;

            //障碍物设置
            matrix[1][1] = 1;
            matrix[2][2]=1;

            backtrack(matrix, x, y);
            System.out.println(route);
            return route;
        }

        private void backtrack(int[][] matrix, int x, int y) {
            if (y == matrix.length - 1 && x == matrix[matrix.length - 1].length - 1) {
                route++;
                return;
            }
            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    if (x == matrix[matrix.length - 1].length - 1||matrix[x + 1][y] == 1) {
                        continue;
                    }

                    //向右
                    //做选择
                    x++;
                    //进入下一层
                    backtrack(matrix, x, y);
                    //回退
                    x--;
                } else {
                    if (y == matrix.length - 1||matrix[x][y + 1] == 1) {
                        continue;
                    }
                    //向下
                    y++;
                    //做选择
                    //进入下一层
                    backtrack(matrix, x, y);
                    //回退
                    y--;
                }

            }


        }
    }

}

