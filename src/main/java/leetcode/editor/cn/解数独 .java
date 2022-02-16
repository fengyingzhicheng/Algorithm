package leetcode.editor.cn;

//编写一个程序，通过填充空格来解决数独问题。 
//
// 数独的解法需 遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 
//
// 
// 
// 
// 示例： 
//
// 
//输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".
//",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".
//","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6
//"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[
//".",".",".",".","8",".",".","7","9"]]
//输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8
//"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],[
//"4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9",
//"6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4",
//"5","2","8","6","1","7","9"]]
//解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
//
//
// 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字或者 '.' 
// 题目数据 保证 输入数独仅有一个解 
// 
// 
// 
// 
// Related Topics 数组 回溯 矩阵 👍 1117 👎 0

import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;

class 解数独 {
    public static void main(String[] args) {
        Solution solution = new 解数独().new Solution();
        //char[][] board = new char[9][9];
        //for (char[] value : board) {
        //    Arrays.fill(value, '.');
        //}
        //for (char[] chars : board) {
        //    System.out.println(Arrays.toString(chars));
        //}

        String str = "[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]";
        String[] split = str.split("],\\[");

        char[][] board = new char[9][9];

        int i = 0;
        for (String string : split) {
            string = string.replace("[[", "");
            string = string.replace("]]", "");
            int j = 0;
            for (String data : string.split(",")) {
                board[i][j] = data.charAt(1);
                j++;
            }
            i++;
        }

        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
        solution.solveSudoku(board);
        System.out.println();
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solveSudoku(char[][] board) {
            backtrack(board, 0, 0);
        }

        private boolean  backtrack(char[][] board, int row, int column) {
            if (row == board.length) {
                return true;
            }
            if (column == board.length) {
                return backtrack(board, row + 1, 0);
            }

            if (board[row][column] != '.') {
                //跳过非空白区
                return backtrack(board, row, column + 1);
            }

            for (char data = '1'; data - '0' < 10; data++) {
                if (!isValid(board, row, column, data)) {
                    continue;
                }
                board[row][column] = data;
                //去下一列
                if (backtrack(board, row, column + 1)) {
                    return true;
                }

                //撤销选择
                board[row][column] = '.';
            }

            return false;

        }

        private boolean isValid(char[][] board, int row, int column, char input) {
            //行不相同
            for (char data : board[row]) {
                //遍历当前行值如果 输入的新值和当前行数据相等 错误
                if (input == data) {
                    return false;
                }
            }

            //列不相同
            for (char[] chars : board) {
                if (input == chars[column]) {
                    return false;
                }
            }
            //3x3 宫不相同
            int x = row / 3 * 3;
            int y = column / 3 * 3;

            for (int i = x; i < x + 3; i++) {
                for (int j = y; j < y + 3; j++) {
                    if (input == board[i][j]) {
                        return false;
                    }
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
