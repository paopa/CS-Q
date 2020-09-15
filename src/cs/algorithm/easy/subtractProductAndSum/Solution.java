package cs.algorithm.easy.subtractProductAndSum;

/**
 * 1281. Subtract the Product and Sum of Digits of an Integer
 * <p>
 * Given an integer number n, return the difference between the product of its digits and the sum of its digits.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 234
 * Output: 15
 * Explanation:
 * Product of digits = 2 * 3 * 4 = 24
 * Sum of digits = 2 + 3 + 4 = 9
 * Result = 24 - 9 = 15
 * <p>
 * Example 2:
 * <p>
 * Input: n = 4421
 * Output: 21
 * Explanation:
 * Product of digits = 4 * 4 * 2 * 1 = 32
 * Sum of digits = 4 + 4 + 2 + 1 = 11
 * Result = 32 - 11 = 21
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^5
 */
public class Solution {

    public static int subtractProductAndSum(Integer input) {
        char[] chars = input.toString().toCharArray();
        return subtract(chars);
    }

    private static int subtract(char[] chars) {
        int product = 1;
        int sum = 0;
        for (char value : chars) {
            int temp = convertToInt(value);
            product *= temp;
            sum += temp;
        }
        return product - sum;
    }

    private static int convertToInt(char value) {
        return Integer.parseInt(String.valueOf(value));
    }
}
