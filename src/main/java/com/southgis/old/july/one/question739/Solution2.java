package com.southgis.old.july.one.question739;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author 王军
 * 解：单调栈 思想是一次遍历如果后面能遇到比他大的就记录对应索引天数数组 如果没有应该记录下来（索引）这样后面有大的才能找到那个没有设置值索引
 * 栈中存储当前遍历的索引及之前没有找到合适值的栈 遍历时看当前值能不能让栈中未被处理的索引满足条件
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
 * 如果气温在这之后都不会升高，请在该位置用0 来代替。
 * 例如，给定一个列表temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是[1, 1, 4, 2, 1, 1, 0, 0]。
 * <p>
 * 提示：气温 列表长度的范围是[1, 30000]。每个气温的值的均为华氏度，都是在[30, 100]范围内的整数。
 * @description
 * @date 2021/7/1 15:35
 */
public class Solution2 {
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] dist = new int[n];
        Stack<Integer> indexs = new Stack<>();
        for (int curIndex = 0; curIndex < n; curIndex++) {
            while (!indexs.isEmpty() && temperatures[curIndex] > temperatures[indexs.peek()]) {
                int preIndex = indexs.pop();
                dist[preIndex] = curIndex - preIndex;
            }
            indexs.add(curIndex);
        }
        return dist;
    }

    public static void main(String[] args) {
        Solution2 solution2=new Solution2();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(solution2.dailyTemperatures(temperatures)));

    }
}