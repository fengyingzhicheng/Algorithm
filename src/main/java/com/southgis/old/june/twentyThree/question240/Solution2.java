package com.southgis.old.june.twentyThree.question240;

/**
 * @author 王军
 * O(m+n)
 *
 * <p>
 * 解：
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * <p>
 * 如果 target  = 9，如果我们从 15 开始遍历, cur = 15
 * <p>
 * target < 15, 去掉当前列, cur = 11
 * [1,   4,  7, 11],
 * [2,   5,  8, 12],
 * [3,   6,  9, 16],
 * [10, 13, 14, 17],
 * [18, 21, 23, 26]
 * <p>
 * target < 11, 去掉当前列, cur = 7
 * [1,   4,  7],
 * [2,   5,  8],
 * [3,   6,  9],
 * [10, 13, 14],
 * [18, 21, 23]
 * <p>
 * target > 7, 去掉当前行, cur = 8
 * [2,   5,  8],
 * [3,   6,  9],
 * [10, 13, 14],
 * [18, 21, 23]
 * <p>
 * target > 8, 去掉当前行, cur = 9, 遍历结束
 * [3,   6,  9],
 * [10, 13, 14],
 * [18, 21, 23]
 * <p>
 * 会发现每次都是向左数字会变小，向下数字会变大，有点和二分查找树相似。二分查找树的话，是向左数字变小，向右数字变大。
 * 所以我们可以把 target 和当前值比较。
 * 如果 target 的值大于当前值，那么就向下走。
 * 如果 target 的值小于当前值，那么就向左走。
 * 如果相等的话，直接返回 true 。
 * 也可以换个角度思考。
 * 如果 target 的值小于当前值，也就意味着当前值所在的列肯定不会存在 target 了，可以把当前列去掉，从新的右上角的值开始遍历。
 * 同理，如果 target 的值大于当前值，也就意味着当前值所在的行肯定不会存在 target 了，可以把当前行去掉，从新的右上角的值开始遍历
 * <p>
 * 二分查找 mlogn
 * <p>
 * 编写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 * @description
 * @date 2021/6/23 9:23
 */
public class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int indexColumn = matrix[0].length - 1;
        int indexRow = 0;
        int cur = matrix[indexRow][indexColumn];

        while (cur != target) {
            if (cur > target) {
                indexColumn--;
            } else {
                indexRow++;
            }
            if (indexRow > matrix.length - 1 || indexColumn < 0) {
                break;
            }
            cur = matrix[indexRow][indexColumn];
        }
        return cur==target;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        Solution2 solution = new Solution2();
        System.out.println(solution.searchMatrix(matrix, 28));
    }
}