package cs.algorithm.easy.length.of.last.word;

/**
 * 58. Length of Last Word
 * Easy
 * Given a string s consists of some words separated by spaces, return the length of the last word in the string. If the last word does not exist, return 0.
 * <p>
 * A word is a maximal substring consisting of non-space characters only.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "Hello World"
 * Output: 5
 * Example 2:
 * <p>
 * Input: s = " "
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 104
 * s consists of only English letters and spaces ' '.
 */
public abstract class Solutions {
    public abstract int lengthOfLastWord(String s);

    public static Solutions factory(String solution) {
        switch (solution) {
            case "1":
                return new Solution1();
            case "2":
                return new Solution2();
            default:
                throw new IllegalArgumentException();
        }
    }

    private static class Solution1 extends Solutions {

        private final char splitter = ' ';

        @Override
        public int lengthOfLastWord(String s) {
            int max = 0, p = 0;
            for (char c : s.toCharArray()) {
                if (splitter == c) {
                    p = 0;
                    continue;
                }
                p++;
                max = p;
            }
            return max;
        }
    }

    private static class Solution2 extends Solutions {

        private final char splitter = ' ';

        @Override
        public int lengthOfLastWord(String s) {
            int max = 0;
            int p = s.length() - 1;
            while (p >= 0 && s.charAt(p) == splitter) p--;
            while (p >= 0 && s.charAt(p) != splitter) {
                max++;
                p--;
            }
            return max;
        }
    }
}

class Test {
    public static void main(String[] args) {
//        String s = " ";
//        String s = "a";
//        String s = "Hello World";
//        String s = "a ";
//        String s = " a ";
        String s = "b   a    ";
        System.out.println(Solutions.factory("2").lengthOfLastWord(s));
    }
}