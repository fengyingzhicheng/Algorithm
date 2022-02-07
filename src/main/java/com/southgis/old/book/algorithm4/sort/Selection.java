package com.southgis.book.algorithm4.sort;

/**
 * @author 王军
 * @description 选择排序
 * 找到数组中最小的那个元素，其次，将它和数组的第
 * 一个元素交换位置（如果第一个元素就是最小元素那么它就和自己交换）。再次，在剩下的元素中
 * 找到最小的元素，将它与数组的第二个元素交换位置。如此往复，直到将整个数组排序。
 *
 *
 * 对于长度为 N 的数组，选择排序需要大约 N2/2 次比较和 N 次交换。
 * @date 2021/6/11 14:47
 */
public class Selection extends Example {
    /**
     * 将a[]按升序排列
     */
    public static void sort(Comparable[] a) {
        // 数组长度
        int N = a.length;
        // 将a[i]和a[i+1..N]中最小的元素交换
        for (int i = 0; i < N; i++) {

            //找到 最小元素的索引
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }

            //交换i和最小值
            exch(a, i, min);
        }
    }

    public static void main(String[] args) { // Read strings from standard input, sort them, and print.
        String[] a = {"2", "1"};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}