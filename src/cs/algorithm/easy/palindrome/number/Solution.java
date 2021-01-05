package cs.algorithm.easy.palindrome.number;

/**
 * 9. Palindrome Number
 * Easy
 * <p>
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Follow up: Could you solve it without converting the integer to a string?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: x = 121
 * Output: true
 * Example 2:
 * <p>
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 * <p>
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Example 4:
 * <p>
 * Input: x = -101
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * -231 <= x <= 231 - 1
 */
public class Solution {
    public boolean isPalindrome(int x) {
        char[] cs = Integer.toString(x).toCharArray();
        int size = cs.length;
        for (int i = 0; i < size; i++) {
            if (cs[i] == cs[(size - 1) - i]) {
                continue;
            }
            return false;
        }
        return true;
    }
}
