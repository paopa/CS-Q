package cs.algorithm.easy.valid.parentheses;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 * Easy
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "()"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 * <p>
 * Input: s = "(]"
 * Output: false
 * Example 4:
 * <p>
 * Input: s = "([)]"
 * Output: false
 * Example 5:
 * <p>
 * Input: s = "{[]}"
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */
public class Solution {
    public boolean isValid(String s) {
        int length = s.length();
        if (length > 10000 || length % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (popCheck(c, stack)) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        return stack.size() == 0;
    }

    private boolean popCheck(char c, Stack<Character> stack) {
        if (stack.size() == 0) {
            return false;
        }
        return switch (c) {
            case ')' -> stack.peek() == '(';
            case ']' -> stack.peek() == '[';
            case '}' -> stack.peek() == '{';
            default -> false;
        };
    }
}

class Test {
    public static void main(String[] args) {
        String input = "{}[()]";
        System.out.println(new Solution().isValid(input));
    }
}
