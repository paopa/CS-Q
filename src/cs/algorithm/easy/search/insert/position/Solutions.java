package cs.algorithm.easy.search.insert.position;

/**
 * 35. Search Insert Position
 * <p>
 * Easy
 * <p>
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 * <p>
 * Example 4:
 * <p>
 * Input: nums = [1,3,5,6], target = 0
 * Output: 0
 * <p>
 * Example 5:
 * <p>
 * Input: nums = [1], target = 0
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 104
 * <p>
 * -104 <= nums[i] <= 104
 * <p>
 * nums contains distinct values sorted in ascending order.
 * <p>
 * -104 <= target <= 104
 */
public abstract class Solutions {

    public abstract int searchInsert(int[] nums, int target);

    public static Solutions factory(String solution) {
        switch (solution) {
            case "1":
                return new Solution1();
            default:
                throw new IllegalArgumentException();
        }
    }

    private static class Solution1 extends Solutions {

        @Override
        public int searchInsert(int[] nums, int target) {
            int p = 0;
            for (int num : nums) {
                if (num >= target) {
                    return p;
                }
                p++;
            }
            return nums.length;
        }
    }
}

class Test {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
//        int[] nums = {1};
//        int target = 5;
//        int target = 2;
        int target = 7;
//        int target = 0;
        System.out.println(Solutions.factory("1").searchInsert(nums, target));
    }
}