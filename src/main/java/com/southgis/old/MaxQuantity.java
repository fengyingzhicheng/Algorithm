package com.southgis.old;


import lombok.Getter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaxQuantity {


    /**
     * 贪心错误
     * 后续的块选择会影响结果
     * @param args
     * @author: 王军
     * @date: 2025/03/12
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine(); // 读取换行符

        //矩阵为
        int[][] maze = new int[N][M];
        //默认初始quantity=0
        int quantity = 0;

        for (int i = 0; i < N; i++) {
            //块数
            int chunk = scanner.nextInt();
            scanner.nextLine();
            for (int i1 = 0; i1 < chunk; i1++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                if (end < start) {
                    throw new UnsupportedOperationException("不支持的分块");
                }
                if (start < 1 || end > M) {
                    throw new UnsupportedOperationException("不支持的分块");
                }
                //start end之间有且只有一个 1
                int index = start - 1;
                for (int j = start; j <= end; j++) {
                    //假如这里是1 计算quantity
                    maze[i][j - 1] = 1;
                    int sum = 0;
                    for (int l = 0; l < M; l++) {
                        int count = 0;
                        for (int k = 0; k <= i; k++) {
                            count += maze[k][l];
                        }
                        sum += count * count;
                    }
                    if (sum > quantity) {
                        quantity = sum;
                        index = j - 1;
                    }
                    maze[i][j - 1] = 0;
                }
                maze[i][index] = 1;
                //换行
                scanner.nextLine();
            }

        }
        System.out.println(quantity);
    }

    // 贪心算法 每块应该选择区间内列最大的 如果列总数相同选择最右的


}