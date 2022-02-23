package leetcode.editor.cn;

//在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示. 
//
// 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换. 
//
// 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。 
//
// 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。 
//
// 示例： 
//
// 
//输入：board = [[1,2,3],[4,0,5]]
//输出：1
//解释：交换 0 和 5 ，1 步完成
// 
//
// 
//输入：board = [[1,2,3],[5,4,0]]
//输出：-1
//解释：没有办法完成谜板
// 
//
// 
//输入：board = [[4,1,2],[5,0,3]]
//输出：5
//解释：
//最少完成谜板的最少移动次数是 5 ，
//一种移动路径:
//尚未移动: [[4,1,2],[5,0,3]]
//移动 1 次: [[4,1,2],[0,5,3]]
//移动 2 次: [[0,1,2],[4,5,3]]
//移动 3 次: [[1,0,2],[4,5,3]]
//移动 4 次: [[1,2,0],[4,5,3]]
//移动 5 次: [[1,2,3],[4,5,0]]
// 
//
// 
//输入：board = [[3,2,4],[1,5,0]]
//输出：14
// 
//
// 提示： 
//
// 
// board 是一个如上所述的 2 x 3 的数组. 
// board[i][j] 是一个 [0, 1, 2, 3, 4, 5] 的排列. 
// 
// Related Topics 广度优先搜索 数组 矩阵 👍 244 👎 0

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class 滑动谜题 {
    public static void main(String[] args) {
        Solution solution = new 滑动谜题().new Solution();
        int[][] board = new int[][]{{1, 2, 3}, {5, 4, 0}};
        solution.slidingPuzzle(board);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<String> visited = new HashSet<>();

        public int slidingPuzzle(int[][] board) {
            Queue<String> queue = new LinkedList<>();
            String start = getStart(board);
            queue.add(start);
            visited.add(start);
            int depth = 0;
            String target = "123450";


            int[][] neighbors = new int[][]{
                    {1, 3},
                    {0, 2, 4},
                    {1, 5},
                    {0, 4},
                    {1, 3, 5},
                    {2, 4}
            };

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String data = queue.remove();
                    if (data.equals(target)) {
                        return depth;
                    }
                    //data的下一步选择 全部压入队列
                    addQueue(queue, neighbors, data);

                }
                depth++;
            }
            return -1;
        }

        /**
         * 压入队列
         *
         * @param queue
         * @param neighbors
         * @param data
         */
        private void addQueue(Queue<String> queue, int[][] neighbors, String data) {
            int sourceIndex = data.indexOf('0');
            for (int targetIndex : neighbors[sourceIndex]) {
                StringBuilder sb = new StringBuilder(data);
                //原始的字符串
                char targetChar = sb.charAt(targetIndex);
                sb.setCharAt(sourceIndex, targetChar);
                sb.setCharAt(targetIndex, '0');
                String toString = sb.toString();
                if (!visited.contains(toString)) {
                    queue.add(toString);
                    visited.add(toString);
                }
            }
        }

        /**
         * 获取开始结点字符串
         *
         * @param board
         * @return
         */
        private String getStart(int[][] board) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int[] array : board) {
                for (int data : array) {
                    stringBuilder.append(data);
                }
            }
            return stringBuilder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
