package cs.algorithm.easy.add.binary;

import java.util.List;

/**
 * 67. Add Binary
 * Easy
 * Given two binary strings a and b, return their sum as a binary string.
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= a.length, b.length <= 104
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 */
public abstract class Solutions {

    public abstract String addBinary(String a, String b);

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
        public String addBinary(String a, String b) {
            int al = a.length() - 1;
            int bl = b.length() - 1;
            int sum;
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            while (al >= 0 || bl >= 0) {
                sum = carry;
                if (al >= 0) {
                    sum += a.charAt(al--) - '0';
                }
                if (bl >= 0) {
                    sum += b.charAt(bl--) - '0';
                }
                carry = sum / 2;
                sb.append(sum % 2);
            }
            if (carry == 1) {
                sb.append(1);
            }
            return sb.reverse().toString();
        }
    }
}

class Test {
    public static void main(String[] args) {
        List.of(
                new TestCase("11", "1"),
                new TestCase("1010", "1011")
        ).forEach(test -> System.out.println(Solutions.factory("1").addBinary(test.a, test.b)));
    }

    private static class TestCase {
        String a;
        String b;

        public TestCase(String a, String b) {
            this.a = a;
            this.b = b;
        }
    }
}
