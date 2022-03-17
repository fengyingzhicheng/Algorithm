package leetcode.editor.cn;

//给你一棵根节点为 0 的 二叉树 ，它总共有 n 个节点，节点编号为 0 到 n - 1 。同时给你一个下标从 0 开始的整数数组 parents 表示这棵
//树，其中 parents[i] 是节点 i 的父节点。由于节点 0 是根，所以 parents[0] == -1 。 
//
// 一个子树的 大小 为这个子树内节点的数目。每个节点都有一个与之关联的 分数 。求出某个节点分数的方法是，将这个节点和与它相连的边全部 删除 ，剩余部分是若
//干个 非空 子树，这个节点的 分数 为所有这些子树 大小的乘积 。 
//
// 请你返回有 最高得分 节点的 数目 。 
//
// 
//
// 示例 1: 
//
// 
//
// 输入：parents = [-1,2,0,2,0]
//输出：3
//解释：
//- 节点 0 的分数为：3 * 1 = 3
//- 节点 1 的分数为：4 = 4
//- 节点 2 的分数为：1 * 1 * 2 = 2
//- 节点 3 的分数为：4 = 4
//- 节点 4 的分数为：4 = 4
//最高得分为 4 ，有三个节点得分为 4 （分别是节点 1，3 和 4 ）。
// 
//
// 示例 2： 
//
// 
//
// 输入：parents = [-1,2,0]
//输出：2
//解释：
//- 节点 0 的分数为：2 = 2
//- 节点 1 的分数为：2 = 2
//- 节点 2 的分数为：1 * 1 = 1
//最高分数为 2 ，有两个节点分数为 2 （分别为节点 0 和 1 ）。
// 
//
// 
//
// 提示： 
//
// 
// n == parents.length 
// 2 <= n <= 10⁵ 
// parents[0] == -1 
// 对于 i != 0 ，有 0 <= parents[i] <= n - 1 
// parents 表示一棵二叉树。 
// 
// Related Topics 树 深度优先搜索 数组 二叉树 👍 112 👎 0

import java.util.ArrayList;
import java.util.List;

class 统计最高分的节点数目 {
    public static void main(String[] args) {
        Solution solution = new 统计最高分的节点数目().new Solution();
        solution.countHighestScoreNodes(new int[]{-1, 2, 0, 2, 0});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        long maxScore = 0;
        int count = 0;
        int n;
        List<Integer>[] children;

        public int countHighestScoreNodes(int[] parents) {
            n = parents.length;
            children = new List[n];
            for (int i = 0; i < n; i++) {
                children[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < n; i++) {
                int p = parents[i];
                if (p != -1) {
                    children[p].add(i);
                }
            }

            //通过深度优先搜索我们是可以求出左右子树的节点数量的，
            // 这样的话，父子树的数量也就很容易求得了，为 总节点数 减去 左右子树的数量 再减 一。
            dfs(0);
            return count;
        }

        public int dfs(int node) {
            long score = 1;
            int size = n - 1;
            for (int c : children[node]) {
                int t = dfs(c);
                score *= t;
                size -= t;
            }
            if (node != 0) {
                score *= size;
            }
            //记录最大分数的次数
            if (score == maxScore) {
                count++;
            } else if (score > maxScore) {
                //更大 设置分数 然后重置1
                maxScore = score;
                count = 1;
            }
            return n - size;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
