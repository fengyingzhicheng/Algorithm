package com.southgis.july.one.question739;

/**
 * @author 王军
 * 解：暴力破解 固定住一个其他的向后遍历找到则跳出赋值 找不到应该赋值0
 * O(n)
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
 * 如果气温在这之后都不会升高，请在该位置用0 来代替。
 * 例如，给定一个列表temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是[1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是[1, 30000]。每个气温的值的均为华氏度，都是在[30, 100]范围内的整数。
 * @description
 * @date 2021/7/1 15:35
 */
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] dayArray = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int j = i + 1;
            for (; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    break;
                }
            }
            if (j == temperatures.length) {
                dayArray[i] = 0;
            } else {
                dayArray[i] = j - i;
            }
        }

        return dayArray;
    }
}