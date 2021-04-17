package cs.algorithm.easy.maximum.subarray;

/**
 * 53. Maximum Subarray
 * Easy
 * <p>
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Example 2:
 * <p>
 * Input: nums = [1]
 * Output: 1
 * Example 3:
 * <p>
 * Input: nums = [5,4,-1,7,8]
 * Output: 23
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 * <p>
 * <p>
 * Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public abstract class Solutions {
    public abstract int maxSubArray(int[] nums);

    public static Solutions factory(String solution) {
        switch (solution) {
            case "1":
                return new Solution1();
            case "2":
                return new Solution2();
            case "3":
                return new Solution3();
            default:
                throw new IllegalArgumentException();
        }
    }

    /**
     * brute force
     * time complexity: O(n^2)
     */
    private static class Solution1 extends Solutions {

        @Override
        public int maxSubArray(int[] nums) {
            int max = nums[0];
            int sum;
            for (int i = 0; i < nums.length; i++) {
                sum = nums[i];
                if (max < sum) {
                    max = sum;
                }
                for (int i1 = i + 1; i1 < nums.length; i1++) {
                    sum += nums[i1];
                    if (max < sum) {
                        max = sum;
                    }
                }
            }
            return max;
        }
    }

    /**
     * divide and conquer
     * time complexity: O(nlog n)
     */
    private static class Solution2 extends Solutions {

        @Override
        public int maxSubArray(int[] nums) {
            return getMax(nums, 0, nums.length - 1);
        }

        private int getMax(int[] nums, int start, int end) {
            if (start == end) {
                return nums[start];
            }
            int middle = (start + end) / 2;
            int leftMax = getMax(nums, start, middle);
            int rightMax = getMax(nums, middle + 1, end);
            int cross = getCrossMax(nums, start, middle, end);
            return Math.max(Math.max(leftMax, rightMax), cross);
        }

        private int getCrossMax(int[] nums, int start, int middle, int end) {
            int leftMax = nums[middle], leftSum = 0;
            int rightMax = nums[middle + 1], rightSum = 0;
            for (int i = middle; i >= start; i--) {
                leftSum += nums[i];
                leftMax = Math.max(leftMax, leftSum);
            }
            for (int i = middle + 1; i <= end; i++) {
                rightSum += nums[i];
                rightMax = Math.max(rightMax, rightSum);
            }
            return Math.max(Math.max(leftMax, rightMax), (leftMax + rightMax));
        }
    }

    /**
     * kadane algorithm
     * time complexity: O(n)
     */
    private static class Solution3 extends Solutions {

        @Override
        public int maxSubArray(int[] nums) {
            int max = nums[0], sum = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum = Math.max(sum + nums[i], nums[i]);
                if (max < sum) {
                    max = sum;
                }
            }
            return max;
        }
    }
}

class Test {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = {5, 4, -1, 7, 8};
//        int[] nums = {1};
//        int[] nums = {-2, 1};
        System.out.println(Solutions.factory("3").maxSubArray(nums));
    }
}