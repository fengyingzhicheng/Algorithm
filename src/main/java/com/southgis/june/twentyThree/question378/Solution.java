package com.southgis.june.twentyThree.question378;

/**
 * @author 王军
 * <p>
 * 给你一个n x n矩阵matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 * <p>
 * eg:
 * 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * 输出：13
 * 解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
 * <p>
 * 输入：matrix = [[-5]], k = 1
 * 输出：-5
 * @description
 * @date 2021/6/23 10:56
 */
//TODO
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[m - 1][n - 1];
        while (left < right) {
            int midData = (left + right) / 2;
            //小于等于的数
            int count = findNotBiggerThanMid(matrix, midData, m, n);
            if (count < k) {
                left = midData + 1;
            } else {
                right = midData;
            }
        }
        return right;
    }

    private int findNotBiggerThanMid(int[][] matrix, int mid, int row, int col) {
        // 以列为单位找，找到每一列最后一个<=mid的数即知道每一列有多少个数<=mid
        int i = row - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < col) {
            if (matrix[i][j] <= mid) {
                // 第j列有i+1个元素<=mid
                count += i + 1;
                j++;
            } else {
                // 第j列目前的数大于mid，需要继续在当前列往上找
                i--;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 8;
        Solution solution = new Solution();
        System.out.println(solution.kthSmallest(matrix, k));
    }
}