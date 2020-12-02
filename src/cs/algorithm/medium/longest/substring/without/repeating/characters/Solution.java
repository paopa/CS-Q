package cs.algorithm.medium.longest.substring.without.repeating.characters;

import java.util.*;

/**
 * 3. Longest Substring Without Repeating Characters
 * Medium
 * Given a string s, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * Example 4:
 * <p>
 * Input: s = ""
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 * <p>
 * link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
//        return solve1(s);
        return solve2(s);
    }

    private int solve2(String s) {
        int max = 0, position = 0, carry = 0;
        Set<Character> charBuff = new HashSet<>();
        while (position < s.length()) {
            if (charBuff.contains(s.charAt(position))) {
                charBuff.remove(s.charAt(carry++));
            } else {
                charBuff.add(s.charAt(position++));
                max = Math.max(max, charBuff.size());
            }
        }
        return max;
    }

    private int solve1(String s) {
        int c = s.length();
        String t;
        loop1:
        {
            while (true) {
                int index = 0;
                while ((c + index) <= s.length()) {
                    t = s.substring(index, c + index);
                    if (isUniqueCharactersString(t)) {
                        break loop1;
                    }
                    index++;
                }
                c--;
            }
        }
        return t.length();
    }

    private boolean isUniqueCharactersString(String t) {
        char[] chars = t.toCharArray();
        Arrays.sort(chars);
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                return false;
            }
        }
        return true;
    }

}
