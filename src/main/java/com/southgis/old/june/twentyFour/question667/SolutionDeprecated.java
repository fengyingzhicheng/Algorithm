package com.southgis.old.june.twentyFour.question667;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 王军
 * <p>
 * 解：根据k=2=>m=k+1=3=> [1,m,2,m-1...]
 * <p>
 * 给你两个整数 n 和 k ，请你构造一个答案列表 answer ，该列表应当包含从 1 到 n 的 n 个不同正整数，并同时满足下述条件：
 * <p>
 * 假设该列表是 answer =[a1, a2, a3, ... , an] ，那么列表 [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] 中应该有且仅有 k 个不同整数。
 * 返回列表 answer 。如果存在多种答案，只需返回其中 任意一种 。
 * <p>
 * eg：
 * 输入：n = 3, k = 1
 * 输出：[1, 2, 3]
 * 解释：[1, 2, 3] 包含 3 个范围在 1-3 的不同整数，并且 [1, 1] 中有且仅有 1 个不同整数：1
 * 示例 2：
 * <p>
 * 输入：n = 3, k = 2
 * 输出：[1, 3, 2]
 * 解释：[1, 3, 2] 包含 3 个范围在 1-3 的不同整数，并且 [2, 1] 中有且仅有 2 个不同整数：1 和 2
 * @description
 * @date 2021/6/24 9:14
 */
public class SolutionDeprecated {
    public Integer[] constructArray(int n, int k) {
        List<Integer> list = new ArrayList<>();
        boolean flag = true;
        int j = 1;
        for (int i = k + 1; i > 1; ) {
            if (i == j) {
                list.add(i);
                break;
            }
            if (flag) {
                list.add(j);
                j++;
            } else {
                list.add(i);
                i--;
            }
            flag = !flag;
        }
        //构建出k个元素然后保证插入数据的不扩展差值Set
        //复杂度太高 需要遍历(n-k-1)*k次 里面还要移动数组
        for (int i = n; i > k + 1; i--) {
            int m = 0;

        }

        return list.toArray(new Integer[0]);

    }

    public static void main(String[] args) {
        SolutionDeprecated solution = new SolutionDeprecated();
        System.out.println(Arrays.toString(solution.constructArray(3, 1)));
    }
}