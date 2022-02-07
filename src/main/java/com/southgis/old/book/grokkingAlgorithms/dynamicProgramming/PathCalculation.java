package com.southgis.book.grokkingAlgorithms.dynamicProgramming;

/**
 * @author 王军
 * @description 路径计算
 * @date 2021/6/22 17:03
 */
public class PathCalculation {

    /***
     *
     * 计算从起点位置到终点的路径数
     * m是行数，n是列数
     * @param m 行数
     * @param n 列数
     * @return int
     */
    public static int countPath(int m, int n) {
        int[][] array = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = array[i - 1][j] + array[i][j - 1];
                }
            }
        }
        return array[n-1][m-1];
    }

    public static void main(String[] args) {
        System.out.println(countPath(7, 3));
    }
}