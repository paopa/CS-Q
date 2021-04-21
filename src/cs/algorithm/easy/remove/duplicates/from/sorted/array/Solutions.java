package cs.algorithm.easy.remove.duplicates.from.sorted.array;

/**
 * 26. Remove Duplicates from Sorted Array
 * <p>
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Example 1:
 * <p>
 * Given nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the returned length.
 * <p>
 * Example 2:
 * <p>
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 * It doesn't matter what values are set beyond the returned length.
 * <p>
 * Clarification:
 * Confused why the returned value is an integer but your answer is an array?
 * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
 * Internally you can think of this:
 * <p>
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 * <p>
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 3 * 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums is sorted in ascending order.
 */
public abstract class Solutions {

    abstract int removeDuplicates(int[] nums);

    static final class Solution1 extends Solutions {

        @Override
        int removeDuplicates(int[] nums) {
            // i 紀錄當前位置 最終會全部跑過一輪
            // j 紀錄目前變換到的位置
            // return j
            int j = 0;
            int tmp = 10001;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != tmp) {
                    j++;
                    nums[j - 1] = nums[i];
                }
                tmp = nums[i];
            }
            return j;
        }
    }
}

class Test {
    public static void main(String[] args) {
//        int[] nums = {1, 1, 2};
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = new Solutions.Solution1().removeDuplicates(nums);
        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
