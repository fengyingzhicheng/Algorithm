package com.southgis.old.match;

/**
 * @author 王军
 * @description
 * @date 2022/1/14 18:57
 */
public class Solution {
    public static void main(String[] args) {
        Integer[][] initialize = {{0, 3, 4}, {2, 2, 9}, {4, 6, 2}, {7, 3, 9}, {8, 5, 2}};


    }


    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    /**
     * 遍历中一旦找到解 就立刻返回 因此该函数需要有返回结果
     */
    private boolean backtrack(char[][] board, int row, int col) {
        //终止条件 即所有区域填充完毕
        if(col == 9) {
            col = 0;
            row++;
            if(row == 9) {
                return true;
            }
        }

        // 跳过已经填充的区域
        if(board[row][col] != '.' ) {
            return backtrack(board, row, col + 1);
        }
        // 穷举1-9
        for(int num = 1; num <= 9; ++num) {
            if(isVaild(board, row, col, (char)(num + '0'))) {

                board[row][col] = (char)('0' + num);

                if(backtrack(board, row, col + 1)) {
                    return true;
                }
                //暂时没有找到可行解 执行回退
                board[row][col] = '.';
            }
        }
        // 当前区域(row, col)穷举完毕 没有找到可行解 则返回false 回到上一个区域继续换数字穷举
        return false;
    }

    private boolean isVaild(char[][] board, int row, int col, int targetNum) {
        for(int i = 0; i < 9; ++i) {
            //当前行是否已有该数
            if(board[row][i] == targetNum) {
                return false;
            }

            //当前列是否已有该数
            if(board[i][col] == targetNum) {
                return false;
            }

            //当前九宫格是否已有该数
            if(board[row - (row % 3) + i / 3][col - (col % 3) + i % 3] == targetNum) {
                return false;
            }
        }
        return true;
    }
}

