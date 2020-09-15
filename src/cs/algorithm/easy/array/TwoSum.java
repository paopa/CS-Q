package cs.algorithm.easy.array;


/**
 * 1. Two Sum
 * <p>
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 * <p>
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 * <p>
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] a = {3, 2, 4};
        int target = 6;
        int[] answer = twoSum(a, target);

        for (int x : answer)
            System.out.print(x + " ");
    }

    /**
     * 概念:bubble sort 全比較
     * <p>
     * Time  complexity:O(n^2)
     * Space complexity:O(1)
     *
     * @param nums
     * @param target
     * @return
     * @throws IllegalAccessException
     */
    public static int[] twoSum(int[] nums, int target) {
        int match;
        for (int i = 0; i <= nums.length - 1; i++) {
            match = target - nums[i];
            for (int j = 0; j <= nums.length - 1; j++) {
                if (i == j) continue;
                if (nums[j] == match)
                    return new int[]{i, j};
            }
        }

        return new int[]{0};
    }

}
