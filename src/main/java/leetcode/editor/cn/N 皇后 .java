package leetcode.editor.cn;

//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
// 
// 
// Related Topics 数组 回溯 👍 1182 👎 0

import java.util.*;
import java.util.stream.Collectors;

class N皇后 {
    public static void main(String[] args) {
        Solution solution = new N皇后().new Solution();
        String[][] nums = new String[4][4];
        List<Map<Integer, Integer>> list = new ArrayList<Map<Integer, Integer>>();
        for (int i = 0; i < 4; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            map.put(i, i);
            list.add(map);
        }
        List<String> route = solution.getRoute(nums, list);
        System.out.println(route);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> result;

        public List<List<String>> solveNQueens(int n) {
            String nums[][] = new String[n][n];

            List<Map<Integer, Integer>> path = new LinkedList<>();
            backtrack(nums, path);
            return result;
        }

        /**
         * 回溯法
         *
         * @param nums
         * @param nodes 存储 皇后Q的i,j索引 表示第几行第几列
         */
        private void backtrack(String nums[][], List<Map<Integer, Integer>> nodes) {
            //如果路径上已经满了N个 表示合适的皇后位置 返回
            if (nodes.size() == nums.length) {
                result.add(getRoute(nums, nodes));
                return;
            }
            Map<Integer, Integer> node = nodes.get(nodes.size() - 1);

        }

        /**
         * 加入当前的
         *
         * @param nums
         * @param nodes
         * @return
         */
        private List<String> getRoute(String[][] nums, List<Map<Integer, Integer>> nodes) {
            Map<Integer, Integer> map = nodes.stream().flatMap(n -> n.entrySet().stream()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            List<String> route = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    Integer data = map.get(i);
                    if (data != null && data == j) {
                        stringBuilder.append("Q");
                    } else {
                        stringBuilder.append(".");
                    }
                }
                route.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            }
            return route;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
