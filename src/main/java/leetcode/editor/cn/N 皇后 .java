package leetcode.editor.cn;

//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
// 
// 
// Related Topics 数组 回溯 👍 1182 👎 0

import java.util.ArrayList;
import java.util.List;

class N皇后 {
    public static void main(String[] args) {
        Solution solution = new N皇后().new Solution();
        String[][] board = new String[4][4];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (i == j) {
                    board[i][j] = "Q";
                } else {
                    board[i][j] = ".";
                }
            }
        }

        List<String> route = solution.toListString(board);
        System.out.println(route);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> result = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            String[][] board = new String[n][n];
            for (int i = 0; i < board.length; i++) {
                for (int i1 = 0; i1 < board.length; i1++) {
                    board[i][i1] = ".";
                }
            }
            backtrack(board, 0);
            return result;
        }

        /**
         * 回溯法
         */
        private void backtrack(String[][] board, int row) {
            //如果路径上已经满了N个 表示合适的皇后位置 返回
            if (row == board.length) {
                //做完选择后已经每个都选好了
                result.add(toListString(board));
                return;
            }

            //往右移动
            for (int column = 0; column < board.length; column++) {
                if (!isValid(board, row, column)) {
                    //不合法的跳过
                    continue;
                }

                //做选择
                board[row][column] = "Q";

                //进入下一行
                backtrack(board, row + 1);

                //撤销选择
                board[row][column] = ".";

            }


        }

        private List<String> toListString(String[][] board) {
            List<String> list = new ArrayList<>();
            for (String[] strings : board) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String string : strings) {
                    stringBuilder.append(string);
                }
                list.add(stringBuilder.toString());
            }
            return list;

        }

        /**
         * 判断当前row column是否合法
         *
         * @param board
         * @param row
         * @param column
         * @return
         */
        private boolean isValid(String[][] board, int row, int column) {
            int n = board.length;
            //同一竖行相同返回false
            for (int i = 0; i < row; i++) {
                if ("Q".equals(board[i][column])) {
                    return false;
                }
            }

            // 检查右上方是否有皇后冲突
            for (int i = row - 1, j = column + 1; i >= 0 && j < n; i--, j++) {
                if ("Q".equals(board[i][j])) {
                    return false;
                }
            }

            // 检查左上方是否有皇后冲突
            for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
                if ("Q".equals(board[i][j])) {
                    return false;
                }
            }

            return true;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
