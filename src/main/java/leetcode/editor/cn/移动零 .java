package leetcode.editor.cn;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
// Related Topics 数组 双指针 👍 1442 👎 0

class 移动零 {
    public static void main(String[] args) {
        Solution solution = new 移动零().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int length = nums.length;
            int slow = 0;
            for (int fast = 0; fast < length; fast++) {
                if (nums[slow] != 0) {
                    slow++;
                } else {
                    if (nums[fast] != 0) {
                        int temp = nums[fast];
                        nums[fast] = nums[slow];
                        nums[slow] = temp;
                        slow++;
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
