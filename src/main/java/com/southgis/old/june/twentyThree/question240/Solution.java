package com.southgis.old.june.twentyThree.question240;

/**
 * @author 王军
 *
 * 看到有序，第一反应就是二分查找。最直接的做法，一行一行的进行二分查找即可。
 * 此外，结合有序的性质，一些情况可以提前结束。
 * 比如某一行的第一个元素大于了 target ，当前行和后边的所有行都不用考虑了，直接返回 false。
 * 某一行的最后一个元素小于了 target ，当前行就不用考虑了，换下一行。
 *
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
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int[] ints : matrix) {
            if (ints[0] > target) {
                break;
            }
            if (ints[ints.length - 1] < target) {
                continue;
            }

            int left = 0, right = ints.length - 1;
            while (left <= right) {
                if (ints[right] < target || ints[left] > target) {
                    break;
                }
                int mid = (left + right) / 2;
                if (ints[mid] > target) {
                    right = mid-1;
                } else if (ints[mid] < target) {
                    left = mid+1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        Solution solution=new Solution();
        System.out.println(solution.searchMatrix(matrix,9));
    }
}