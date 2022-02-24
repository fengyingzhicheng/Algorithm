package leetcode.editor.cn;

//给定一个整数 n 和一个 无重复 黑名单整数数组 blacklist 。设计一种算法，从 [0, n - 1] 范围内的任意整数中选取一个 未加入 黑名单 
//blacklist 的整数。任何在上述范围内且不在黑名单 blacklist 中的整数都应该有 同等的可能性 被返回。 
//
// 优化你的算法，使它最小化调用语言 内置 随机函数的次数。 
//
// 实现 Solution 类: 
//
// 
// Solution(int n, int[] blacklist) 初始化整数 n 和被加入黑名单 blacklist 的整数 
// int pick() 返回一个范围为 [0, n - 1] 且不在黑名单 blacklist 中的随机整数 
// 
//
// 
//
// 示例 1： 
//
// 
//输入
//["Solution", "pick", "pick", "pick", "pick", "pick", "pick", "pick"]
//[[7, [2, 3, 5]], [], [], [], [], [], [], []]
//输出
//[null, 0, 4, 1, 6, 1, 0, 4]
//
//解释
//Solution solution = new Solution(7, [2, 3, 5]);
//solution.pick(); // 返回0，任何[0,1,4,6]的整数都可以。注意，对于每一个pick的调用，
//                 // 0、1、4和6的返回概率必须相等(即概率为1/4)。
//solution.pick(); // 返回 4
//solution.pick(); // 返回 1
//solution.pick(); // 返回 6
//solution.pick(); // 返回 1
//solution.pick(); // 返回 0
//solution.pick(); // 返回 4
// 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 10⁹ 
// 0 <= blacklist.length <- min(10⁵, n - 1) 
// 0 <= blacklist[i] < n 
// blacklist 中所有值都 不同 
// pick 最多被调用 2 * 10⁴ 次 
// 
// Related Topics 哈希表 数学 二分查找 排序 随机化 👍 86 👎 0

import java.util.*;

class 黑名单中的随机数 {
    public static void main(String[] args) {
        Solution solution = new 黑名单中的随机数().new Solution(7, new int[]{2, 3, 5});
        solution.pick();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //黑名单映射到正确的索引数值
        Map<Integer, Integer> map;
        int wL;//白名单的长度
        Random random;

        public Solution(int N, int[] blacklist) {
            map = new HashMap<>();
            random = new Random();
            wL = N - blacklist.length;//白名单的个数/长度
            //可以将[0,N)看做为一个数组，随机0到wL的数字即可，因为0到wL中间可能存在黑名单，所以可以将0到wL中黑名单的数字，映射到wL到N-1里边的白名单数字
            //①拿到所有比wL大的数字集合
            Set<Integer> wList = new HashSet<>();
            for (int i = wL; i < N; i++) {
                wList.add(i);
            }
            //②去掉数字集合中的黑名单数字，只留下白名单数字，供映射使用
            for (int black : blacklist) {
                wList.remove(black);
            }
            //③映射，将小于wL的黑名单全部映射到大于wL的白名单中
            Iterator<Integer> iterator = wList.iterator();
            for (int black : blacklist) {
                if (black < wL) {
                    map.put(black, iterator.next());
                }
            }
        }

        public int pick() {
            int index = random.nextInt(wL);
            Integer blackIndex = map.get(index);
            if (blackIndex != null) {//命中了黑名单
                return blackIndex;
            }
            //如果没有命中，直接返回
            return index;
        }
    }


/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
