package cs.algorithm.easy.implement.str;

import static java.util.Objects.isNull;

/**
 * 28. Implement strStr()
 * Easy
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Clarification:
 * <p>
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Example 3:
 * <p>
 * Input: haystack = "", needle = ""
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack and needle consist of only lower-case English characters.
 */
public abstract class Solutions {

    public abstract int strStr(String haystack, String needle);

    public static Solutions factory(String solution) {
        if (isNull(solution)) {
            throw new IllegalArgumentException();
        }
        switch (solution) {
            case "1":
                return new Solution1();
            default:
                throw new IllegalArgumentException();
        }
    }

    private static class Solution1 extends Solutions {

        @Override
        public int strStr(String haystack, String needle) {
            if (needle.length() == 0) {
                return 0;
            }
            if (needle.length() > haystack.length()) {
                return -1;
            }
            byte[] hbs = haystack.getBytes();
            byte[] nbs = needle.getBytes();
            int hp = 0, np = 0;
            while (hp < hbs.length && np < nbs.length) {
                if (hbs[hp] == nbs[np]) {
                    np++;
                    if (np == nbs.length) {
                        return hp - np + 1;
                    }
                } else {
                    hp -= np;
                    np = 0;
                }
                hp++;
            }
            return -1;
        }
    }
}

class Test {
    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
//        String haystack = "aaaaa", needle = "bba";
//        String haystack = "", needle = "";
        System.out.println(Solutions.factory("1").strStr(haystack, needle));
    }
}
