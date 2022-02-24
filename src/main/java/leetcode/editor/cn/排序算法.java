package leetcode.editor.cn;

import java.util.Arrays;

/**
 * @author 王军
 * @description
 * @date 2022/2/22 13:38
 */
public class 排序算法 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 5, 1, 4, 6, 2};
        System.out.println("------------------------------");
        System.out.println("选择排序");
        selectSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{2, 3, 5, 1, 4, 6, 2};
        System.out.println("------------------------------");
        System.out.println("插入排序");
        insertSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{2, 3, 5, 1, 4, 6, 2};
        System.out.println("------------------------------");
        System.out.println("冒泡排序");
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{2, 3, 5, 1, 4, 6, 2};
        System.out.println("------------------------------");
        System.out.println("归并排序");
        System.out.println(Arrays.toString(mergeSort(nums)));
    }

    private static int[]  mergeSort(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    /**
     * @param nums
     * @param left
     * @param right
     */
    private static int[] mergeSort(int[] nums, int left, int right) {
        if (left == right) return new int[]{nums[left]};

        int middle = (left + right) / 2;
        //处理
        int[] leftNums = mergeSort(nums, left, middle);
        int[] rightNums = mergeSort(nums, middle + 1, right);

        //合并leftNums rightNums
        return merge(leftNums, rightNums);

    }

    private static int[] merge(int[] leftNums, int[] rightNums) {
        int newLength = leftNums.length + rightNums.length;
        int[] array = new int[newLength];
        for (int left = 0, right = 0, i = 0; i < newLength; i++) {
            if (left >= leftNums.length) {
                array[i] = rightNums[right];
                right++;
                continue;
            }

            if (right >= rightNums.length) {
                array[i] = leftNums[left];
                left++;
                continue;
            }

            if (leftNums[left] < rightNums[right]) {
                array[i] = leftNums[left];
                left++;
            } else {
                array[i] = rightNums[right];
                right++;
            }
        }
        return array;
    }

    /**
     * 冒泡排序
     *
     * @param nums
     */
    private static void bubbleSort(int[] nums) {
        int length = nums.length;
        for (int i = length; i > 1; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (nums[j + 1] < nums[j]) {
                    swap(nums, j, j + 1);
                }
            }
        }

    }

    /**
     * 选择排序
     *
     * @param nums 数据
     */
    public static void selectSort(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i; j < length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            //交换i和minIndex
            swap(nums, i, minIndex);
        }
    }

    /**
     * 插入排序
     *
     * @param nums 数据
     */
    public static void insertSort(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int temp = nums[i];

            int index = 0;
            for (int j = i; j > 0; j--) {
                if (nums[j - 1] > temp) {
                    nums[j] = nums[j - 1];
                } else {
                    index = j;
                    break;
                }
            }
            nums[index] = temp;
        }
    }

    /**
     * 交换数组值算法
     *
     * @param nums 交换的数组
     * @param m    交换的第一个索引
     * @param n    交换的第二个索引
     */
    private static void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }


}