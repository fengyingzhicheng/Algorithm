package com.southgis.old.question455;

import java.util.Arrays;

/**
 * @className: Solution
 * @package: com.southgis.question455
 * @author: 王军
 * @description: 分配饼干
 * @date: 2020/12/17 14:30
 */
class Solution {
    public int findContentChildren(int[] children, int[] cookies) {
        Arrays.sort(children);
        Arrays.sort(cookies);
        int child=0;
        int cookie=0;

        while (child < children.length && cookie < cookies.length) {
            if(children[child]<=cookies[cookie]){ child++;
            }
            cookie++;
        }
        return child;
    }
}