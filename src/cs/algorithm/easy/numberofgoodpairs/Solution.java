package cs.algorithm.easy.numberofgoodpairs;

/**
 * 1512. Number of Good Pairs
 * Easy
 * Given an array of integers nums.
 * <p>
 * A pair (i,j) is called good if nums[i] == nums[j] and i < j.
 * <p>
 * Return the number of good pairs.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1,1,3]
 * Output: 4
 * Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
 * Example 2:
 * <p>
 * Input: nums = [1,1,1,1]
 * Output: 6
 * Explanation: Each pair in the array are good.
 * Example 3:
 * <p>
 * Input: nums = [1,2,3]
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class Solution {

    public static int switchMethod(int[] nums, String version) throws Exception {
        if (version == null) {
            throw new Exception("version is null");
        }
        System.out.printf("method version: %s\n", version);
        switch (version) {
            case "v1":
                return numIdenticalPairsV1(nums);
            case "v2":
                return numIdenticalPairsV2(nums);
        }
        return 0;
    }

    /* O(n^2) */
    private static int numIdenticalPairsV1(int[] nums) {
        int i = 0, j, ans = 0;
        for (int x : nums) {
            j = 0;
            for (int y : nums) {
                if (x == y && i < j) {
                    ans++;
                }
                j++;
            }
            i++;
        }
        return ans;
    }

    /* O(n) */
    private static int numIdenticalPairsV2(int[] nums) {
        int[] array = new int[101];
        int ans = 0;
        for (int num : nums) {
            ans += array[num];
            array[num]++;
        }
        return ans;
    }

}
