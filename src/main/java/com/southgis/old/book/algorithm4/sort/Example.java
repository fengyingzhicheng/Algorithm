package com.southgis.book.algorithm4.sort;

/**
 * @author 王军
 * @description 样例
 * @date 2021/6/11 14:34
 */
public class Example {
    public static void sort(Comparable[] a) { /* See Algorithms 2.1, 2.2, 2.3, 2.4, 2.5, or 2.7. */ }

    /***
     *
     * v比w小返回true
     * @param v
     * @param w
     * @return boolean
     */
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) { // Print the array, on a single line.
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
        }

    }

    public static boolean isSorted(Comparable[] a) { // Test whether the array entries are in order.
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }

        return true;
    }


}