package com.southgis.book.grokkingAlgorithms.recursion;

import java.util.Arrays;

/**
 * @author 王军
 * @description 快速排序
 * @date 2021/6/15 14:19
 */
public class QuickSort {
    public static int[] quick_sort(int[] array, int start, int end) {
        //基线条件
        if (start > end) {
            return array;
        }
        //缩小问题规模
        else {
            int pivot = array[start];
            //返回array 为less+pivot+greater;
            //?如何处理成 小于基准值+pivot+大于基准值的局面
            int left = start;
            int right = end;
            while (left < right) {
                while (array[right] >= pivot && left < right) {
                    right--;
                }
                while (array[left] <= pivot && left < right) {
                    left++;
                }
                if (left < right) {
                    int temp;
                    temp = array[left];
                    array[left] = array[right];
                    array[right] = temp;
                }
            }
            array[start] = array[right];
            array[right] = pivot;

            quick_sort(array, start, right - 1);
            quick_sort(array, right + 1, end);
            return array;
        }
    }

    public static void main(String[] args) {
        int[] array = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8, 11};
        System.out.println(Arrays.toString(quick_sort(array, 0, array.length - 1)));
    }
}