package cs.algorithm.easy.reverseinteger;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 7. Reverse Integer
 * Easy
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Note:
 * Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * <p>
 * Example 1:
 * <p>
 * Input: x = 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: x = -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: x = 120
 * Output: 21
 * Example 4:
 * <p>
 * Input: x = 0
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * -231 <= x <= 231 - 1
 */
public class Solution {
    public static int reverse(int x) {
        String reverse = executeReverse(String.valueOf(x));
        if (isOverFlow(reverse)) {
            return 0;
        }
        return Integer.parseInt(reverse);
    }

    private static String executeReverse(String integer) {
        boolean isNegative = isNegative(integer);
        char[] chars = integer.replace("-", "").toCharArray();
        char[] newChars = new char[chars.length];
        for (int index = 0; index < chars.length; index++) {
            newChars[(chars.length - 1) - index] = chars[index];
        }
        return (isNegative ? "-" : "") + String.valueOf(newChars);
    }

    private static boolean isNegative(String integer) {
        return integer.matches("-.*");
    }

    private static boolean isOverFlow(String reverse) {
        try {
            Integer.parseInt(reverse);
        } catch (Exception e) {
            return true;
        }
        return false;
    }
}
