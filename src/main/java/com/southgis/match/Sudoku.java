package com.southgis.match;

import java.util.*;

/**
 * @author 王军
 * @description
 * @date 2022/1/14 16:11
 */
public class Sudoku {

    public static void main(String[] args) {
        Integer[][] initialize = {{0, 3, 4}, {2, 2, 9}, {4, 6, 2}, {7, 3, 9}, {8, 5, 2}};

        List<List<Integer>> listList = new ArrayList<>();
        initializationList(initialize, listList);

        Map<Integer, Set<Integer>> checkerboard = getCheckerBoard(listList);
        Map<Integer, Set<Integer>> rowMap = getRowMap(listList);
        Map<Integer, Set<Integer>> columnMap = getColumnMap(listList);


        System.out.println("\n");
        for (int i1 = 0; i1 < listList.size(); i1++) {
            List<Integer> list = listList.get(i1);
            for (int i2 = 0; i2 < list.size(); i2++) {
                for (int i = 0; i < 9; i++) {
                    if (list.get(i2) == null) {
                        boolean test1 = !rowMap.get(i1).contains(i + 1);
                        boolean test2 = !columnMap.get(i2).contains(i + 1);
                        Set<Integer> localCheckerBoard = checkerboard.get(i1 / 3 * 3 + i2 / 3 + 1);
                        boolean test3 = !localCheckerBoard.contains(i + 1);
                        if (test1 && test2 && test3) {
                            //都不包含更新set
                            localCheckerBoard.add(i + 1);
                            rowMap.get(i1).add(i + 1);
                            columnMap.get(i2).add(i + 1);
                            list.set(i2, i + 1);
                            break;
                        }
                    }
                }
            }
            System.out.println(list);
            System.out.println("\n");
        }


        sout(listList);
    }

    /**
     * 获取最小棋盘种包含的Set
     *
     * @param listList
     */
    private static Map<Integer, Set<Integer>> getRowMap(List<List<Integer>> listList) {
        Map<Integer, Set<Integer>> checkerboard = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            checkerboard.put(i, new HashSet<>());
        }

        for (int i = 0; i < listList.size(); i++) {
            List<Integer> list = listList.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) != null) {
                    checkerboard.get(i).add(list.get(j));
                }
            }
        }

        System.out.println(checkerboard);
        return checkerboard;
    }


    /**
     * 获取最小棋盘种包含的Set
     *
     * @param listList
     */
    private static Map<Integer, Set<Integer>> getColumnMap(List<List<Integer>> listList) {
        Map<Integer, Set<Integer>> checkerboard = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            checkerboard.put(i, new HashSet<>());
        }

        for (int i = 0; i < listList.size(); i++) {
            List<Integer> list = listList.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) != null) {
                    checkerboard.get(j).add(list.get(j));
                }
            }
        }

        System.out.println(checkerboard);
        return checkerboard;
    }


    /**
     * 获取最小棋盘种包含的Set
     *
     * @param listList
     */
    private static Map<Integer, Set<Integer>> getCheckerBoard(List<List<Integer>> listList) {
        Map<Integer, Set<Integer>> checkerboard = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            checkerboard.put(i + 1, new HashSet<>());
        }

        for (int i = 0; i < listList.size(); i++) {
            List<Integer> list = listList.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) != null) {
                    checkerboard.get(i / 3 * 3 + j / 3 + 1).add(list.get(j));
                }
            }
        }

        System.out.println(checkerboard);
        return checkerboard;
    }


    /**
     * 初始化list 设置值
     *
     * @param initialize
     * @param listList
     */
    private static void initializationList(Integer[][] initialize, List<List<Integer>> listList) {
        for (int i = 0; i < 9; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                row.add(null);
            }
            listList.add(row);
        }
        sout(listList);

        for (Integer[] rowColumnData : initialize) {
            Integer row = rowColumnData[0];
            Integer column = rowColumnData[1];
            Integer data = rowColumnData[2];

            listList.get(row).set(column, data);
        }

        sout(listList);
    }

    /**
     * 打印生成的矩阵
     *
     * @param listList
     */
    private static void sout(List<List<Integer>> listList) {
        for (List<Integer> data : listList) {
            System.out.println(data);
        }
        System.out.println("\n");
    }
}