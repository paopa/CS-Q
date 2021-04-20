package cs.algorithm.easy.sqrt.x;

import java.util.List;

/**
 * 69. Sqrt(x)
 * Easy
 * Given a non-negative integer x, compute and return the square root of x.
 * <p>
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 * <p>
 * Example 1:
 * <p>
 * Input: x = 4
 * Output: 2
 * Example 2:
 * <p>
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= x <= 231 - 1
 */
public abstract class Solutions {
    public abstract int mySqrt(int x);

    public static Solutions factory(String solution) {
        switch (solution) {
            case "1":
                return new Solution1();
            case "2":
                return new Solution2();
            case "3":
                return new Solution3();
            default:
                throw new IllegalArgumentException();
        }
    }

    private static class Solution1 extends Solutions {

        @Override
        public int mySqrt(int x) {
            for (int i = 1; i <= x; i++) {
                if (x / i == i) {
                    return i;
                }
                if (x / i < i) {
                    return i - 1;
                }
            }
            return 0;
        }
    }

    private static class Solution2 extends Solutions {

        @Override
        public int mySqrt(int x) {
            return ((int) Math.pow(x, 0.5));
        }
    }

    private static class Solution3 extends Solutions {

        @Override
        public int mySqrt(int x) {
            if (x == 0) return 0;
            if (x == 1) return 1;
            int start = 0, end = x, middle, ans = 0;
            while (start <= end) {
                middle = start + (end - start) / 2;
                if (x / middle == middle) return middle;
                if (x / middle > middle) {
                    start = middle + 1;
                    ans = middle;
                    continue;
                }
                end = middle - 1;
            }
            return ans;
        }
    }
}

class Test {
    public static void main(String[] args) {
        List.of(
                new TestCase(4),
                new TestCase(8),
                new TestCase(1),
                new TestCase(2147483647)
        ).forEach(test -> System.out.println(Solutions.factory("3").mySqrt(test.x)));
    }

    private static class TestCase {
        int x;

        public TestCase(int x) {
            this.x = x;
        }
    }
}
