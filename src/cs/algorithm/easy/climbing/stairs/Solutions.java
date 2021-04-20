package cs.algorithm.easy.climbing.stairs;

import java.util.List;

/**
 * 70. Climbing Stairs
 * Easy
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 * <p>
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 45
 */
public abstract class Solutions {

    public abstract int climbStairs(int n);

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

    /**
     * brute force recursive
     * time complexity: O(2^n)
     */
    private static class Solution1 extends Solutions {

        @Override
        public int climbStairs(int n) {
            if (n == 1) return 1;
            if (n == 2) return 2;
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    /**
     * dynamic programming
     */
    private static class Solution2 extends Solutions {

        private final int[] cache = new int[46];

        {
            cache[1] = 1;
            cache[2] = 2;
        }

        @Override
        public int climbStairs(int n) {
            if (n == 1 || n == 2 || cache[n] != 0) return cache[n];
            return cache[n] = climbStairs(n - 1) + climbStairs(n - 2);
        }
    }
}

class Test {
    public static void main(String[] args) {
        List.of(
                new TestCase(2), //2
                new TestCase(3), //3
                new TestCase(4), //5
                new TestCase(5), //8
                new TestCase(6), //13
                new TestCase(45)
        ).forEach(test -> System.out.println(Solutions.factory("2").climbStairs(test.stairs)));
    }

    private static class TestCase {
        int stairs;

        public TestCase(int stairs) {
            this.stairs = stairs;
        }
    }
}
