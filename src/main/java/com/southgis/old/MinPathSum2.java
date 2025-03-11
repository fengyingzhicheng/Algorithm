package com.southgis.old;

/**
 * 1.
 * 陷阱迷宫
 * 一个大小为N*N，并且有若干个陷阱的迷宫，
 * X星人现在站在迷宫左上角的起点(第1行第1列)，
 * 迷宫的终点是右下角(第N行第N列)。
 * X星人每次可以朝上、下、左、右四个方向行走，但不允许穿越墙壁。
 * 在迷宫中，“0”表示空地，“1”表示墙壁，“#”表示陷阱。X星人在迷宫中每行走一步需要1秒钟，
 * 但如果不幸掉入陷阱，则需要额外增加K秒的 逃脱时间。如果终点位置恰好是陷阱，也需要计算时间。
 * 假设起点(左上角)既不是墙也不是陷阱，请问X星人从起点到终点最少需要多少时间?
 *
 * @author 王军
 * @date 2025/03/11
 */
public class MinPathSum2 {
    public static void main(String[] args) {
        char[][] A = {
                {'0', '1', '0', '0'},
                {'0', '0', '#', '1'},
                {'1', '0', '1', '1'},
                {'1', '1', '0', '0'}
        };
        int result = minPathSum(A);
        System.out.println("最小路径和为：" + result);
    }

    public static int minPathSum(char [][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] dp = new int[m][n];

    }
}
