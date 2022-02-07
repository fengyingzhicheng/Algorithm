package com.southgis.book.algorithm4.sort;

/**
 * @author 王军
 * @description 插入排序
 * <p>
 * 对于随机排列的长度为 N 且主键不重复的数组，平均情况下插入排序需要～ N2/4 次比较
 * 以及～ N2 /4 次交换。最坏情况下需要～ N2 /2 次比较和～ N2 /2 次交换
 * 最好情况下需要 N-1次比较和 0 次交换。
 * <p>
 * 倒置指的是数组中的两个顺序颠倒的元素。
 * 插入排序需要的交换操作和数组中倒置的数量相同，
 * 需要的比较次数大于等于倒置的数量，小于等于倒置的数量加上数组的大小再减一。
 * @date 2021/6/11 15:39
 */
public class Insertion extends Example {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            // 将 a[i] 插入到 a[i-1]、a[i-2]、a[i-3]...之中
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
}