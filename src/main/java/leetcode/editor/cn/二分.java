package leetcode.editor.cn;

public class 二分 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,2,2,5};
        System.out.println("找得到数据");
        //最中间的目标数据(偶数靠左)
        System.out.println(binarySearch(nums,2));

        //最左侧的目标数据索引
        System.out.println(left_bound(nums,2));

        //最右侧的目标数据索引
        System.out.println(right_bound(nums,2));



        System.out.println("找不到数据");
        //-1
        System.out.println(binarySearch(nums,6));

        //比target小的个数
        System.out.println(left_bound(nums,6));

        //比target小的个数 -1
        System.out.println(right_bound(nums,6));



        System.out.println("找不到数据");
        //-1
        System.out.println(binarySearch(nums,0));

        //比target小的个数
        System.out.println(left_bound(nums,0));

        //比target小的个数 -1
        System.out.println(right_bound(nums,0));
    }

    static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        return -1;
    }

    static int left_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // 注意

        while (left < right) { // 注意
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // 注意
            }
        }
        return left;
    }

    static int right_bound(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // 注意
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left - 1; // 注意
    }
}
