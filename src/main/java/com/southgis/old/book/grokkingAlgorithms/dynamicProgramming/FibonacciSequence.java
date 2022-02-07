package com.southgis.book.grokkingAlgorithms.dynamicProgramming;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author 王军
 * @description 斐波那契数列
 * @date 2021/6/22 15:30
 */
public class FibonacciSequence {

    public int fibByDefinition(int n) {
        if (n < 2) {
            return n;
        } else {
            return fibByDefinition(n - 1) + fibByDefinition(n - 2);
        }
    }

    @Test
    public void testFibByDefinition() {

        //2^n
        System.out.println(fibByDefinition(100));
    }

    public BigDecimal fibByDP(int n) {
        //数学上的斐波那契数列本身就是一种动态规划
        BigDecimal[] array = new BigDecimal[n + 1];
        for (int i = 0; i < n + 1; i++) {
            if (i < 2) {
                array[i] = BigDecimal.valueOf(i);
            } else {
                array[i] = array[i - 1].add(array[i - 2]) ;
            }
        }
        return array[n];
    }

    @Test
    public void testFibByDP() {
        //n
        System.out.println(fibByDP(100));
    }
}