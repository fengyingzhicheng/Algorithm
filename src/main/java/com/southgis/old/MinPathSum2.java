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
 * <p>
 * <p>
 * 时间限制：C/C++ 1秒，其他语言2秒
 * 空间限制：C/C++ 256M，其他语言512M
 * 输入描述：
 * 单组输入。 第1行输入两个正整数N和K，表示迷宫的大小和逃脱陷阱需要额外增加的时间。(N<=100，K<=100) 接下来N行表示迷宫，X星人的起点是左上角，终点是右下角。
 * 输出描述：
 * 输出X星人从起点到终点最少需要的时间(单位:秒)。如果不能从起点到达终点则输出“No solution”。
 *
 * @author 王军
 * @date 2025/03/11
 */

import lombok.Getter;

import java.util.*;

public class MinPathSum2 {

    @Getter
    static class Node {
        int x;
        int y;
        int time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        scanner.nextLine(); // 读取换行符

        char[][] maze = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine()
                    .trim();
            for (int j = 0; j < N; j++) {
                maze[i][j] = line.charAt(j);
            }
        }

        // 处理N=1的情况
        if (N == 1) {
            System.out.println(0);
            return;
        }

        int[][] dist = new int[N][N];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getTime));
        pq.add(new Node(0, 0, 0));

        int[][] directions= {
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int x = node.getX();
            int y = node.getY();
            int time = node.getTime();

            // 提前到达终点则直接返回
            if (x == N-1 && y == N-1) {
                System.out.println(time);
                return;
            }

            if(time>dist[x][y]){
                continue;
            }

            for (int[] direction : directions) {
                int dx = direction[0];
                int dy = direction[1];
                if (x + dx < 0 || x + dx >= N || y + dy < 0 || y + dy >= N || maze[x + dx][y + dy] == '1') {
                    continue;
                }

                calculateDistance(K, maze, dist, pq, time, x + dx, y + dy);
            }
        }

        if (dist[N - 1][N - 1] != Integer.MAX_VALUE) {
            System.out.println(dist[N - 1][N - 1]);
            return;
        }
        System.out.println("No solution");
    }

    private static void calculateDistance(int K, char[][] maze, int[][] dist, PriorityQueue<Node> pq, int time, int x1, int y1) {
        Node node1 = new Node(x1, y1, time + (maze[x1][y1] == '#' ? K : 1));
        if (dist[x1][y1] > node1.getTime()) {
            dist[x1][y1] = node1.getTime();
            pq.add(node1);
        }
    }
}
