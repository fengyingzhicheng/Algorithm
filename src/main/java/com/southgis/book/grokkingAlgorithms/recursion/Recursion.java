package com.southgis.book.grokkingAlgorithms.recursion;

/**
 * @author 王军
 * @description 递归
 * @date 2021/6/15 13:36
 */
public class Recursion {
    public static int countdown(int number) {
        System.out.println(number);
        //基线条件
        if (number <= 0) {
            return 0;
        }
        //递归条件
        else {
            countdown(number - 1);
        }
        return 0;
    }

}