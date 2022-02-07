package com.southgis.book.grokkingAlgorithms.recursion;

import java.util.Arrays;

/**
 * @author 王军
 * @description 分而治之
 * 步骤：
 * (1) 找出基线条件，这种条件必须尽可能简单。
 * (2) 不断将问题分解（或者说缩小规模），直到符合基线条件。
 *
 * eh:给定一个数字数组。你需要将这些数字相加，并返回结果。
 * (1):基线条件:数组不包含任何元素或只包含一个元素，计算总和将非常容易。
 * (2):每次递归调用都必须离空数组更近一步。如何缩小问题的规模呢？
 *
 * @date 2021/6/15 13:40
 */
public class DivideAndConquer {
    public static int divide_and_conquer(int[] array) {
        //基线条件
        if (array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
        }
        //缩小问题规模
        else {
            return array[array.length-1]+divide_and_conquer(Arrays.copyOf(array,array.length-1));
        }
    }

    public static void main(String[] args) {
        int[] array={1,2,3,4,5};
        int i = divide_and_conquer(array);
        System.out.println(i);
    }
}