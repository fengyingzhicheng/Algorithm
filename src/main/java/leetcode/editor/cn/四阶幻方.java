package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 王军
 * @description
 * @date 2022/2/18 10:56
 */
class 四阶幻方 {
    public static void main(String[] args) {
        Solution solution = new 四阶幻方().new Solution();
        solution.solveSudoku();
    }

    class Solution {
        Set<Integer> visited = new HashSet<>();


        public void solveSudoku() {
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i < 16; i++) {
                set.add(i + 1);
                //2-15
            }

            int[][] matrix = new int[4][4];
            matrix[0][0] = 1;
            visited.add(1);
            backtrack(matrix, set, 0, 0, 0);

            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    System.out.print(anInt);
                    System.out.print(" ");
                }
                System.out.println();
            }
        }

        private boolean backtrack(int[][] matrix, Set<Integer> set, int row, int column, int lastSum) {
            if (row == matrix.length) {
                int data = 0;
                for (int i = 0; i < matrix.length; i++) {
                    data += matrix[0][i];
                }
                //每一行不相等sum返回false
                for (int[] array : matrix) {
                    int sum = 0;
                    for (int nums : array) {
                        sum += nums;
                    }
                    if (data != sum) {
                        return false;
                    }
                }
                //每一列不相等sum返回false
                for (int i = 0; i < matrix.length; i++) {
                    int sum = 0;
                    for (int[] array : matrix) {
                        sum += array[i];
                    }
                    if (data != sum) {
                        return false;
                    }
                }
                //对角线不相等sum返回false
                //右对角线
                int sum = 0;
                for (int i = 0, j = matrix.length - 1; i < matrix.length; i++, j--) {
                    sum += matrix[i][j];
                }
                if (data != sum) {
                    return false;
                }

                //左对角线
                sum = 0;
                for (int i = 0, j = 0; i < matrix.length; i++, j++) {
                    sum += matrix[i][j];
                }
                return data == sum;
            }
            if (column == matrix.length) {
                int sum = 0;
                if (lastSum == 0) {
                    for (int i = 0; i < column; i++) {
                        sum += matrix[row][i];
                    }
                } else {
                    for (int i = 0; i < column; i++) {
                        sum += matrix[row][i];
                    }
                    if (sum != lastSum) {
                        return false;
                    }
                }

                return backtrack(matrix, set, row + 1, 0, sum);
            }

            if (matrix[row][column] != 0) {
                //跳过非空白区
                return backtrack(matrix, set, row, column + 1, lastSum);
            }
            for (Integer integer : set) {
                if (visited.contains(integer)) {
                    continue;
                }
                //做选择
                matrix[row][column] = integer;
                visited.add(integer);
                if (backtrack(matrix, set, row, column + 1, lastSum)) {
                    return true;
                }
                matrix[row][column] = 0;
                visited.remove(integer);
            }
            return false;
        }
    }
}

