package com.southgis.book.grokkingAlgorithms.recursion;

/**
 * @author 王军
 * @description 二分查找
 * @date 2021/6/15 9:44
 */
public class BinarySearch {
    public static int binary_search(int[] array, int item) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mod = (left + right) / 2;
            if (array[mod] < item) {
                left = mod + 1;
            } else if (array[mod] > item) {
                right = mod - 1;
            } else {
                return mod;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(binary_search(array, 10));
    }
}