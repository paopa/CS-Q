package cs.algorithm.easy.remove.element;

import java.util.Arrays;

import static java.util.Objects.isNull;

/**
 * 27. Remove Element
 * Easy
 * <p>
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * Clarification:
 * <p>
 * Confused why the returned value is an integer but your answer is an array?
 * <p>
 * Note that the input array is passed in by reference, which means a modification to the input array will be known to the caller as well.
 * <p>
 * Internally you can think of this:
 * <p>
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeElement(nums, val);
 * <p>
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 * print(nums[i]);
 * }
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,2,2,3], val = 3
 * Output: 2, nums = [2,2]
 * Explanation: Your function should return length = 2, with the first two elements of nums being 2.
 * It doesn't matter what you leave beyond the returned length. For example if you return 2 with nums = [2,2,3,3] or nums = [2,2,0,0], your answer will be accepted.
 * Example 2:
 * <p>
 * Input: nums = [0,1,2,2,3,0,4,2], val = 2
 * Output: 5, nums = [0,1,4,0,3]
 * Explanation: Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4. Note that the order of those five elements can be arbitrary. It doesn't matter what values are set beyond the returned length.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 50
 * 0 <= val <= 100
 */
public abstract class Solutions {

    public abstract int removeElement(int[] nums, int val);

    public static Solutions factory(String solution) {
        if (isNull(solution)) {
            throw new IllegalArgumentException();
        }
        switch (solution) {
            case "1":
                return new Solution1();
            case "2":
                return null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private static class Solution1 extends Solutions {

        @Override
        public int removeElement(int[] nums, int val) {
            int p1 = 0;
            int p2 = nums.length - 1;
            while (p1 <= p2) {
                if (nums[p1] == val) {
                    if (nums[p2] == val) {
                        p2--;
                        continue;
                    }
                    nums[p1] = nums[p2];
                    p2--;
                }
                p1++;
            }
            return p1;
        }
    }
}

class Test {
    public static void main(String[] args) {
//        int[] nums = {3, 2, 2, 3};
//        int val = 3;
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
//        int[] nums = {2};
//        int val = 3;
        System.out.println(Solutions.factory("1").removeElement(nums, val));
        Arrays.stream(nums).mapToObj(num -> num + " ").forEach(System.out::print);
    }
}
