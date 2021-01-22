package cs.algorithm.easy.move.zeros;

public class Solution {
    public static void moveZeroes(int[] nums) {
        int z = 0, temp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                z++;
                continue;
            }
            temp = nums[i - z];
            nums[i - z] = nums[i];
            nums[i] = temp;
        }
    }
}
