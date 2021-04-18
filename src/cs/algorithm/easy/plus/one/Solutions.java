package cs.algorithm.easy.plus.one;

import java.util.Arrays;

/**
 * 66. Plus One
 * Easy
 * <p>
 * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * <p>
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 * <p>
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Example 3:
 * <p>
 * Input: digits = [0]
 * Output: [1]
 * <p>
 * Constraints:
 * <p>
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */
public abstract class Solutions {

    public abstract int[] plusOne(int[] digits);

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
        public int[] plusOne(int[] digits) {
            return plusOne(digits, 1);
        }

        private int[] plusOne(int[] digits, int position) {
            if (digits.length < position) {
                int[] newArray = new int[digits.length + 1];
                System.arraycopy(digits, 0, newArray, 0, digits.length);
                digits = newArray;
            }
            if (digits[digits.length - position] < 9) {
                digits[digits.length - position] += 1;
                return digits;
            }
            digits[digits.length - position] = 0;
            return plusOne(digits, position + 1);
        }
    }
}

class Test {
    public static void main(String[] args) {
//        int[] digits = {1, 2, 3};
//        int[] digits = {4, 3, 2, 1};
//        int[] digits = {0};
//        int[] digits = {1,9};
        int[] digits = {9};
        Arrays.stream(Solutions.factory("1").plusOne(digits))
                .forEach(num -> System.out.print(num + " "));
    }
}
