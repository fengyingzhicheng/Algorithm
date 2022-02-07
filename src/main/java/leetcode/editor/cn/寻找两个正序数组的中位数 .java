package leetcode.editor.cn;

//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -10⁶ <= nums1[i], nums2[i] <= 10⁶ 
// 
// Related Topics 数组 二分查找 分治 👍 4956 👎 0

class 寻找两个正序数组的中位数 {
    public static void main(String[] args) {
        Solution solution = new 寻找两个正序数组的中位数().new Solution();

        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            //给定两个有序数组，要求找到两个有序数组的中位数，最直观的思路有以下两种：
            //
            //使用归并的方式，合并两个有序数组，得到一个大的有序数组。大的有序数组的中间位置的元素，即为中位数。
            //
            //不需要合并两个有序数组，只要找到中位数的位置即可。由于两个数组的长度已知，因此中位数对应的两个数组的下标之和也是已知的。
            // 维护两个指针，初始时分别指向两个数组的下标 00 的位置，每次将指向较小值的指针后移一位（如果一个指针已经到达数组末尾，则只需要移动另一个数组的指针），
            // 直到到达中位数的位置。
            //
            //假设两个有序数组的长度分别为 mm 和 nn，上述两种思路的复杂度如何？
            //
            //第一种思路的时间复杂度是 O(m+n)O(m+n)，空间复杂度是 O(m+n)O(m+n)。
            // 第二种思路虽然可以将空间复杂度降到 O(1)O(1)，但是时间复杂度仍是 O(m+n)O(m+n)。


            //如何把时间复杂度降低到 O(\log(m+n))O(log(m+n)) 呢？如果对时间复杂度的要求有 \loglog，
            // 通常都需要用到二分查找，这道题也可以通过二分查找实现。
            //
            //根据中位数的定义，当 m+nm+n 是奇数时，中位数是两个有序数组中的第 (m+n)/2(m+n)/2 个元素，当 m+nm+n 是偶数时，
            // 中位数是两个有序数组中的第 (m+n)/2(m+n)/2 个元素和第 (m+n)/2+1(m+n)/2+1 个元素的平均值。
            // 因此，这道题可以转化成寻找两个有序数组中的第 kk 小的数，其中 kk 为 (m+n)/2(m+n)/2 或 (m+n)/2+1(m+n)/2+1。

            int m = nums1.length;
            int n = nums2.length;

            //如果m+n是奇数找到 (m+n)/2
            //如果m+n是偶数找到 (m+n)/2 和 (m+n)/2+1 求和除以2
            //转化成寻找两个有序数组中的第 k小的数，其中 k 为 (m+n)/2(m+n)/2 或 (m+n)/2+1(m+n)/2+1。

            int len = m + n;
            //默认是左侧
            int left = -1;
            int right = -1;
            int aStart = 0, bStart = 0;
            for (int i = 0; i <= len / 2; i++) {
                //left 表示当前指针的上一个位置 值
                //right 表示当前指向的值
                left = right;

                //正常 中位数找到 aStart bStart 都没索引越界

                //TODO 当前最小值如何寻找
                if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
                    right = nums1[aStart++];
                } else {
                    right = nums2[bStart++];
                }
            }
            if (len % 2 == 0) {
                return (left + right) / 2.0;
            } else {
                return right;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
